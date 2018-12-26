package com.citibank.ohs.web.controller.DownloadPDF;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.citibank.ohs.service.client.beans.OrderHistory;
import com.itextpdf.text.log.SysoCounter;

@Controller
@RequestMapping(value="/download")
public class OrderHistoryWebDownloadController  {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewPDF(HttpServletRequest request, Model model){
		String view = request.getParameter("view");
		System.out.println(view);
		
		int listSize = 0;
		HttpSession session = request.getSession();
		List<OrderHistory> orderHistory = (List<OrderHistory>) session.getAttribute("weblistDownloader");
		System.out.println("pdf controllor list  " + orderHistory);
		if ("pdf".equals(view)) {
			if (orderHistory != null) {
				System.out.println("pdf controllor list size " +orderHistory.size());
				listSize = orderHistory.size();
				return new ModelAndView("pdfView", "orderHistory", orderHistory);
			}
		}else if("excel".equals(view)){
			return new ModelAndView("excelView", "orderHistory", orderHistory);
		}

		System.out.println("exit from  pdf controller");
		return new ModelAndView("error");
	
	}
}
