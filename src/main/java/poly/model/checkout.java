package poly.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class checkout {
	@NotEmpty(message = "Tên Không Được Để Trống!")
	String username;
	@NotEmpty(message = "Email Không Được Để Trống!")
	@Email(message = "Email Không Đúng Định Dạng!")
	String email;
	@NotEmpty(message = "SĐT Không Được Để Trống!")
	@Size(min = 10 ,message = "SĐT Chứa 10 số!")
	private String sdt;
	@NotEmpty(message = "Địa Chỉ 1 Không Được Để Trống!")
	String diachi1;
	@NotEmpty(message = "Địa Chỉ 2 Không Được Để Trống!")
	String diachi2;
	@NotEmpty(message = "Vui Lòng Chọn Quốc Gia!")
	String quocgia;
	@NotEmpty(message = "Thành Phố Không Được Để Trống!")
	String thanhpho;
	@NotEmpty(message = "Mã Bưu Chính Không Được Để Trống!")
	String buuchinh;
}
