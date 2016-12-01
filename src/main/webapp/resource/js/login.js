/**
 * 
 */

/**
 * Login
 */
function login() {

	$.ajax({
		url : 'login.do',
		type : 'post',
		dataType : "json",
		//JSON Type
// 		contentType:'application/json;charset=utf-8',
		// You Can't add @RequestBody to the method's params for this ContentType(x-www-form-urlencoded)
		// If @RequestBody is added, error would be occured.
		contentType : 'application/x-www-form-urlencoded;charset=utf-8',
		// JSON Data
		data : $("#ff").serializeArray(),
		// JSON Result
		success : function(data) {
			
			if (data.bsResult == ResultCode.Success) {
				
				window.location.href = "main.do";
			} else {
				
				showError(data.bsMessage);
			}
				
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			
			alert(textStatus);
		}
	});
	
//	$("#f").attr("action", "login.do").submit();
}

/**
 * Register
 */
function register(){
    
    window.location.href = "register.do";
}
