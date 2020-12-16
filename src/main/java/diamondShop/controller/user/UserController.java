package diamondShop.controller.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.Bill;
import diamondShop.entites.BillDetail;
import diamondShop.entites.Product;
import diamondShop.entites.User;
import diamondShop.services.user.AccountServiceImpl;
import diamondShop.services.user.BillServiceImpl;
import diamondShop.services.user.ProductServiceImpl;

@Controller
public class UserController extends BaseController {
	@Autowired
	AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	@Autowired
	BillServiceImpl billServiceImpl = new BillServiceImpl();
	@Autowired
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView register() {
		_mavShare.setViewName("user/account/register");
		_mavShare.addObject("user", new User());
		_mavShare.addObject("category", _homeServiceImpl.getDataCategory());
		return _mavShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView createAcc(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) throws ServletException, IOException {
		Date date = new Date();
		user.setCreated_at(new Timestamp(date.getTime()));
		int count = accountServiceImpl.addAccount(user);
		if (count > 0) {
			_mavShare.addObject("status", "Đăng ký thành công!");
		} else {
			_mavShare.addObject("status", "Đăng ký thất bại!");
		}
		_mavShare.setViewName("user/account/register");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, HttpServletRequest request, @ModelAttribute("user") User user) {
		user = accountServiceImpl.findUserByLogin(user);
		if (user != null) {
			_mavShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
			request.getSession().setMaxInactiveInterval(60*60);
		} else {
			_mavShare.addObject("statusLogin", "Đăng nhập thất bại!");
		}
		return _mavShare;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		_mavShare.setViewName("user/index");
		return "redirect:/trang-chu";
	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ModelAndView editProfile(@PathVariable long id) {
		User user = accountServiceImpl.getUserById(id);
		_mavShare.addObject("user", user);
		_mavShare.setViewName("user/account/editProfile");
		return _mavShare;
	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute("user") User user ,@PathVariable long id) {
		User existUser = accountServiceImpl.getUserById(id);
		existUser.setPassword(user.getPassword());
		existUser.setDisplay_name(user.getDisplay_name());
		existUser.setAddress(user.getAddress());
		existUser.setPhone(user.getPhone());
		accountServiceImpl.updateUser(existUser);
		
		_mavShare.addObject("user", existUser);
		_mavShare.setViewName("user/account/editProfile");
		return _mavShare;
	}
	
	@RequestMapping(value="user/bill", method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session) {
		_mavShare.setViewName("user/bill/view_bill");
		User user = (User) session.getAttribute("LoginInfo");
		List<Bill> listBill = billServiceImpl.getBillByUserEmail(user.getEmail());
		
		_mavShare.addObject("list_bill", listBill);
		return _mavShare;
	}
	
	@RequestMapping(value = "user/bill/{id}", method = RequestMethod.GET)
	public ModelAndView billDetail(@PathVariable long id) {
		_mavShare.setViewName("user/bill/bill_detail");
		List<Product> listProduct = new ArrayList<Product>();
		
		List<BillDetail> listBillDetail = billServiceImpl.getBillDetailByBillId(id);
		for (BillDetail billDetail : listBillDetail) {
			Product product = productServiceImpl.getProductById(billDetail.getId_product());	
			listProduct.add(product);
		}
		
		_mavShare.addObject("listBillDetail", listBillDetail);
		_mavShare.addObject("listProduct", listProduct);
		
		return _mavShare;
	}
}
