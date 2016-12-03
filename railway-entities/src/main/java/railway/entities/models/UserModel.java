package railway.entities.models;

import java.io.Serializable;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String login;
	private String password1;
	private String password2;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String money;
	
	public UserModel(long id, String login, String password1, String password2, String name, String surname, 
			String email, String phone, String money) {
		this.id = id;
		this.login = login;
		this.password1 = password1;
		this.password2 = password2;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.money = money;
	}

	public long getId(){
		return id;
	}
	
	public String getLogin() {
		return login;
	}

	public String getPassword1() {
		return password1;
	}

	public String getPassword2() {
		return password2;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getMoney() {
		return money;
	}
}
