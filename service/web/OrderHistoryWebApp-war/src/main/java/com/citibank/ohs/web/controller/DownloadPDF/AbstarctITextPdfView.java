package com.citibank.ohs.web.controller.DownloadPDF;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;



public abstract class AbstarctITextPdfView extends AbstractView {
	
	public AbstarctITextPdfView(){
		setContentType("application/pdf");
	}
	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ByteArrayOutputStream baos=createTemporaryOutputStream();
		
		//apply preferences and build metadata
		Document document=newDocument();
		PdfWriter writer=newWriter(document,baos);
		prepareWriter(model,writer,request);
		buildPdfMetadata(model,document,request);
		//build pdf document
		document.open();
		buildPdfDocument(model,document,writer,request,response);
		document.close();
		
		//Flush to HTTP Response
		writeToResponse(response, baos);
	}
	protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception ;
	protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
		
	}
	protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request) {
		writer.setViewerPreferences(getViewerPreferences());
	}
	protected int getViewerPreferences() {
		return PdfWriter.ALLOW_PRINTING|PdfWriter.PageLayoutSinglePage;
	}
	protected PdfWriter newWriter(Document document, ByteArrayOutputStream os) throws DocumentException {
		return PdfWriter.getInstance(document, os);
	}
	protected Document newDocument() {
		return new Document(PageSize.A4);
	}

}

