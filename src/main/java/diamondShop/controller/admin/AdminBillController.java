package diamondShop.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.Bill;
import diamondShop.entites.BillDetail;
import diamondShop.entites.Product;
import diamondShop.services.user.BillServiceImpl;
import diamondShop.services.user.PaginateServiceImpl;
import diamondShop.services.user.ProductServiceImpl;

@Controller
public class AdminBillController extends BaseAdminController {
	@Autowired
	BillServiceImpl billServiceImpl = new BillServiceImpl();
	@Autowired
	PaginateServiceImpl paginateServiceImpl = new PaginateServiceImpl();
	@Autowired
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	

	@RequestMapping(value = "admin/bill", method = RequestMethod.GET)
	public ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		_mavShare.setViewName("admin/bill/list_bill");
		
		_mavShare.addObject("list_bill", billServiceImpl.listBillPaginate(0, 10));
		_mavShare.addObject("totalItem", (billServiceImpl.listBill().size() / 10));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}

	@RequestMapping(value = "admin/bill/{page}", method = RequestMethod.GET)
	public ModelAndView listPage(HttpServletRequest request, HttpServletResponse response, @PathVariable int page)
			throws ServletException, IOException {
		_mavShare.setViewName("admin/bill/list_bill");
		_mavShare.addObject("list_bill", billServiceImpl.listBillPaginate((page - 1) * 10, 10));
		_mavShare.addObject("totalItem", (billServiceImpl.listBill().size() / 10));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/not_pay_bill", method = RequestMethod.GET)
	public ModelAndView listNotPayBill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		_mavShare.setViewName("admin/bill/not_pay_bill");
		
		_mavShare.addObject("list_bill", billServiceImpl.getBillByStatusPaginate(0, 10));
		_mavShare.addObject("totalItem", (billServiceImpl.getBillByStatus().size() / 10));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/not_pay_bill/{page}", method = RequestMethod.GET)
	public ModelAndView listNotPayBill(HttpServletRequest request, HttpServletResponse response, @PathVariable int page) 
			throws ServletException, IOException {
		_mavShare.setViewName("admin/bill/not_pay_bill");
		
		_mavShare.addObject("list_bill", billServiceImpl.getBillByStatusPaginate((page - 1) * 10, 10));
		_mavShare.addObject("totalItem", (billServiceImpl.getBillByStatus().size() / 10));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/not_pay_bill/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editBill(@PathVariable long id) {
		Bill bill = billServiceImpl.getBillById(id);
		List<Product> listProduct = new ArrayList<Product>();
		List<BillDetail> listBillDetail = billServiceImpl.getBillDetailByBillId(bill.getId());
		for (BillDetail billDetail : listBillDetail) {
			Product product = productServiceImpl.getProductById(billDetail.getId_product());	
			listProduct.add(product);
		}
		
		_mavShare.addObject("listBillDetail", listBillDetail);
		_mavShare.addObject("listProduct", listProduct);
		_mavShare.addObject("bill", bill);
		_mavShare.setViewName("admin/bill/edit_bill");
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/not_pay_bill/edit/{id}", method = RequestMethod.POST)
	public String editBill(HttpServletRequest request, @ModelAttribute("bill") Bill bill, @PathVariable long id) {
		Bill existBill = billServiceImpl.getBillById(id);
		if(bill.getStatus() == true) {
		existBill.setStatus(bill.getStatus());
		billServiceImpl.updateBill(existBill);
		}
		
		if(existBill.getStatus() == true) {
			List<BillDetail> listBillDetail = billServiceImpl.getBillDetailByBillId(existBill.getId());
			for (BillDetail billDetail : listBillDetail) {
				int quantity = billDetail.getQuantity();
				Product product = productServiceImpl.getProductById(billDetail.getId_product());
				product.setQuantity(product.getQuantity() - quantity);
				productServiceImpl.updateProduct(product);
			}
		}
		
		_mavShare.addObject("bill", existBill);
		return "redirect:/admin/not_pay_bill";
	}
	
	@RequestMapping(value = "admin/not_pay_bill/search")
	public ModelAndView searchBill(@RequestParam(required=false, name="search") String search) {
		_mavShare.setViewName("admin/bill/search_bill");
		List<Bill> listBill = billServiceImpl.getListBillByEmail(search);
		_mavShare.addObject("list_bill", listBill);
		return _mavShare;
	}
}
