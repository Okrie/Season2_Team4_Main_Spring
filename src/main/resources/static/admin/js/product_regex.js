$(document).ready(function() {
	$("#confirmInsert").on("click", function(e) {
		e.preventDefault();
		checkRegex();
	});

	function checkRegex() {
		const regExpName = /^[\s가-힣]{1,20}$/;
		const regExpCategory = /^[\s가-힣]{1,20}$/;
		const regExpRice = /^[\s가-힣,()]{1,20}$/;
		const regExpCook1 = /^[\s가-힣,()]{1,20}$/;
		const regExpCook2 = /^[\s가-힣,()]{0,20}$/;
		const regExpCook3 = /^[\s가-힣,()]{0,20}$/;
		const regExpSoup = /^[\s가-힣,()]{1,20}$/;
		const regExpStock = /^[0-9]{0,20}$/;
		const regExpPrice = /^[0-9]{0,20}$/;
		const regExpCalories = /^[0-9]{0,20}$/;

		const name = $("#name").val();
		const category = $("#category").val();
		const rice = $("#rice").val();
		const cook1 = $("#cook1").val();
		const cook2 = $("#cook2").val();
		const cook3 = $("#cook3").val();
		const soup = $("#soup").val();
		const stock = $("#stock").val();
		const price = $("#price").val();
		const calories = $("#calories").val();

		if (!regExpName.test(name)) {
			Swal.fire(
				'제품 이름 수정이 필요합니다.',
				'20자 이하 한글 이름만 가능합니다.',
				'error'
			);
			return;
		}

		if (!regExpCategory.test(category)) {
			Swal.fire(
				'카테고리 수정이 필요합니다.',
				'20자 이하 한글 이름만 가능합니다.',
				'error'
			);
			return;
		}

		// 나머지 필드들의 유효성 검사도 동일하게 작성

		Swal.fire({
			title: '수정 및 입력 확인',
			text: '수정 및 입력하시겠습니까?',
			icon: 'warning',
			showCancelButton: true,
			showCloseButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '승인',
			cancelButtonText: '취소',
			allowOutsideClick: false,
			allowEscapeKey: false
		}).then((result) => {
			if (result.isConfirmed) {
				const form = $("#product");
				form.submit();

				Swal.fire({
					title: '승인',
					text: '수정 및 입력 처리되었습니다.',
					icon: 'success',
					confirmButtonText: '확인',
					confirmButtonColor: '#3085d6',
					allowOutsideClick: false,
					allowEscapeKey: false
				});
			}
		});
	}

	$("#confirmDelete").on("click", function() {
		var pcode = $(this).data("pcode");
		var invalidate = $(this).data("invalidate");
		Swal.fire({
			title: '삭제 및 복구 확인',
			text: '누르시면, 되돌릴 수 없습니다.',
			icon: 'warning',
			showCancelButton: true,
			showCloseButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '승인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.isConfirmed) {
				Swal.fire({
					title: '승인',
					text: '삭제 및 복구 처리되었습니다.',
					icon: 'success',
					confirmButtonText: '확인',
					confirmButtonColor: '#3085d6',
					allowOutsideClick: false,
					allowEscapeKey: false
				}).then(() => {
					window.location.href = "adminUpdateProduct?invalidate=" + invalidate + "&pcode=" + pcode;
				});
			}
		});
	});
});
