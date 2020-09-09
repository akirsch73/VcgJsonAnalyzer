package telefonieCenter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	private WebDriver driver;

	private By benutzernameLocator = By.id("pw_usr");

	private By weiterButtonLocator = By.id("pw_submit");

	private By passwortLocator = By.id("pw_pwd");

	private By loginButtonLocator = By.id("pw_submit");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void typeBenutzername(String benutzername) {
		driver.findElement(benutzernameLocator).sendKeys(benutzername);
	}

	public void clickWeiterButton() {
		driver.findElement(weiterButtonLocator).click();
	}

	public void typePasswort(String passwort) {
		driver.findElement(passwortLocator).sendKeys(passwort);
	}

	public void clickLoginButton() {
		driver.findElement(loginButtonLocator).click();
	}

}
