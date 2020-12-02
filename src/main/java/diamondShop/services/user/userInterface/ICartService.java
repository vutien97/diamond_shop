package diamondShop.services.user.userInterface;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import diamondShop.dto.CartDto;

@Service
public interface ICartService {
	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> editCart(long id, int quantity, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart);
	public int totalQuantity(HashMap<Long, CartDto> cart);
	public double totalPrice(HashMap<Long, CartDto> cart);
}
