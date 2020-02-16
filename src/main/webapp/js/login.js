function loginGo() {
		location.href="/login"; 
	}
function logout() {
		if(confirm('정말 로그아웃 하시겠습니까?')){
			location.href="/logout"; 
		}
}
function home() {
		location.href="/"; 
}