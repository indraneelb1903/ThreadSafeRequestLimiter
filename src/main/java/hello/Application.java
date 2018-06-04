package hello;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.DispatcherServlet;

@EnableScheduling
@SpringBootApplication
public class Application implements InitializingBean{

	@Autowired
	DispatcherServlet dispatcherServlet;
	
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(dispatcherServlet.getServletName());
		System.out.println(dispatcherServlet.toString());
	}

    
    
}
