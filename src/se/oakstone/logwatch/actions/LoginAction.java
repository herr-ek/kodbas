/**
 * 
 */
package se.oakstone.logwatch.actions;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import se.oakstone.logwatch.User;
import se.oakstone.logwatch.dao.HibernateUtil;
import se.oakstone.logwatch.dao.UserDAO;
import se.oakstone.logwatch.dao.UserDAOImpl;

/**
 * @author NEK
 *
 */
public class LoginAction extends ActionSupport {

	public static final String LOGGED_IN_USER = "lw_user";

	@Override
    public String execute() throws Exception {
		ServletContext ctx = ServletActionContext.getServletContext();
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserDAO userDAO = new UserDAOImpl();
		try {
			HibernateUtil.beginTransaction();
			Query query = HibernateUtil.getSession().createQuery("from com.pipechain.logwatch.User where username=:username and password=:password");
			query.setString("username", username);
			query.setString("password", password);
			User loggedInUser = userDAO.findOne(query);
			HibernateUtil.commitTransaction();
			
			if (loggedInUser == null) {
				addActionError("Login failed. User or password unknown.");
				return INPUT;
			}
			else {
				session.put(LOGGED_IN_USER, loggedInUser);
			}
		}
		finally {
			HibernateUtil.getSession().close();
		}
		return SUCCESS;
    }

    @SkipValidation
    public String form() throws Exception {
        return INPUT;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
