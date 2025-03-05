package it.unical.demacs.informatica.abstractfactory.factory.cucineConcrete;

import it.unical.demacs.informatica.abstractfactory.factory.CucinaFactory;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.*;
import it.unical.demacs.informatica.abstractfactory.factory.piattiCucinaGiapponese.*;

// Cucina Giapponese Factory
public class CucinaGiapponeseFactory implements CucinaFactory {

    @Override
    public PrimoPiatto1 creaPrimoPiatto1() {
        return new PrimoPiatto1Giapponese();
    }

    @Override
    public PrimoPiatto2 creaPrimoPiatto2() {
        return new PrimoPiatto2Giapponese();
    }

    @Override
    public PrimoPiatto3 creaPrimoPiatto3() {
        return new PrimoPiatto3Giapponese();
    }

    @Override
    public SecondoPiatto1 creaSecondoPiatto1() {
        return new SecondoPiatto1Giapponese();
    }

    @Override
    public SecondoPiatto2 creaSecondoPiatto2() {
        return new SecondoPiatto2Giapponese();
    }

    @Override
    public SecondoPiatto3 creaSecondoPiatto3() {
        return new SecondoPiatto3Giapponese();
    }

    @Override
    public Dessert1 creaDessert1() {
        return new Dessert1Giapponese();
    }

    @Override
    public Dessert2 creaDessert2() {return new Dessert2Giapponese();}
}
