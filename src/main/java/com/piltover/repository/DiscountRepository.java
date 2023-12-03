package com.piltover.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piltover.dto.request.DiscountReq;
import com.piltover.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
	@Transactional
	@Query(value = "SELECT * FROM discounts", nativeQuery = true)
	List<Discount> ReadAllDiscountNoDelete();

	@Query(value = "CALL Discount_ReadOneByID(:id)", nativeQuery = true)
	Discount readOneByDiscountNoDelete(@Param("id") Long id);

//	@Modifying
//	@Query(value = " INSERT INTO discounts "
//			+ " (`Name`, `Percentage`, `Amount`, `Code`, `Create_User`, `Create_at`, `Update_at`, `Update_User`, `is_Delete`, `min`, `max`)"
//			+ "   VALUES(?1,?2,?3,?4,?5,?6,?7,0,?9,?10,?11)",nativeQuery = true)
//	void insertDiscount(String Name, float Percentage, int Amount, String Code,int Create_User, Date Create_at, Date Update_at, float min,float max);

//	@Modifying
//	@Transactional
////	@Procedure("InsertDiscount")
//	@Query(value = "CALL InsertDiscount(:Name,:Percentage,:Amount,:Create_User,:min,:max)", nativeQuery = true)
//	void insertDiscount(@Param("Name") String Name, @Param("Percentage") float Percentage, @Param("Amount") int Amount,
//			@Param("Create_User") Long Create_User, @Param("min") float min, @Param("max") float max);
	
	@Modifying
	@Transactional
	@Query(value = "CALL InsertDiscount(:#{#discountDTO.name}, :#{#discountDTO.percentage},:#{#discountDTO.amount}, :#{#discountDTO.create_User}, :#{#discountDTO.min}, :#{#discountDTO.max})",nativeQuery = true)
	void insertDiscount(DiscountReq discountDTO);	

	@Modifying
	@Transactional
	@Query(value = "UPDATE discounts d SET d.is_Delete=1 WHERE d.id =:discountId", nativeQuery = true)
	void deleteDiscount(@Param("discountId") Long id);
}
