package diamondShop.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import diamondShop.dto.CartDto;
import diamondShop.dto.ProductDto;

@Repository
public class CartDao extends BaseDao {
	@Autowired
	ProductDao productDao = new ProductDao();

	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductDto product = productDao.findProductById(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		} else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(product.getPrice());
		}

		// Day vao 1 gio hang cu, dua ra 1 gio hang moi
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> editCart(long id, int quantity, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(quantity * itemCart.getProduct().getPrice());
		}
		// Day vao 1 gio hang cu, dua ra 1 gio hang moi
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	// Lay ra tong so san pham trong gio hang
	public int totalQuantity(HashMap<Long, CartDto> cart) {
		int totalQuantity = 0;
		for (Map.Entry<Long, CartDto> itemcart : cart.entrySet()) {
			totalQuantity += itemcart.getValue().getQuantity();
		}
		return totalQuantity;
	}

	// Tinh tong gia tri cua gio hang
	public double totalPrice(HashMap<Long, CartDto> cart) {
		double totalCartPrice = 0;
		for (Map.Entry<Long, CartDto> itemcart : cart.entrySet()) {
			totalCartPrice += itemcart.getValue().getTotalPrice();
		}
		return totalCartPrice;
	}
}
