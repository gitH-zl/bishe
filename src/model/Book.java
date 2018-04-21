package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_book")
public class Book {

	private int id;
	
	private String bookname;
	
	private Date time;
	
	private String zuozhe;
	
	private String path1;
	
	private String path2;
	
	private String info;
	
	private String shuhao;
	
	private int dianjicount;
	
	private int xiazaicount;
	
	private String chubanshe;
	
	

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getZuozhe() {
		return zuozhe;
	}

	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}

	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}

	@Column(name="info", columnDefinition="text")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getShuhao() {
		return shuhao;
	}

	public void setShuhao(String shuhao) {
		this.shuhao = shuhao;
	}

	public int getDianjicount() {
		return dianjicount;
	}

	public void setDianjicount(int dianjicount) {
		this.dianjicount = dianjicount;
	}

	public int getXiazaicount() {
		return xiazaicount;
	}

	public void setXiazaicount(int xiazaicount) {
		this.xiazaicount = xiazaicount;
	}

	public String getChubanshe() {
		return chubanshe;
	}

	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	
	
	
}
