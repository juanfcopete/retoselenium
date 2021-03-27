Feature: BuscarVueloBarato
  Yo como persona
  Quiero buscar el vuelo mas barato entre Medellin bogota
  Para ahorrar dinero

  Scenario: Buscar vuelo mas barato
    Given quiero viajar
    When busco vuelos desde medellin a bogota
    Then deberia obtener el vuelo mas barato