package it.unical.demacs.informatica.abstractfactory.factory;

import it.unical.demacs.informatica.abstractfactory.factory.cucineConcrete.CucinaCineseFactory;
import it.unical.demacs.informatica.abstractfactory.factory.cucineConcrete.CucinaGiapponeseFactory;
import it.unical.demacs.informatica.abstractfactory.factory.cucineConcrete.CucinaItalianaFactory;

public class FactoryProducer {
    public static CucinaFactory getFactory(String tipoCucina) {
        if (tipoCucina.equalsIgnoreCase("italiana")) {
            return new CucinaItalianaFactory();
        } else if (tipoCucina.equalsIgnoreCase("cinese")) {
            return new CucinaCineseFactory();
        } else if (tipoCucina.equalsIgnoreCase("giapponese")) {
            return new CucinaGiapponeseFactory();
        }
        return null;
    }
}

