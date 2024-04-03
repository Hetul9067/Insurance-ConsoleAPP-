package company;

import java.util.HashMap;
import java.util.Map;

public class InsuranceAgreement {
    private String name;
    private double yearlyFee;
    private int risk;
    private double insuranceAmount;
    private int startYear;
    private int endYear;

    private boolean isActive = true;

    private double totalAmountPaid;

    //category of insurance agreement
    private String type;


    //claims details
    private boolean isClaimed = false;

    private double totalClaimedAmount = 0;

    private Map<Integer, Double> claimedDetails = new HashMap<>();


    //details of breaking the agreement
    private boolean isCanceled = false;

    private double breakAmount = 0;

    private double breakYear = 0;




    //constructor
    public InsuranceAgreement(){

    }


    //for claiming the amount
    public void claim(){
        this.setClaimed(true);

        System.out.println("claim amount" + insuranceAmount);
        this.getClaimedDetails().put(HardCodedValue.currentYear, insuranceAmount);
        this.totalClaimedAmount += insuranceAmount;
    }

    //for cancelling the agreement
    public void cancelled(){
        this.setCanceled(true);
        this.setBreakYear(HardCodedValue.currentYear);
        this.setBreakAmount(10*yearlyFee);

    }

    //for calculating the net Profit
    public double netProfitCalc(){
        double totalAmountPaid = yearlyFee* (HardCodedValue.currentYear -  startYear + 1);
        if(isCanceled){
            return totalAmountPaid-totalClaimedAmount-breakAmount;
        }
        return totalAmountPaid-totalClaimedAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getYearlyFee() {
        return yearlyFee;
    }

    public void setYearlyFee(double yearlyFee) {
        this.yearlyFee = yearlyFee;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isClaimed() {
        return isClaimed;
    }

    public void setClaimed(boolean claimed) {
        isClaimed = claimed;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public Map<Integer, Double> getClaimedDetails() {
        return claimedDetails;
    }

    public void setClaimedDetails(Map<Integer, Double> claimedDetails) {
        this.claimedDetails = claimedDetails;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public double getBreakAmount() {
        return breakAmount;
    }

    public void setBreakAmount(double breakAmount) {
        this.breakAmount = breakAmount;
    }

    public double getBreakYear() {
        return breakYear;
    }

    public void setBreakYear(double breakYear) {
        this.breakYear = breakYear;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getTotalClaimedAmount() {
        return totalClaimedAmount;
    }

    public void setTotalClaimedAmount(double totalClaimedAmount) {
        this.totalClaimedAmount = totalClaimedAmount;
    }
}
