package diamondShop.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.services.user.BillServiceImpl;
import diamondShop.services.user.PaginateServiceImpl;

@Controller
public class AdminBillController extends BaseAdminController {
	@Autowired
	BillServiceImpl billServiceImpl = new BillServiceImpl();
	@Autowired
	PaginateServiceImpl paginateServiceImpl = new PaginateServiceImpl();

	@RequestMapping(value = "admin/bill", method = RequestMethod.GET)
	public ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		_mavShare.setViewName("admin/bill/list_bill");
		
		_mavShare.addObject("list_bill", billServiceImpl.billIn1WeekPaginate(0, 10));
		_mavShare.addObject("totalItem", (billServiceImpl.in1Week().size() / 10));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}

	@RequestMapping(value = "admin/bill/{page}", method = RequestMethod.GET)
	public ModelAndView listPage(HttpServletRequest request, HttpServletResponse response, @PathVariable int page)
			throws ServletException, IOException {
		_mavShare.setViewName("admin/bill/list_bill");
		_mavShare.addObject("list_bill", billServiceImpl.billIn1WeekPaginate((page - 1) * 10, 10));
		_mavShare.addObject("totalItem", (billServiceImpl.in1Week().size() / 10));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}
}
