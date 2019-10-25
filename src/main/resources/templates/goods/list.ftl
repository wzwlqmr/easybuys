<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body class="easyui-layout">
<!-- 工具栏 -->
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:toAdd();" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:toUpdate()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
        <a href="javascript:deleteBatch()" class="easyui-linkbutton" iconCls="icon-cut" plain="true">批量删除</a>
        <a href="javascript:deletes()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        name:<input id="dname" class="easyui-textbox" style="width:80px">
        Date From: <input id="starttime" class="easyui-datebox" style="width:99px">
        To: <input id="endtime" class="easyui-datebox" style="width:99px">
        Language:
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
</div>
<table id="tbs" class="easyui-datagrid" title="基本数据表格" style="width:700px;height:250px"
       data-options="toolbar:'#tb',singleSelect:true,collapsible:true,url:'findWaresList',pageList:[3,5,10],fitColumns:true,pageSize:3,fit:true,pagination:true">
    <thead>
    <tr>
        <th data-options="field:'good_id',width:80">编号</th>
        <th data-options="field:'good_name',width:100">产品名称</th>
        <th data-options="field:'good_price',width:80,align:'right'">市场价</th>
        <th data-options="field:'good_count',width:80,align:'right'">成本价</th>
        <th data-options="field:'good_type',width:80,align:'right'">类型</th>
        <th data-options="field:'good_create_date',width:250">日期</th>
        <th data-options="field:'emp_id',width:50">操作人</th>
        <th data-options="field:'good_img',formatter:readPic,fit:true">图像</th>
        <th data-options="field:'good_status',align:'center',width:50">状态</th>
    </tr>
    </thead>
</table>
<!-- 添加对话框 -->
<div id="dd1" class="easyui-dialog" title="添加" style="width:400px;height:400px;"
     data-options="buttons:'#bb1',href:'toAdd',cache:false,closed:true,iconCls:'icon-save',resizable:true,modal:true,">
    <div id="bb1">
        <a id="btn1" href="javascript:add()" class="easyui-linkbutton">添加</a>
        <a id="btn2" href="javascript:close()" class="easyui-linkbutton">关闭</a>
    </div>
</div>
<!-- 修改对话框 -->
<div id="dd2" class="easyui-dialog" title="修改" style="width:400px;height:400px;"
     data-options="buttons:'#bb2',href:'toUpdate',cache:false,closed:true,iconCls:'icon-save',resizable:true,modal:true,">
    <div id="bb2">
        <a id="btn3" href="javascript:update()" class="easyui-linkbutton">修改</a>
        <a id="btn4" href="javascript:close2()" class="easyui-linkbutton">关闭</a>
    </div>
</div>
<script>

    //读取图片
    function readPic(value) {
        return "<img  alt=这是一张图片 width=123px height=123px src=readPic?path="+value+"></a> ";
    }

    function toAdd() {
        $("#dd1").dialog('open');
    }

    function add() {
        alert("ss")
        $('#addForm').form('submit',{
            url:'add',
            onSubmit: function(){

            },
            success:function(data){
                var jsonData=JSON.parse(data);
                if(jsonData.errorCode==1){
                    alert("添加成功");
                    $("#dd1").dialog('close');
                    $("#tbs").datagrid('reload');
                }
                if(jsonData.errorCode==0){
                    alert("添加失败");
                }
            }
        });
    }

    //修改回显
    function toUpdate() {
        $("#dd2").dialog('open');
        var row=$("#tbs").datagrid('getSelected');
        console.log(row)
        $.ajax({
            url:'findGoodsById',
            data:{good_id:row.good_id},
            dataType:'json',
            type:'post',
            success:function(data){
                console.log(data)
                $("#updateForm").form('load',{
                    emp_id: data.emp_id,
                    good_count: data.good_count,
                    good_create_date: data.good_create_date,
                    type_id: data.type_id,
                    good_id: data.good_id,
                    good_img: data.good_img,
                    good_name: data.good_name,
                    good_price: data.good_price,
                    good_status: data.good_status,
                    good_type: data.good_type
                });
                $("#imgFiles").prop({"src":"readPic?path="+data.good_img});
            }
        })
    }

    //修改
    function update() {
        $('#updateForm').form('submit',{
            url:'update',
            onSubmit: function(){
            },
            success:function(data){
                var jsonData=JSON.parse(data);
                if(jsonData.errorCode==1){
                    alert("修改成功");
                    $("#dd2").dialog('close');
                    $("#tbs").datagrid('reload');
                }
                if(jsonData.errorCode==0){
                    alert("修改失败");
                }
            }
        });
    }
    function close() {
        $("#dd1").dialog('close')
    }
    function close2() {
        $("#dd2").dialog('close')
    }

</script>
</body>
</html>