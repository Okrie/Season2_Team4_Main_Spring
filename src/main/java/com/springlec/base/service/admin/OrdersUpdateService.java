package com.springlec.base.service.admin;

import jakarta.mail.MessagingException;

public interface OrdersUpdateService {
	public int refundupdate(int ordercode) throws Exception;
	
	public int deliveryupdate(int ordercode) throws Exception;
	
	public void sendMail(int ordercode) throws MessagingException, Exception;
}
