package poly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
@SuppressWarnings("serial")
public class Account implements Serializable {
	@Id
	@NotEmpty(message = "Tên đăng nhập không được để trống!")
	@Column(columnDefinition = "varchar(30)")
	String username;

	@NotEmpty(message = "Mật khẩu không được để trống!")
	@Size(min = 6, max = 14, message = "Mật khẩu phải lớn hơn 6 nhỏ hơn 14 kí tự")
	@Column(columnDefinition = "varchar(30)")
	String password;

	@NotEmpty(message = "Tên không được để trống!")
	@Column(columnDefinition = "nvarchar(70)")
	String fullname;

	@NotEmpty(message = "Email không được để trống!")
	@Column(columnDefinition = "varchar(150)")
	String email;
	String photo;
	Boolean activated;
	Boolean admin;
	@OneToMany(mappedBy = "account")
	List<Order> orders;

}