package diamondShop.controller.admin;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	@RequestMapping(value = "admin/product/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable long id) {
		Product product = productServiceImpl.getProductById(id);
		_mavShare.addObject("product", product);
		_mavShare.setViewName("admin/product/editProduct");
		return _mavShare;
	}

	@RequestMapping(value = "admin/product/edit/{id}", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request, @ModelAttribute("product") Product product, @PathVariable long id) {
		Product existProduct = productServiceImpl.getProductById(id);
		existProduct.setName(product.getName());
		existProduct.setPrice(product.getPrice());
		existProduct.setTitle(product.getTitle());
		existProduct.setQuantity(product.getQuantity());
		existProduct.setImg(product.getImg());
		existProduct.setNew_product(product.isNew_product());
		existProduct.setHighlight(product.isHighlight());
		existProduct.setDetail(product.getDetail());
		productServiceImpl.updateDetailProduct(existProduct);
	
		_mavShare.addObject("product", existProduct);
		
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "admin/product/add", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		_mavShare.setViewName("admin/product/addProduct");
		_mavShare.addObject("product", new Product());
		return _mavShare;
	}

	@RequestMapping(value = "admin/product/add", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, @ModelAttribute("product") Product product) {
		int count = productServiceImpl.addProduct(product);
		if (count > 0) {
			_mavShare.addObject("status", "Thêm thành công!");
			return "redirect:/admin/product";
		} else {
			_mavShare.addObject("status", "Thêm thất bại!");
			return "redirect:" + request.getHeader("Referer");
		}
	}
	
	@RequestMapping(value = "admin/product/search")
	public ModelAndView searchBill(@RequestParam(required=false, name="search") String search) {
		_mavShare.setViewName("admin/product/search_product");
		List<Product> listProduct = productServiceImpl.getListProductBySearch(search);
		_mavShare.addObject("list_product", listProduct);
		return _mavShare;
	}
}
