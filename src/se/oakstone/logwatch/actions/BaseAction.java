/**
 * 
 */
package se.oakstone.logwatch.actions;

import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import se.oakstone.logwatch.User;

/**
 * @author Nils
 *
 */
public abstract class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 9159478329880322632L;
	protected User user;

	
	@Override	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User) session.get(LoginAction.LOGGED_IN_USER);
		
		if (user == null) return "NotLoggedIn";
		
		return myExecute();
	}

	@Override
	@SkipValidation
	public String input() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User) session.get(LoginAction.LOGGED_IN_USER);
		
		if (user == null) return "NotLoggedIn";
		
		return myInput();
	}

	public abstract String myExecute() throws Exception; 
	public abstract String myInput() throws Exception; 


}
