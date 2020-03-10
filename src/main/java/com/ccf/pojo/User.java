package com.ccf.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_sys_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="systemid")
	private Integer systemid;
	@Column(name="username")
	private String username;
	@Column(name="usertype")
	private String usertype;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="role_id")
	private Role roles;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer systemid, String username, String usertype) {
		super();
		this.systemid = systemid;
		this.username = username;
		this.usertype = usertype;
	}
	public Integer getSystemid() {
		return systemid;
	}
	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	
	
	@Override
	public String toString() {
		return "User [systemid=" + systemid + ", username=" + username + ", usertype=" + usertype + ", roles=" + roles
				+ "]";
	}
	
	
	
}
