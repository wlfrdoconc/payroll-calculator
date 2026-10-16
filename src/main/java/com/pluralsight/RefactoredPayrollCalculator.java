package com.pluralsight;

import java.util.Scanner;

public class RefactoredPayrollCalculator {
    // Workbook 1C - Calculator with Methods Refactor
    // Split up original payroll calculator into separate methods
    // We are doing this to make the code condensed and more efficient

    // Main method
    public static void main(String[] args) {
        // Create a payroll calculator

        Scanner read = new Scanner(System.in);

        // 1. Asks the user for their name
        System.out.print("What is your name? ");
        String userName = read.nextLine();

        // 2. Asks the user for their hours worked (a floating point number)
        System.out.print("How many hours have you worked? ");
        double hoursWorked = read.nextFloat();

        // 3. Asks the user for their pay rate (a floating point number)
        System.out.print("What is your pay rate? ");
        double payRate = read.nextFloat();

        // Close the scanner
        read.close();

        double regularPay = calculateRegularPay(hoursWorked, payRate);
        double overtimePay = calculateOverTimePay(hoursWorked, payRate);
        double grossPay = calculateGrossPay(regularPay, overtimePay);

        printInfo(userName, regularPay, overtimePay, grossPay);

    }

    // Print employee info (regular pay, overtime pay, and total pay)
    public static void printInfo(String userName, double regularPay, double overtimePay, double grossPay) {
        System.out.printf("%s's regular pay is: $%.2f%n", userName, regularPay);
        System.out.printf("%s's overtime pay is: $%.2f%n", userName, overtimePay);
        System.out.printf("%s's gross pay is: $%.2f%n", userName, grossPay);
    }


    // Calculate regular pay
    public static double calculateRegularPay(double hoursWorked, double payRate) {
        double regularHours = Math.min(hoursWorked, 40);
        double basePay = regularHours * payRate; // renamed regularPay to basePay
        return basePay;
    }

    // Calculate overtime pay
    public static double calculateOverTimePay(double hoursWorked, double payRate) {
        if (hoursWorked > 40) {
            double overTimeHours = hoursWorked - 40; // Separating the amount of overtime hours worked
            double overTimeRate = payRate * 1.5;
            double overTimePay = overTimeHours * overTimeRate;

            return overTimePay;
        }
        return 0.0;
    }

    // Calculate gross pay
    public static double calculateGrossPay(double regularPay, double overtimePay) {
        double grossPay = regularPay + overtimePay;
        return grossPay;
    }
}
