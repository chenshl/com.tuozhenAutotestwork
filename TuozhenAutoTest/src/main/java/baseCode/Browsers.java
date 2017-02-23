package baseCode;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	
	public WebDriver driver = null;
	private FirefoxProfile firefoxProfile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = "E://eclipseWorkSpace//TuozhenAutoTest";//工具存储路径
	
	public Browsers(BrowsersType browserstype){
		switch (browserstype) {
		    case firefox:
		    	//File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
		    	//File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
		    	firefoxProfile = new FirefoxProfile();
		    	try {
		    		//firefoxProfile.addExtension(firebug);
					//firefoxProfile.addExtension(firepath);
					firefoxProfile.setPreference("webdriver.accept.untrusted.certs", true);
					firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.12.1");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		    	driver = new FirefoxDriver(firefoxProfile);
		    	driver.manage().window().maximize();
			    break;
		    case ie:
		    	System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer64.exe");
		    	caps = DesiredCapabilities.internetExplorer();
		    	caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
		    	caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		    	caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		    	caps.setCapability("ignoreZoomSetting", true);
		    	driver = new InternetExplorerDriver(caps);
		    	driver.manage().window().maximize();
		    	break;
		    case chrome:
		        System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver.exe");
		        caps = DesiredCapabilities.chrome();
		        caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));//最大化browser
		        //capabilities.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //设置代理
		        driver = new ChromeDriver(caps);
		        driver.manage().window().maximize();
		        break;
		    

		}
	}
	

}
