package com.citibank.ohs.web.controller.sorting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citibank.ohs.web.beans.Orders;


@Controller
	public class OrderHistorySortingController {

		/*@RequestMapping("/sortcardnum")
		public String getOrderByCardNum(Model model, HttpServletRequest req, HttpServletResponse resp) {
			HttpSession session = req.getSession(false);

			@SuppressWarnings("unchecked")
			List<Orders> orders = (List<Orders>) session.getAttribute("weblistDownloader");
			Collections.sort(orders, new Comparator<Orders>() {
				@Override
				public int compare(Orders o1, Orders o2) {
					return o1.getCardNum().compareTo(o2.getCardNum());
				}
			});
			model.addAttribute("lists", orders);

			return "sucess";
		}*/

		@RequestMapping(value="/sortprice",method=RequestMethod.GET)
		public String getOrderByPrice(Model model, HttpServletRequest req, HttpServletResponse resp) {

			HttpSession session = req.getSession(false);

			@SuppressWarnings("unchecked")
			List<Orders> orders = (List<Orders>) session.getAttribute("weblistDownloader");
			
			Collections.sort(orders, new Comparator<Orders>() {
				@Override
				public int compare(Orders o1, Orders o2) {
					int difference= (int)(o1.getPrice()-o2.getPrice());
					return difference;
				}
			});
			model.addAttribute("listOrder", orders);

			return "success";
		}

		@RequestMapping(value="/typeoforder",method=RequestMethod.GET)
		public String getOrderByOrder(Model model, HttpServletRequest req, HttpServletResponse resp) {

			HttpSession session = req.getSession(false);

			@SuppressWarnings("unchecked")
			List<Orders> orders = (List<Orders>) session.getAttribute("weblistDownloader");
			System.out.println(orders);
			Collections.sort(orders, new Comparator<Orders>() {
				@Override
				public int compare(Orders o1, Orders o2) {
					return o1.getType().compareTo(o2.getType());
				}
			});
			model.addAttribute("listOrder", orders);

			return "success";
		}

		@RequestMapping(value="/sortstatus",method=RequestMethod.GET)
		public String getOrderStatus(Model model, HttpServletRequest req, HttpServletResponse resp) {

			HttpSession session = req.getSession(false);

			@SuppressWarnings("unchecked")
			List<Orders> orders = (List<Orders>) session.getAttribute("weblistDownloader");
			Collections.sort(orders, new Comparator<Orders>() {
				@Override
				public int compare(Orders o1, Orders o2) {
					return o1.getStatus().compareTo(o2.getStatus());
				}
			});
			model.addAttribute("listOrder", orders);

			return "success";
		}

		@RequestMapping(value="/sortbyDate",method=RequestMethod.GET)
		public String getOrderByDate(Model model, HttpServletRequest req, HttpServletResponse resp) {

			HttpSession session = req.getSession(false);

			@SuppressWarnings("unchecked")
			List<Orders> orders = (List<Orders>) session.getAttribute("weblistDownloader");
			Collections.sort(orders, new Comparator<Orders>() {
				@Override
				public int compare(Orders o1, Orders o2) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date d1 = null;
					Date d2 = null;

					try {
						d1 = sdf.parse(o1.getDate());
						d2 = sdf.parse(o2.getDate());
					} catch (ParseException e) {

						e.printStackTrace();
					}

					return d1.compareTo(d2);
				}
			});
			model.addAttribute("listOrder", orders);

			return "success";
		}
	}

