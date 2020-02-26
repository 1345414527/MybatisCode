<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/9/30
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>

    <script type="text/javascript" src="/Mybatis/student/jquery-1.9.1.js"></script>
    <script>



        $(function(){
            <!--必须保证卸载jsp文件中,如果写在js文件中由于js文件服务不会进行任何解析操作直接送给
                客户端浏览器,所以如果写在js文件中认为${}字符串。-->
            var pageSise="${requestScope.pageInfo.pageSize}";
            var pageNumber="${requestScope.pageInfo.pageNumber}";
            var tname="${pageInfo.tname}";
            var sname="${pageInfo.sname}";
            var total="${pageInfo.total}";

            <!--i表示循环角标,n表示迭代变量 n=数组[i]   n是dom对象
                 dom对象转化为jquery对象? $(dom对象)
                 把juqery转化为dom对象？ jquery对象[0] jquery对象.get(0)-->
            $.each($(":radio"),function (i,n){
                if($(n).val()==pageSise){
                    $(n).attr("checked","checked");
                }
            });




        //对输入框设置值
        $(":text[name='sname']").val(sname);
        $(":text[name='tname']").val(tname);

        //查询按钮点击事件
        $("button").onclick(function(){
            location.href="show?pageSize="+pageSize+"&pageNumber=1&tname"+${":text[name='tname']".val()+"&sname="+${":text[name='sname']"}.val}
        });

        //单选按钮点击事件
        $(":radio").onclick(function(){
           pageSise=$(this).val();
            location.href="show?pageSize="+pageSize+"&pageNumber=1&tname"+${":text[name='tname']".val()+"&sname="+${":text[name='sname']"}.val}
        })

        //点击上一页
        $(".page_a:eq(0)").click(function () {
            pageNumber=parseInt(pageNumber)-1;
            if(pageNumber>=1){
                location.href="show?pageSize="+pageSize+"&pageNumber="+pageNumber+"&tname"+${":text[name='tname']".val()+"&sname="+${":text[name='sname']"}.val}
            }else{
                pageNumber=1;
            }
            return false;
        });

        //单击下一页
        $(".page_a:eq(1)").click(function () {
            pageNumber=parseInt(pageNumber)-1;
            if(pageNumber<=parseInt(total)){
                location.href="show?pageSize="+pageSize+"&pageNumber="+pageNumber+"&tname"+${":text[name='tname']".val()+"&sname="+${":text[name='sname']"}.val}
            }else{
                pageNumber=1;
            }
            return false;
        });

        });


    </script>
</head>
<body>
  <input type="radio" value="2" name="pageSize">2
  <input type="radio" value="3" name="pageSize">2
  <input type="radio" value="4" name="pageSize">2
  学生姓名:<input type="text" name="sname"/>老师姓名 <input type="text" name="tname"/><button>查询</button>
  <table border="1">
      <tr>
          <th>学生编号</th>
          <th>学生姓名</th>
          <th>年龄</th>
          <th>任课老师</th>
      </tr>

      <c:forEach var="stu" items="${pageInfo.list}">
          <tr>
              <td>${stu.id}</td>
              <td>${stu.name}</td>
              <td>${stu.age}</td>
              <td>${stu.teacher.name}</td>
          </tr>
      </c:forEach>

      <a href="">上一页</a>
      <a href="">下一页</a>
  </table>

</body>
</html>
