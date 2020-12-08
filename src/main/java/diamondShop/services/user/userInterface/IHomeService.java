package diamondShop.services.user.userInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.entites.Category;
import diamondShop.entites.Menu;
import diamondShop.entites.Product;
import diamondShop.entites.Slide;
@Service
public interface IHomeService {
	@Autowired
	public List<Slide> getDataSlide();
	public List<Category> getDataCategory();
	public List<Menu> getDataMenu();
	public List<Product> getHighlightProduct();
	public List<Product> getNewProduct();
	public List<Product> getListProduct();
}
