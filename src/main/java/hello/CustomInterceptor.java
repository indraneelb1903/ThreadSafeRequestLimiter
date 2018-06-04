package hello;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomInterceptor implements HandlerInterceptor {

	@Autowired
	private MapWrapper mapWrapper;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, Exception arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		
		String ipAddress = arg0.getRemoteAddr();
		ConcurrentHashMap<String, Integer> map = mapWrapper.getMap();
		
		return checkAndInsert(map, ipAddress, arg1);
	}
	
	
	public boolean checkAndInsert(ConcurrentHashMap<String, Integer> map , String ipAddress , HttpServletResponse response) {
		while(true) {
			
			Integer previousValue;
			Integer oldValue = map.get(ipAddress);
			if( null == oldValue) {
				previousValue = map.putIfAbsent(ipAddress, 1);
				if( null == previousValue) {
					System.out.println("Value entered for first time for ip address is: "+ipAddress);
					return true;
				}
				else
					oldValue = previousValue;
				
			}
			if(oldValue >= 10) {
				System.out.println("Limit exceeded");
				try {
					response.getWriter().println("You exceeded your prescribed limit");
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				return false;
			}
			else {
				Integer newValue = oldValue + 1;
				boolean Successful = map.replace(ipAddress, oldValue, newValue);
				if(Successful) {
					System.out.println("Update successful");
					return true;
				}
				System.out.println("Update failed");
			}
			
		}
	}

}
