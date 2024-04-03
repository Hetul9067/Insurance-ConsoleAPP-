package factory;

import builder.insuranceAgreement.CarInsuranceAgreementBuilder;
import builder.insuranceAgreement.HealthInsuranceAgreementBuilder;
import builder.insuranceAgreement.IInsuranceAgreementBuilder;
import builder.insuranceApplication.CarInsuranceApplicationBuilder;
import builder.insuranceApplication.HealthInsuranceApplicationBuilder;
import builder.insuranceApplication.IInsuranceApplicationBuilder;
import company.InsuranceAgreement;
import company.InsuranceApplication;

public class HealthInsuranceFactory extends AbstractFactory{
    @Override
    public InsuranceApplication makeInsuranceApplication() {
        IInsuranceApplicationBuilder iBuilder = new HealthInsuranceApplicationBuilder();
        iBuilder.buildYearlyFeeAndType();
        return iBuilder.getInsuranceApplication();
    }

    @Override
    public InsuranceAgreement makeInsuranceAgreement(double yearlyFee) {
        IInsuranceAgreementBuilder iBuilder = new HealthInsuranceAgreementBuilder();
        iBuilder.buildClientNameAndType();
        iBuilder.buildYearlyFee(yearlyFee);
        iBuilder.buildChanceOfAccident();
        iBuilder.buildInsuranceAmount();

        return iBuilder.getInsuranceAgreement();
    }
}
