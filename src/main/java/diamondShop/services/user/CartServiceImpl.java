package diamondShop.services.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diamondShop.dao.CartDao;
import diamondShop.dto.CartDto;
import diamondShop.services.user.userInterface.ICartService;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartDao cartDao;

	@Override
	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart) {
		return cartDao.addCart(id, cart);
	}

	@Override
	public HashMap<Long, CartDto> editCart(long id, int quantity, HashMap<Long, CartDto> cart) {
		return cartDao.editCart(id, quantity, cart);
	}

	@Override
	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart) {
		return cartDao.deleteCart(id, cart);
	}

	@Override
	public int totalQuantity(HashMap<Long, CartDto> cart) {
		return cartDao.totalQuantity(cart);
	}

	@Override
	public double totalPrice(HashMap<Long, CartDto> cart) {
		return cartDao.totalPrice(cart);
	}

}
