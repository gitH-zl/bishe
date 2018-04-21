package action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.User;

import org.apache.struts2.ServletActionContext;

import util.Pager;
import util.Util;

import com.opensymphony.xwork2.ActionSupport;

import dao.BookDao;
import dao.UserDao;

public class ManageAction extends ActionSupport {

	/**
	 * 
	 */

	private static final long serialVersionUID = 6330249044386288973L;

	private UserDao userDao;

	private BookDao bookDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
//用户登录操作
	public String login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String adminId = request.getParameter("adminId");
		String passWord = request.getParameter("passWord");
		User u = new User();
		u.setUsername(adminId);
		u.setPassword(passWord);
		User user = userDao.selectbean(adminId, passWord);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("role", "role" + user.getRole());
			if (user.getRole() == 1) {

				return "success1";
			} else {

				return "success2";
			}

		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者账号错误');window.location.href='login.jsp';</script>");
			return null;
		}
	}
//用户退出操作
	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("role");
		return "success";
	}
//系统管理员首页
	public String index() {
		return "success";
	}
//用户首页	
	public String index1() {
		return "success";
	}
//图书列表
	public String booklist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = bookDao.selectBeanCount();
		request.setAttribute("list", bookDao.selectBeanByPage((currentpage - 1)
				* pagesize, pagesize));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "booklist", "共有" + total + "条记录"));
		return "success";
	}

	//用户图书信息列表
	public String booklist2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = bookDao.selectBeanCount();
		request.setAttribute("list", bookDao.selectBeanByPage((currentpage - 1)
				* pagesize, pagesize));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "booklist2", "共有" + total + "条记�录"));
		return "success";
	}
	//查询图书操作
	public String booksearch() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String keyword1 = request.getParameter("keyword1");
		String keyword2 = request.getParameter("keyword2");
		String keyword3 = request.getParameter("keyword3");
		String keyword4 = request.getParameter("keyword4");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(keyword1!=null&&!"".equals(keyword1)){
			sb.append("bookname like '%"+keyword1+"%'");
			sb.append(" and ");
		}
		if(keyword2!=null&&!"".equals(keyword2)){
			sb.append("shuhao like '%"+keyword2+"%'");
			sb.append(" and ");
		}
		if(keyword3!=null&&!"".equals(keyword3)){
			sb.append("zuozhe like '%"+keyword3+"%'");
			sb.append(" and ");
		}
		if(keyword4!=null&&!"".equals(keyword4)){
			sb.append("chubanshe like '%"+keyword4+"%'");
			sb.append(" and ");
		}
		
		sb.append(" 1=1 ");
		String where = sb.toString();
		
		
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = bookDao.selectBeanCountByWhere(where);
		request.setAttribute("list", bookDao.selectBeanByPageBywhere((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "booksearch?keyword1=" + keyword1+"&keyword2="+keyword2+"&keyword3="+keyword3+"&keyword4="+keyword4, "共有" + total
						+ "条记�录"));
		return "success";
	}
	//用户查询图书操作
	public String booksearch2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String keyword1 = request.getParameter("keyword1");
		String keyword2 = request.getParameter("keyword2");
		String keyword3 = request.getParameter("keyword3");
		String keyword4 = request.getParameter("keyword4");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(keyword1!=null&&!"".equals(keyword1)){
			sb.append("bookname like '%"+keyword1+"%'");
			sb.append(" and ");
		}
		if(keyword2!=null&&!"".equals(keyword2)){
			sb.append("shuhao like '%"+keyword2+"%'");
			sb.append(" and ");
		}
		if(keyword3!=null&&!"".equals(keyword3)){
			sb.append("zuozhe like '%"+keyword3+"%'");
			sb.append(" and ");
		}
		if(keyword4!=null&&!"".equals(keyword4)){
			sb.append("chubanshe like '%"+keyword4+"%'");
			sb.append(" and ");
		}
		
		sb.append(" 1=1 ");
		String where = sb.toString();
		
		
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = bookDao.selectBeanCountByWhere(where);
		request.setAttribute("list", bookDao.selectBeanByPageBywhere((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "booksearch2?keyword1=" + keyword1+"&keyword2="+keyword2+"&keyword3="+keyword3+"&keyword4="+keyword4, "共有" + total
						+ "条记�录"));
		return "success";
	}

	private File uploadfile1;

	private File uploadfile2;

	public File getUploadfile1() {
		return uploadfile1;
	}

	public void setUploadfile1(File uploadfile1) {
		this.uploadfile1 = uploadfile1;
	}

	public File getUploadfile2() {
		return uploadfile2;
	}

	public void setUploadfile2(File uploadfile2) {
		this.uploadfile2 = uploadfile2;
	}
