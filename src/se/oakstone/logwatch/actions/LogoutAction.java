/**
 * 
 */
package se.oakstone.logwatch.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author NEK
 *
 */
public class LogoutAction extends ActionSupport {

	@Override
    public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		session.remove("user");
		
		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
		    try {
		        ((org.apache.struts2.dispatcher.SessionMap<String, Object>) session).invalidate();
		    } catch (IllegalStateException e) {
		        //logger.error(msg, e);
		    }
		}
		
	    return SUCCESS;
    }
}
