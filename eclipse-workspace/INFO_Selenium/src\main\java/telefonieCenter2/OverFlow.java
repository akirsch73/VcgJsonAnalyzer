package telefonieCenter2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverFlow {

	private WebDriver driver;

	private By whiteListLocator = By.xpath("//a[contains(text(),'Positivliste')]");

	private By whiteListStatus = By.xpath("//em[@class='amount h1 visible']");

	private By whiteListInput = By.xpath("//input[@placeholder='Name oder Nummer eingeben']");

	private By whiteListAdder = By.xpath("//button[@class='ui-icon-only-button add-item']");

	private By whiteListClose = By.xpath("//span[@class='label primary']");

	private By whiteListFeedback = By.xpath("//span[@class='content']");

	public OverFlow(WebDriver driver) {
		this.driver = driver;
	}

	public void openWhiteList() throws InterruptedException {

		WebElement whiteListLink = driver.findElement(By.xpath("//a[contains(text(),'Positivliste')]"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", whiteListLink);
		Thread.sleep(1000);

	}

	public int checkStatus() {
		String amount = driver.findElement(whiteListStatus).getText();
		int status = Integer.parseInt(amount);
		status = 50 - status;
		System.out.println(status);
		return status;
	}

	public void inputWhiteList() throws InterruptedException {

		for (int digits = 0; digits < checkStatus(); digits++) {
			driver.findElement(whiteListInput).sendKeys("06151689" + digits);
			Thread.sleep(3000);
			driver.findElement(whiteListAdder).click();
			Thread.sleep(3000);

		}

	}

	public String overflowWhitList() throws InterruptedException {
		driver.findElement(whiteListInput).sendKeys("06151680999");
		Thread.sleep(3000);
		driver.findElement(whiteListAdder).click();
		Thread.sleep(3000);

		String feedback = driver.findElement(whiteListFeedback).getText();
		driver.findElement(By.xpath("//span[@class='label primary']")).click();
		
		System.out.println("Overflow: " +feedback);
		return feedback;
	}

}
