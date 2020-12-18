package diamondShop.services.user.userInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import diamondShop.entites.User;

@Service
public interface IUserService {
	public List<User> getAllUser();
	public int addAccount(User user);
	public User findUserByLogin(User user);
	public List<User> getListUserPaginate(int start, int totalProductIn1Page);
	public void deleteUser(User user);
	public User getUserById(long id);
	public int updateUser(User user);
}
