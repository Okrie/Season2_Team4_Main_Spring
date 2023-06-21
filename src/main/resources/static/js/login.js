/**
 * 
 */

 function checkMember() {
	const regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
	const regExpName = /^[가-힣]*$/
	const regExpPasswd = /^[0-9|a-z|A-Z]*$/
	const regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
	const regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
	const regExpAdmin = /^(?!.*(?:admin|root|insert|update|revoke|submit|select|delete|create|drop))^.*$/
	const regExpBirth = /^(19[4-9]\d|20[0-9]{2})\.(0[1-9]|1[0-2])\.(0[1-9]|[12]\d|3[01])$/;
	
	const form = document.user
	const id = document.getElementById("userid").value
	const inputid = document.getElementById("inputID").value
	const idCheck = document.getElementById("idCheck").value
	const name = document.getElementById("name").value
	const passwd1 = document.getElementById("password1").value
	const passwd2 = document.getElementById("password2").value
	const phone = document.getElementById("telno").value
	const address = document.getElementById("address_detail").value
	const email = document.getElementById("email").value
	const birthdate = document.getElementById("age").value
	const gender = document.querySelector('input[name="gender"]:checked').value;
	const allergy = document.getElementById("allergyCheck").value
	
	if(!regExpId.test(id)){
		alert("아이디는 문자로 시작해 주세요.")
		return
	}
	
	if(!regExpAdmin.test(inputid)){
		alert("사용이 불가능한 아이디 입니다. 다시 작성해주세요.")
		return
	}
	
	if(idCheck.value == 0){
		alert("아이디 중복체크를 해주세요.")
		return	
	}
	
	if(!regExpName.test(name)){
		alert("이름은 한글로만 입력해주세요.")
		return
	}
	
	if(passwd1 == "" || passwd2 == ""){
		alert("비밀번호를 입력해주세요.")
		return
	}
	
	if(!regExpPasswd.test(passwd1) || !regExpPasswd.test(passwd2)){
		alert("비밀번호는 영문 또는 숫자로만 입력해주세요.")
		return
	}
	
	if(passwd1 !== passwd2){
		alert("비밀번호가 일치 하지 않습니다.")
		return
	}
	
	if(address == ""){
		alert("상세 주소를 입력해주세요.")
		return	
	}
		
	if(!regExpPhone.test(phone)){
		alert("연락처 입력을 확인해주세요.")
		return
	}
	
	if(!regExpEmail.test(email)){
		alert("이메일 입력을 확인해주세요.")
		return
	}
	
	if(!regExpBirth.test(birthdate)){
		alert("생년월일을 확인해주세요.")
		return
	}
	
	if(allergy.value == 0){
		alert("알러지 항목을 확인해주세요. 알러지가 없다면 확인만 눌러주세요.")
		return
	}
	
	alert("환영합니다.")
	
	form.submit()
}

function checkPassword(){
	var password1 = document.getElementById("password1").value
	var password2 = document.getElementById("password2").value
	
	if((password1 === password2) && password1 !== ""){
		document.getElementById("passwordStatus").value = "비밀번호 일치";
		document.getElementById("passwordStatus").style.color = "BLUE";
	} else{
		document.getElementById("passwordStatus").style.color = "RED";
		document.getElementById("passwordStatus").value = "비밀번호 불일치";
	}
}

function checkWho(){
	var result = document.loginfn.result.value
	
	if(result === ""){
		alert("아이디 혹은 비밀번호가 틀렸습니다.")
		return
	}else if(result === "admin"){
		alert("안녕하세요, 관리자님")
		return
	}else if(result === "user"){
		alert("환영합니다." + document.loginfn.loginuid.value + "님")
		return
	}
}

function setIdpw(){
	var form = document.createElement('form');
	var objs;
	objs = document.createElement('input');
	objs.setAttribute('type', 'text');
	
	var uid = document.getElementById("exampleInputEmail");
	var upw = document.getElementById("exampleInputPassword");
	
	objs.setAttribute('name', 'exampleInputEmail');
	objs.setAttribute('value', $('#userid').val());
	form.appendChild(objs);
	objs.setAttribute('type', 'text');
	objs.setAttribute('name', 'exampleInputPassword');
	objs.setAttribute('value', $('#userpw').val());
	form.appendChild(objs);
	form.setAttribute('method', 'post');
	form.setAttribute('action', 'loginCheck')
	document.body.appendChild(form)
	form.submit();
	
	window.location.href = "loginCheck?userid="+ uid.value + "&userpw=" + upw.value;
}

function checkUser(getResult, getId){
	
	const user = 'user'
	const admin = 'admin'

	if(getResult === user){
		alert('환영합니다. ' + getId)
		window.location.href = "/"
	} else if(getResult === admin){
		alert('안녕하세요, 관리자님')
		window.location.href = "adminLogin"
	} else{
		alert('아이디 혹은 비밀번호가 틀렸습니다. 다시 시도해 주세요.')
		return;
	}
}

function setStatusVar(varStat){
	
	if(varStat === "allergyCheck"){
		document.getElementById("allergyCheck").value = 1;
	}else{
		document.getElementById("allergyCheck").value = '0';
	}
	if(varStat === "idCheck"){
		document.getElementById("idCheck").value = 1;
	}else{
		document.getElementById("idCheck").value = '0';
	}
}

