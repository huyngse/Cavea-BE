package com.example.demo.Repo;

import com.example.demo.DTO.CartDTOInterface;
import com.example.demo.DTO.HistoryDTO;
import com.example.demo.Entities.dbo.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer> {
  @Query(
      value =
          "SELECT bill_id, birdtype_id, created_date, date_pay, description, expected_date, material,\n"
              + "    price, product_id, custom_product_id, shape, COUNT(product_id) as 'numberOfSelectedItems',status, username\n"
              + "    FROM dbo.cart where (:username is null or username = :username)\n"
              + "    AND ((:status IS NULL AND status IS NULL) OR (status = :status))\n"
              + "    GROUP BY bill_id, birdtype_id, created_date, date_pay, description, expected_date, material,\n"
              + "    price, product_id, shape, status, username, custom_product_id ",
      countQuery =
          "SELECT count(*) FROM dbo.cart where (:username is null or username = :username) "
              + "AND ((:status IS NULL AND status IS NULL) OR (status = :status)) ",
      nativeQuery = true)
  Page<CartDTOInterface> get(
      @Param(value = "username") String username,
      @Param(value = "status") Integer status,
      Pageable pageable);

  @Query(
      value =
          "SELECT bill_id, birdtype_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, custom_product_id, shape, COUNT(product_id) as 'numberOfSelectedItems',status, username\n"
              + "FROM dbo.cart where (:username is null or username = :username)\n"
              + "AND ((0 IS NULL AND status IS NULL) OR (status = 0)) AND product_id IS NOT NULL\n"
              + "GROUP BY bill_id, birdtype_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, shape, status, username, custom_product_id ",
      countQuery =
          "SELECT count(*) FROM dbo.cart where (:username is null or username = :username) "
              + "AND ((:status IS NULL AND status IS NULL) OR (status = :status)) ",
      nativeQuery = true)
  Page<CartDTOInterface> getUnSolveRegularCage(
      @Param(value = "username") String username,
      Pageable pageable);

  @Query(
      value =
          "SELECT bill_id, birdtype_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, custom_product_id, shape, COUNT(product_id) as 'numberOfSelectedItems',status, username\n"
              + "FROM dbo.cart where (:username is null or username = :username)\n"
              + "AND ((0 IS NULL AND status IS NULL) OR (status = 0)) AND product_id IS NULL\n"
              + "GROUP BY bill_id, birdtype_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, shape, status, username, custom_product_id ",
      countQuery =
          "SELECT count(*) FROM dbo.cart where (:username is null or username = :username) "
              + "AND ((:status IS NULL AND status IS NULL) OR (status = :status)) ",
      nativeQuery = true)
  Page<CartDTOInterface> getUnSolveCustomRegularCage(
      @Param(value = "username") String username,
      Pageable pageable);

  @Query(
      value =
          "select * from cart where username = :username and (:status is null or status = :status) ",
      nativeQuery = true)
  List<Cart> getAll(
      @Param(value = "username") String username, @Param(value = "status") Integer status);

  @Modifying
  @Query(
      value =
          "DELETE FROM dbo.cart where username = :username and product_id = :product_id and status = 0",
      nativeQuery = true)
  void removeOne(
      @Param(value = "username") String username, @Param(value = "product_id") Integer productId);

  @Modifying
  @Query(
      value =
          "DELETE TOP(1) FROM [SWP391].[dbo].[cart] where username = :username and product_id = :product_id and status = 0",
      nativeQuery = true)
  void removeAtom(
      @Param(value = "username") String username, @Param(value = "product_id") Integer productId);

  @Modifying
  @Query(
      value = "DELETE FROM dbo.cart where username = :username and status is null",
      nativeQuery = true)
  void removeAll(@Param(value = "username") String username);

  @Modifying
  @Query(
      value =
          "update dbo.cart set status = 1, payment_id = :payment, date_pay = GETDATE(), bill_id = :bill_id, created_date = :createdDate,"
              + "expected_date = :expectedDate "
              + "where username = :username and ((:status IS NULL AND status IS NULL) OR (status = 0))",
      nativeQuery = true)
  void updateAllBought(
      @Param(value = "username") String username,
      @Param(value = "status") Integer status,
      @Param(value = "bill_id") Integer billId,
      @Param(value = "createdDate") String createdDate,
      @Param(value = "expectedDate") String expectedDate,
      @Param(value = "payment") Integer payment);

  @Query(value = "select * from cart where status is not null and status != 2", nativeQuery = true)
  List<Cart> getAllBill();

  @Query(
      value =
          "select * from cart where (:product_id IS NULL AND product_id IS NOT NULL) OR (:product_id IS NOT NULL AND product_id IS NULL)",
      countQuery =
          "SELECT count(*) FROM cart where (:product_id IS NULL AND product_id IS NOT NULL) OR (:product_id IS NOT NULL AND product_id IS NULL)",
      nativeQuery = true)
  Page<Cart> getAllBill(@Param(value = "product_id") Integer product_id, Pageable pageable);

  @Query(
      value = "select * from cart where (:product_id IS NULL AND product_id IS NULL)",
      countQuery =
          "SELECT count(*) FROM cart where (:product_id IS NULL AND product_id IS NOT NULL)",
      nativeQuery = true)
  Page<Cart> getAllBillProductCustom(
      @Param(value = "product_id") Integer product_id, Pageable pageable);

  @Query(
      value =
          "select sum(cage_price) from dbo.cart inner join production.regular_cages on cart.product_id = regular_cages.cage_id\n"
              + "where cart.status is not null",
      nativeQuery = true)
  String sumPriceBillAll();

  @Query(
      value =
          "select sum(cage_price) from dbo.cart inner join production.regular_cages on cart.product_id = regular_cages.cage_id\n"
              + "where cart.status is null and username = :username",
      nativeQuery = true)
  String sumPriceById(@Param(value = "username") String username);

  @Modifying
  @Query(
      value = "DELETE FROM dbo.cart where username = :username and status = 2",
      nativeQuery = true)
  void removeAllOrderCustomize(@Param(value = "username") String username);

  @Query(value = "select TOP 1 bill_id from dbo.cart order by bill_id desc", nativeQuery = true)
  Integer countBillId();

  @Query(value = "select * from cart where bill_id = :bill_id", nativeQuery = true)
  List<Cart> getAllByBillId(@Param(value = "bill_id") Integer billId);

  @Query(
      value = "select * from cart where bill_id = :bill_id",
      countQuery = "SELECT count(*) FROM cart where bill_id = :bill_id",
      nativeQuery = true)
  Page<Cart> getAllByBillId(@Param(value = "bill_id") Integer billId, Pageable pageable);

  @Query(
      value = "select * from cart where bill_id = :bill_id",
      countQuery = "select count(*) from cart where bill_id = :bill_id",
      nativeQuery = true)
  Page<Cart> getPageByBillId(@Param(value = "bill_id") Integer billId, Pageable pageable);

  @Modifying
  @Query(
      value = "update dbo.cart set status = :status where bill_id = :bill_id",
      nativeQuery = true)
  void updateStatusByBillId(
      @Param(value = "status") Integer status, @Param(value = "bill_id") Integer billId);

  Optional<Cart> getCartByIdAndUsername(int id, String username);

  List<Cart> findAllByUsernameOrderByCreatedDateDesc(String username);

  @Query(
      value =
          "SELECT bill_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, custom_product_id, shape, COUNT(product_id) as 'numberOfSelectedItems',status, username,\n"
              + "cage_code, cage_name, cage_price, short_decription, long_decription, discount, quantity, (SELECT A.image_url FROM [production].[regular_cage_images] A WHERE A.is_main = 1 AND A.cage_id = product_id) AS 'image_url',\n"
              + "payment_id\n"
              + "FROM dbo.cart \n"
              + "LEFT JOIN [production].[regular_cages] on dbo.cart.product_id = [production].[regular_cages].cage_id\n"
              + "WHERE (:username IS NULL OR username = :username)\n"
              + "AND ((null IS NULL OR STATUS IS NOT NULL) OR (status = null)) AND \n"
              + "product_id IS NOT NULL\n"
              + "GROUP BY bill_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, custom_product_id, shape, status, username,\n"
              + "cage_code, cage_name, cage_price, short_decription, long_decription, discount, quantity,\n"
              + "payment_id",
      countQuery =
          "SELECT count(*) FROM dbo.cart where (:username is null or username = :username) "
              + "AND ((:status IS NULL AND status IS NULL) OR (status = :status)) ",
      nativeQuery = true)
  List<HistoryDTO> getHistory(@Param(value = "username") String username);

  @Query(
      value =
          "SELECT bill_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, custom_product_id, shape, COUNT(product_id) as 'numberOfSelectedItems',status, username,\n"
              + "cage_code, cage_name, cage_price, short_decription, long_decription, discount, quantity, (SELECT A.image_url FROM [production].[regular_cage_images] A WHERE A.is_main = 1 AND A.cage_id = product_id) AS 'image_url',\n"
              + "payment_id\n"
              + "FROM dbo.cart \n"
              + "LEFT JOIN [production].[regular_cages] on dbo.cart.product_id = [production].[regular_cages].cage_id\n"
              + "WHERE (:username IS NULL OR username = :username)\n"
              + "AND ((null IS NULL OR STATUS IS NOT NULL) OR (status = null)) AND\n"
              + "cart.id = :cart_id\n"
              + "GROUP BY bill_id, created_date, date_pay, description, expected_date, material,\n"
              + "price, product_id, custom_product_id, shape, status, username,\n"
              + "cage_code, cage_name, cage_price, short_decription, long_decription, discount, quantity,\n"
              + "payment_id",
      countQuery =
          "SELECT count(*) FROM dbo.cart where (:username is null or username = :username) "
              + "AND ((:status IS NULL AND status IS NULL) OR (status = :status)) ",
      nativeQuery = true)
  Optional<HistoryDTO> getHistoryDetails(
      @Param(value = "username") String username, @Param(value = "cart_id") Integer cart_id);

  List<Cart> getAllByProductIdIsNullAndUsername(String username);

  Optional<Cart> findCartByIdAndProductIdIsNullAndUsername(Integer cart_id, String username);

  @Query(
      value =
          "SELECT COUNT(C.product_id)\n"
              + "FROM CART C\n"
              + "WHERE C.product_id = :product_id\n"
              + "GROUP BY C.product_id", nativeQuery = true)
  Integer numberOfCage(@Param(value = "product_id") Integer product_id);
}
