var date = new Date();
var day = date.getDate();
var month = date.getMonth() + 3;
var year = date.getFullYear();
if (month < 10) month = "0" + month;
if (day < 10) day = "0" + day;
var today = year + "-" + month + "-" + day;
document.getElementById('dateEnd').value = today;