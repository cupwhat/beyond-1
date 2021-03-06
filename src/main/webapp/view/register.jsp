<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="msg.beyond.register" /></title>
    <script type="text/javascript" src="resource/js/jquery.min.js"></script>
    
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resource/easyui/themes/icon.css">
    
    <script type="text/javascript" src="resource/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resource/js/jquery.i18n.properties.js"></script>
    
    <script type="text/javascript" src="resource/js/common.js"></script>

    <script type="text/javascript">
    
        $(document).ready(function(){
            
//          alert('BS');
        });

        /**
         *
         */
        function test(){
            
            
            window.location.href = "test.do";
        }

    </script>
</head>
<body>
    <h2><fmt:message key="msg.beyond.register.title" /></h2>
    <p><fmt:message key="msg.beyond.register.title.description" /></p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="name" style="width:100%" data-options="label:'Name:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="password" style="width:100%" data-options="label:'Email:',required:true,validType:'email'">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="subject" style="width:100%" data-options="label:'Subject:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="message" style="width:100%;height:60px" data-options="label:'Message:',multiline:true">
            </div>
            <div style="margin-bottom:20px">
                <select class="easyui-combobox" name="language" label="Language" style="width:100%"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
            </div>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
        </div>
    </div>
    <script>
        function submitForm(){
            $('#ff').form('submit',{
                onSubmit:function(){
                    return $(this).form('enableValidation').form('validate');
                }
            });
        }
        function clearForm(){
            $('#ff').form('clear');
        }
    </script>
</body>
</html>