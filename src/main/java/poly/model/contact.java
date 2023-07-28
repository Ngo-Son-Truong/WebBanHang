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
public class contact {
	@NotEmpty(message = "Tên Không Được Để Trống!")
	String username;
	@NotEmpty(message = "Email Không Được Để Trống!")
	@Email(message = "Email Không Đúng Định Dạng!")
	String email;
	@NotEmpty(message = "Tiêu Đề Không Được Để Trống!")
	String tieude;
	@NotEmpty(message = "Lời Nhắn Không Được Để Trống!")
	@Size(min = 10, max = 500, message = "Lời Nhắn Chứa Ít Nhất 10!")
	String loinhan;
}
