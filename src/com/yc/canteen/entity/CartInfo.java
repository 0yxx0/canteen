package com.yc.canteen.entity;

import java.io.Serializable;

public class CartInfo implements Serializable {
	private static final long serialVersionUID = -1965070273018732551L;
	private String cno;
	private String mno;
	private Integer fno;
	private Integer num;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public Integer getFno() {
		return fno;
	}
	public void setFno(Integer fno) {
		this.fno = fno;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cno == null) ? 0 : cno.hashCode());
		result = prime * result + ((fno == null) ? 0 : fno.hashCode());
		result = prime * result + ((mno == null) ? 0 : mno.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
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
		CartInfo other = (CartInfo) obj;
		if (cno == null) {
			if (other.cno != null)
				return false;
		} else if (!cno.equals(other.cno))
			return false;
		if (fno == null) {
			if (other.fno != null)
				return false;
		} else if (!fno.equals(other.fno))
			return false;
		if (mno == null) {
			if (other.mno != null)
				return false;
		} else if (!mno.equals(other.mno))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CartInfo [cno=" + cno + ", mno=" + mno + ", fno=" + fno + ", num=" + num + "]";
	}
	public CartInfo(String cno, String mno, Integer fno, Integer num) {
		super();
		this.cno = cno;
		this.mno = mno;
		this.fno = fno;
		this.num = num;
	}
	public CartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
