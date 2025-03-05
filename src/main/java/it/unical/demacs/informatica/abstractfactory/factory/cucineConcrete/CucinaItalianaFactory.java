package it.unical.demacs.informatica.abstractfactory.factory.cucineConcrete;

import it.unical.demacs.informatica.abstractfactory.factory.CucinaFactory;
import it.unical.demacs.informatica.abstractfactory.factory.interfacce.*;
import it.unical.demacs.informatica.abstractfactory.factory.piattiCucinaItaliana.*;

// Cucina Italiana Factory
public class CucinaItalianaFactory implements CucinaFactory {
    @Override
    public PrimoPiatto1 creaPrimoPiatto1() {
        return new PrimoPiatto1Italiano();
    }

    @Override
    public PrimoPiatto2 creaPrimoPiatto2() {return new PrimoPiatto2Italiano();}

    @Override
    public PrimoPiatto3 creaPrimoPiatto3() {
        return new PrimoPiatto3Italiano();
    }

    @Override
    public SecondoPiatto1 creaSecondoPiatto1() {
        return new SecondoPiatto1Italiano();
    }

    @Override
    public SecondoPiatto2 creaSecondoPiatto2() {
        return new SecondoPiatto2Italiano();
    }

    @Override
    public SecondoPiatto3 creaSecondoPiatto3() {
        return new SecondoPiatto3Italiano();
    }

    @Override
    public Dessert1 creaDessert1() {
        return new Dessert1Italiano();
    }

    @Override
    public Dessert2 creaDessert2() {return new Dessert2Italiano();}
}
