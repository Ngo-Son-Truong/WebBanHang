package poly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Products")
//@NamedQuery(name = "getInventoryByCategory", query = "select new Report(p.category, SUM(p.available), COUNT(p)"
//		+ "FROM Product p GROUP BY p.category")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@NotEmpty(message = "Tên không được để trống!")
	String name;
	@NotNull(message = "Giá không được để trống!")
	Double price;
	String image;
	@Column(name = "deadline")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "createDate không được để trống!")
    Date createDate;
	@NotNull(message = "available không được để trống!")
	Integer available;
	@Column(columnDefinition = "nvarchar(255)")
	String description;
	@ManyToOne @JoinColumn(name = "Categoryid")
	@NotNull(message = "category không được để trống!")
	Category category;
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;	
}
