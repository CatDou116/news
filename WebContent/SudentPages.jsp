<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分页</title>
</head>
<body>


<form >
<!-- 获取selvet的装满数据的对象,通过对象点的方式获取它里面的数据并遍历通过el表达式 -->
<table align="center" style="width: 60%;"border="1"  >
 <tr>
 
	<th>学生编号</th>
	<th>学生姓名</th>
	<th>学生年龄</th>
	<th>性别</th>
 	<th>生日</th>
 </tr>



<c:forEach var="stu" items="${pagelist.lis }"  >

<tr>
	<th>${stu.id }</th>
	<th>${stu.name }</th>
	<th>${stu.age }</th>
	<th>${stu.sex }</th>
 	<th>${stu.birth }</th>
 </tr>


</c:forEach>

</table>

</form>

<div align="center" ;>
<a href="Pageservlet?CurPage=1" >首页</a>
当前页:${pagelist.dangqianPage}
<c:if test="${pagelist.dangqianPage-1>0}"     >
<a href="Pageservlet?CurPage=${pagelist.dangqianPage-1}">上一页</a>

</c:if>
<c:if test="${pagelist.dangqianPage+1<=6}"     >
<a href="Pageservlet?CurPage=${pagelist.dangqianPage+1}">下一页</a>

</c:if>
<!-- 判断如果是最后一页就不显示不让翻页 -->
<a href="Pageservlet?CurPage=${pagelist.totalPages }">最后一页</a>
总页数:${pagelist.totalPages }
</div>
<!-- pagelist.totalPages是获取的总页数pagelist.dangqianPage是获取到的当前页页码 -->


</body>
</html>