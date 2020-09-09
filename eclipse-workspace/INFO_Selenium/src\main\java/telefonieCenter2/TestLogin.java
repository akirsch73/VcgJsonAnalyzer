package telefonieCenter2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {

	private WebDriver driver;
	private Login login;
	private Navigate navigate;
	private BlackList blackList; 
	private WhiteList whiteList;
	private OverFlow overFlow;
	private Closure closure;

	public void base() {
		System.setProperty("webdriver.gecko.driver", "/home/sea29/driver_container/geckodriver");

		driver = new FirefoxDriver();
		login = new Login(driver);
		navigate = new Navigate(driver);
		blackList = new BlackList(driver);
		whiteList = new WhiteList(driver);
		overFlow = new OverFlow(driver);
		closure = new Closure(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://telefoniecenter2.ver.sul.t-online.de/fcc/index.html");

	}

	public void testLogin() throws InterruptedException {

		login.typeBenutzername("voip2ims_gb_20190521_1");
		login.clickWeiterButton();
		login.typePasswort("voip2ims_gb_20190521_1");
		login.clickLoginButton();
		Thread.sleep(1000);
	}

	public void navigate() throws InterruptedException {
		navigate.clickDropdown();
		navigate.clickSelect();
		navigate.clickWeiter();
		Thread.sleep(5000);
		navigate.clickPopUp();
		navigate.clickLink();
		
	}
	
	public void setBlackList () throws InterruptedException {
		blackList.scrollToBlackList();
		blackList.openBlackList();
		blackList.fillInBlackList();
		
	}
	public void setWhiteList () throws InterruptedException {
		whiteList.openWhiteList();
		whiteList.inputWhiteList();
	}
	
	public void getOverFlow() throws InterruptedException {
		overFlow.openWhiteList();
		overFlow.checkStatus();
		overFlow.inputWhiteList();
		overFlow.overflowWhitList();
		
	}
	
	public void exit() {
		closure.scrollToNutzer();
		closure.clickNutzer();
		closure.logout();
	}
}
