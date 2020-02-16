package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = " User name shuld not be blank ")
	@Size(min = 1,max = 10,message = "user name lenght 1-10")
	private String name;

	@NotBlank(message = " User Last name shuld be not blank ")
	@Size(min= 1,max = 15,message = " user last name lenght 1-15")
	private String lName;
	
	@NotEmpty(message = " User email id shuld be not empty ")
	private String email;

	private Long phnNo;

	public UserInfo() {
	}
	public UserInfo(String name, String lName, String email, Long phnNo) {
		super();
		this.name = name;
		this.lName = lName;
		this.email = email;
		this.phnNo = phnNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhnNo() {
		return phnNo;
	}
	public void setPhnNo(Long phnNo) {
		this.phnNo = phnNo;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", lName=" + lName + ", email=" + email + ", phnNo=" + phnNo
				+ "]";
	}

}


