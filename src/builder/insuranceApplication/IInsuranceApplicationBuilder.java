package builder.insuranceApplication;

import company.InsuranceApplication;

public interface IInsuranceApplicationBuilder {
    public void buildYearlyFeeAndType();
    public InsuranceApplication getInsuranceApplication();
}
