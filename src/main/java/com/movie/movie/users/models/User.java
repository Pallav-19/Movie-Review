package com.movie.movie.users.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	public User(String _id, String name, String email, String password, String role) {
		super();
		this._id = _id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	@Id
	private String _id;
	private String name;
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		_id = id;
	}
	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String email;
	private String password;
	private String role;
	

}
