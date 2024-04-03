package factory;

import builder.insuranceAgreement.CarInsuranceAgreementBuilder;
import builder.insuranceAgreement.IInsuranceAgreementBuilder;
import builder.insuranceApplication.CarInsuranceApplicationBuilder;
import builder.insuranceApplication.IInsuranceApplicationBuilder;
import company.InsuranceAgreement;
import company.InsuranceApplication;

public class CarInsuranceFactory extends AbstractFactory{


    @Override
    public InsuranceApplication makeInsuranceApplication() {
        IInsuranceApplicationBuilder iBuilder = new CarInsuranceApplicationBuilder();
        iBuilder.buildYearlyFeeAndType();
        return iBuilder.getInsuranceApplication();
    }

    @Override
    public InsuranceAgreement makeInsuranceAgreement(double yearlyFee) {
        IInsuranceAgreementBuilder iBuilder = new CarInsuranceAgreementBuilder();
        iBuilder.buildClientNameAndType();
        iBuilder.buildYearlyFee(yearlyFee);
        iBuilder.buildChanceOfAccident();
        iBuilder.buildInsuranceAmount();

        return iBuilder.getInsuranceAgreement();
    }
}
