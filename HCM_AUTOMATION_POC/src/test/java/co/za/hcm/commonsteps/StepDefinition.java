package co.za.hcm.commonsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class StepDefinition {


    private CommonSteps CommonSteps;

    public StepDefinition() {
        this.CommonSteps = new CommonSteps();
    }

    @Given("^A user navigates to HomePage$")
    public void user_navigates_To_HomePage() {
        this.CommonSteps.goToHomePage();
    }

    @When("^user log in(.*) (.*)$")
    public void user_log_inn(final String name, final String password){

        this.CommonSteps.login(name,password);
    }

    @Then("^user sort page$")
    public void userPopulateTheFormOnceDisplayed() throws Throwable  {
        this.CommonSteps.sortAscedingOrder();
    }

    @And("user click on time absences module")
    public void userClickOnTimeAbsencesModule() {
        this.CommonSteps.click_absence_module();

    }

    @And("user click on add absence component")
    public void userClickOnAddAbsenceComponent() {
        this.CommonSteps.clickAbsence();
    }

    @And("user select type of absence")
    public void userSelectTypeOfAbsence() {
        this.CommonSteps.selectDropDown();
    }

    @And("user capture time")
    public void userCaptureTime() {
        this.CommonSteps.addDates();
    }

    @Then("saves and close")
    public void savesAndClose() {
        this.CommonSteps.saveAndClose();
    }

    @And("user click on hiring")
    public void userClickOnHiring() {
        this.CommonSteps.clickHiring();
    }

    @And("user click on add")
    public void userClickOnAdd() {
    }

    @And("user fills how section")
    public void userFillsHowSection() {
    }

    @And("user fills how basic info section")
    public void userFillsHowBasicInfoSection() {
    }

    @And("user fills hiring team section")
    public void userFillsHiringTeamSection() {
    }

    @And("user fills requisition structure section")
    public void userFillsRequisitionStructureSection() {
    }

    @And("user fills details section")
    public void userFillsDetailsSection() {
    }

    @And("user fills work requirement section")
    public void userFillsWorkRequirementSection() {
    }

    @And("user click on benefits module")
    public void userClickOnTimeBenefitsModule() {
        this.CommonSteps.benefitModule();
    }

    @And("user click on start enrolment")
    public void userClickOnStartEnrolment() {

        this.CommonSteps.startEnrolment();
    }

    @And("user add people to cover")
    public void userAddPeopleToCover() {
    }

    @And("user add Beneficiary Organizations")
    public void userAddBeneficiaryOrganizations() {
    }
}
