<%--
  Created by IntelliJ IDEA.
  User: teaGod
  Date: 2017/9/25
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>ECharts</title>
      <meta charset="utf-8">
      <!-- 引入 ECharts 文件 -->
<script type="text/javascript" src="../../js/echarts.min.js"></script>
  </head>

  <body>
  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
  <div id="main" style="width: 600px;height:400px;"></div>
  <script type="text/javascript">
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('main'));

      var arr = new Array();
      var index = 0;
      <c:forEach items="${goodsList}" var="goods">
          arr[index++] = ${goods.sales};
      </c:forEach>

      // 指定图表的配置项和数据
      var option = {
          title: {
              text: 'ECharts 入门示例'
          },
          tooltip: {
              show: true
          },
          legend: {
              data:['销量']
          },
          xAxis : [
              {
                  type : 'category',
                  data : [
                      <c:forEach items="${goodsList}" var="g">
                      ["${g.price}"],
                      </c:forEach>
                  ]
              }
          ],
          yAxis : [
              {
                  type : 'value'
              }
          ],
          series : [
              {
                  name:'销量',
                  type:'bar',
                  data: arr
              }
          ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
  </script>
  </body>
</html>