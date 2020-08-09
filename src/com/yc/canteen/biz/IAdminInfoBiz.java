package com.yc.canteen.biz;

import java.util.List;

import com.yc.canteen.entity.AdminInfo;

public interface IAdminInfoBiz {
	public AdminInfo login(AdminInfo af);

	public int reg(AdminInfo af);

	public List<AdminInfo> find(AdminInfo af);

	public int delete(String aid);

	public int update(AdminInfo af);

}
