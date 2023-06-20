package com.springlec.base.controller.admin;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVWriter;
import com.springlec.base.service.admin.MainService;
import com.springlec.base.service.admin.OrdersGraphService;
import com.springlec.base.service.admin.UserGraphService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RestController
public class DownloadController {

	@Autowired
	OrdersGraphService orderservice;

	@Autowired
	MainService mainservice;
	
	@Autowired
	UserGraphService userGraphService;
	
	

	@GetMapping("/download-csv")
	public ResponseEntity<byte[]> downloadCSV() throws IOException, Exception {
		// CSV 파일 데이터 생성
		// 연간 매출액
		ArrayList<ArrayList<String>> dataSales = mainservice.searchyearsales();
		//	주간 주문 개수
		ArrayList<ArrayList<String>> dataOrders = orderservice.searchWeekorders();
		//	상품별 주문
		ArrayList<ArrayList<String>> dataProduct = orderservice.searchOrdersProduct();
		//	주간	가입자 추이
		ArrayList<ArrayList<String>> dataSetInsert = userGraphService.searchInsertdate();
		
		

		// CSV 파일 생성
		File csvFile = File.createTempFile("Data", fileName(".csv"));
		FileWriter writer = new FileWriter(csvFile);
		CSVWriter csvWriter = new CSVWriter(writer);
		
		csvWriter.writeNext(new String[]{"# 연간 매출액", " ", "","" });
		for (ArrayList<String> rowData : dataSales) {
			String[] rowArray = rowData.toArray(new String[0]);
			csvWriter.writeNext(rowArray);
		}
		csvWriter.writeNext(new String[]{"", "", "","" });
		csvWriter.writeNext(new String[]{"# 주간 주문 개수 ", "", "","" });
		for (ArrayList<String> rowData : dataOrders) {
			String[] rowArray = rowData.toArray(new String[0]);
			csvWriter.writeNext(rowArray);
		}
		csvWriter.writeNext(new String[]{"", "", "","" });
		csvWriter.writeNext(new String[]{"# 상품별 주문  ", "", "","" });
		for (ArrayList<String> rowData : dataProduct) {
			String[] rowArray = rowData.toArray(new String[0]);
			csvWriter.writeNext(rowArray);
		}
		csvWriter.writeNext(new String[]{"", "", "","" });
		csvWriter.writeNext(new String[]{"# 주간 가입자 추이", "", "", " " });
		for (ArrayList<String> rowData : dataSetInsert) {
			String[] rowArray = rowData.toArray(new String[0]);
			csvWriter.writeNext(rowArray);
		}
		csvWriter.close();

		// 파일 다운로드 응답 생성
		byte[] fileContent = getFileContent(csvFile);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/csv"));
		headers.setContentDispositionFormData("attachment", fileName(".csv"));
		headers.setContentLength(fileContent.length);

		return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
	}

	@GetMapping("/download-excel")
	public ResponseEntity<byte[]> downloadExcel() throws IOException, Exception {
		// Excel 워크북 생성
		Workbook workbook = new XSSFWorkbook();

		// 첫 번째 시트 생성
		Sheet sheet1 = workbook.createSheet("# 연간 매출액");
		ArrayList<ArrayList<String>> dataSales = mainservice.searchyearsales();
		int rowNum = 0;
		for (ArrayList<String> rowData : dataSales) {
			Row row = sheet1.createRow(rowNum++);
			int cellNum = 0;
			for (String cellData : rowData) {
				Cell cell = row.createCell(cellNum++);
				cell.setCellValue(cellData);
			}
		}
		
		// 두 번째 시트 생성
		Sheet sheet2 = workbook.createSheet("# 주간 주문 개수");
		ArrayList<ArrayList<String>> dataOrders = orderservice.searchWeekorders();
		rowNum = 0;
		for (ArrayList<String> rowData : dataOrders) {
			Row row = sheet2.createRow(rowNum++);
			int cellNum = 0;
			for (String cellData : rowData) {
				Cell cell = row.createCell(cellNum++);
				cell.setCellValue(cellData);
			}
		}
		
		// 세 번째 시트 생성
		Sheet sheet3 = workbook.createSheet("# 상품별 주문");
		ArrayList<ArrayList<String>> dataProduct = orderservice.searchOrdersProduct();
		rowNum = 0;
		for (ArrayList<String> rowData : dataProduct) {
			Row row = sheet3.createRow(rowNum++);
			int cellNum = 0;
			for (String cellData : rowData) {
				Cell cell = row.createCell(cellNum++);
				cell.setCellValue(cellData);
			}
		}

		// 네 번째 시트 생성
		Sheet sheet4 = workbook.createSheet("# 주간 가입자 추이");
		ArrayList<ArrayList<String>> dataSetInsert = userGraphService.searchInsertdate();
		rowNum = 0;
		for (ArrayList<String> rowData : dataSetInsert) {
			Row row = sheet4.createRow(rowNum++);
			int cellNum = 0;
			for (String cellData : rowData) {
				Cell cell = row.createCell(cellNum++);
				cell.setCellValue(cellData);
			}
		}
		// 파일 이름 인코딩
	    String fileName = "관리자의 참고자료";
	    byte[] fileNameBytes = fileName.getBytes(StandardCharsets.UTF_8);
	    fileName = new String(fileNameBytes, StandardCharsets.ISO_8859_1);

		 // Excel 파일 생성
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    workbook.write(outputStream);
	    workbook.close();

	    // 파일 다운로드 응답 생성
	    byte[] fileContent = outputStream.toByteArray();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
	    headers.setContentDispositionFormData("attachment", fileName(".xlsx"));
	    headers.setContentLength(fileContent.length);

		return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
	}

	private byte[] getFileContent(File file) throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		byte[] fileContent = inputStream.readAllBytes();
		inputStream.close();
		return fileContent;
	}
	
	private String fileName(String file) throws Exception {
		LocalDate nowday = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String now = nowday.format(formatter);
	    String fileName = "관리자의 참고자료_"+now;
	    byte[] fileNameBytes = fileName.getBytes(StandardCharsets.UTF_8);
	    fileName = new String(fileNameBytes, StandardCharsets.ISO_8859_1);
		return fileName+file;
	}
}
