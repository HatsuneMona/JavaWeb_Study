function checkUsername() {
    let uname = $("#username").val();//jQuery语法
    //以字母开头，字母与数字的组合，3-10字符
    let unameRegExp = /^[a-zA-Z][a-zA-z0-9]{2,9}$/;
    if (unameRegExp.test(uname)) {
        $("#username").css("border-color", "");
        return true;
    } else {
        $("#username").css("border-color", "red");
        return false;
    }
}

function checkPhoneNum() {
    let uphone = $("#phonenum").val();
    let uphoneRegExp = /^[0-9]{11}$/;
    if (uphoneRegExp.test(uphone)) {
        $("#phonenum").css("border-color", "");
        return true;
    } else {
        $("#phonenum").css("border-color", "red");
        return false;
    }
}

function checksex() {
    if ($("#sex").val != "") {
        $("#sex").css("border-color", "");
        return true;
    } else {
        $("#sex").css("border-color", "red");
        return false
    }
}

function checkRealname() {
    let realname = $("#realname").val();//jQuery语法
    //以字母开头，字母与数字的组合，3-10字符
    let unameRegExp = /^[\u4e00-\u9fa5]{2,5}$/;
    if (unameRegExp.test(realname)) {
        $("#realname").css("border-color", "");
        return true;
    } else {
        $("#realname").css("border-color", "red");
        return false;
    }
}

var pw;

function checkPassword1() {
    pw = $("#password1").val();//jQuery语法
    //以字母开头，字母与数字的组合，3-10字符
    let unameRegExp = /^[\w]{2,5}$/;
    if (unameRegExp.test(pw)) {
        $("#password1").css("border-color", "");
        return true;
    } else {
        $("#password1").css("border-color", "red");
        return false;
    }
}

function checkPassword2() {
    //let pw1 = $("#password1").val();//jQuery语法
    //let pw2 = $("#password2").val();
    //以字母开头，字母与数字的组合，3-10字符
    //let unameRegExp = /^[0-9][a-z][A-Z]{2,5}$/;
    if (pw !== "" && pw === $("#password2").val()) {
        $("#password2").css("border-color", "");
        return true;
    } else {
        $("#password2").css("border-color", "red");
        return false;
    }
}

function checkAll() {
    if (checkUsername() && checkPhoneNum() && checksex()
        && checkPassword1() && checkPassword2() && checkRealname()) {
        return true;
    }
    else{
        return false;
    }
}