function checkDuplicate() {
	var id = $("#inputID").val();
	const btn1 = document.getElementById("modalCheck");
	btn1.style.display = 'none';
	document.getElementById("inputID").value = "";
	
	if(id == ""){
		alert("ID를 입력해주세요.")
		return;
	}else{
		$.ajax({
		    type: "POST",
		    url: "register/duplicate", // URL
		    data: { userid : id },
		    success: function(result) {
				console.log(result)
				if (result === 0) {
					alert("사용 가능한 아이디 입니다.");
					document.getElementById("userid").value = id;
					document.getElementById("uid").value = id;
					btn1.style.display = 'block';
				} else if(result === 1){
					alert("이미 존재하는 아이디 입니다.");
					btn1.style.display = 'none';
				} else{
					alert("사용 불가능한 아이디 입니다.");
					btn1.style.display = 'none';
				}
			},
			error: function(xhr, status, error) {
			    console.log("에러 발생: " + error); // 오류 메시지 출력
			}
		});
	}
}

function addressbtn(){
	// kakao map
	new daum.Postcode({
		oncomplete: function(data){ 
			// 주소 선택시 세팅
			document.getElementById("address_kakao").value = data.address;
			document.getElementById("address_detail").value = data.address;
			document.querySelector("input[id=address_detail]").focus();
		}
	}).open();
}

function chkpw(userid){
	var userpw = document.getElementById('password').value
	$.ajax({
	    type: "POST",
	    url: "NDUserCheck", // URL
	    data: { userid : userid,
	    		userpw : userpw },
	    success: function(result) {
			if (result === Number(1)) {
				window.location.href = "mypageDetail"
			} else{
				alert("비밀번호가 틀렸습니다.")
			}
		},
		error: function(xhr, status, error) {
		    console.log("에러 발생: " + error); // 오류 메시지 출력
		}
	});
}

function updateMember() {
	const regExpName = /^[가-힣]*$/
	const regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
	const regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
	const regExpBirth = /^(19[4-9]\d|20[0-9]{2})\.(0[1-9]|1[0-2])\.(0[1-9]|[12]\d|3[01])$/;
	
	const form = document.user
	const id = document.getElementById("userid").value
	const name = document.getElementById("name").value
	const phone = document.getElementById("telno").value
	const address = document.getElementById("address_detail").value
	const email = document.getElementById("email").value
	const birthdate = document.getElementById("birthdate").value
	const allergy = document.getElementById("allergyCheck").value
	
	if(!regExpName.test(name)){
		alert("이름은 한글로만 입력해주세요.")
		return
	}
	
	if(address == ""){
		alert("상세 주소를 입력해주세요.")
		return	
	}
		
	if(!regExpPhone.test(phone)){
		alert("연락처 입력을 확인해주세요.")
		return
	}
	
	if(!regExpEmail.test(email)){
		alert("이메일 입력을 확인해주세요.")
		return
	}
	
	if(!regExpBirth.test(birthdate)){
		alert("생년월일을 확인해주세요.")
		return
	}
	
	alert("정보가 수정되었습니다.")
	
	form.submit()
}

function formatBirthdate(input) {
  var value = input.value.replace(/\D/g, ''); // 숫자 이외의 문자 제거
  var formattedValue = value.replace(/(\d{4})(\d{2})(\d{2})/, '$1.$2.$3'); // 형식 적용
  input.value = formattedValue;
}

function cartInsertFn(pcode){
	if(document.getElementById("qty") === null || document.getElementById("qty") === undefined){
		var count = 1;
	}else{
		var count = document.getElementById("qty").value;
	}
	//var pcode = document.getElementById("pcode").value();
	$.ajax({
	    type: "POST",
	    url: "NDCartInsert", // URL
	    data: { pcode : pcode,
	    		count : count },
	    success: function(result) {
			console.log(result)
			if (Number(result) == Number(0)) {
				alert("장바구니에 추가하였습니다.");
				window.location.reload();
			} else if(Number(result) == Number(2)){
				alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
				window.location.href = "login";
			} else{
				alert("장바구니에 추가하지 못했습니다.");
			}
		},
		error: function(xhr, status, error) {
		    console.log("에러 발생: " + error); // 오류 메시지 출력
		}
	});
}

function wishInsertFn(pcode){
	//var pcode = document.getElementById("pcode").value();
	$.ajax({
	    type: "POST",
	    url: "wishlist", // URL
	    data: { pcode : pcode },
	    success: function(result) {
			console.log(result)
			if (Number(result) == Number(0)) {
				alert("위시리스트에 추가하였습니다.");
				window.location.reload();
			} else if(Number(result) == Number(2)){
				alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
				window.location.href = "login";
			} else{
				alert("위시리스트에 추가하지 못했습니다.");
			}
		},
		error: function(xhr, status, error) {
		    console.log("에러 발생: " + error); // 오류 메시지 출력
		}
	});
}

function wishdeleteFn(pcode){
	//var pcode = document.getElementById("pcode").value();
	$.ajax({
	    type: "POST",
	    url: "wishlistdelete", // URL
	    data: { pcode : pcode },
	    success: function(result) {
			console.log(result)
			if (Number(result) == Number(0)) {
				alert("위시리스트에서 삭제하였습니다.");
				window.location.reload();
			} else if(Number(result) == Number(2)){
				alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
				window.location.href = "login";
			} else{
				alert("위시리스트에서 삭제하지 못했습니다.");
			}
		},
		error: function(xhr, status, error) {
		    console.log("에러 발생: " + error); // 오류 메시지 출력
		}
	});
}