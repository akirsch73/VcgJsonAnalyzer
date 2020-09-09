package telefonieCenter2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlackList {

	private WebDriver driver;

	private By blackListLocator = By
			.xpath("//span[@class='tooltip error black-list']//a[@class='enabled'][contains(text(),'Negativliste')]");

	private By blackListAdder = By.xpath("//input[@placeholder='Name oder Nummer eingeben']");

	private By blackListPlus = By.xpath("//button[@class='ui-icon-only-button add-item']");

	private By blackListCloser = By.xpath("//span[@class='label primary']");

	public BlackList(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollToBlackList() {
		WebElement blackListLink = driver.findElement(By.xpath(
				"//span[@class='tooltip error black-list']//a[@class='enabled'][contains(text(),'Negativliste')]"));
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", blackListLink);
	}

	public void openBlackList() {
		driver.findElement(blackListLocator).click();
	}

	public void fillInBlackList() throws InterruptedException {
		driver.findElement(blackListAdder).sendKeys("06151680");
		Thread.sleep(1000);
		driver.findElement(blackListPlus).click();
		driver.findElement(blackListCloser).click();
	}
}
