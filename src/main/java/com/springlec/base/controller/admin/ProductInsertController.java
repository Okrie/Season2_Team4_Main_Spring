package com.springlec.base.controller.admin;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.service.admin.ProductInsertService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductInsertController {
	@Autowired
	ProductInsertService productService;

	@PostMapping("/adminInsertProduct")
	public String insertProduct(@RequestParam("photo") MultipartFile file, HttpServletRequest request, Model model)
			throws Exception {
		String photo = "";
		String pcode = request.getParameter("pcode");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String rice = request.getParameter("rice");
		String cook1 = request.getParameter("cook1");
		String cook2 = request.getParameter("cook2");
		String cook3 = request.getParameter("cook3");
		String soup = request.getParameter("soup");
		int price = Integer.parseInt(request.getParameter("price"));
		int calories = Integer.parseInt(request.getParameter("calories"));

		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			photo = "static/img/" + fileName;
			File uploadedFile = new File(photo);
			file.transferTo(uploadedFile);
		}
		
		productService.insertProduct(pcode, name, category, rice, cook1, cook2, cook3, soup, photo, calories, soup,
				calories, price);

		return "redirect:adminSearchProduct";
	}


}
