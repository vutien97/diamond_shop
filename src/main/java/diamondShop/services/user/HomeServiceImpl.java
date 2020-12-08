package diamondShop.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.CategoryDao;
import diamondShop.dao.MenuDao;
import diamondShop.dao.ProductDao;
import diamondShop.dao.SlideDao;
import diamondShop.entites.Category;
import diamondShop.entites.Menu;
import diamondShop.entites.Product;
import diamondShop.entites.Slide;
import diamondShop.services.user.userInterface.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private SlideDao slidedao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ProductDao productDao;

	public List<Slide> getDataSlide() {
		return slidedao.getDataSlide();
	}

	public List<Category> getDataCategory() {
		return categoryDao.getDataCategory();
	}

	public List<Menu> getDataMenu() {
		return menuDao.getDataMenu();
	}

	public List<Product> getHighlightProduct() {
		List<Product> listProduct = productDao.getHighlightProduct();
		return listProduct;
	}

	public List<Product> getNewProduct() {
		List<Product> listProduct = productDao.getNewProduct();
		return listProduct;
	}

	public List<Product> getListProduct() {
		List<Product> listProduct = productDao.getListProduct();
		return listProduct;
	}

}
