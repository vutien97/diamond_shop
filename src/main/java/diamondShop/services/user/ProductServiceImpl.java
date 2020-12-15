package diamondShop.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.ProductDao;
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
	public void updateProduct(Product product) {
		/*
		 * Date date = new Date(); for (Map.Entry<Long, CartDto> itemCart :
		 * cart.entrySet()) {
		 * 
		 * Product product =
		 * getProductById(itemCart.getValue().getProduct().getId_product()); int
		 * quantity = product.getQuantity() - itemCart.getValue().getQuantity();
		 * product.setQuantity(quantity); product.setUpdated_at(new
		 * Timestamp(date.getTime()));
		 */
		productDao.updateProduct(product);

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

	@Override
	public int updateDetailProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateDetailProduct(product);
	}

	@Override
	public List<Product> getListProductBySearch(String search) {
		// TODO Auto-generated method stub
		return productDao.getListProductBySearch(search);
	}

	@Override
	public List<Product> getListProductBySearchPaginate(String search, int start, int totalProductIn1Page) {
		// TODO Auto-generated method stub
		return productDao.getListProductBySearchPaginate(search, start, totalProductIn1Page);
	}

}
