package diamondShop.controller.user;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.dto.CartDto;
import diamondShop.entites.Bill;
import diamondShop.entites.User;
import diamondShop.services.user.BillServiceImpl;
import diamondShop.services.user.CartServiceImpl;
import diamondShop.services.user.ProductServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartServiceImpl = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billServiceImpl = new BillServiceImpl();
	@Autowired
	private ProductServiceImpl productServiceImpl = new ProductServiceImpl();

	@RequestMapping(value = "gio-hang")
	public ModelAndView index() {
		_mavShare.addObject("slide", _homeServiceImpl.getDataSlide());
		_mavShare.addObject("category", _homeServiceImpl.getDataCategory());
		_mavShare.addObject("product", _homeServiceImpl.getListProduct());
		_mavShare.addObject("new_product", _homeServiceImpl.getNewProduct());
		_mavShare.addObject("highlight", _homeServiceImpl.getHighlightProduct());
		_mavShare.setViewName("user/cart/list_cart");
		return _mavShare;
	}

	@RequestMapping(value = "addCart/{id}")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		@SuppressWarnings("unchecked")
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartServiceImpl.addCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartServiceImpl.totalQuantity(cart));
		session.setAttribute("TotalPrice", cartServiceImpl.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "gio-hang/editCart/{id}/{quantity}")
	public String editCart(HttpServletRequest request, HttpSession session, @PathVariable long id,
			@PathVariable int quantity) {
		@SuppressWarnings("unchecked")
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartServiceImpl.editCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartServiceImpl.totalQuantity(cart));
		session.setAttribute("TotalPrice", cartServiceImpl.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "deleteCart/{id}")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		@SuppressWarnings("unchecked")
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartServiceImpl.deleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantity", cartServiceImpl.totalQuantity(cart));
		session.setAttribute("TotalPrice", cartServiceImpl.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView Checkout(HttpServletRequest request, HttpSession session) {
		_mavShare.setViewName("user/bill/checkout");
		Bill bill = new Bill();
		User loginInfo = (User) session.getAttribute("LoginInfo");
		if (loginInfo != null) {
			Date date = new Date();
	
			bill.setAddress(loginInfo.getAddress());
			bill.setDisplay_name(loginInfo.getDisplay_name());
			bill.setEmail(loginInfo.getEmail());
			bill.setBillDate(new Timestamp(date.getTime()));
		}
		_mavShare.addObject("bill", bill);
		return _mavShare;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String CheckoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill) {
		bill.setQuantity((int) session.getAttribute("TotalQuantity"));
		bill.setTotal((double) session.getAttribute("TotalPrice"));
		
		if (billServiceImpl.addBill(bill) > 0) {
			@SuppressWarnings("unchecked")
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
			billServiceImpl.addBillDetail(cart);
			productServiceImpl.updateProduct(cart);
		}
		session.removeAttribute("Cart");
		return "redirect:/trang-chu";
	}

}
