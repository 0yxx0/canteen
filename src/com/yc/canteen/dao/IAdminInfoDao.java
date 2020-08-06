package com.yc.canteen.dao;

import com.yc.canteen.entity.AdminInfo;

public interface IAdminInfoDao {
	public AdminInfo login(AdminInfo af);

	public int reg(AdminInfo af);

}
