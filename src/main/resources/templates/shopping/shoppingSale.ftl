<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.5.4.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.5.4.2/themes/icon.css">
    <script type="text/javascript" src="/js/jquery-easyui-1.5.4.2/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="/images/logo.gif" /></div>
    <div class="help"><a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a href="register.html">注册</a><a href="guestbook.html">留言</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li class="current"><a href="#">首页</a></li>
            <li><a href="#">图书</a></li>
            <li><a href="#">百货</a></li>
            <li><a href="#">品牌</a></li>
            <li><a href="#">促销</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="wrap">
        <ul class="clearfix">
            <li class="first"><a href="#">音乐</a></li>
            <li><a href="#">影视</a></li>
            <li><a href="#">少儿</a></li>
            <li><a href="#">动漫</a></li>
            <li><a href="#">小说</a></li>
            <li><a href="#">外语</a></li>
            <li><a href="#">数码相机</a></li>
            <li><a href="#">笔记本</a></li>
            <li><a href="#">羽绒服</a></li>
            <li><a href="#">秋冬靴</a></li>
            <li><a href="#">运动鞋</a></li>
            <li><a href="#">美容护肤</a></li>
            <li><a href="#">家纺用品</a></li>
            <li><a href="#">婴幼奶粉</a></li>
            <li><a href="#">饰品</a></li>
            <li class="last"><a href="#">Investor Relations</a></li>
        </ul>
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list.html">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
            <h2>商品分类</h2>
            <dl>
                <dt>图书音像</dt>
                <dd><a href="product-list.html">图书</a></dd>
                <dd><a href="product-list.html">音乐</a></dd>
                <dt>百货</dt>
                <dd><a href="product-list.html">运动健康</a></dd>
                <dd><a href="product-list.html">服装</a></dd>
                <dd><a href="product-list.html">家居</a></dd>
                <dd><a href="product-list.html">美妆</a></dd>
                <dd><a href="product-list.html">母婴</a></dd>
                <dd><a href="product-list.html">食品</a></dd>
                <dd><a href="product-list.html">手机数码</a></dd>
                <dd><a href="product-list.html">家具首饰</a></dd>
                <dd><a href="product-list.html">手表饰品</a></dd>
                <dd><a href="product-list.html">鞋包</a></dd>
                <dd><a href="product-list.html">家电</a></dd>
                <dd><a href="product-list.html">电脑办公</a></dd>
                <dd><a href="product-list.html">玩具文具</a></dd>
                <dd><a href="product-list.html">汽车用品</a></dd>
            </dl>
        </div>
    </div>
    <div id="product" class="main">
        <h1>${goodVO.good_name}</h1>
        <div class="infos">
            <div class="thumb"><img src="/images/product/0.jpg" /></div>
            <div class="buy">
                <p>活动价：<span class="price">￥${goodVO.good_price*goodVO.priceDiscount}</span></p>
                <p>商城原价：<span class="oldPrice"><del>￥${goodVO.good_price}</del></span></p>
                <p>
                    <#if goodVO.good_count<=0>
                        库存:缺货
                        <#else >
                        库存:有货
                    </#if>
                </p>
                <p>
                    活动倒计时：<span id="orderDate" class="price"></span>
                </p>

                数量:<input size="3" type="text" id="goodCount">
                <div class="button">
                    <input type="button" name="button" value="" onclick="goBuyInsert('${goodVO.good_id}')" />
                    <input type="button" value="放入购物车" onclick="addShopCart('${goodVO.good_id}')" />
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="introduce">
            <h2><strong>商品详情</strong></h2>
            <div class="text">
                sdf<br />
                sdf<br />
                <input type="hidden" id="endTime" value="${goodVO.endTime?string('yyyy-MM-dd HH:mm:ss')}"/>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 明瑞教育 All Rights Reserved. 京ICP证1000001号
</div>
<script>
    // 点击购买
    function goBuyInsert(id) {
        // 获取商品id和数量
        var count = $("#goodCount").val();
        // 发送请求到后台 传参下单
        $.ajax({
            url:"/shopping/insertDeal",
            data:{
                "good_id":id,
                "good_count":count
            },
            dataType:"json",
            type:"post",
            success:function(data){
                if(data.errorCode==200){
                    alert("请求成功 等待订单处理");
                    return;
                }
                if(data.errorCode==201){
                    alert("库存不足 请修改数量后重新下单");
                    return;
                }
                if(data.errorCode==202){
                    alert("已经超过活动时间 是否按原价购买");
                    return;
                }
            },
            error:function(data){
                alert("系统内部异常 请联系管理员")
            }
        })

    }
    // alert(123);
    // $(function () {
    //     alert(234);
    // })
    var date = "";
    function CountDown() {
        if(date==""||date==null){
            date = (new Date($("#endTime").val())-new Date().getTime())/1000
        }
        if (date >= 0) {
            hours = Math.floor(date/3600);
            minutes = Math.floor(date / 60)-hours*60;
            seconds = Math.floor(date % 60);
            msg = "距离结束还有"+hours+" 时" + minutes + "分" + seconds + "秒";
            $("#orderDate").html(msg);
            // if (maxtime == 5 * 60)alert("距离结束仅剩5分钟");
            --date;
        } else{
            clearInterval(timer);
            alert("时间到，结束!");
        }
    }
    timer = setInterval("CountDown()", 1000);

</script>
</body>
</html>
