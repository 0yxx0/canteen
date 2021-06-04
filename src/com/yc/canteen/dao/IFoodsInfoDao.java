package com.yc.canteen.dao;

import java.util.List;

import com.yc.canteen.entity.FoodsInfo;

public interface IFoodsInfoDao {

	int add(FoodsInfo foods);

	List<FoodsInfo> findByPage(int page, int rows);

	public List<FoodsInfo> findIndex();

	public List<FoodsInfo> findHot();

	// 后台食品信息查询
	public int total(String tno, String fname);

	// 后台报表页面查询食品
	public List<FoodsInfo> findFood();

	public List<FoodsInfo> findByCondition(String tno, String fname, int page, int rows);

	public FoodsInfo findByFno(String fno);

	public List<FoodsInfo> findByTno(String tno, int page, int rows);

	public int total(String tno);

	public int update(FoodsInfo f);

	public List<FoodsInfo> findAll();
}
