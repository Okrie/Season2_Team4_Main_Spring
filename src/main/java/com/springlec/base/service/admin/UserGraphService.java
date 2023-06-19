package com.springlec.base.service.admin;

import java.util.ArrayList;

public interface UserGraphService {
	public ArrayList<ArrayList<String>> searchGender() throws Exception;

	public ArrayList<ArrayList<String>> searchAge() throws Exception;
	
	public ArrayList<ArrayList<String>> searchInsertdate() throws Exception;
	
}
