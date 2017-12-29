package cn.et.lesson05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInteractor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String myToken=request.getParameter("myToken");
		Object myToken1=request.getSession().getAttribute("myToken");
		//��֤�ظ��ύ
		if(myToken!=null){
			//�ظ��ύ
			if(myToken1==null){
				return false;
			}else{
				if(myToken.equals(myToken1)){
					request.getSession().removeAttribute("myToken");
					return true;
				}else{
					return false;
				}
			}
		}else{
			return true;
		}
	}

}
