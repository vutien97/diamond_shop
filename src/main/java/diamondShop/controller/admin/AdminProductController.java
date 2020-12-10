package diamondShop.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView listProduct() {
		_mavShare.setViewName("admin/product/product");
		// _mavShare.addObject("list_product", productServiceImpl.getListProduct());
		_mavShare.addObject("list_product", productServiceImpl.getListProductPaginate(0, 10));
		_mavShare.addObject("totalItem", (productServiceImpl.getListProduct().size() / 10));
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
}
