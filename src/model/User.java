package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_User")
public class User implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String username;
	
	private String password;
	
	private Date createtime;
	
	private String xingming;
	
	private int role;//1表示系统管理员。0表示普通用户

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	

	
	
}
