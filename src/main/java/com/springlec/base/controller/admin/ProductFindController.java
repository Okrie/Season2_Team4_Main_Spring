package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.admin.DataSetProduct;
import com.springlec.base.service.admin.ProductFindService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductFindController {
	@Autowired
	ProductFindService productService;
	
	@RequestMapping("/adminFindProduct")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		String pcode = request.getParameter("pcode");
		ArrayList<DataSetProduct> dataSetProduct = productService.findProduct(pcode);
		model.addAttribute("dataSetProduct", dataSetProduct);
		return "admin_product_insert";
	}
}
