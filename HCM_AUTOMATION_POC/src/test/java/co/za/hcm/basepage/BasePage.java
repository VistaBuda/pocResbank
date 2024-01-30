package co.za.hcm.basepage;

import co.za.hcm.infrastructure.driver.Setup;
import co.za.hcm.infrastructure.driver.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected Wait wait;
    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}
