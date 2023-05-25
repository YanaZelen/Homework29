package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Order;
import web.model.User;
import web.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

  private final OrderRepository repo;

  public List<Order> findAllOrders() {
    return (List<Order>) repo.findAll();
  }

  public Order findOrderById(Long id) {
    return repo.findById(id).get();
  }

  public void addOrder(Order order) {
    repo.save(order);
  }

  public void deleteOrder(Order order) {
    repo.delete(order);
  }

  @Transactional
  public List<Order> findAll() {
    List<Order> all = repo.listAllOrders();
    return all;
  }

  @Transactional
  public List<Order> allUsersOrdersById() {
    List<Order> all = repo.listAllUsersOrdersById();
    return all;
  }

}
