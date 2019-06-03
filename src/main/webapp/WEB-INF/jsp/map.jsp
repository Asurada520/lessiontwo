<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-20
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>输入提示</title>
    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css" />
    <style>
        html,
        body,
        #container {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div id="container"></div>
<div class="info">
    <div class="input-item">
        <div class="input-item-prepend">
            <span class="input-item-text" style="width:8rem;">出发地：</span>
        </div>
        <input id='tipinput' type="text">
    </div>

    <div class="input-item">
        <div class="input-item-prepend">
            <span class="input-item-text" style="width:8rem;">目的地：</span>
        </div>
        <input id='tipDinput' type="text">
    </div>
</div>

<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.14&key=d871ac8972f969b5bd65a7d452665cf1&plugin=AMap.Autocomplete"></script>
<script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true
    });
    //输入提示
    var  info1 = new AMap.Autocomplete({
        input: "tipinput"
    });

    //输入提示
    var info2 = new AMap.Autocomplete({
        input: "tipDinput"
    });

    var p1 = [116.434027, 39.941037];
    var p2 = [116.461665, 39.941564];
    // 返回 p1 到 p2 间的地面距离，单位：米
    var dis = AMap.GeometryUtil.distance(p1, p2);

    console.info(dis)
</script>
</body>
</html>
