package Linkdin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserUtil11 {
	WebDriver driver;

	public WebDriver launchbrowser(String Browser) {

		switch (Browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			// driver.manage().window().maximize();
			break;

		case "Edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.print(Browser);
		}

		return driver;

	}

	public void launchUrl(String url) {
		if (url == null) {
			System.out.println("url is null");
			throw new FrameworkException("url is null");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

	}

}