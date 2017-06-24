package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({ "/premium.jsp" })
public class PremiumPageFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		if (session.getAttribute("logged")==null || session.getAttribute("logged").equals("false")){
			
			httpResponse.sendRedirect("/");
			
		}
		else if (session.getAttribute("logged").equals("true") && session.getAttribute("premium").equals("premiumNo")){
			httpResponse.sendRedirect("/ProfileServlet");
		}
		
		else filterChain.doFilter(request, response);
			

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
