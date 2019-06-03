<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-21
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>获取距离</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <%--<script src="http://code.jquery.com/jquery-latest.js"></script>--%>
</head>
<body>
        <div>
        出发地：<input type="text" name="start" id="start"/>
        目的地：<input type="text" name="end" id="end"/>
            <input type="button" onclick="func1()" value="获取"/>
            两者之间的距离是 <input type="text" name="distance" id="distance"/> 公里
        </div>

<script>

    console.info("${pageContext.request.contextPath}");

    function func1(){
        var start = $("#start").val();
        var end = $("#end").val();
        console.log(start,end);
        // $("#distance").val(122)
        $.ajax({
            url:"${pageContext.request.contextPath}/map/getDistance?start="+start+"&end="+end,
            //contentType:"application/json;charset=UTF-8",
            // data:,
            type:"get",
            dataType:"text",
            success:function(res){
                console.log(res);
                $("#distance").val(res)
            },
            error:function(){
                alert("请求失败");
            }
        })
    }

</script>
</body>
</html>
