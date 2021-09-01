package edu.cscc;

import java.util.Scanner;

/**
 * @author musab fiqi
 * @version 1.0
 * Body Mass Index with Validation
 * 2019.10.17
 */
public class Main {

    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";

    public static void main(String[] args) {
        double lbs, inches, meters, kgs, bmi;
        String classification;

        System.out.println("Calculate BMI");
        lbs = inputWeight();
        inches = inputHeight();

        meters = convertToMeters(inches);
        kgs = convertToKilograms(lbs);
        bmi = calcBMI(meters, kgs);
        classification = bmiClassification(bmi);

        System.out.println("Your BMI is: " + bmi);
        System.out.println("Your BMI classification is: " + classification);
    }

    /**
     * Convert Pounds to Kilograms
     *
     * @param lbs Pounds
     * @return kgs Kgs
     */
    private static double convertToKilograms(double lbs) {
        return lbs / 2.2046;
    }

    /**
     * Convert Inches to Meters
     *
     * @param inches Inches
     * @return meters
     */
    private static double convertToMeters(double inches) {
        return inches / 39.37;
    }

    /**
     * Calculate BMI
     *
     * @param meters Meters
     * @param kgs    Kgs
     * @return BMI
     */
    private static double calcBMI(double meters, double kgs) {
        return kgs / Math.pow(meters, 2);
    }

    /**
     * Finding BMI Classification
     *
     * @param bmi BMI
     * @return BMI Classification
     */
    private static String bmiClassification(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        }
        if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        }
        if (bmi > 30) {
            return "Obese";
        } else return null;
    }

    /**
     * Input Weight
     * @return Weight(lbs)
     */
    private static double inputWeight() {
        double lbs = 0;

        while (lbs <= 0) {

            try {
                System.out.println("Enter weight(lbs): ");
                String pounds = input.nextLine();
                lbs = Double.parseDouble(pounds);
                if (lbs <= 0) {
                    System.out.println(INPUT_ERROR);
                }
            }
            catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR);
            }
        }
        return lbs;
    }

    /**
     * Input Height
     * @return Height(inches)
     */
    private static double inputHeight() {
        double inchesDouble = 0;

        while (inchesDouble <= 0) {

            try {
                System.out.println("Enter height(inches): ");
                String inchesString = input.nextLine();
                inchesDouble = Double.parseDouble(inchesString);
                if (inchesDouble <= 0) {
                    System.out.println(INPUT_ERROR);
                }
            }
            catch (NumberFormatException e) {
                System.out.println(INPUT_ERROR);
            }
        }
        return inchesDouble;
    }
}
