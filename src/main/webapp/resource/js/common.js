/**
 * 
 */

var ResultCode = {
	Success : "1",
	Fail : "0"
}

/**
 * Key
 */
var Keys = {
    F1 : "f1",
    F2 : "f2",
    F3 : "f3",
    F4 : "f4",
    F5 : "f5",
    F6 : "f6",
    F7 : "f7",
    F8 : "f8",
    F9 : "f9",
    F10 : "f10",
    F11 : "f11",
    F12 : "f12",
    F12 : "f12",

    Esc : "esc",
    Enter : "return",
    Backspace : "backspace",
    Delete : "delete"
};

/**
 * Initialize
 */
$(document).ready(function() {

    /**
     * Load properties file
     */
    $.i18n.properties({
        name:'strings',
        path:'resource/message/',
        cashe:false,
        mode:'map',
        callback: function() {
            // 
        }
    });
    
    
    
    /**
     * IE F1
     */
    window.onhelp = function() { return false; };
    
    /**
     * Keydown Event
     */
    window.onkeydown = globalKeydown;
    function globalKeydown(event) {

        var e = window.event || event || event.which;

        // F1 - F12 Enter Esc BackSpace Delete
        if (e.keyCode == 13
            || e.keyCode == 27
            || e.keyCode == 8
            || e.keyCode == 46
            || e.keyCode == 112
            || e.keyCode == 113
            || e.keyCode == 114
            || e.keyCode == 115
            || e.keyCode == 116
            || e.keyCode == 117
            || e.keyCode == 118
            || e.keyCode == 119
            || e.keyCode == 120
            || e.keyCode == 121
            || e.keyCode == 122
            || e.keyCode == 123) {

            e.keyCode = 0;

            switch (e.keyCode){
            case 13:    // Enter
                return doEnter();
                break;
            case 27:    // Esc
                return doEsc();
                break;
            case 8:     // BackSpace
                return doBackspace();
                break;
            case 46:    // Delete
                return doDelete();
                break;
            case 112:
                return doF1();
                break;
            case 113:
                return doF2();
                break;
            case 114:
                return doF3();
                break;
            case 115:
                return doF4();
                break;
            case 116:
                return doF5();
                break;
            case 117:
                return doF6();
                break;
            case 118:
                return doF7();
                break;
            case 119:
                return doF8();
                break;
            case 120:
                return doF9();
                break;
            case 121:
                return doF10();
                break;
            case 122:
                return doF11();
                break;
            case 123:
                return doF12();
                break;
            default:
                return false;
            }

            return false;
        }
    }
});

function doEnter() {return handleKeyDown(Keys.Enter);}
function doEsc() {return handleKeyDown(Keys.Esc);}
function doBackspace() {return handleKeyDown(Keys.Backspace);}
function doDelete() {return handleKeyDown(Keys.Delete);}
function doF1() {return handleKeyDown(Keys.F1);}
function doF2() {return handleKeyDown(Keys.F2);}
function doF3() {return handleKeyDown(Keys.F3);}
function doF4() {return handleKeyDown(Keys.F4);}
function doF5() {return handleKeyDown(Keys.F5);}
function doF6() {return handleKeyDown(Keys.F6);}
function doF7() {return handleKeyDown(Keys.F7);}
function doF8() {return handleKeyDown(Keys.F8);}
function doF9() {return handleKeyDown(Keys.F9);}
function doF10() {return handleKeyDown(Keys.F10);}
function doF11() {return handleKeyDown(Keys.F11);}
function doF12() {return handleKeyDown(Keys.F12);}

/**
 * get the length of string (full and half)
 */
function getLength(s) {

 var length = 0;
 var l = s.length;
 for (var i = 0; i < l; i++) {
     
     //Full(Half * 2)
     if (s.charCodeAt(i) < 0 ||  s.charCodeAt(i) > 255)
         length = length + 2;
     else
         length++;
 }
 return length;
}

function showMessage(msg) {

	$("#bsError").hide();
	$("#bsMsg").show();
	$("#bsMsg").html(msg);
	

//	$("#bsMsg").addClass("errorMsg");
//	$("#bsMsg").html(dmsg);
//	$("#bsMsg").show();
}

function showError(msg) {

	$("#bsMsg").hide();
	$("#bsError").show();
	$("#bsError").html(msg);

//	$("#bsMsg").removeClass("errorMsg");
//	$("#bsMsg").html(msg);
//	$("#bsMsg").show();
}
