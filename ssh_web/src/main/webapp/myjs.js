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

        }
        function append(){
            if (endEditing()){       } else {
            $('#dg').datagrid('selectRow', editIndex);
        }
    }
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
    $.ajax({url:"flow/findAllGuiZe.action",
        data:{"boolValues":boolValues},async:false,type:"POST",dataType:'json',
        success:function (data) {
            var datalist=data.rows;
            console.log(datalist);
            datalist.forEach(function (e) {
                $('.guizebody').html('<tr><td>'+e.id+'</td><td>'
                    +e.orderId+'</td><td>'
                    +e.type+'</td><td>'+e.createTime+'</td><td>'
                    +e.sum+'</td><td>'+e.unit+'</td><td>'
                    +e.status+'</td><td>'+e.updateTime+'</td><td>'
                    +e.isCreateDelivery+'</td><td>'+e.isADCSO+'</td><td>'
                    +e.isADToA+'</td><td>'+e.isASFFS+'</td><td>'
                    +e.isASFS+'</td><td>'+e.isASFIAl+'</td></tr>');
            });
        }});
});
