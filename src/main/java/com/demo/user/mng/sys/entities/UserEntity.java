package com.demo.user.mng.sys.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "")
	public Integer id;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name = "user_name")
	public String userName;

	@Column(name = "email")
	public String email;

	@Column(name = "password")
	public String password;

	@Transient
	@Column(name = "confirm_password")
	public String confirmPassword;

	@ManyToOne
	@JoinColumn(name = "fk_user_role_id", referencedColumnName = "id")
	public RoleEntity role;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Integer id, String firstName, String lastName, String userName, String email, String password,
			String confirmPassword, RoleEntity role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}

}
