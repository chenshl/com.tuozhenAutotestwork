package doc;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DocLoginPage;
import pages.HomePage;
import baseCode.Browsers;
import baseCode.BrowsersType;
import baseCode.Wait;


public class DocLoginTestOne {
	
	private WebDriver driver;
	
	@BeforeClass
	public void choosedriver(){
		//选择测试所用的浏览器
		Browsers browsers = new Browsers(BrowsersType.firefox);
		driver = browsers.driver;
	}
	
	@Test
	public void clickuserloginbutton(){
		driver.get("http://www.tuozhen.com");
		HomePage homepage = new HomePage(driver);
		DocLoginPage docloginpage = new DocLoginPage(driver);
		Wait wait = new Wait(driver);
		wait.waitForElementIsEnable("//*[@id='doctorLogin_sso']");
		homepage.goDocloginpage();
		docloginpage.getusername("18716201367");
		docloginpage.getpassword("123456789");
		docloginpage.login();
		wait.waitForElementIsEnable("//*[@id='loginOut']");//等待退出登录加载，验证是否登录成功
		wait.waitFor(5000);
		homepage.loginout();
		wait.waitFor(5000);
	}
	
	@AfterClass
	public void releasedriver(){
		driver.quit();
	}

}
