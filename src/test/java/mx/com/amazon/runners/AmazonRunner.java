package mx.com.amazon.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/mx/com/amazon/features/"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/FinalProject.json",
        "html:target/FinalProject-html"},
        glue = {"mex.com.amazon.sites",
				"mex.com.amazon.pages",
                "mex.com.amazon.steps",
                "mex.com.amazon.utils",
                "mex.com.amazon.hooks"})


public class AmazonRunner
{}
