package diamondShop.services.user;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.ProductDao;
import diamondShop.dto.CartDto;
import diamondShop.entites.Product;
import diamondShop.services.user.userInterface.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductDao productDao = new ProductDao();

	@Override
	public Product getProductById(long id) {
		List<Product> listProductDto = productDao.getProductById(id);
		return listProductDto.get(0);
	}

	@Override
	public List<Product> getProductByCId(int id) {
		return productDao.getListProductByCategoryId(id);
	}

	@Override
	public void updateProduct(HashMap<Long, CartDto> cart) {
		Date date = new Date();
		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {

			Product product = getProductById(itemCart.getValue().getProduct().getId_product());
			int quantity = product.getQuantity() - itemCart.getValue().getQuantity();
			product.setQuantity(quantity);
			product.setUpdated_at(new Timestamp(date.getTime()));
			productDao.updateProduct(product);
		}

	}

	@Override
	public List<Product> getListProduct() {
		// TODO Auto-generated method stub
		return productDao.getListProduct();
	}

	@Override
	public List<Product> getListProductPaginate(int start, int totalProductIn1Page) {
		
		return productDao.getListProductPaginate(start, totalProductIn1Page);
	}

	@Override
	public void deleteProductById(Product product) {
		productDao.deleteProductById(product);
	}
	
	public int addProduct(Product product) {
		return productDao.addProduct(product);
	}

}
