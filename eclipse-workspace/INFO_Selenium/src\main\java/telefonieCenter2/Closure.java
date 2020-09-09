package telefonieCenter2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Closure {

	private WebDriver driver; 
	
	private By nutzerLocator = By.xpath("//span[contains(text(),'Nutzer')]");
	
	private By logoutLocator = By.xpath("//li[@id='tc-selectbox-2-option-4']");
	
	public Closure (WebDriver driver) {
		this.driver= driver;
	}
	
	public void scrollToNutzer() {
		WebElement nutzerAccess = driver.findElement(By.xpath(
				"//span[contains(text(),'Nutzer')]"));
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", nutzerAccess);
	}

	public void clickNutzer() {
		driver.findElement(nutzerLocator).click();
	}
	
	public void logout () {
		driver.findElement(logoutLocator).click();
	}
	
}
