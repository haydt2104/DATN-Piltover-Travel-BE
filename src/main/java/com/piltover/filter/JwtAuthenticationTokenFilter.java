package com.piltover.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.piltover.service.AuthService;
import com.piltover.util.JwtTokenUtil;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
	AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        final String header = request.getHeader("Authorization");
        
        System.out.println("Filter enable");

        if (header != null && header.startsWith("Bearer ")) 
        {
            String authToken = header.substring(7);
            
            System.out.println("token: "+authToken);

            try
            {
                String email = jwtTokenUtil.getEmailFromToken(authToken);
                if (email != null)
                
                	System.out.println("email from token: "+email);
                
                {
                    if (jwtTokenUtil.validateToken(authToken, email))
                    {
                        // here username should be validated with database and get authorities from database if valid
                        List<GrantedAuthority> authList = new ArrayList<>();
                        List<String> roleNames = authService.getRolesByUsername(email);
                        for (String roleName : roleNames) {
                             authList.add(new SimpleGrantedAuthority("ROLE_" + roleName));
                        }

                        // if(!roleNames.contains("USER")){
                        //     response.sendError(HttpServletResponse.SC_FORBIDDEN);
                        // }
                        System.out.println("Filter this...");
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, null, authList);
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                    else
                    {
                        System.out.println("Token has been expired");
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                        return;
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Unable to get JWT Token, possibly expired");
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
