function checkTeacherNo() {
  let no = $("#teacherNo").val();
  let uphoneRegExp = /^[0-9]{2,11}$/;
  if (uphoneRegExp.test(no)) {
    $("#teacherNo").css("border-color", "");
    return true;
  } else {
    $("#teacherNo").css("border-color", "red");
    return false;
  }
}

function checkTeacherName() {
  let realname = $("#teacherName").val();//jQuery语法
  //以字母开头，字母与数字的组合，3-10字符
  let unameRegExp = /^[\u4e00-\u9fa5]{2,10}$/;
  if (unameRegExp.test(realname)) {
    $("#teacherName").css("border-color", "");
    return true;
  } else {
    $("#teacherName").css("border-color", "red");
    return false;
  }
}

function checkTeacherAge() {
  let age = $("#teacherAge").val();
  let uphoneRegExp = /^[0-9]{1,2}$/;
  if (uphoneRegExp.test(age)) {
    $("#teacherAge").css("border-color", "");
    return true;
  } else {
    $("#teacherAge").css("border-color", "red");
    return false;
  }
}

function checkTeacherDept() {
  let age = $("#teacherDept").val();
  let uphoneRegExp = /^[0-9]{1,11}$/;
  if (uphoneRegExp.test(age)) {
    $("#teacherDept").css("border-color", "");
    return true;
  } else {
    $("#teacherDept").css("border-color", "red");
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


function checkAll() {
  if (checkTeacherNo() && checkTeacherName() && checkTeacherAge()
      && checkTeacherDept() && checksex()) {
    return true;
  } else {
    return false;
  }
}