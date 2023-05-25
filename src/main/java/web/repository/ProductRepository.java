package web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Product;
import web.model.User;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  Product findProductById(Long id);

  List<User> findAllProducts();

  void addProduct(Product product);

  void deleteProduct(Product product);
}
