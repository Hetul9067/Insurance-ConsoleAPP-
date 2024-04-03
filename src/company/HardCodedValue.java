package company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HardCodedValue {

    public static double BUDGET = 10000000;
    public static DecimalFormat DF = new DecimalFormat("#.00");
    public static int currentYear = 2023;
    public static double carYearlyFeesMin = 800;
    public static double carYearlyFeesMax = 1500;

    public static double healthYearlyFeesMin = 500;
    public static double healthYearlyFeesMax = 800;

    public static double HouseYearlyFeesMin = 2000;
    public static double HouseYearlyFeesMax = 3000;
    public static Scanner SCANNER = new Scanner(System.in);


    public static String ERROR1 = "Please enter value in between 1 to " ;
    public static String ERROR2 = "##########################\n" +
            "Please enter valid input!\n" +
            "##########################";
}
