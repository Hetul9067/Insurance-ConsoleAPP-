package handler;

import company.HardCodedValue;

public class CustomException extends Exception{
    private String msg = "";

    public CustomException(){
        super();
    }
    public CustomException(String message){
        super(message);
        msg = message;
    }

    public void processError(int value){
        System.out.println("#########################");
        switch (msg){
            case "error1":
                System.out.println(HardCodedValue.ERROR1+ value+ "!");
                break;
            case "error2":
                System.out.println("");
                break;
        }
        System.out.println("#########################");
    }
}
