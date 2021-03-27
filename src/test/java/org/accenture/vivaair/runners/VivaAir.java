package org.accenture.vivaair.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/vivaair.feature"}
        ,glue = {"org.accenture.vivaair.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class VivaAir {

}
