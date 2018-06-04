package hello;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/*greet*/")
public class GreetingController implements ApplicationEventPublisherAware {
	
	private static final String template = "Hello, %s!";
	
	
	//private String name;
	private ApplicationEventPublisher publisher;
    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping("greeting")
    public String greeting() {
    	//System.out.println("Principal:"+principal.getName());
    	//System.out.println("Json String:"+jsonString);
        return  "as";
    }
    
    @RequestMapping("sa")
    public String sa() {
        return  "sa";
    }

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.publisher=arg0;
		// TODO Auto-generated method stub
		
	}
	
}
