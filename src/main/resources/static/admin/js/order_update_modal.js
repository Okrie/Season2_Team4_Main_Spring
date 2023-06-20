/**
 * 
 */

  $("#confirmRefund").click(function () {
        	var ordercode = $(this).data("ordercode");
            Swal.fire({
                title: '환불 확인',
                text: '누르시면, 되돌릴 수 없습니다.',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '승인',
                cancelButtonText: '취소'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                    	'환불 처리 완료!',
                        '환불 처리되었습니다.',
                        'success'
                    ).then(() => {
                      window.location.href= "adminUpdateOrdersRefund?ordercode="+ordercode;
                    });
                }
            })
        });

        $("#confirmDelivery").click(function () {
        	var ordercode = $(this).data("ordercode");
            Swal.fire({
                title: '배송 확인',
                text: '누르시면, 되돌릴 수 없습니다.',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '승인',
                cancelButtonText: '취소'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                    		'배송 처리 완료!',
                     '배송이 완료처리되었습니다.',
                    'success'
                    ).then(() => {
                    window.location.href="adminUpdateOrdersDelivery?ordercode=" + ordercode;
                    });
               }
            })
        });