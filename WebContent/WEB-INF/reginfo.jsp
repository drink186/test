<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.css" />
		<script type="text/javascript" src="../js/jquery.min.js" ></script>
		<script type="text/javascript" src="../js/bootstrap.min.js" ></script>
</head>
<body>
  


   <table  class="table table-striped">
     <thead>
       <tr>
         <th>姓名</th><th>身份证号码</th>
         <th>入住日期</th><th>押金</th>
         <th>客房地址</th>
       </tr>
     </thead>
     <tbody>
       <tr>
         <td>${guest.name}</td><td>${guest.idcard}</td>
         <td>${guest.inDate}</td><td>${guest.deposit}</td>
         <td>${guest.room.description}</td>
         
       </tr>
     </tbody>
   </table>
  
</body>
</html>