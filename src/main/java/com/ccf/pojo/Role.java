package com.ccf.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_sys_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roleid")
	private Integer roleid;
	@Column(name="rolename")
	private String rolename;
	
	@OneToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	@ManyToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="t_role_menu", joinColumns = @JoinColumn(name="role_id"), inverseJoinColumns = @JoinColumn(name="menu_id"))
	private Set<Menu> menus = new HashSet<Menu>();
	
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
}