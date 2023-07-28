package poly;

import lombok.Data;

@Data
public class AccountDTO {
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	Boolean activated;
	Boolean admin;
}
