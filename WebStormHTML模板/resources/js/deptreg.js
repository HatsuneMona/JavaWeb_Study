function checkDeptNo() {
  let no = $("#deptNo").val();
  let uphoneRegExp = /^[0-9]{2,11}$/;
  if (uphoneRegExp.test(no)) {
    $("#deptNo").css("border-color", "");
    return true;
  } else {
    $("#deptNo").css("border-color", "red");
    return false;
  }
}

function checkDeptName() {
  let realname = $("#deptName").val();//jQuery语法
  //以字母开头，字母与数字的组合，3-10字符
  let unameRegExp = /^[\u4e00-\u9fa5]{2,20}$/;
  if (unameRegExp.test(realname)) {
    $("#deptName").css("border-color", "");
    return true;
  } else {
    $("#deptName").css("border-color", "red");
    return false;
  }
}

function checkDeptHeader() {
  let header = $("#deptHeader").val();
  let uphoneRegExp = /^[0-9]{2,11}$/;
  if (uphoneRegExp.test(header)) {
    $("#deptHeader").css("border-color", "");
    return true;
  } else {
    $("#deptHeader").css("border-color", "red");
    return false;
  }
}

function checkAll() {
  if (checkDeptNo() && checkDeptName() && checkDeptHeader()) {
    return true;
  } else {
    return false;
  }
}