package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Order;
import web.model.Product;
import web.model.User;
import web.service.OrderService;
import web.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping(value = "/findAllProducts")
  public ResponseEntity<String> findAllProducts() {
    List<Product> all = productService.findAllProducts();
    return ResponseEntity.ok(all.toString());
  }

  @PostMapping(value = "/product/add")
  public String addProduct(Product product) {
    productService.addProduct(product);
    return "redirect:/product";
  }

}