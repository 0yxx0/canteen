package com.yc.canteen.entity;

import java.io.Serializable;

public class OrderItemInfo implements Serializable{
	private static final long serialVersionUID = 7870021058936063774L;

	private Integer ino;
	private String ono;
	private Integer fno;
	private Integer nums;
	private double price;
	private Integer status;
	public Integer getIno() {
		return ino;
	}
	public void setIno(Integer ino) {
		this.ino = ino;
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public Integer getFno() {
		return fno;
	}
	public void setFno(Integer fno) {
		this.fno = fno;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
		result = prime * result + ((fno == null) ? 0 : fno.hashCode());
		result = prime * result + ((ino == null) ? 0 : ino.hashCode());
		result = prime * result + ((nums == null) ? 0 : nums.hashCode());
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		OrderItemInfo other = (OrderItemInfo) obj;
		if (fno == null) {
			if (other.fno != null)
				return false;
		} else if (!fno.equals(other.fno))
			return false;
		if (ino == null) {
			if (other.ino != null)
				return false;
		} else if (!ino.equals(other.ino))
			return false;
		if (nums == null) {
			if (other.nums != null)
				return false;
		} else if (!nums.equals(other.nums))
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderItemInfo [ino=" + ino + ", ono=" + ono + ", fno=" + fno + ", nums=" + nums + ", price=" + price
				+ ", status=" + status + "]";
	}
	public OrderItemInfo(Integer ino, String ono, Integer fno, Integer nums, double price, Integer status) {
		super();
		this.ino = ino;
		this.ono = ono;
		this.fno = fno;
		this.nums = nums;
		this.price = price;
		this.status = status;
	}
	public OrderItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
