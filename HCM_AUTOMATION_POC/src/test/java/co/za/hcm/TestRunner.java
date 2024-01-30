package co.za.hcm;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/co/za/hcm/Absence.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/home-page.json",
        "html:target/home-page-html"},
        glue = {"co.za.hcm.infrastructure.driver",
                "co.za.hcm.commonsteps"})
public class TestRunner {
}
