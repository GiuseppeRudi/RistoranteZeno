package it.unical.demacs.informatica.abstractfactory.factory.cucineConcrete;


import it.unical.demacs.informatica.abstractfactory.factory.CucinaFactory;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.*;
import it.unical.demacs.informatica.abstractfactory.factory.piattiCucinaCinese.*;

public class CucinaCineseFactory implements CucinaFactory {


    @Override
    public PrimoPiatto1 creaPrimoPiatto1() {
        return new PrimoPiatto1Cinese();
    }

    @Override
    public PrimoPiatto2 creaPrimoPiatto2() {
        return new PrimoPiatto2Cinese();
    }

    @Override
    public PrimoPiatto3 creaPrimoPiatto3() {
        return new PrimoPiatto3Cinese();
    }

    @Override
    public SecondoPiatto1 creaSecondoPiatto1() {
        return new SecondoPiatto1Cinese();
    }

    @Override
    public SecondoPiatto2 creaSecondoPiatto2() {
        return new SecondoPiatto2Cinese();
    }

    @Override
    public SecondoPiatto3 creaSecondoPiatto3() {
        return new SecondoPiatto3Cinese();
    }

    @Override
    public Dessert1 creaDessert1() {
        return new Dessert1Cinese();
    }

    @Override
    public Dessert2 creaDessert2() {
        return new Dessert2Cinese();
    }


}