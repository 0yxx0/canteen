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

	public Map<String, Object> findIndex();

	public List<FoodsInfo> findFood();

	public Map<String, Object> findByCondition(String tno, String fname, int page, int rows);

	public FoodsInfo findByFno(String fno);

	public List<FoodsInfo> findByTno(String tno, int page, int rows);

	public Map<String, Object> findByTnos(String tno, int page, int rows);

	public Map<String, Object> findHot();

}
