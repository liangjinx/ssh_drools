<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link href="./extendcss/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="extendjs/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="extendjs/themes/icon.css">
<link rel="stylesheet" type="text/css" href="extendjs/demo/demo.css">

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.0.0.js"></script>
<script type="text/javascript" src="extendjs/jquery.easyui.min.js"></script>
<style>
    table tr th{
        width: 20px;
    }
</style>
<body>
table
    <table id="dg" class="easyui-datagrid" title="后台数据显示" style="width:700px;height:auto"
           data-options="
                    iconCls: 'icon-edit',
                    singleSelect: true,
                    toolbar: '#tb',
                    url: 'flow/findAll.action',
                    method: 'get',
                    onClickRow: onClickRow
                ">
        <thead>
            <tr>
                <th data-options="field:'id',width:80">id</th>
                <th data-options="field:'flowName',width:100,editor:'textbox'">Product</th>
                <th data-options="field:'flowType',width:80,align:'right',editor:{type:'numberbox'}">flowType</th>
                <th data-options="field:'parentFlow',width:80,align:'right',editor:'textbox'">parentFlow</th>
                <th data-options="field:'childFlow',width:250,editor:'textbox'">childFlow</th>
                <th data-options="field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'1',off:'0'}}">Status</th>
            </tr>
        </thead>
    </table>
    <div id="tb" style="height:auto">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="save()">save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
    </div>
    <div>
        <div id="checkout_value">
            是否已经创建交货单(0,否，1，是)：<input type="checkbox" name="b" value=0 />
            是否交货单都已经生成装运单(0,否，1，是)：<input type="checkbox" name="b" value=0 />
            订单状态(输出是状态是1的):<input type="checkbox" name="b" value=0 />
            <input type="button" value="查询" name="查询" class="btn1"/>
        </div>
        <table id="guize" class="easyui-datagrid" title="Multiple Sorting" style="width:1100px;height:250px"
               data-options="singleSelect:true,collapsible:true,
				url:'flow/findAllGuiZe.action',
				method:'get',
				queryParams:{'boolValues':'true,false,false,false,false,false'},
				remoteSort:false,
				multiSort:true
			">
            <thead>
            <tr>
                <th data-options="field:'id',width:80,sortable:true">id</th>
                <th data-options="field:'orderId',width:80,align:'center'">orderId</th>
                <th data-options="field:'type',width:20,align:'center'">type</th>
                <th data-options="field:'createTime',width:100,align:'center'">createTime</th>
                <th data-options="field:'sum',width:60,align:'center'">sum</th>
                <th data-options="field:'unit',width:80,align:'center'">unit</th>
                <th data-options="field:'status',width:80,align:'center'">status</th>
                <th data-options="field:'updateTime',width:100,align:'center'">updateTime</th>
                <th data-options="field:'isCreateDelivery',width:80,align:'center'">isCreateDelivery</th>
                <th data-options="field:'isADCSO',width:80,align:'center'">isADCSO</th>
                <th data-options="field:'isADToA',width:80">isADToA</th>
                <th data-options="field:'isASFFS',width:80,align:'center'">isASFFS</th>
                <th data-options="field:'isASFS',width:80,align:'center'">isASFS</th>
                <th data-options="field:'isASFIAl',width:80,align:'center'">isASFIAl</th>
            </tr>
            </thead>
        </table>
    </div>
</body>
<script>
    var editIndex = undefined;
    var issave=false;
    function endEditing(){
        if (editIndex == undefined){return true}
        if ($('#dg').datagrid('validateRow', editIndex)){
            var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'id'});
            $('#dg').datagrid('endEdit', editIndex);
            var rows =$('#dg').datagrid("getSelected");
            $.ajax({url:"flow/save.action",async:false,data:{flowName:rows.flowName,
                parentFlow:rows.parentFlow, childFlow:rows.childFlow,flowType:rows.flowType,
                status:rows.status}});
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }
    function onClickRow(index){
        if (editIndex != index){
            if (endEditing()){
                $('#dg').datagrid('selectRow', index)
                        .datagrid('beginEdit', index);
                editIndex = index;
            } else {
                $('#dg').datagrid('selectRow', editIndex);
            }
        }
    }
    function append(){
        if (endEditing()){
            $('#dg').datagrid('appendRow',{status:'P'});
            editIndex = $('#dg').datagrid('getRows').length-1;
            $('#dg').datagrid('selectRow', editIndex)
                    .datagrid('beginEdit', editIndex);
            issave=true;
        }
    }
    function removeit(){
        var rows =$('#dg').datagrid("getSelected");
        if (editIndex == undefined){return}
        $('#dg').datagrid('cancelEdit', editIndex)
                .datagrid('deleteRow', editIndex);
        $.ajax({url:"flow/delete.action",async:false,data:{id:rows.id}});
        editIndex = undefined;
    }
    function accept(){
        if (endEditing()){
            $('#dg').datagrid('acceptChanges');
        }
    }
    function reject(){
        $('#dg').datagrid('rejectChanges');
        editIndex = undefined;
    }
    function getChanges(){
        var rows = $('#dg').datagrid('getChanges');
        alert(rows.length+' rows are changed!');
    }
    $("input[type='checkbox']").click(function () {
        if(this.value==0){
            this.value=1;
        }else{
            this.value=0;
        }
    });
    $(".btn1").click(function(){
        var boolValues=null;
        var values=$("#checkout_value").find("input[type='checkbox']");
        for (var i=0;i<values.length;i++){
            if(values[i]==null || values[i].value==0){
                if (boolValues==null){
                    boolValues ='false';
                }else{
                    boolValues = boolValues + ',false';
                }
            }else{
                if (boolValues==null){
                    boolValues ='true';
                }else{
                    boolValues = boolValues + ',true';
                }

            }
        }
        if(values.length<6){
            for (var i=values.length;i<6;i++){
                boolValues = boolValues + ',false';
            }
        }
        $('#guize').datagrid({
            url:'flow/findAllGuiZe.action',
            method:'get',
            queryParams:{'boolValues':boolValues},
        });
    });
</script>
</html>