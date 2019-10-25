<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!--引入CSS-->
    <link rel="stylesheet" type="text/css" href="js/webuploader-0.1.5/webuploader.css">
    <link href="js/webuploader-0.1.5/style.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5.4.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5.4.2/themes/icon.css">
    <script type="text/javascript" src="js/jquery-easyui-1.5.4.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5.4.2/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/webuploader-0.1.5/webuploader.js"></script>
</head>
<body class="easyui-layout">
<!-- 头  -->
<div data-options="region:'north',title:'welcome',split:true" style="height:100px;">
    <center><font style="font-size: 40px;color:violet">EASYBUY</font></center>
</div>
<!-- 列表  -->
<div data-options="region:'west',title:'列表',split:true" style="width:200px;">
    <div id="aa" class="easyui-accordion" fit="true" style="width:300px;height:200px;">
        <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
            <a href="javascript:;" onclick="addTap('读取')">内容</a>
        </div>
        <div title="Title3">
            <a href="javascript:;" onclick="addGoodTap('lala')">商品</a>
            <ul id="ttTree"></ul>
        </div>
    </div>
</div>
<!-- 内容  -->
<div id="content" data-options="region:'center',title:'内容'"  style="padding:5px;background:#eee;">
    <div id="tt" class="easyui-tabs" fit="true"  style="width:500px;height:250px;">
        <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
            tab2
        </div>
    </div>
</div>

<script type="text/javascript">

    $(function(){
        $("#ttTree").tree({
            url:"findTypeList"
        })
    });

    function addTap() {

        $('#tt').tabs('add',{
            title:'内容',
            href:'list',
            closable:true
        });

    }
    function addGoodTap() {

        $('#tt').tabs('add',{
            title:'商品',
            href:'goods',
            closable:true
        });

    }

</script>




</body>
</html>