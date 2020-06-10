function checkInfo(idString, type, DOWN, UP) {
  let string = $("#" + idString).val();//jQuery语法
  let uRegExp;
  if (type == "number") {
    uRegExp = eval("/^[0-9]{" + DOWN + "," + UP + "}$/");
  } else if (type == "pw") {
    uRegExp = eval("/^[\w]{" + DOWN + "," + UP + "}$/");
  } else {
    uRegExp = eval("/^[\u4e00-\u9fa5]{" + DOWN + "," + UP + "}$/");
  }
  if (uRegExp.test(string)) {
    $("#" + idString).css("border-color", "");
    return true;
  } else {
    $("#" + idString).css("border-color", "red");
    return false;
  }
}

function checkPassword() {
  pw = $("#password").val();//jQuery语法
  //以字母开头，字母与数字的组合，3-10字符
  let unameRegExp = /^[\w]{6,20}$/;
  if (unameRegExp.test(pw)) {
    $("#password").css("border-color", "");
    return true;
  } else {
    $("#password").css("border-color", "red");
    return false;
  }
}

function checkAll() {
  if (checkInfo('role', 'str', 1, 10) &&
      //checkInfo('email', 'str', 5, 30) &&
      checkInfo('phone', 'number', 11, 11) &&
      checkInfo('duty', 'str', 1, 15) &&
      checkInfo('year', 'number', 4, 4) &&
      checkInfo('realname', 'str', 2, 5) &&
      checkPassword()) {
    return true
  } else {
    return false
  }
}