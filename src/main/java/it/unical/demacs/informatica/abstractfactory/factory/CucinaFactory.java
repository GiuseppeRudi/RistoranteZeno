package it.unical.demacs.informatica.abstractfactory.factory;

import it.unical.demacs.informatica.abstractfactory.factory.interfacce.*;

public interface CucinaFactory {

    PrimoPiatto1 creaPrimoPiatto1();
    PrimoPiatto2 creaPrimoPiatto2();
    PrimoPiatto3 creaPrimoPiatto3();

    SecondoPiatto1 creaSecondoPiatto1();
    SecondoPiatto2 creaSecondoPiatto2();
    SecondoPiatto3 creaSecondoPiatto3();

    Dessert1 creaDessert1();
    Dessert2 creaDessert2();

}
