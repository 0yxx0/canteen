package com.yc.canteen.entity;

import java.io.Serializable;

public class OrderInfo implements Serializable{
	private static final long serialVersionUID = -2328858016309595923L;

	private String ono;
	private String odate;
	private String pdate;
	private Integer status;
	private double price;
	private String tano;
	private String mno;
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTano() {
		return tano;
	}
	public void setTano(String tano) {
		this.tano = tano;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mno == null) ? 0 : mno.hashCode());
		result = prime * result + ((odate == null) ? 0 : odate.hashCode());
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		result = prime * result + ((pdate == null) ? 0 : pdate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		OrderInfo other = (OrderInfo) obj;
		if (mno == null) {
			if (other.mno != null)
				return false;
		} else if (!mno.equals(other.mno))
			return false;
		if (odate == null) {
			if (other.odate != null)
				return false;
		} else if (!odate.equals(other.odate))
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (pdate == null) {
			if (other.pdate != null)
				return false;
		} else if (!pdate.equals(other.pdate))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
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
		return "OrderInfo [ono=" + ono + ", odate=" + odate + ", pdate=" + pdate + ", status=" + status + ", price="
				+ price + ", tano=" + tano + ", mno=" + mno + "]";
	}
	public OrderInfo(String ono, String odate, String pdate, Integer status, double price, String tano, String mno) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.pdate = pdate;
		this.status = status;
		this.price = price;
		this.tano = tano;
		this.mno = mno;
	}
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
