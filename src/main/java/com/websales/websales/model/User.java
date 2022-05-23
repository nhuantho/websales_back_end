package com.websales.websales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(nullable = false)
    private String fullname;
	@Column(nullable = false)
    private String dob;
	@Column(nullable = false)
    private String gender;
	@Column(nullable = false)
    private String phone;
	@Column(nullable = false)
    private String address;
	@Column(nullable = false)
    private String username;
	@Column(nullable = false)
    private String password;
	@Column(nullable = false)
    private int isAdmin;
	@Column(nullable = true)
    private String note;
}