//添加图书操作
	public void bookadd() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bookname = request.getParameter("bookname");
		String zuozhe = request.getParameter("zuozhe");
		String info = request.getParameter("info");
		String chubanshe = request.getParameter("chubanshe");
		String savaPath = ServletActionContext.getServletContext().getRealPath(
				"/")
				+ "/uploadfile/";

		String time = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()).toString();

		String path1 = time + ".jpg";
		File file1 = new File(savaPath + path1);
		Util.copyFile(uploadfile1, file1);

		String path2 = time + ".txt";
		File file2 = new File(savaPath + path2);
		Util.copyFile(uploadfile2, file2);

		Book bean = new Book();
		bean.setBookname(bookname);
		bean.setZuozhe(zuozhe);
		bean.setInfo(info);
		bean.setChubanshe(chubanshe);
		bean.setPath1(path1);
		bean.setPath2(path2);
		bean.setTime(new Date());
		bean.setShuhao(new Date().getTime() + "");
		bookDao.addBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('图书添加成功');window.location.href='bookadd.jsp';</script>");

	}
	//查看文献信息操作
	public String bookshow() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Book bean = bookDao.selectbean(Integer.parseInt(request
				.getParameter("id")));
		int currentpage = 1;
		int pagesize = 3000;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		if (bean.getPath2() != null) {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String content = Util.readFileByLines(basePath + "uploadfile/"
					+ bean.getPath2());

			int total = (content.length() / pagesize) + 1;

			String c = null;

			if (currentpage == total) {
				c = content.substring((currentpage - 1) * pagesize, content
						.length());
			} else {
				
				try{
					c = content.substring((currentpage - 1) * pagesize, pagesize* currentpage);
				}catch(Exception ee){
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
					response
							.getWriter()
							.print(
									"<script language=javascript>alert('无法直接阅读该页');window.location.href='bookshow?id="+bean.getId()+"';</script>");
					return null;
				}
				
			}

			request.setAttribute("content", c);
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, 1,
					currentpage, "bookshow?id=" + bean.getId(), "共有" + total
							+ "页"));

		}

		request.setAttribute("bean", bean);
		return "success";
	}

	//用户查看文献信息操作
	public String bookshow2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Book bean = bookDao.selectbean(Integer.parseInt(request
				.getParameter("id")));
		bean.setDianjicount(bean.getDianjicount()+1);
		bookDao.updateBean(bean);
		int currentpage = 1;
		int pagesize = 1000;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		if (bean.getPath2() != null) {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String content = Util.readFileByLines(basePath + "uploadfile/"
					+ bean.getPath2());

			int total = (content.length() / pagesize) + 1;

			String c = null;

			if (currentpage == total) {
				c = content.substring((currentpage - 1) * pagesize, content
						.length());
			} else {
				
				try{
					c = content.substring((currentpage - 1) * pagesize, pagesize* currentpage);
				}catch(Exception ee){
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
					response
							.getWriter()
							.print(
									"<script language=javascript>alert('无法直接阅读该页');window.location.href='bookshow2?id="+bean.getId()+"';</script>");
					return null;
				}
				
			}

			request.setAttribute("content", c);
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, 1,
					currentpage, "bookshow?id=" + bean.getId(), "共有" + total
							+ "页"));

		}

		request.setAttribute("bean", bean);
		return "success";
	}
	
	//跳转到更新图书信息页面
	public String bookupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Book bean = bookDao.selectbean(Integer.parseInt(request
				.getParameter("id")));
		request.setAttribute("bean", bean);
		return "success";

	}
