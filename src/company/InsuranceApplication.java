package company;

public class InsuranceApplication {

    private String type ;
    private double yearlyFee = 0;

    public double getYearlyFee() {
        return yearlyFee;
    }

    public void setYearlyFee(double yearlyFee) {
        this.yearlyFee = yearlyFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
