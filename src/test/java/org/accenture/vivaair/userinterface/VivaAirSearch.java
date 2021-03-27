package org.accenture.vivaair.userinterface;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.accenture.reto.vivaair.interactions.JavaScriptClick;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.vivaair.com/co/es")
public class VivaAirSearch extends PageObject {

    private LocalDate current = LocalDate.now();
    private String fecha = current.plusDays(1).toString();
    private final String fechaxPATH="//button[@date=\""+fecha+"\"]";
    public LocalDate getCurrent() {
        return current;
    }

    @FindBy(xpath="//*[@id=\"onesignal-slidedown-cancel-button\"]") private WebElementFacade closeAdds;
    @FindBy(xpath = "//*[@id=\"criteria\"]/div/div[1]/label/span[1]") private WebElementFacade soloIda;
    @FindBy(xpath = "//*[@id=\"criteria-airport-select-departure-input\"]") private WebElementFacade origen;
    @FindBy(xpath = "//*[@id=\"criteria-airport-select-departure-station-MDE\"]") private WebElementFacade origenAirport;
    @FindBy(xpath = "//*[@id=\"criteria-airport-select-destination-input\"]") private WebElementFacade destino;
    @FindBy(xpath = "//*[@id=\"criteria-airport-select-destination-station-BOG\"]") private WebElementFacade destinoAirport;
    @FindBy(xpath = "//*[@id=\"criteria-dates-from\"]") private WebElementFacade clickFechaIda;
    @FindBy(xpath = "//*[@id=\"criteria-search-button-desktop\"]") private WebElementFacade buscar;
    @FindBy(xpath = "//*[@id=\"days-0\"]/button[4]/div[3]") private WebElementFacade vueloMasEconomico;
    @FindBy(xpath = "//div[@class=\"fare-footer bold viva fare-disabled\"]") private WebElementFacade seleccionarCard;
    @FindBy(xpath = "//span[text()=\"Continuar\"]") private WebElementFacade continuar;

    public void CloseAdds()
    {
        JavaScriptClick.jsOnClick(closeAdds);
        closeAdds.waitUntilClickable().click();
    }

    public void SoloIda()
    {
        soloIda.click();
    }

    public void Origen(String origenParameter)
    {
        origen.sendKeys(Keys.CLEAR);
        origen.waitUntilClickable().type(origenParameter);
        origenAirport.waitUntilClickable().click();

    }

    public void Destino(String destinoParameter)
    {
        destino.waitUntilClickable().type(destinoParameter);
        destinoAirport.waitUntilClickable().click();
    }

    public void SeleccionarFechas()
    {
        clickFechaIda.waitUntilClickable();
        clickFechaIda.click();
        findBy("//button[@date=\""+fecha+"\"]").waitUntilClickable().click();
    }

    public void SeleccionarVueloMasEconomico()
    {
        findBy(" //div[@class=\"from-price\"][ text() = \""+getVueloMasEconomico()+"\"]").waitUntilClickable().click();
    }

    public String vueloSeleccionado()
    {
        return findBy(" //div[@class=\"from-price\"][ text() = \""+getVueloMasEconomico()+"\"]").getText();
    }

    public void SeleccionarCard()
    {
        seleccionarCard.waitUntilClickable().click();
    }

    public void Continuar()
    {
        continuar.waitUntilClickable().click();
    }

    public String getVueloMasEconomico() {
        return vueloMasEconomico.getText();
    }

    public void Buscar()
    {
        buscar.waitUntilClickable();
        buscar.click();
    }
}
