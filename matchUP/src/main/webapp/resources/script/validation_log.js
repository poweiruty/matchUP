$(document).ready(function() {
	openTab("active", "puser_login");
});
function openTab(evt, tabName) {
	// 탭 내용을 모두 숨김
	let i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	// 탭 버튼의 active 클래스 제거
	tablinks = document.getElementsByClassName("tablink");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	// 선택된 탭 내용 표시 및 버튼에 active 클래스 추가
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.class += " active";
}