package Linkdin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkdinProfile1 {

	public static void main(String[] args) throws InterruptedException {
		Properties prop = ConfigReader.getProperties();

		BrowserUtil11 brutil = new BrowserUtil11();
		String url = prop.getProperty("app.url");
		String browser = prop.getProperty("browser.name");
		String username = prop.getProperty("user.email");
		String password = prop.getProperty("user.password");
		WebDriver driver = brutil.launchbrowser(browser);

		brutil.launchUrl(url);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='My Network']")).click();

		Thread.sleep(3000);

		List<WebElement> elements = driver.findElements(By.xpath("//p[contains(text(),'other mutual connections')]"));

		for (WebElement el : elements) {
			String fullText = el.getText();
			String numberStr = fullText.replaceAll("[^0-9]", "");
			if (!numberStr.isEmpty()) {
				int number = Integer.parseInt(numberStr);
				if (number > 50) {
					String dynamicXPath = String.format(
							"//p[contains(text(),'%d other mutual connections')]/parent::div/../following-sibling::div/button[contains(@aria-label ,'connect')]",
							number);
					WebElement button = driver.findElement(By.xpath(dynamicXPath));
					System.out.println("Clicking connect for: " + fullText);
					button.click();
				}
			}
		}
	}
}
