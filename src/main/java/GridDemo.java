import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
 * see also session 'phase-6__s4'
 * 
 * 
 * selenium grid: java -jar selenium-server-standalone-3.5.3.jar -role hub
 * 
 * start a node: java -jar selenium-server-standalone-3.5.3.jar -role node -hub http://172.17.0.1:4444/grid/register/
 * 
 * 
 * then open the grid console: http://172.17.0.1:4444/grid/console
 * 
 * 
 * launch hub with config json file: java -jar selenium-server-standalone-3.5.3.jar -role hub -hubConfig hubconfig.json
 * 
 * same for node: ... -nodeConfig nodeconfig.json
 * 
 * */

public class GridDemo {
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.LINUX);
		
		URL url = new URL("http://172.17.0.1:4444/wd/hub"); //since we are running just 1 node, this single node is used to make the request
		WebDriver driver = new RemoteWebDriver(url,cap);
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}
