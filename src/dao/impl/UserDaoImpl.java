package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;





public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public void addBean(User User) {
		this.getHibernateTemplate().save(User);
		
	}

	public void deleteBean(User User) {
		this.getHibernateTemplate().delete(User);
		
	}

	@SuppressWarnings("unchecked")
	public List<User> selectBeanByPage(final int start,final int limit) {
		return (List<User>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<User> list = session.createQuery("from User where  role=0 order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectBeanCount() {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from User where  role=0").get(0);
		return (int)count;
	}

	public User selectbean(int id) {
		return this.getHibernateTemplate().get(User.class,(long) id);
	}

	public void updateBean(User User) {
		this.getHibernateTemplate().update(User);
		
	}

	@SuppressWarnings("unchecked")
	public User selectbean(String username, String password) {
		List<User> list = this.getHibernateTemplate().find("from User where username=? and password = ? ",username,password);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public User selectbean(String username) {
		List<User> list = this.getHibernateTemplate().find("from User where username=? ",username);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> selectBeanByPage(final int start,final int limit,final String keyword) {
		return (List<User>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<User> list = session.createQuery("from User where  role=0  and xingming like '%"+keyword+"%'  order by id desc")
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public int selectBeanCount(String keyword) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from User where  role=0 and xingming like '%"+keyword+"%'").get(0);
		return (int)count;
	}
	
}
