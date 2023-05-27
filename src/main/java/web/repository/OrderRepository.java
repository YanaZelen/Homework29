package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Order;

import java.util.List;

/**
 * Тут ты и так подключила JPA репозиторий, вме методы, что ты не написала сама через @Query, Spring попробует создать сам.
 * Естественно он будет пытаться их созадть по своим ключевым словам, а ты их нарушила в тех методах.
 * Я об этом уже писал и даже скидывал документацию
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

//  @Query("SELECT DISTINCT a FROM Order a JOIN FETCH a.product_id")
//  List<Order> listAllOrders();

  List<Order> findAll();

//  @Query("SELECT DISTINCT a FROM Order a JOIN FETCH a.user_id")
//  List<Order> listAllUsersOrdersById();

  List<Order> findAllByUser_id(Long userId);
}
