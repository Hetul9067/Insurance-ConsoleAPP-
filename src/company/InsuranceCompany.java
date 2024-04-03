package company;

import handler.CustomException;

import java.util.*;

public class InsuranceCompany {

    private Random ran = new Random();
    private double budget  = HardCodedValue.BUDGET;
    private List<InsuranceApplication> insuranceApplicationsList = new ArrayList<>(6);
    private List<InsuranceAgreement> canceledInsuranceAgreementList = new ArrayList<>();

    private List<InsuranceAgreement> endInsuranceAgreementList = new ArrayList<>();
    private List<InsuranceAgreement> insuranceAgreementsList = new ArrayList<>(20);

    //for storing total payout claims
    private double totalPayoutClaims;

    private Map<Integer, Double> yearAndNetProfit = new HashMap<>();

    //for storing total payout of canceled agreements
    private double totalPayoutCanceledAggr;

    //for storing total income of the company
    private double totalIncome;

    private InsuranceDirector iDirector;

    //constructor
    public InsuranceCompany(){
        iDirector = new InsuranceDirector();
        generateApplicationFirst();
    }


    public void generateAgreement(){

    }

    //for creating 6 new insurance application during first time
    public void generateApplicationFirst(){
        for(int i=0; i<6; i++){

            insuranceApplicationsList.add(iDirector.generateInsuranceApplication());


        }


    }

    public int userInputChecker(int range){
        boolean checker = true;
        int ans = 0;
        do{
            try{
                checker = false;
                System.out.println("Please enter a value!");
                ans = Integer.parseInt(HardCodedValue.SCANNER.nextLine());
                if(ans < 1 || ans > range) throw new CustomException("error1");
            }catch(CustomException ce){
                checker = true;
                ce.processError(range);
            }catch(Exception e){
                checker = true;
                System.out.println(HardCodedValue.ERROR2);
            }
        }while(checker);
        return ans;
    }

    //for displaying all the insurance application
    public void displayInsuranceApplicationList(){
        System.out.println("Select the insurance application: ");
        System.out.println("   Application type ||  YearlyFees");
        for(int i=0; i<6; i++){


            System.out.println((i+1)+". "+insuranceApplicationsList.get(i).getType()+"  ||  " + HardCodedValue.DF.format(insuranceApplicationsList.get(i).getYearlyFee()));
        }
        System.out.println("7. for returning to the main menu!");
        int ans =  userInputChecker(7)-1;
        if(ans==6) return;

        //for building insurance aggrement and then adding to the insurance agreement list

        insuranceAgreementsList.add(iDirector.generateInsuranceAgreement(insuranceApplicationsList.get(ans)));
        double yearlyFeeI = insuranceAgreementsList.get(insuranceAgreementsList.size()-1).getYearlyFee();
        double claimedAmountI = insuranceAgreementsList.get(insuranceAgreementsList.size()-1).getTotalClaimedAmount();

        this.totalIncome += yearlyFeeI;
        this.totalPayoutClaims += claimedAmountI;
        this.totalIncome = this.totalIncome - claimedAmountI;
        this.budget += yearlyFeeI;
        this.budget -= claimedAmountI;
        double netProfitPerYear = 0;
        if(this.getYearAndNetProfit().containsKey(HardCodedValue.currentYear)){
            netProfitPerYear = this.getYearAndNetProfit().get(HardCodedValue.currentYear);
        }
        this.getYearAndNetProfit().put(HardCodedValue.currentYear, netProfitPerYear + yearlyFeeI - claimedAmountI  );
        //removing this insurance application from the list
        insuranceApplicationsList.remove(ans);
        //generating new application and adding it to the application list
        generateApplication();


    }


    public void displayInsuranceAgreementList(){
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("Details of the insurance agreements : ");
        System.out.println("insurance_name || insurance type ||yearly_fee || risk || insurance_Amount || isActive||   net profit");
        for(int i=0; i<insuranceAgreementsList.size();i++){
            InsuranceAgreement iagree = insuranceAgreementsList.get(i);
            System.out.println((i+1)+". "+iagree.getName()+" ||  "+iagree.getType() + " ||  "+ HardCodedValue.DF.format(iagree.getYearlyFee())+" || "+iagree.getRisk()+" || "+HardCodedValue.DF.format(iagree.getInsuranceAmount())+" || "+iagree.isActive()+" || "+HardCodedValue.DF.format(insuranceAgreementsList.get(i).netProfitCalc()));
        }



    }

