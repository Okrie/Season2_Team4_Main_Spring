/**
 * board init하는 javascript
 */

 window.addEventListener('DOMContentLoaded', function() {
		document.getElementById('boardDiv').style.display = 'block';
		document.getElementById('reviewDiv').style.display = 'none';
		document.getElementById('noticeDiv').style.display = 'none';
	});

	document.getElementById('boardBtn').addEventListener('click', function() {
		document.getElementById('boardDiv').style.display = 'block';
		document.getElementById('reviewDiv').style.display = 'none';
		document.getElementById('noticeDiv').style.display = 'none';
		document.getElementById('boardTable').style.display = 'table';
		document.getElementById('reviewTable').style.display = 'none';
		document.getElementById('noticeTable').style.display = 'none';
		document.getElementById('headerTitle').innerText = "게시판 확인";
	});

	document.getElementById('reviewBtn').addEventListener('click', function() {
		document.getElementById('boardDiv').style.display = 'none';
		document.getElementById('reviewDiv').style.display = 'block';
		document.getElementById('noticeDiv').style.display = 'none';
		document.getElementById('boardTable').style.display = 'none';
		document.getElementById('reviewTable').style.display = 'table';
		document.getElementById('noticeTable').style.display = 'none';
		document.getElementById('headerTitle').innerText = "리뷰글 확인";
	});

	document.getElementById('noticeBtn').addEventListener('click', function() {
		document.getElementById('boardDiv').style.display = 'none';
		document.getElementById('reviewDiv').style.display = 'none';
		document.getElementById('noticeDiv').style.display = 'block';
		document.getElementById('boardTable').style.display = 'none';
		document.getElementById('reviewTable').style.display = 'none';
		document.getElementById('noticeTable').style.display = 'table';
		document.getElementById('headerTitle').innerText = "공지사항 확인";
	});