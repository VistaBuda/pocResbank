package co.za.hcm.commonsteps;

import co.za.hcm.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;


import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class CommonSteps extends BasePage {

    private static final String HOME_PAGE_URL = "https://fa-evra-dev2-saasfaprod1.fa.ocs.oraclecloud.com/hcmUI/faces/FuseWelcome";
    private Map<String, Object> vars;
    JavascriptExecutor js;

/*
    Objects
 */
    @FindBy(xpath = "//*[@id='userid']")
    private WebElement txtUsername;

    @FindBy(xpath="//*[@id='password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//*[@id='btnActive']")
    private WebElement btnLogin;

    @FindBy(css = "*[data-test='product_sort_container']")
    private WebElement drpsort;



    /*
       Common Steps
     */
    CommonSteps(){
        PageFactory.initElements(driver, this);
    }
    void goToHomePage(){
        driver.get(HOME_PAGE_URL);
        wait.forLoading(100);
    }

    void login(final String username, final String password) {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        txtUsername.click();
        txtUsername.sendKeys(username);

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        txtPassword.click();
        txtPassword.sendKeys(password);

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        btnLogin.click();

    }

    void sortAscedingOrder() throws Throwable{

        List<WebElement>beforeFilterPrice = driver.findElements(By.className("inventory_container"));

        List<Double> beforeFilterPriceList = new ArrayList<>();

        for(WebElement p : beforeFilterPrice){
            beforeFilterPriceList.add( Double.valueOf(p.getText().replace("$", "")));
        }

        Select drpDown = new Select(driver.findElement(By.className("product_sort_container")));
        drpDown.selectByVisibleText("Price (low to high)");

        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_container"));
        List<Double>afterFilterPriceList = new ArrayList<>();

        for(WebElement p : afterFilterPrice){
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        Collections.sort(afterFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);

        Thread.sleep(2000);

    }

    void click_absence_module(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#itemNode_my_information_absences1 > svg.svg-nav.suiicon.svg-bkgd05 > path.svg-outline")).click();

    }

    void clickAbsence(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr1:0:lp1Upl:UPsp1:i2:1:tb1:TBpgl6']/div/span")).click();

    }

    void selectDropDown(){
        driver.findElement(By.id("pt1:_FOr1:1:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:typSis:typSrh::content")).click();
        driver.findElement(By.xpath("//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:typSis:typSrh::item0']/th/div")).click();
    }

    void addDates(){
        driver.findElement(By.id("pt1:_FOr1:1:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:bsDtPce:abDtsT:0:abSt1Dt::content")).sendKeys("2024-02-21");
        driver.findElement(By.id("pt1:_FOr1:1:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:bsDtPce:abDtsT:0:abEd1Dt::content")).click();
        driver.findElement(By.id("pt1:_FOr1:1:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:bsDtPce:abDtsT:0:abEd1Dt::content")).clear();
        driver.findElement(By.id("pt1:_FOr1:1:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:bsDtPce:abDtsT:0:abEd1Dt::content")).sendKeys("2024-02-25");
        driver.findElement(By.id("pt1:_FOr1:1:_FONSr2:0:MAnt2:1:adAbUpl:UPsp1:svclBtn")).click();

    }

    void saveAndClose(){
        driver.findElement(By.id("pt1:_UIScmil2u")).click();
        driver.findElement(By.id("pt1:_UISlg1")).click();
    }

    void logOut() {

    }

    void clickHiring(){
       // driver.get("https://fa-evra-dev2-saasfaprod1.fa.ocs.oraclecloud.com/fscmUI/faces/FuseWelcome?_afrLoop=33601499456939603&_adf.ctrl-state=10zu8vq81m_73");
        driver.findElement(By.cssSelector("svg.svg-nav.suiicon.svg-bkgd01 > path.svg-outline")).click();
        //driver.get("https://fa-evra-dev2-saasfaprod1.fa.ocs.oraclecloud.com/hcmUI/faces/FndOverview?fnd=%3B%3B%3B%3Bfalse%3B256%3B%3B%3B&fndGlobalItemNodeId=itemNode_Recruiting_Hiring");
        wait.forLoading(100);
        //driver.findElement(By.xpath("//*[@id='pt1:_FOr1:0:_FONSr2:0:_FOTr0:0:jrUpl:UPsp1:jrPce:addBtn::icon']/g[3]/path")).click();

        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:reTySel::drop")).click();

        wait.forLoading(100);
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:reTySel::pop']/li[2]")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:locSis:locIs::btn")).click();
        wait.forLoading(100);
        driver.findElement(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:locSis:locIs::item0']/th/div")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:sourSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:sourSel::pop']/li[3]")).click();

        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:posSis:posIs::btn")).click();
        driver.findElement(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:posSis:posIs::item0']/th/div")).click();

        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr0:0:bicoBtn")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr1:1:bicoBtn")).click();

        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr2:1:reSis:reIs::btn")).click();
        driver.findElement(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr2:1:reSis:reIs::item1']/th/div")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPcb12")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:rtSel::drop")).click();
        wait.forLoading(100);
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:rtSel::pop']/li[5]")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:locSis:locIs::btn")).click();
        wait.forLoading(100);
        driver.findElement(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:locSis:locIs::item0']/th/div")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:orgSis:orgIs::btn")).click();
        wait.forLoading(100);
        driver.findElement(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:orgSis:orgIs::item0']/th/div")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:i2:0:olSis:olIs::btn")).click();
        wait.forLoading(100);
        driver.findElement(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:i2:0:olSis:olIs::item0']/th/div")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr3:1:bicoBtn")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:wtSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:wtSel::pop']/li[4]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:ptSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:ptSel::pop']/li[3]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:rtSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:rtSel::pop']/li[3]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:slSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:slSel::pop']/li[4]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:editDff_RequisitionDffIteratorcontactPersonEmail__FLEX_EMPTY::content")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:editDff_RequisitionDffIteratorcontactPersonEmail__FLEX_EMPTY::content")).clear();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr4:1:editDff_RequisitionDffIteratorcontactPersonEmail__FLEX_EMPTY::content")).sendKeys("testautomation@gmail.com");
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPcb14")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr5:1:wrRgn:0:wpLV1:0:ntrSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr5:1:wrRgn:0:wpLV1:0:ntrSel::pop']/li[3]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr5:1:wrRgn:0:wpLV1:0:refSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr5:1:wrRgn:0:wpLV1:0:refSel::pop']/li[3]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPcb15")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr6:1:ipdSis:ipdIs::btn")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPcb16")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr7:1:i1:0:olSis:olIs::btn")).click();
        wait.forLoading(100);
        driver.findElement(By.xpath("//tr[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr7:1:i1:0:olSis:olIs::item0']/th/div")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPcb17")).click();
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPcb18")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr9:1:cspSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr9:1:cspSel::pop']/li[3]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr9:1:eafSel::drop")).click();
        driver.findElement(By.xpath("//ul[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPmtfr9:1:eafSel::pop']/li[3]")).click();
        wait.forLoading(100);
        driver.findElement(By.id("_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:gpRgn:0:GPcb19")).click();
        wait.forLoading(100);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
        wait.forLoading(100);
        driver.findElement(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:jrcUpl:UPsp1:SPsb2']/a/span/span")).click();

    }

    void benefitModule(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.id("pt1:_FOr1:1:_FONSr2:0:_FOTsr1:0:lp1Upl:UPsp1:lp2Rgn:0:SEnrBtn")).click();

        driver.findElement(By.cssSelector("#itemNode_my_information_benefits .svg-outline:nth-child(8)")).click();
    }

    void startEnrolment(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr1:0:lp1Upl:UPsp1:lp2Rgn:0:SEnrBtn']")).click();

    }
}

