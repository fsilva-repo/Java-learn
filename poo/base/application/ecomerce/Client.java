package poo.base.application.ecomerce;

import java.time.LocalDate;

public class Client {
	private String name;
	private String email;
	private LocalDate birtDate;

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirtDate(LocalDate birtDate) {
		this.birtDate = birtDate;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirtDate() {
		return birtDate;
	}

}
