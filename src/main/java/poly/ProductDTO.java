package poly;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import poly.model.Category;
@Data
public class ProductDTO {
	Integer id;
	String name;
	Double price;
	String image;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date createDate;
	Integer available;
	String description;
	Category category;
}
