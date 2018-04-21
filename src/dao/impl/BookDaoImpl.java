package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Book;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BookDao;





public class BookDaoImpl extends HibernateDaoSupport implements  BookDao{

	public void addBean(Book Book) {
		this.getHibernateTemplate().save(Book);
		
	}

	public void deleteBean(Book Book) {
		this.getHibernateTemplate().delete(Book);
		
	}

	@SuppressWarnings("unchecked")
	public List<Book> selectBeanByPage(final int start,final int limit) {
		return (List<Book>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Book> list = session.createQuery("from Book  order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectBeanCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Book ").get(0);
		return (int)count;
	}

	public Book selectbean(int id) {
		return this.getHibernateTemplate().get(Book.class, id);
	}

	public void updateBean(Book Book) {
		this.getHibernateTemplate().update(Book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> selectBeanByPage(final int start,final int limit,final String keyword) {
		return (List<Book>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Book> list = session.createQuery("from Book where bookname like '%"+keyword+"%' order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectBeanCount(String keyword) {
		String sql = "select count(*) from Book where bookname like '%"+keyword+"%'";
		long count = (Long)this.getHibernateTemplate().find(sql).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Book> selectBeanByPageBywhere(final int start,final int limit, final String where) {
		return (List<Book>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Book> list = session.createQuery("from Book "+where+" order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectBeanCountByWhere(String where) {
		String sql = "select count(*) from Book "+where;
		long count = (Long)this.getHibernateTemplate().find(sql).get(0);
		return (int)count;
	}
	
	
	
}
