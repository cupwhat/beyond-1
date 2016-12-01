<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title><fmt:message key="msg.beyond.main.title" /></title>
    <script type="text/javascript" src="resource/js/jquery.min.js"></script>
    
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/icon.css">
    
    <script type="text/javascript" src="resource/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resource/js/jquery.i18n.properties.js"></script>
    
    <script type="text/javascript" src="resource/js/common.js"></script>

    <script type="text/javascript">
    
        $(document).ready(function(){
        	
//         	alert('BS');
        });

        /**
         *
         */
        function login(){
            
            
            window.location.href = "login.do";
        }

        /**
         *
         */
        function test(){
        	
        	
            window.location.href = "test.do";
        }

        var bUser = {
       	    userName : "BS",
       	    password : "12"
       	};
        
        /**
         * AJAX
         */
        function ajax(){

            $.ajax({
                url:'ajax.do',
                type:'post',
                dataType: "json",
                //JSON Type
                contentType:'application/json;charset=utf-8',
                // JSON Data
                data:JSON.stringify(bUser),
                // JSON Result
                success:function(data){
                    console.log("success");
                    alert(data.userName);
                },
                error: function(e){
                    alert("Error");
                    console.log("error");
                }
            });
        }

        function testProperties(){
            
            alert($.i18n.prop('msg.beyond'));
        }

    </script>
</head>
<body>
    <h2><fmt:message key="msg.beyond.main.title.business" /></h2>
    <p>This is Beyond Main Page.</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="<fmt:message key="msg.beyond.main.title.business" />"
        style="width:100%;max-width:600px;padding:30px 60px;">
        <div style="text-align:center;padding:5px 0">
            <a href="#" class="easyui-linkbutton" onclick="login()" style="width:80px">Login</a>
<!--             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="ajax()" style="width:80px">Ajax Test</a> -->
<!--             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="testProperties()" style="width:80px">Properties Test</a> -->
        </div>
    </div>
    <div style="margin:10px 0;"></div>
    <div class="easyui-panel" title="Test" style="width:100%;max-width:600px;padding:30px 60px;">
        <div style="text-align:center;padding:5px 0">
            <a href="#" class="easyui-linkbutton" onclick="test()" style="width:80px">Test</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="ajax()" style="width:80px">Ajax Test</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="testProperties()" style="width:160px">Properties Test</a>
        </div>
    </div>
    <div style="margin:20px 0;"></div>
</body>
</html>