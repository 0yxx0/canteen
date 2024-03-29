package com.yc.canteen.biz;

import java.util.List;

import com.yc.canteen.entity.MemberInfo;

public interface IMemberInfoBiz {

	public MemberInfo login(MemberInfo mf);

	public List<MemberInfo> finds();

	public int reg(MemberInfo mf);

	public MemberInfo find(MemberInfo mf);

	public List<MemberInfo> findAll();

	public int change(MemberInfo m);

}
