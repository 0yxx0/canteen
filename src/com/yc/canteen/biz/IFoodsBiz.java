package com.yc.canteen.biz;

import java.util.List;
import java.util.Map;

import com.yc.canteen.entity.FoodsInfo;


public interface IFoodsBiz {
	public int add(FoodsInfo foods);

	public FoodsInfo findByNid(String nid);
	
	public Map<String, Object> findByTid(String tno, int page, int rows);
	
	public List<FoodsInfo> findByPage(int page, int rows);
	
	public List<FoodsInfo> find();
}
