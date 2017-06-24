package s14292Zadanie2;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import repositories.DummyLoginApplicationRepository;
import repositories.LoginApplicationRepository;
import web.LoginServlet;
import web.filters.LoginPageFilter;
import web.filters.PremiumEditPageFilter;
import web.filters.PremiumPageFilter;
import web.filters.ProfilePageFilter;
import web.filters.RegisterPageFilter;
import web.filters.SummaryPageFilter;

@RunWith(MockitoJUnitRunner.class)
public class Zadanie2UnitTest extends Mockito{

	@Spy
	LoginApplicationRepository repo = new DummyLoginApplicationRepository();
	
	@InjectMocks
	LoginPageFilter servletL;
	@InjectMocks
	RegisterPageFilter servletR;
	@InjectMocks
	ProfilePageFilter servletP;
	@InjectMocks
	PremiumPageFilter servletPr;
	@InjectMocks
	SummaryPageFilter servletS;
	@InjectMocks
	PremiumEditPageFilter servletE;
	
	
	@Test
	public void logged_should_go_to_profile_instead_login () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("true");
		
		FilterChain chain = null;
		servletL.doFilter(request, response, chain);
		verify(response).sendRedirect("/ProfileServlet");
	}
	
	@Test
	public void logged_should_go_to_profile_instead_register () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("true");
		
		FilterChain chain = null;
		servletR.doFilter(request, response, chain);
		verify(response).sendRedirect("/ProfileServlet");
	}	
	
	@Test
	public void no_session_cannot_access_profile () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn(null);
		
		FilterChain chain = null;
		servletP.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void not_logged_cannot_access_profile () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("false");
		
		FilterChain chain = null;
		servletP.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void not_premium_should_go_to_profile_instead_premium () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("true");
		when(session.getAttribute("premium")).thenReturn("premiumNo");
		
		FilterChain chain = null;
		servletPr.doFilter(request, response, chain);
		verify(response).sendRedirect("/ProfileServlet");
	}
	
	@Test
	public void no_session_cannot_access_premium () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn(null);
		
		FilterChain chain = null;
		servletPr.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void not_logged_cannot_access_premium () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("false");
		
		FilterChain chain = null;
		servletPr.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void no_session_cannot_access_summary () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn(null);
		
		FilterChain chain = null;
		servletS.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void not_logged_cannot_access_summary () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("false");
		
		FilterChain chain = null;
		servletS.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void not_admin_should_go_to_profile_instead_summary () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("true");
		when(session.getAttribute("admin")).thenReturn("adminNo");
		
		FilterChain chain = null;
		servletS.doFilter(request, response, chain);
		verify(response).sendRedirect("/ProfileServlet");
	}
	
	@Test
	public void no_session_cannot_access_editpremium () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn(null);
		
		FilterChain chain = null;
		servletE.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void not_logged_cannot_access_editpremium () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("false");
		
		FilterChain chain = null;
		servletE.doFilter(request, response, chain);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void not_admin_should_go_to_profile_instead_editpremium () throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("logged")).thenReturn("true");
		when(session.getAttribute("admin")).thenReturn("adminNo");
		
		FilterChain chain = null;
		servletE.doFilter(request, response, chain);
		verify(response).sendRedirect("/ProfileServlet");
	}
	
}
