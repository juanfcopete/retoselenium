package org.accenture.vivaair.steps;

import net.thucydides.core.annotations.Step;
import org.accenture.vivaair.userinterface.VivaAirSearch;

public class VivaAir {
    VivaAirSearch search;

    @Step
    public void isTheSearchPage()
    {
        search.open();
    }

    @Step
    public void Search(String origenParameter, String destinoParameter)
    {
        search.CloseAdds();
        search.SoloIda();
        search.Origen(origenParameter);
        search.Destino(destinoParameter);
    }

    @Step
    public void buscar()
    {
        search.Buscar();
    }

    @Step
    public void seleccionarFechas()
    {
        search.SeleccionarFechas();
    }

    public String vueloMasBarato()
    {
        return search.getVueloMasEconomico();
    }

    @Step
    public String seleccionarVueloMasEconomico()
    {
        search.SeleccionarVueloMasEconomico();
        return search.vueloSeleccionado();
    }

    @Step
    public void seleccionarCard()
    {
        search.SeleccionarCard();
    }

    @Step
    public void continuar(){
        search.Continuar();
    }

}
