package company;


import handler.CustomException;

public class DisplayMenu {
    private InsuranceCompany insuranceCompany ;
    private boolean newLogin = true;

    public DisplayMenu(){
        insuranceCompany = new InsuranceCompany();

    }

    public int menu(){
        if(newLogin){
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("Welcome to the Y & H Financial Service Ltd.");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println();
            System.out.println();
            System.out.println("=================================");
            newLogin = false;
        }
        System.out.println("=============================");
        System.out.println("Financial service comapny page: "+HardCodedValue.currentYear);
        System.out.println("=============================");
        System.out.println("=============================");
        System.out.println("1. Shows total amount of money!");
        System.out.println("2. Receive new Applications!");
        System.out.println("3. see all current insurance agreements!");
        System.out.println("4. see financial breakdown!");
        System.out.println("5. Break insurance agreement");
        System.out.println("6. move time forward!");
        System.out.println("7. logout!");

        int ans = 0;
        boolean checker = true;
        do{
            try{
                checker = false;
                System.out.println("Please enter the require option(1 to 7): ");
                ans = Integer.parseInt(HardCodedValue.SCANNER.nextLine());

                if(ans <1 || ans>7) throw new CustomException("error1");
            }catch(CustomException ce){
                checker = true;
                ce.processError(7);

            }catch(Exception e){
                checker = true;
                System.out.println(HardCodedValue.ERROR2);

            }


        }while(checker);

        return ans;



    }


    public void selectOption(){
        boolean login = true;
        do{
            int ans = menu();
            switch(ans){
                case 1:
                    showTotalAmountOfMoney();
                    break;
                case 2:
                    receiveNewApplication();
                    break;
                case 3:
                    seeAllCurrentAgreements();
                    break;
                case 4:
                    seeFinancialBreakDown();
                    break;
                case 5:
                    breakInsuranceAgreement();
                    break;
                case 6 :
                    moveTimeForward();
                    break;

                case 7:
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    System.out.println("Thank you!!!");
                    System.out.println("Successfully logout from the system!");
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    login = false;
                    break;

            }
        }while(login);
    }
    public void showTotalAmountOfMoney(){
        System.out.println("total amount of money is " + HardCodedValue.DF.format(insuranceCompany.getTotalIncome()));
        System.out.println("total budget of the company is "+ HardCodedValue.DF.format(insuranceCompany.getBudget()));

    }
    public void receiveNewApplication(){
        insuranceCompany.displayInsuranceApplicationList();
    }
    public void seeAllCurrentAgreements(){
        insuranceCompany.displayInsuranceAgreementList();
    }

    //it will show all the financial data
    public void seeFinancialBreakDown(){
        System.out.println("=========================");
        System.out.println("Financial Breakdown : \n\n");
        System.out.println("Total Payout from the claims : "+ HardCodedValue.DF.format(this.insuranceCompany.getTotalPayoutClaims()));
        System.out.println("Total payout from the canceled agreements : "+ HardCodedValue.DF.format(this.insuranceCompany.getTotalPayoutCanceledAggr()));
        System.out.println("Total income made : "+ HardCodedValue.DF.format(this.insuranceCompany.getTotalIncome()));
        this.insuranceCompany.getYearAndNetProfit().forEach((key, value) -> {
            System.out.println("1. net profit in "+ key + " is : "+ HardCodedValue.DF.format(value));
        });
        System.out.println("Average net Profit is : "+ HardCodedValue.DF.format(this.insuranceCompany.getTotalIncome()/((HardCodedValue.currentYear-2023)+1)));

    }

    //for breaking the agreement
    public void breakInsuranceAgreement(){
        insuranceCompany.displayInsuranceAgreements();
    }

    //for changing the time
    public void moveTimeForward(){
        insuranceCompany.moveTimeForward();
    }

}
