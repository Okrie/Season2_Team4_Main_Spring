package com.springlec.base.controller.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.admin.ProductSearchService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductSearchController {
	@Autowired
	ProductSearchService productService;
	
	@RequestMapping("/adminSearchProduct")
	public String adminSearchorders(HttpServletRequest request, Model model) throws Exception {
		ArrayList<ArrayList<String>> dataSetProduct = productService.searchProduct();
		model.addAttribute("dataSetProduct", dataSetProduct);
		return "admin_product";
	}
}
