package com.ptit.ptitexam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
<<<<<<< HEAD:src/main/java/com/ptit/ptitexam/entity/User.java
public class User {
=======
@Table(name = "Account")
public class Account {
>>>>>>> 3f2cc66bf57e13d7d4f60e957dbab4eecea1bfe9:src/main/java/com/ptit/ptitexam/entity/Account.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{4,}")
    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email(message = "Invalid email")
    @Column(nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    private Boolean isActive = true;

    private String fullname;

    @Column(length = 20)
    private String classID;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(length = 5)
    private String gender;

    @Column(length = 15)
    private String phoneNumber;


<<<<<<< HEAD:src/main/java/com/ptit/ptitexam/entity/User.java
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastLogin;
=======
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Time getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Time lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<ExamResult> getExamResults() {
		return ExamResults;
	}

	public void setExamResults(List<ExamResult> examResults) {
		ExamResults = examResults;
	}

	@Temporal(TemporalType.TIME)
    private Time lastLogin;
>>>>>>> 3f2cc66bf57e13d7d4f60e957dbab4eecea1bfe9:src/main/java/com/ptit/ptitexam/entity/Account.java

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ExamResult> ExamResults;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }


}
