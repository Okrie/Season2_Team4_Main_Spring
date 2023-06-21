package com.springlec.base.controller.admin;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.service.admin.ProductInsertService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductInsertController {
	@Autowired
	ProductInsertService productService;

	@PostMapping("/adminInsertProduct")
	public String insertProduct(@RequestParam("photo") MultipartFile file, HttpServletRequest request,
			HttpSession session, Model model) throws Exception {
		String photo = "";
		String pcode = request.getParameter("pcode");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String rice = request.getParameter("rice");
		String cook1 = request.getParameter("cook1");
		String cook2 = request.getParameter("cook2");
		String cook3 = request.getParameter("cook3");
		String soup = request.getParameter("soup");
		String adminid = (String) session.getAttribute("ID");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int calories = Integer.parseInt(request.getParameter("calories"));

		if (!file.isEmpty()) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			fileName = fileName.replaceAll("\\s", "");
			photo = "/img/" + fileName;
			String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/img/"; // 저장할 경로 설정
			File uploadPathDir = new File(uploadDir);
			if (!uploadPathDir.exists()) {
				uploadPathDir.mkdirs(); // 경로가 존재하지 않으면 생성합니다.
			}
			File uploadedFile = new File(uploadDir + fileName);
			file.transferTo(uploadedFile);
		}

		productService.insertProduct(pcode, name, category, rice, cook1, cook2, cook3, soup, photo, calories, adminid,
				stock, price);

		return "redirect:adminSearchProduct";
	}

	@GetMapping("/adminInsertProductpage")
	public String insertProductPage() {
	    return "admin_product_insert";
	}

}