//更新图书信息操作
	public void bookupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bookname = request.getParameter("bookname");
		String zuozhe = request.getParameter("zuozhe");
		String info = request.getParameter("info");
		String chubanshe = request.getParameter("chubanshe");
		String id = request.getParameter("id");
		Book bean = bookDao.selectbean(Integer.parseInt(id));
		String savaPath = ServletActionContext.getServletContext().getRealPath(
				"/")
				+ "/uploadfile/";

		String time = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()).toString();

		if (uploadfile1 != null) {
			String path1 = time + ".jpg";
			File file1 = new File(savaPath + path1);
			Util.copyFile(uploadfile1, file1);
			bean.setPath1(path1);
		}
		if (uploadfile2 != null) {
			String path2 = time + ".txt";
			File file2 = new File(savaPath + path2);
			Util.copyFile(uploadfile2, file2);
			bean.setPath2(path2);
		}
		bean.setBookname(bookname);
		bean.setZuozhe(zuozhe);
		bean.setInfo(info);
		bean.setChubanshe(chubanshe);
		bean.setTime(new Date());
		bean.setShuhao(new Date().getTime() + "");
		bookDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('图书更新成功');window.location.href='booklist';</script>");
	}
//删除图书
	public void bookdel() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] ids = request.getParameterValues("ids");
		for (int i = 0; i < ids.length; i++) {
			Book bean = bookDao.selectbean(Integer.parseInt(ids[i]));
			bookDao.deleteBean(bean);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('图书删除成功');window.location.href='booklist';</script>");

	}
//用户列表
	public String userlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount();
		request.setAttribute("list", userDao.selectBeanByPage((currentpage - 1)
				* pagesize, 10));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "userlist", "共有" + total + "条记�录"));
		return "success";
	}
//用户列表
	public String userlist2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount();
		request.setAttribute("list", userDao.selectBeanByPage((currentpage - 1)
				* pagesize, pagesize));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "userlist2", "共有" + total + "条记录"));
		return "success";
	}
//查询用户信息
	public String usersearch() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String keyword = request.getParameter("keyword");
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount(keyword);
		request.setAttribute("list", userDao.selectBeanByPage((currentpage - 1)
				* pagesize, pagesize, keyword));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "usersearch?keyword=" + keyword, "共有" + total
						+ "条记�?"));
		return "success";
	}


//添加用户操作
	public void useradd2() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String xingming = request.getParameter("xingming");
		User  u = userDao.selectbean(username);
			
		if (u != null) {
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户添加失败。该用户名已经存在');window.location.href='useradd.jsp';</script>");
			return;
		}
		User user = new User();
		user.setPassword("123456");
		user.setUsername(username);
		user.setXingming(xingming);
		user.setCreatetime(new Date());
		userDao.addBean(user);
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('用户添加成功,默认密码123456');window.location.href='useradd.jsp';</script>");

	}
//跳转到用户更新页面
	public String userupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectbean(Integer.parseInt(request
				.getParameter("id")));
		request.setAttribute("bean", bean);

		return "success";

	}
//用户更新操作
	public void userupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectbean(Integer.parseInt(request
				.getParameter("id")));
		
		bean.setXingming(request.getParameter("xingming"));
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('用户更新成功');window.location.href='userlist';</script>");
	}
//删除用户操作
	public void userdel() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] ids = request.getParameterValues("ids");
		for (int i = 0; i < ids.length; i++) {
			User bean = userDao.selectbean(Integer.parseInt(ids[i]));

			userDao.deleteBean(bean);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('用户删除成功');window.location.href='userlist';</script>");

	}
//跳转到添加用户页面
	public String useradd() {
		return "success";
	}
//修改密码操作
	public void passwordupdate() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		User u = userDao.selectbean(user.getUsername(), password1);
		if (u == null) {
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('原密码错误，修改失败');window.location.href='user.jsp';</script>");
		} else {
			u.setPassword(password2);
			userDao.updateBean(u);
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('密码修改成功');window.location.href='user.jsp';</script>");
		}
	}
	
	
	
	
//图书下载操作	
	public void bookdownload() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Book bean = bookDao.selectbean(Integer.parseInt(id));
		if (bean.getPath2() != null) {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String uri = basePath + "uploadfile/"+ bean.getPath2();
			String content = Util.readFileByLines(uri);
			
			ManageAction.download(uri, response, content);
			bean.setXiazaicount(bean.getDianjicount()+1);
			bookDao.updateBean(bean);
		}else{
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('没有该书的下载信息，下载失败');window.location.href='booklist2';</script>");
		}
 		

    }
	
	public static HttpServletResponse download(String uri, HttpServletResponse response,String content) {
        try {
        	
        	
        	URL url = new URL(uri);
	 		URLConnection connection = url.openConnection();
	 		InputStream fis = connection.getInputStream();
	 		
        
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=xiazaitushu.txt" );
            response.addHeader("Content-Length", "" +content.length() );
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }


}
