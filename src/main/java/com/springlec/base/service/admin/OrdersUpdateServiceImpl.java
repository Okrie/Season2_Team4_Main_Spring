package com.springlec.base.service.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.admin.OrdersDao;
import com.springlec.base.model.admin.OrdersDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrdersUpdateServiceImpl implements OrdersUpdateService {

	@Autowired
	OrdersDao ordersDao;

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public int refundupdate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		return ordersDao.refundupdate(ordercode);
	}

	@Override
	public int deliveryupdate(int ordercode) throws Exception {
		// TODO Auto-generated method stub
		return ordersDao.deliveryupdate(ordercode);
	}

	@Override
	public void senddeliveryMail(int ordercode) throws MessagingException, Exception {
		ArrayList<OrdersDto> dtoOrders = ordersDao.searchEmail(ordercode);
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		OrdersDto ordersDto = dtoOrders.get(0);
		
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
		mimeMessageHelper.setTo(ordersDto.getEmail()); // 메일 수신자
		mimeMessageHelper.setSubject("안녕하세요,"+ordersDto.getUserid() +"님, Nutridelights에서 배송 확인 메일 드립니다. "); 
		String context=
				"<html lang=\"UTF-8\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>배송 확인 이메일</title>\n"
				+ "    <style>\n"
				+ "        body {\n"
				+ "            font-family: Arial, sans-serif;\n"
				+ "            line-height: 1.6;\n"
				+ "        }\n"
				+ "        .container {\n"
				+ "            max-width: 600px;\n"
				+ "            margin: 0 auto;\n"
				+ "            padding: 20px;\n"
				+ "            border: 1px solid #ccc;\n"
				+ "            border-radius: 5px;\n"
				+ "        }\n"
				+ "        h1 {\n"
				+ "            font-size: 24px;\n"
				+ "            margin-bottom: 20px;\n"
				+ "        }\n"
				+ "        p {\n"
				+ "            margin-bottom: 10px;\n"
				+ "        }\n"
				+ "        .bold {\n"
				+ "            font-weight: bold;\n"
				+ "        }\n"
				+ "        .button {\n"
				+ "            display: inline-block;\n"
				+ "            padding: 10px 20px;\n"
				+ "            background-color: #4CAF50;\n"
				+ "            color: #fff;\n"
				+ "            text-decoration: none;\n"
				+ "            border-radius: 5px;\n"
				+ "        }\n"
				+ "    </style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "    <div class=\"container\">\n"
				+ "        <h1>배송 확인</h1>\n<br/><br/>"
				+ "        <p>안녕하세요, 주문하신 상품의 배송이 완료되었습니다.</p>\n"
				+ "        <p>아래는 배송 정보입니다:</p>\n<br/><br/>"
				+ "        <p><span class=\"bold\">상품명: </span>"+ordersDto.getName() +" "+ Integer.toString( ordersDto.getCount())+"개</p>\n"
				+ "        <p><span class=\"bold\">배송 주소: </span>"+ordersDto.getAddress() +"</p>"
				+ "        <p><span class=\"bold\">배송 시간: </span>"+ordersDto.getDeliverydate() +"</p><br/><br/>"
				+ "        <p>추가 문의 사항이 있으시면 언제든지 연락 주세요.</p>\n"
				+ "        <p>감사합니다.</p><br/><br/>"
				+ "			<img src=\"https://i.ibb.co/yQCP0g5/logo.png\" alt=\"logo\" border=\"0\">"
				+ "    </div>\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "";
		mimeMessageHelper.setText(context, true); // 메일 본문 내용, HTML 여부
		javaMailSender.send(mimeMessage);
		log.info("Success!!");

	}

	@Override
	public void sendrefundMail(int ordercode) throws MessagingException, Exception {
		ArrayList<OrdersDto> dtoOrders = ordersDao.searchEmail(ordercode);
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		OrdersDto ordersDto = dtoOrders.get(0);
		
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
		mimeMessageHelper.setTo(ordersDto.getEmail()); // 메일 수신자
		mimeMessageHelper.setSubject("안녕하세요,"+ordersDto.getUserid() +"님, Nutridelights에서 환불 확인 메일 드립니다. "); 
		String context=
				"<html lang=\"UTF-8\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>환불 확인 이메일</title>\n"
				+ "    <style>\n"
				+ "        body {\n"
				+ "            font-family: Arial, sans-serif;\n"
				+ "            line-height: 1.6;\n"
				+ "        }\n"
				+ "        .container {\n"
				+ "            max-width: 600px;\n"
				+ "            margin: 0 auto;\n"
				+ "            padding: 20px;\n"
				+ "            border: 1px solid #ccc;\n"
				+ "            border-radius: 5px;\n"
				+ "        }\n"
				+ "        h1 {\n"
				+ "            font-size: 24px;\n"
				+ "            margin-bottom: 20px;\n"
				+ "        }\n"
				+ "        p {\n"
				+ "            margin-bottom: 10px;\n"
				+ "        }\n"
				+ "        .bold {\n"
				+ "            font-weight: bold;\n"
				+ "        }\n"
				+ "        .button {\n"
				+ "            display: inline-block;\n"
				+ "            padding: 10px 20px;\n"
				+ "            background-color: #4CAF50;\n"
				+ "            color: #fff;\n"
				+ "            text-decoration: none;\n"
				+ "            border-radius: 5px;\n"
				+ "        }\n"
				+ "    </style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "    <div class=\"container\">\n"
				+ "        <h1>배송 확인</h1>\n<br/><br/>"
				+ "        <p>안녕하세요, 주문하신 상품의 환불이 완료되었습니다.</p>\n"
				+ "        <p>아래는 배송 정보입니다:</p>\n<br/><br/>"
				+ "        <p><span class=\"bold\">주문 번호: </span>"+ordersDto.getOrdercode()+"</p>\n"
				+ "        <p><span class=\"bold\">상품명: </span>"+ordersDto.getName() +" "+ Integer.toString( ordersDto.getCount())+"개</p>\n"
				+ "        <p><span class=\"bold\">환불 금액: </span>"+(Integer.toString( ordersDto.getCount()*ordersDto.getPrice())) +"원</p>"
				+ "        <p><span class=\"bold\">환불 시간: </span>"+ordersDto.getRefunddate() +"</p><br/><br/>"
				+ "        <p>추가 문의 사항이 있으시면 언제든지 연락 주세요.</p>\n"
				+ "        <p>감사합니다.</p><br/><br/>"
				+ "			<img src=\"https://i.ibb.co/yQCP0g5/logo.png\" alt=\"logo\" border=\"0\">"
				+ "    </div>\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "";
		mimeMessageHelper.setText(context, true); // 메일 본문 내용, HTML 여부
		javaMailSender.send(mimeMessage);
		log.info("Success!!");

	}

}
