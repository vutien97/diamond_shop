package diamondShop.controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.dto.CartDto;
import diamondShop.services.user.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartServiceImpl = new CartServiceImpl();

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

}
