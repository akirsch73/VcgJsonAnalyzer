package telefonieCenter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigate {

	private WebDriver driver;
	
	private By dropdownLocator = By.xpath("//div[@id='tc-selectbox-1']//a[@class='form-select-js-choice']");
	
	private By selectLocator = By.xpath("//li[@id='tc-selectbox-1-option-2']");
	
	private By weiterLocator = By.xpath("//button[@id='intro-continue-button']");
	
	private By popUpLocator = By.xpath("//span[@class='label primary']");
	
	private By linkLocator = By.xpath("//span[contains(text(),'Anrufer blockieren')]");
	
	
	public Navigate (WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickDropdown() {
		driver.findElement(dropdownLocator).click();
		}
	
	public void clickSelect () {
		driver.findElement(selectLocator).click();
	}
	
	public void clickWeiter() {
		driver.findElement(weiterLocator).click();
	}
	
	public void clickPopUp () {
		driver.findElement(popUpLocator).click();
	}
	
	public void clickLink () throws InterruptedException {
		driver.findElement(linkLocator).click();
		Thread.sleep(3000);
	}

}
