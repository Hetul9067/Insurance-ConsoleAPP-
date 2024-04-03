package builder.insuranceAgreement;

import company.InsuranceAgreement;

public interface IInsuranceAgreementBuilder {
    public void buildClientNameAndType();
    public void buildYearlyFee(double yearlyFee);
    public void buildChanceOfAccident();
    public void buildInsuranceAmount();

    public InsuranceAgreement getInsuranceAgreement();
}
