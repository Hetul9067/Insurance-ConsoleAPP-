package builder.insuranceApplication;

import company.HardCodedValue;
import company.InsuranceApplication;

import java.util.Random;

public class HealthInsuranceApplicationBuilder implements IInsuranceApplicationBuilder{
    private InsuranceApplication insApplication;


    public HealthInsuranceApplicationBuilder(){
        insApplication = new InsuranceApplication();
    }
    @Override
    public void buildYearlyFeeAndType() {
        this.insApplication.setType("health");
        Random ran = new Random();
        this.insApplication.setYearlyFee(ran.nextDouble(HardCodedValue.healthYearlyFeesMax- HardCodedValue.healthYearlyFeesMin)+ HardCodedValue.healthYearlyFeesMin);

    }

    public InsuranceApplication getInsuranceApplication(){
        return this.insApplication;
    }
}
