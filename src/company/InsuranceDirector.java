package company;

import factory.AbstractFactory;

import java.util.Random;

public class InsuranceDirector {
    private Random ran = new Random();

    //for generating insurance application
    public InsuranceApplication generateInsuranceApplication(){
        String[] categories = {"car", "health", "house"};
        AbstractFactory factory = AbstractFactory.factory(categories[ran.nextInt(3)]);
        return factory.makeInsuranceApplication();

    }

    //for generating insurance agreement
    public InsuranceAgreement generateInsuranceAgreement(InsuranceApplication insuranceApplication){


        return AbstractFactory.factory(insuranceApplication.getType()).makeInsuranceAgreement(insuranceApplication.getYearlyFee());

    }
}
