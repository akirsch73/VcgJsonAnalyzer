package telefonieCenter2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WhiteList {

	private WebDriver driver;

	private By whiteListLocator = By.xpath("//a[contains(text(),'Positivliste')]");

	// private By whiteListStatus1 = By.xpath("//em[@class='amount h1 visible']");
	// private By whiteListStatus2 = By.xpath("//span[@class='no-entries
	// visible']");
	// private By whiteListStatus3 = By.xpath("//h4[@class='list-header']");
	// span[@class='no-entries visible']

	private By whiteListInput = By.xpath("//input[@placeholder='Name oder Nummer eingeben']");

	private By whiteListAdder = By.xpath("//button[@class='ui-icon-only-button add-item']");

	private By whiteListClose = By.xpath("//span[@class='label primary']");

	public WhiteList(WebDriver driver) {
		this.driver = driver;
	}

	public void openWhiteList() {

		WebElement whiteListLink = driver.findElement(By.xpath("//a[contains(text(),'Positivliste')]"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", whiteListLink);

	}

//	public int checkStatus() {
//		int status = 0;
//		String amount = null;
//		boolean present;
//		try {
//			driver.findElement(By.xpath("//em[@class='amount h1 visible']"));
//			present = true;
//		} catch (NoSuchElementException e) {
//			present = false;
//		}
//		if (present == true) {
//			System.out.println(driver.findElement(By.xpath("//em[@class='amount h1 visible']")).getText());
//			amount = (String) driver.findElement(By.xpath("//em[@class='amount h1 visible']")).getText();
//			if (present == false) {
//				status = 0;
//			}
//			status = Integer.parseInt(amount);
//			status = 50 - status;
//
//		}
//		return status;
//
//	}

	public void inputWhiteList() throws InterruptedException {

		for (int digits = 11; digits < 60; digits++) {
			driver.findElement(whiteListInput).sendKeys("06151680" + digits);
			Thread.sleep(3000);
			driver.findElement(whiteListAdder).click();
			Thread.sleep(3000);

		}

		driver.findElement(whiteListClose).click();

	}
}

//
//}whiteListBox.sendKeys("06151777777");Thread.sleep(3000);driver.findElement(By.xpath("//button[@class='ui-icon-only-button add-item']")).click();
//String feedback = whiteListBox.findElement(By.xpath("//span[@class='content']"))
//		.getText();driver.findElement(By.xpath("//span[@class='label primary']")).click();System.out.println("Originaldatei: "+feedback);return feedback;
//		
//		
//		
//		
