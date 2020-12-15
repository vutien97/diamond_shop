package diamondShop.services.user.userInterface;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.dto.CartDto;
import diamondShop.entites.Product;

@Service
public interface IProductService {
	public Product getProductById(long id);
	public List<Product> getProductByCId(int id);
	public void updateProduct(HashMap<Long, CartDto> cart);
	public List<Product> getListProduct();
	public List<Product> getListProductPaginate(int start, int totalProductIn1Page);
	public void deleteProductById(Product product);
	public int addProduct(Product product);
	public int updateDetailProduct(Product product);
	public List<Product> getListProductBySearch(String search);
	public List<Product> getListProductBySearchPaginate(String search, int start, int totalProductIn1Page);
}
