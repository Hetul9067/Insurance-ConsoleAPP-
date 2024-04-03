package factory;

import company.InsuranceAgreement;
import company.InsuranceApplication;

public abstract class AbstractFactory {
    public static AbstractFactory factoryCarInsurance = new CarInsuranceFactory();

    public static AbstractFactory factoryHealthInsurance = new HealthInsuranceFactory();

    public static AbstractFactory factoryHouseInsurance = new HouseInsuranceFactory();

    public static AbstractFactory factory(String type){
        switch (type){
            case "car" :
                return factoryCarInsurance;
            case "house" :
                return factoryHouseInsurance;
            case "health" :
                return factoryHealthInsurance;

        }
        return null;
    }

    public abstract InsuranceApplication makeInsuranceApplication();
    public abstract InsuranceAgreement makeInsuranceAgreement(double yearlyFee);


}