    //for showing insurance agreements list for breaking the agreement
    public void displayInsuranceAgreements(){
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("Details of the insurance agreements : ");
        System.out.println("insurance                 ||         yearly fee");
        System.out.println("insurance_name || insurance type ||yearly_fee || risk || insurance_Amount || isActive");
        for(int i=0; i<insuranceAgreementsList.size();i++){
            InsuranceAgreement iagree = insuranceAgreementsList.get(i);
            System.out.println((i+1)+". "+iagree.getName()+" ||  "+iagree.getType() + " ||  "+ HardCodedValue.DF.format(iagree.getYearlyFee())+" || "+iagree.getRisk()+" || "+HardCodedValue.DF.format(iagree.getInsuranceAmount())+" || "+iagree.isActive());

        }
        System.out.println((insuranceAgreementsList.size()+1)+". return to the main menu!");
        int ans = userInputChecker(insuranceAgreementsList.size()+1)-1;

        //for going back to the main menu
        if(ans==(insuranceAgreementsList.size())) return;

        //cancelling the agreement and set the data regarding to that
        insuranceAgreementsList.get(ans).cancelled();

        double netProfitPerYear = 0;
        if(this.getYearAndNetProfit().containsKey(HardCodedValue.currentYear)){
            netProfitPerYear = this.getYearAndNetProfit().get(HardCodedValue.currentYear);
        }
        double breakAmount = insuranceAgreementsList.get(ans).getBreakAmount();
        this.yearAndNetProfit.put(HardCodedValue.currentYear, netProfitPerYear+ breakAmount);
        this.totalPayoutCanceledAggr += breakAmount;
        this.totalIncome += breakAmount;
        this.budget += breakAmount;
        InsuranceAgreement removedInsuranceAgreement = insuranceAgreementsList.get(ans);
        insuranceAgreementsList.remove(ans);

        //for tracking the agreement storing that to another cancelling list
        canceledInsuranceAgreementList.add(removedInsuranceAgreement);

    }

    //for generating single insurance application
    public void generateApplication(){
        insuranceApplicationsList.add(iDirector.generateInsuranceApplication());
    }


    public void moveTimeForward(){

        HardCodedValue.currentYear ++;
        System.out.println("current year is : "+ HardCodedValue.currentYear);
        for(int i=0; i<insuranceAgreementsList.size();i++){
            if(insuranceAgreementsList.get(i).getEndYear() < HardCodedValue.currentYear ) {
                endInsuranceAgreementList.add(insuranceAgreementsList.get(i));

                insuranceAgreementsList.get(i).setActive(false);

                insuranceAgreementsList.remove(i);
                i--;
            }else{

                insuranceAgreementsList.get(i).setTotalAmountPaid(insuranceAgreementsList.get(i).getTotalAmountPaid()  + insuranceAgreementsList.get(i).getYearlyFee());
                this.totalIncome += insuranceAgreementsList.get(i).getYearlyFee();
                this.budget += insuranceAgreementsList.get(i).getYearlyFee();

                double netProfitPerYear = 0;
                if(this.getYearAndNetProfit().containsKey(HardCodedValue.currentYear)){
                    netProfitPerYear = this.getYearAndNetProfit().get(HardCodedValue.currentYear);
                }
                netProfitPerYear += insuranceAgreementsList.get(i).getYearlyFee();
                this.yearAndNetProfit.put(HardCodedValue.currentYear, netProfitPerYear );

                insuranceAgreementsList.get(i).setRisk(ran.nextInt(95)+5);

                if(insuranceAgreementsList.get(i).getRisk()> 75){
                    insuranceAgreementsList.get(i).claim();
                    this.totalPayoutClaims += insuranceAgreementsList.get(i).getInsuranceAmount();
                    this.totalIncome -= insuranceAgreementsList.get(i).getInsuranceAmount();
                    this.yearAndNetProfit.put(HardCodedValue.currentYear, netProfitPerYear - insuranceAgreementsList.get(i).getInsuranceAmount());
                    this.budget -= insuranceAgreementsList.get(i).getInsuranceAmount();
                }
            }

        }
    }

    //for calculating total money
    public double showTotalMoney(){
        return 0;
    }



    public List<InsuranceApplication> getInsuranceApplicationsList() {
        return insuranceApplicationsList;
    }

    public void setInsuranceApplicationsList(List<InsuranceApplication> insuranceApplicationsList) {
        this.insuranceApplicationsList = insuranceApplicationsList;
    }

    public List<InsuranceAgreement> getInsuranceAgreementsList() {
        return insuranceAgreementsList;
    }

    public void setInsuranceAgreementsList(List<InsuranceAgreement> insuranceAgreementsList) {
        this.insuranceAgreementsList = insuranceAgreementsList;
    }

    public double getTotalPayoutClaims() {
        return totalPayoutClaims;
    }

    public void setTotalPayoutClaims(double totalPayoutClaims) {
        this.totalPayoutClaims = totalPayoutClaims;
    }

    public double getTotalPayoutCanceledAggr() {
        return totalPayoutCanceledAggr;
    }

    public void setTotalPayoutCanceledAggr(double totalPayoutCanceledAggr) {
        this.totalPayoutCanceledAggr = totalPayoutCanceledAggr;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Random getRan() {
        return ran;
    }

    public void setRan(Random ran) {
        this.ran = ran;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<InsuranceAgreement> getCanceledInsuranceAgreementList() {
        return canceledInsuranceAgreementList;
    }

    public void setCanceledInsuranceAgreementList(List<InsuranceAgreement> canceledInsuranceAgreementList) {
        this.canceledInsuranceAgreementList = canceledInsuranceAgreementList;
    }

    public List<InsuranceAgreement> getEndInsuranceAgreementList() {
        return endInsuranceAgreementList;
    }

    public void setEndInsuranceAgreementList(List<InsuranceAgreement> endInsuranceAgreementList) {
        this.endInsuranceAgreementList = endInsuranceAgreementList;
    }

    public Map<Integer, Double> getYearAndNetProfit() {
        return yearAndNetProfit;
    }

    public void setYearAndNetProfit(Map<Integer, Double> yearAndNetProfit) {
        this.yearAndNetProfit = yearAndNetProfit;
    }

    public InsuranceDirector getiDirector() {
        return iDirector;
    }

    public void setiDirector(InsuranceDirector iDirector) {
        this.iDirector = iDirector;
    }
}


