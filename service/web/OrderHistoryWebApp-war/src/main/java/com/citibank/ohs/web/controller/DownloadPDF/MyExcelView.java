package com.citibank.ohs.web.controller.DownloadPDF;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.citibank.ohs.web.beans.Orders;


public class MyExcelView extends AbstractXlsView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("enter into excel builder");
		List<Orders> orderList = new ArrayList<Orders>();
		orderList = (List<Orders>) model.get("orderHistory");
		System.out.println("Excel list "+orderList.size());
		// create a new Excel sheet
		Sheet sheet = workbook.createSheet("Transaction");
		sheet.setDefaultColumnWidth(30);

		// create a style for header parts
		CellStyle style = workbook.createCellStyle();
		Font font =  workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		Row header = sheet.createRow(0);
		if (orderList.size() > 0) {
			header.createCell(0).setCellValue("id");
			header.getCell(0).setCellStyle(style);

			header.createCell(1).setCellValue("date");
			header.getCell(1).setCellStyle(style);

			header.createCell(2).setCellValue("merchantName");
			header.getCell(2).setCellStyle(style);

			header.createCell(3).setCellValue("description");
			header.getCell(3).setCellStyle(style);

			header.createCell(4).setCellValue("status");
			header.getCell(4).setCellStyle(style);

			header.createCell(5).setCellValue("type");
			header.getCell(5).setCellStyle(style);

			header.createCell(6).setCellValue("price");
			header.getCell(6).setCellStyle(style);

			// create data rows
			int rowCount = 1;
			
			for(Orders orderHistory:orderList){
				Row row=sheet.createRow(rowCount++);
				row.createCell(0).setCellValue(String.valueOf(orderHistory.getOid()));
				row.createCell(1).setCellValue(orderHistory.getDate());
				row.createCell(2).setCellValue(orderHistory.getName());
				row.createCell(3).setCellValue(orderHistory.getDesc());
				row.createCell(4).setCellValue(orderHistory.getStatus());
				row.createCell(5).setCellValue(orderHistory.getType());;
				row.createCell(6).setCellValue(String.valueOf(orderHistory.getPrice()));
				
			}

		}
		System.out.println("exit from excel builder");
	}
}
			
			
			