/**
 * img preview
 */
function openFileUploader() {
	// 파일 업로드 창을 열기 위해 fileUploader 요소를 클릭합니다.
	document.getElementById('fileUploader').click();
}

function handleFileSelect(event) {
	var file = event.target.files[0];

	// FileReader 객체를 사용하여 이미지 파일을 읽습니다.
	var reader = new FileReader();
	reader.onload = function(e) {
		// 이미지 파일의 데이터를 가져와서 이미지 미리보기를 업데이트합니다.
		document.getElementById('imagePreview').src = e.target.result;
	};
	reader.readAsDataURL(file);
	// 선택한 파일의 정보를 가져옵니다.

	document.getElementById('photo').value = file[0].name;
	document.getElementById('photoname').placeholder = file[0].name;
}
