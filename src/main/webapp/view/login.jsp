<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="msg.beyond.login" /></title>
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/icon.css">
    
    <link rel="stylesheet" type="text/css" href="resource/css/common.css">
</head>
<body>
    <h2><fmt:message key="msg.beyond.login.title" /></h2>
    <p><fmt:message key="msg.beyond.login.title.description" /></p>
    <div style="margin:10px 0;"></div>
    <div id="bsMsg" style="display:none;"></div>
    <div id="bsError" class="errorMsg" style="display:none;"></div>
    <div style="margin:10px 0;"></div>
    <div class="easyui-panel" title="<fmt:message key="msg.beyond.login.title" />" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="userId" style="width:100%"
                    data-options="label:'User Id:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input type="password" class="easyui-textbox" id="password" name="password" style="width:100%"
                    data-options="label:'Password',required:true">
            </div>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="login()" style="width:80px">Login</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="register()" style="width:80px">Register</a>
        </div>
    </div>
    
    <script type="text/javascript" src="resource/js/jquery.min.js"></script>
    
    <script type="text/javascript" src="resource/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resource/js/jquery.i18n.properties.js"></script>
    
    <script type="text/javascript" src="resource/js/common.js"></script>
    <script type="text/javascript" src="resource/js/login.js"></script>
    
</body>
</html>