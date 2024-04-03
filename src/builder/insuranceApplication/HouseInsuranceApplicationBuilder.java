package builder.insuranceApplication;

import company.HardCodedValue;
import company.InsuranceApplication;

import java.util.Random;

public class HouseInsuranceApplicationBuilder implements IInsuranceApplicationBuilder{
    private InsuranceApplication insApplication;


    public HouseInsuranceApplicationBuilder(){
        insApplication = new InsuranceApplication();

    }
    @Override
    public void buildYearlyFeeAndType() {
        this.insApplication.setType("house");

        Random ran = new Random();
        this.insApplication.setYearlyFee(ran.nextDouble()*(HardCodedValue.HouseYearlyFeesMax- HardCodedValue.HouseYearlyFeesMin)+ HardCodedValue.HouseYearlyFeesMin);

    }

    public InsuranceApplication getInsuranceApplication(){
        return this.insApplication;
    }
}
