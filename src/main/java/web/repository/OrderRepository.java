package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  @Query("SELECT DISTINCT a FROM Order a JOIN FETCH a.product_id")
  List<Order> listAllOrders();

  @Query("SELECT DISTINCT a FROM Order a JOIN FETCH a.user_id")
  List<Order> listAllUsersOrdersById();

  Order findOrderById(Long id);

  List<Order> findAllOrders();

  void addOrder(Order order);

  void deleteOrder(Order order);
}
