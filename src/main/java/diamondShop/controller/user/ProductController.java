package diamondShop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import diamondShop.entites.Product;
import diamondShop.services.user.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private ProductServiceImpl _productServiceImpl;
	/*
	 * @Autowired private PaginateServiceImpl _paginateServiceImpl;
	 */
	
	@RequestMapping(value = {"/chi-tiet-san-pham/{id}"})
	public ModelAndView product(@PathVariable long id) {
		_mavShare.setViewName("user/product/product");
		Product productDto = _productServiceImpl.getProductById(id);
		_mavShare.addObject("productById", productDto);
		_mavShare.addObject("category", _homeServiceImpl.getDataCategory());
		_mavShare.addObject("productByCId", _productServiceImpl.getProductByCId(productDto.getId_category()));
		return _mavShare;
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView searchProduct(@RequestParam(required=false, name="search") String search) {
		_mavShare.setViewName("user/product/search_result");
		

		_mavShare.addObject("list_product_by_search", _productServiceImpl.getListProductBySearchPaginate(search, 0, 9));
		_mavShare.addObject("totalItem", (_productServiceImpl.getListProductBySearch(search).size() / 9));
		_mavShare.addObject("search", search);
		
		return _mavShare;
	}
	
	@RequestMapping(value = "/search/{page}")
	public ModelAndView searchProduct(@RequestParam(required=false, name="search") String search, @PathVariable int page) {
		_mavShare.setViewName("user/product/search_result");
		/*
		 * int totalData = _productServiceImpl.getListProductBySearch(search).size();
		 * PaginateDto paginateDto = _paginateServiceImpl.getInforPaginate(totalData, 9,
		 * page);
		 */
		_mavShare.addObject("list_product_by_search", _productServiceImpl.getListProductBySearchPaginate(search, (page - 1) * 9, 9));
		/* _mavShare.addObject("paginateInfo", paginateDto); */
		_mavShare.addObject("totalItem", (_productServiceImpl.getListProductBySearch(search).size() / 9));
		
		
		return _mavShare;
	}
	
}
