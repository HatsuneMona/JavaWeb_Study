function checkNumber(idString, DOWN, UP) {
  let no = $(idString).val();//jQuery语法
  let uphoneRegExp = eval("/^[0-9]{" + DOWN + "," + UP + "}$/");
  if (uphoneRegExp.test(no)) {
    $(idString).css("border-color", "");
    return true;
  } else {
    $(idString).css("border-color", "red");
    return false;
  }
}

function checkUnicode(idString, DOWN, UP) {
  let realname = $(idString).val();//jQuery语法
  let unameRegExp = eval("/^[\u4e00-\u9fa5]{" + DOWN + "," + UP + "}$/");
  if (unameRegExp.test(realname)) {
    $(idString).css("border-color", "");
    return true;
  } else {
    $(idString).css("border-color", "red");
    return false;
  }
}

