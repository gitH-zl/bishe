package dao;

import java.util.List;

import model.User;






public interface UserDao  {
	
	public void addBean(User User);
	
	public void updateBean(User User);
	
	public void deleteBean(User User);
	
	public User selectbean(int id);
	
	public List<User> selectBeanByPage(final int start, final int limit);
	
	public int selectBeanCount();
	
	public User selectbean(String username,String  password);
	
	public User selectbean(String username);
	
	public List<User> selectBeanByPage(final int start, final int limit,String keyword);
	
	public int selectBeanCount(String keyword);
	
}
