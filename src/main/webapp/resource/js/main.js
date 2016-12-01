/**
 * 
 */

$(document).ready(function(){
	
	// alert('BS');
});

/**
 * Login
 */
function login(){
    
    window.location.href = "showLogin.do";
}

/**
 * Login
 */
function logout(){
    
    window.location.href = "logout.do";
}

/**
 * Register
 */
function register(){
    
    window.location.href = "register.do";
}

/**
 * Test
 */
function test(){
	
	
    window.location.href = "test.do";
}

var bUser = {
    userName : "BS",
    password : "12"
};

/**
 * AJAX Test
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

/**
 * Properties Test
 */
function testProperties(){
    
    alert($.i18n.prop('msg.beyond'));
}
