package web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Data
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  @ToString.Exclude
  private List<Product> product_id;

  @ManyToOne
  @JoinColumn
  @ToString.Exclude
  private User user_id;

  private String order_date;
}
