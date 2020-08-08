package com.yc.canteen.dao;

import java.util.List;

import com.yc.canteen.entity.AdminInfo;

public interface IAdminInfoDao {
	public AdminInfo login(AdminInfo af);

	public int reg(AdminInfo af);

	public List<AdminInfo> find(AdminInfo af);

}
