package com.piltover.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piltover.dto.request.DiscountReq;
import com.piltover.dto.request.Discount_UpdateReq;
import com.piltover.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
	@Transactional
	@Query(value = "CALL Discount_ReadAll()", nativeQuery = true)
	List<Discount> ReadAllDiscount();
	
	@Transactional
	@Query(value = "select d.* from discounts d ORDER BY d.Create_at  DESC", nativeQuery = true)
	List<Discount> ReadAllDiscount1();

	@Query(value = "CALL Discount_ReadOneByID(:id_in)", nativeQuery = true)
	Discount readOneByDiscountNoDelete(@Param("id_in") Long id);

	@Modifying
	@Transactional
	@Query(value = "CALL Discount_Insert(:#{#discountDTO.name}, :#{#discountDTO.percentage},:#{#discountDTO.amount}, :#{#discountDTO.create_User}, :#{#discountDTO.min}, :#{#discountDTO.max})", nativeQuery = true)
	void insertDiscount(DiscountReq discountDTO);

	@Modifying
	@Transactional
	@Query(value = "UPDATE discounts d SET d.is_Delete=1,d.Update_User=:Update_User WHERE d.id =:discountId", nativeQuery = true)
	void deleteDiscount(@Param("discountId") Long id,@Param("Update_User") Long updateUser);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE discounts d SET d.is_Delete=0,d.Update_User=:Update_User WHERE d.id =:discountId", nativeQuery = true)
	void activeDiscount(@Param("discountId") Long id,@Param("Update_User") Long updateUser);

	@Transactional
	@Modifying
	@Query(value="CALL Discount_Update(:did, :#{#discountDTO.name}, :#{#discountDTO.percentage},:#{#discountDTO.amount}, :#{#discountDTO.Update_User}, :#{#discountDTO.min}, :#{#discountDTO.max})",nativeQuery = true)
	void updateDiscount1(@Param("did") Long id,Discount_UpdateReq discountDTO);
	
	@Transactional
	@Query(value = "SELECT Amount FROM discounts where discounts.id=:id",nativeQuery = true)
	Integer checkAmount(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE discounts SET Amount=:num WHERE Id =:id;",nativeQuery = true)
	Discount addAmount(@Param("id") Long id,@Param("num") int num);
	
	@Transactional
	@Query(value = "select is_delete from discounts where discounts.id=:id",nativeQuery = true)
	Boolean check_delete(@Param("id") Long id);
}
