// function myFunction() {
//     document.getElementById("test").innerHTML="测试通过";
// }

function calculation() {

  var money = document.getElementById("money").value;
  var yanglaoa = money * 0.08;
  var yanglaob = money * 0.2;
  var yiliaoa = money * 0.02;
  var yiliaob = money * 0.06;
  var sya = money * 0.005;
  var syb = money * 0.015;
  var gs = money * 0.005;
  var sy = money * 0.008;
  var gjj = money * 0.12;
  var alla = yanglaoa + yiliaoa + sya + gjj;
  var allb = yanglaob + yiliaob + syb + gs + sy;
  var all = alla + allb;
  document.getElementById("yanglaoa").innerHTML = yanglaoa.toString();
  document.getElementById("yanglaob").innerHTML = yanglaob.toString();
  document.getElementById("yiliaoa").innerHTML = yiliaoa.toString();
  document.getElementById("yiliaob").innerHTML = yiliaob.toString();
  document.getElementById("sya").innerHTML = sya.toString();
  document.getElementById("syb").innerHTML = syb.toString();
  document.getElementById("gs").innerHTML = gs.toString();
  document.getElementById("sy").innerHTML = sy.toString();
  document.getElementById("gjja").innerHTML = gjj.toString();
  document.getElementById("gjjb").innerHTML = gjj.toString();
  document.getElementById("alla").innerHTML = alla.toString();
  document.getElementById("allb").innerHTML = allb.toString();
  document.getElementById("all").innerHTML = all.toString();

}