package com.yc.canteen.biz;

import com.yc.canteen.entity.AdminInfo;

public interface IAdminInfoBiz {
	public AdminInfo login(AdminInfo af);

	public int reg(AdminInfo af);

}
