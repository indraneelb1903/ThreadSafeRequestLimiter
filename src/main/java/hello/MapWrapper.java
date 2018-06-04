package hello;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MapWrapper implements InitializingBean , DisposableBean{

	
	private ConcurrentHashMap<String,Integer> map;
	
	public ConcurrentHashMap<String, Integer> getMap() {
		return map;
	}

	public  MapWrapper() {
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.map = new ConcurrentHashMap<>();
		
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Scheduled(cron = "0 5/15 * * * *")
	public void clearMap() {
		System.out.println("Clearing map");
		this.map.clear();
	}
	

}
