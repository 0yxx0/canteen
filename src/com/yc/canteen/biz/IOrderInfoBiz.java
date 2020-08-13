package com.yc.canteen.biz;

import java.util.List;
import java.util.Map;

public interface IOrderInfoBiz {

	List<Map<String, String>> finds(Integer mno);

	int add(String cnos, double price, String ano);

}
