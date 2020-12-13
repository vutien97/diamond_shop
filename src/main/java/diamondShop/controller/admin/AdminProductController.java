package diamondShop.controller.admin;

import java.io.IOException;

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

import diamondShop.entites.Product;
import diamondShop.services.user.PaginateServiceImpl;
import diamondShop.services.user.ProductServiceImpl;

@Controller

public class AdminProductController extends BaseAdminController {
	@Autowired
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	@Autowired
	PaginateServiceImpl paginateServiceImpl = new PaginateServiceImpl();

	@RequestMapping(value = "admin/product", method = RequestMethod.GET)
	public ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		_mavShare.setViewName("admin/product/product");
		// _mavShare.addObject("list_product", productServiceImpl.getListProduct());
		_mavShare.addObject("list_product", productServiceImpl.getListProductPaginate(0, 10));
		_mavShare.addObject("totalItem", (productServiceImpl.getListProduct().size() / 10));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return _mavShare;
	}

	@RequestMapping(value = "admin/product/{page}", method = RequestMethod.GET)
	public ModelAndView listPage(@PathVariable int page) {
		_mavShare.setViewName("admin/product/product");
		_mavShare.addObject("list_product", productServiceImpl.getListProductPaginate((page - 1) * 10, 10));
		_mavShare.addObject("totalItem", (productServiceImpl.getListProduct().size() / 10));
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/product/delete/{id}")
	public String deleteProduct(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		Product product = productServiceImpl.getProductById(id);
		productServiceImpl.deleteProductById(product);
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "admin/product/add", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		_mavShare.setViewName("admin/product/addProduct");
		_mavShare.addObject("product", new Product());
		return _mavShare;
	}
	
	@RequestMapping(value = "admin/product/add", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product) {
		int count = productServiceImpl.addProduct(product);
		if(count > 0) {
			_mavShare.addObject("status", "Thêm thành công!");
		} else {
			_mavShare.addObject("status", "Thêm thất bại!");
		}
		
		_mavShare.setViewName("admin/product/addProduct");
		return _mavShare;
	}
}
