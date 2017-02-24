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
		//ѡ��������õ������
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
		wait.waitForElementIsEnable("//*[@id='loginOut']");//�ȴ��˳���¼���أ���֤�Ƿ��¼�ɹ�
		wait.waitFor(5000);
		homepage.loginout();
		wait.waitFor(5000);
	}
	
	@AfterClass
	public void releasedriver(){
		driver.quit();
	}

}
