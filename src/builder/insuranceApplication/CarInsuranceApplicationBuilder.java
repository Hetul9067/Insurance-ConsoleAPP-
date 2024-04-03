package builder.insuranceApplication;

import builder.insuranceAgreement.CarInsuranceAgreementBuilder;
import company.InsuranceApplication;
import company.*;
import java.util.Random;

public class CarInsuranceApplicationBuilder implements IInsuranceApplicationBuilder{

    private InsuranceApplication insApplication;


    public CarInsuranceApplicationBuilder(){
        insApplication = new InsuranceApplication();
    }
    @Override
    public void buildYearlyFeeAndType() {
        this.insApplication.setType("car");
        Random ran = new Random();
        this.insApplication.setYearlyFee(ran.nextDouble(HardCodedValue.carYearlyFeesMax- HardCodedValue.carYearlyFeesMin)+ HardCodedValue.carYearlyFeesMin);

    }


    public InsuranceApplication getInsuranceApplication(){
        return this.insApplication;
    }
}
