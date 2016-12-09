<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Regular</title>
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/icon.css">
    
    <script type="text/javascript" src="resource/js/jquery.min.js"></script>
    
    <script type="text/javascript" src="resource/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resource/js/jquery.i18n.properties.js"></script>
    
    <script type="text/javascript" src="resource/js/common.js"></script>
    
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;padding:10px">Regular</div>
    <div data-options="region:'west',split:true" title="West" style="width:100px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="Title1" style="padding:10px;">
                content1
            </div>
            <div title="Title2" data-options="selected:true" style="padding:10px;">
                content2
            </div>
            <div title="Title3" style="padding:10px">
                content3
            </div>
        </div>
    </div>
	<div data-options="region:'east',split:true" title="East" style="width:180px;">
       <ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
    </div>
	<div data-options="region:'south',border:false" style="height:50px;padding:10px;">Created By Better Sun.</div>
	<div data-options="region:'center',iconCls:'icon-ok'" title="Center" style="padding:5px">
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'north',split:true" style="height:50px"></div>
            <div data-options="region:'west',split:true" style="width:100px">
                TREEE
                <ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
            </div>
            <div data-options="region:'center'">
                <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
	                <div title="About" style="padding:5px"></div>
	                <div title="Regular List" style="padding:5px"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>