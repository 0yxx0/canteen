package com.yc.canteen.dao;

import java.util.List;

import com.yc.canteen.entity.FoodsInfo;

public interface IFoodsInfoDao {

	int add(FoodsInfo foods);

	List<FoodsInfo> findByPage(int page, int rows);

	public List<FoodsInfo> findIndex();

	//后台食品信息查询
	public int total(String tno, String fname);
	public List<FoodsInfo> findByCondition(String tno, String fname, int page, int rows);
}
