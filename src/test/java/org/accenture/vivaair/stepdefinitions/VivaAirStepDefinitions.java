package org.accenture.vivaair.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.accenture.vivaair.steps.VivaAir;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class VivaAirStepDefinitions {
    @Steps
    VivaAir vivaAir;

    String vueloMasBarato;
    String vueloSeleccionado;

    @Given("^quiero viajar$")
    public void quieroViajar() {
        vivaAir.isTheSearchPage();

    }

    @When("^busco vuelos desde (.*) a (.*)$")
    public void buscoVuelosDesdeMedellinABogota(String arg1 , String arg2) {
        vivaAir.Search(arg1,arg2);
        vivaAir.seleccionarFechas();
        vivaAir.buscar();
        vueloMasBarato=vivaAir.vueloMasBarato();
        vueloSeleccionado=vivaAir.seleccionarVueloMasEconomico();
        vivaAir.seleccionarCard();
        vivaAir.continuar();

    }

    @Then("^deberia obtener el vuelo mas barato$")
    public void deberiaObtenerElVueloMasBarato() {
        System.out.println(vueloSeleccionado);
        System.out.println(vueloMasBarato);
        Assert.assertEquals(vueloSeleccionado,vueloMasBarato);
    }
}
