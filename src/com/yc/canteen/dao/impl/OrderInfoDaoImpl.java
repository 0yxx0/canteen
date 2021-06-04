package com.yc.canteen.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IOrderInfoDao;
import com.yc.canteen.entity.OrderInfo;

public class OrderInfoDaoImpl implements IOrderInfoDao {

	@Override
	public int add(String cnos, double price, String mno) {
		// 添加一条数据到订单表中(订单编号、总价)
		String ono = UUID.randomUUID().toString().replace("-", "");
		String sql1 = "insert into orderinfo values(?,now(),0,?,?)";
		List<Object> param1 = new ArrayList<Object>();
		param1.add(ono);
		param1.add(price);
		param1.add(mno);

		// 添加多条记录到订单详细表 ono fno nums price
		String sql2 = "insert into orderiteminfo select 0, ?, c.fno, c.num, price, 1 from cartinfo c, foodsinfo f where c.fno=f.fno and cno in(";
		List<Object> param2 = new ArrayList<Object>();
		param2.add(ono);
		String[] temp = cnos.split(",");
		for (String cno : temp) {
			sql2 += "?,";
			param2.add(cno);
		}
		sql2 = sql2.substring(0, sql2.lastIndexOf(",")) + ")";

		List<String> sqls = new ArrayList<String>();
		List<List<Object>> params = new ArrayList<List<Object>>();
		sqls.add(sql1);
		params.add(param1);

		sqls.add(sql2);
		params.add(param2);

		String sql3 = null;
		List<Object> param = null;
		for (String cno : temp) {
			param = new ArrayList<Object>();
			sql3 = "update foodsinfo set sales = sales + (select num from cartinfo where cno=?) where fno = (select fno from cartinfo where cno=?)";
			param.add(cno);
			param.add(cno);

			sqls.add(sql3);
			params.add(param);
		}

		// 删除购物车表cno
		String sql4 = "delete from cartinfo where cno in(";
		List<Object> param4 = new ArrayList<Object>();
		for (String cno : temp) {
			sql4 += "?,";
			param4.add(cno);
		}
		sql4 = sql4.substring(0, sql4.lastIndexOf(",")) + ")";
		sqls.add(sql4);
		params.add(param4);

		DBHelper db = new DBHelper();
		return db.updates(sqls, params);
	}

	@Override
	public List<Map<String, String>> finds(String mno) {
		DBHelper db = new DBHelper();
		String sql = "select o.ono, date_format(odate,'%Y-%m-%d %H-%i-%s') odate,o.price totalPrice, o.status, i.fno, nums, i.price, f.fname, f.pics "
				+ " from orderinfo o,orderiteminfo i,foodsinfo f, memberinfo m where o.ono=i.ono and i.fno=f.fno and m.mno=? order by odate desc";
		return db.gets(sql, mno);
	}

	@Override
	public List<OrderInfo> all() {
		DBHelper db = new DBHelper();
		String sql = "select sum(oi.price) as amount,fname FROM orderiteminfo oi,foodsinfo f"
				+ " where f.fno=oi.fno and f.status = 1 group by fname";
		return db.finds(OrderInfo.class, sql);
	}

	@Override
	public List<Map<String, String>> month(String fno) {
		DBHelper db = new DBHelper();
		String sql = "select DATE_FORMAT(odate, \"%Y-%m\" ) as month,sum(o.price) as amount from orderinfo o,orderiteminfo ot where o.ono=ot.ono and ot.fno=? group by month";
		return db.gets(sql, fno);
	}
}
