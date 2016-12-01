<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title><fmt:message key="msg.beyond.main.title" /></title>
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/icon.css">
    
    <link rel="stylesheet" type="text/css" href="resource/css/common.css">
    
</head>
<body>
    <h2><fmt:message key="msg.beyond.main.title.business" />&nbsp;&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;${userName}</h2>
    <p>This is Beyond Main Page.</p>
    <div style="margin:10px 0;"></div>
    <div id="bsMsg" style="display:none;"></div>
    <div id="bsError" class="errorMsg" style="display:none;"></div>
    <div style="margin:10px 0;"></div>
    <div class="easyui-panel" title="<fmt:message key="msg.beyond.main.title.business" />"
        style="width:100%;max-width:600px;padding:30px 60px;">
        <div style="text-align:center;padding:5px 0">
            <a href="#" class="easyui-linkbutton" onclick="login()" style="width:80px">Login</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="register()" style="width:80px">Register</a>
            <!-- href="#" ： for refreshing ${xx} tag. (eg: ${userName}) -->
            <a href="#" class="easyui-linkbutton" onclick="logout()" style="width:80px">Logout</a>
        </div>
    </div>
    <div style="margin:10px 0;"></div>
    <div class="easyui-panel" title="Test" style="width:100%;max-width:600px;padding:30px 60px;">
    
        <h2>${testLabel}</h2>
        <div style="text-align:center;padding:5px 0">
            <a href="#" class="easyui-linkbutton" onclick="test()" style="width:80px">Test</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="ajax()" style="width:80px">Ajax Test</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="testProperties()" style="width:160px">Properties Test</a>
        </div>
    </div>
    <div style="margin:20px 0;"></div>
    
    
    <script type="text/javascript" src="resource/js/jquery.min.js"></script>
    
    <script type="text/javascript" src="resource/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resource/js/jquery.i18n.properties.js"></script>
    
    <script type="text/javascript" src="resource/js/common.js"></script>
    <script type="text/javascript" src="resource/js/main.js"></script>
</body>
</html>