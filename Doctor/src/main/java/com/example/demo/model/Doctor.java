package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = " Doctor name notbe blank ")
	@Size(min = 0,max = 15,message = " Doctor name shuld be range of 0 to 15")
	private String doctorName;
	@NotBlank(message = " Doctor last name not be blank")
	@Size(min = 0,max = 15,message = " Doctor last name should be range of 0 to 15 ")
	private String doctorLName;
	@NotBlank(message = " ")
	@Size(min = 0,max= 15,message = " ")
	private String specialist;
	@NotBlank(message = "")
	@Size(min = 0,max = 20,message = "")
	private String email;
	private Long phnNo;
	 public Doctor() {
	}
	public Doctor(Long id, String doctorName, String doctorLName, String specialist, String email, Long phnNo) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.doctorLName = doctorLName;
		this.specialist = specialist;
		this.email = email;
		this.phnNo = phnNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorLName() {
		return doctorLName;
	}
	public void setDoctorLName(String doctorLName) {
		this.doctorLName = doctorLName;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
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
		return "Doctor [id=" + id + ", doctorName=" + doctorName + ", doctorLName=" + doctorLName + ", specialist="
				+ specialist + ", email=" + email + ", phnNo=" + phnNo + "]";
	}
	 

}
