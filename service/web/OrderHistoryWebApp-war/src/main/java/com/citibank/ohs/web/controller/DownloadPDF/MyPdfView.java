package com.citibank.ohs.web.controller.DownloadPDF;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citibank.ohs.web.beans.Orders;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class MyPdfView extends AbstarctITextPdfView {

	@Override
	protected void buildPdfDocument(Map model, Document doc, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("welcom to pdfbuilder");
		List<Orders> orderList=new ArrayList<Orders>();
		orderList=(List<Orders>)model.get("orderHistory");
		
		System.out.println(orderList);
		//System.out.println("pdf builder list size " + orderList.size());
		
		doc.add(new Paragraph("welcome to citybank"));
		if (orderList.size() == 0) {
			doc.add(new Paragraph("No transaction found"));
		}

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });
		table.setSpacingBefore(10);

		// define font for table heander row
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(7);

		// write table heander
		if (orderList.size() >0) {
			cell.setPhrase(new Phrase("id", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("date", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("description", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("status", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Type", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Price", font));
			table.addCell(cell);

			// write table row data
			
			for(Orders orderHistory:orderList){
				table.addCell(String.valueOf(orderHistory.getOid()));
				table.addCell(orderHistory.getDate());
				table.addCell(orderHistory.getName());
				table.addCell(orderHistory.getDesc());
				table.addCell(orderHistory.getStatus());
				table.addCell(orderHistory.getType());
				table.addCell(String.valueOf(orderHistory.getPrice()));
				
			}
			doc.add(table);
			}
		

		
		System.out.println("exit from pdf builder");

	
	}
}

