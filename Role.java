package com.nets.springSecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "userrole")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	
	@Column(name="userid")
	private int userid;

    @Column(name="rolename")
    private String rolename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",insertable=false,updatable= false)
    private User users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	

}

 


