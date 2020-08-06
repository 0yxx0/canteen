package com.yc.canteen.entity;

import java.io.Serializable;

public class TableInfo implements Serializable{
	private static final long serialVersionUID = -2099823697041183524L;
	private String tano;
	private String name;
	private Integer pwd;
	private Integer status;
	public String getTano() {
		return tano;
	}
	public void setTano(String tano) {
		this.tano = tano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPwd() {
		return pwd;
	}
	public void setPwd(Integer pwd) {
		this.pwd = pwd;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tano == null) ? 0 : tano.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableInfo other = (TableInfo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tano == null) {
			if (other.tano != null)
				return false;
		} else if (!tano.equals(other.tano))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TableInfo [tano=" + tano + ", name=" + name + ", pwd=" + pwd + ", status=" + status + "]";
	}
	public TableInfo(String tano, String name, Integer pwd, Integer status) {
		super();
		this.tano = tano;
		this.name = name;
		this.pwd = pwd;
		this.status = status;
	}
	public TableInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
