package edu.sdp.com.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.sdp.com.entities.User;

public class ManagerLoginInterceptor implements HandlerInterceptor {
	/**
	 * 在用户访问manager路径下的页面的时候
	 * <p>
	 * 进入该拦截器
	 * <p>
	 * 该方法在执行目标方法前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle在目标方法执行前执行");
		HttpSession session = request.getSession();
		 User user = (User) session.getAttribute("user");
		 if (user != null) {
		 // 用户登陆,并且是管理员
		 if ("admin".equals(user.getUsername())) {
		 // 放行
		 return true;
		 }
		 }
		request.setAttribute("msg", "请使用管理员账号登陆");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/login.jsp");
		requestDispatcher.forward(request, response);
		// 拦截器不放行
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle方法在调用目标方法后，渲染视图之前调用,可以对ModelAndView进行修改");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion方法在调用目标方法后，渲染试图并转发之后调用");
	}

}
