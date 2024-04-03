package builder.insuranceAgreement;

import company.HardCodedValue;
import company.InsuranceAgreement;

import java.util.Random;

public class HealthInsuranceAgreementBuilder implements IInsuranceAgreementBuilder{
    private Random ran = new Random();

    private InsuranceAgreement insAgreement;

    public HealthInsuranceAgreementBuilder(){
        insAgreement = new InsuranceAgreement();
    }

    @Override
    public void buildClientNameAndType() {
        this.insAgreement.setType("health");
        String[] names = {"Yasmeen", "Hetul", "Nouhac", "Faiqa"};
        this.insAgreement.setName(names[ran.nextInt(4)]);

    }

    @Override
    public void buildYearlyFee(double yearlyFee) {
        this.insAgreement.setYearlyFee(yearlyFee);
    }

    @Override
    public void buildChanceOfAccident() {
        this.insAgreement.setRisk(ran.nextInt(95)+5);

    }

    @Override
    public void buildInsuranceAmount() {
        double insuranceAmount = (ran.nextInt(15)+ 5)* this.insAgreement.getYearlyFee();
        this.insAgreement.setInsuranceAmount(insuranceAmount);
        this.insAgreement.setStartYear(HardCodedValue.currentYear);
        this.insAgreement.setEndYear(ran.nextInt(4)+HardCodedValue.currentYear);
        this.insAgreement.setTotalAmountPaid(this.insAgreement.getYearlyFee());
        if(this.insAgreement.getRisk() > 75){
            this.insAgreement.claim();

        }
    }

    @Override
    public InsuranceAgreement getInsuranceAgreement(){
        return this.insAgreement;
    }
}
