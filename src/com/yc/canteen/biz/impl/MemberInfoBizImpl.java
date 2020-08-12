package com.yc.canteen.biz.impl;

import com.yc.canteen.biz.IMemberInfoBiz;
import com.yc.canteen.dao.IMemberInfoDao;
import com.yc.canteen.dao.impl.MemberInfoDaoImpl;
import com.yc.canteen.entity.MemberInfo;
import com.yc.canteen.util.StringUtil;

public class MemberInfoBizImpl implements IMemberInfoBiz{

	@Override
	public MemberInfo login(MemberInfo mf) {
		if(StringUtil.checkNull(mf.getNickName(),mf.getPwd())) {
			return null;
		}
			
		   IMemberInfoDao adminInfoDao = new MemberInfoDaoImpl();
		   return adminInfoDao.login(mf);
	}
}
