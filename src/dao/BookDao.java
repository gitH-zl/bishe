package dao;

import java.util.List;

import model.Book;






public interface BookDao  {
	
	public void addBean(Book Book);
	
	public void updateBean(Book Book);
	
	public void deleteBean(Book Book);
	
	public Book selectbean(int id);
	
	public List<Book> selectBeanByPage(final int start, final int limit);
	
	public int selectBeanCount();
	
	public List<Book> selectBeanByPage(final int start, final int limit,String keyword);
	
	public int selectBeanCount(String keyword);
	
	public List<Book> selectBeanByPageBywhere(final int start, final int limit,String where);
	
	public int selectBeanCountByWhere(String where);
	
}
