var httpPath = "http://localhost:8090/manage/";
if (top.location.href != httpPath) {
	alert("不允许你这样操作！");
	window.opener = null;
	window.close();
	// window.open("","_self");
	location.href = httpPath;
}