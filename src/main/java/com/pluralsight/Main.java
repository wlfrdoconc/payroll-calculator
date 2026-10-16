package com.pluralsight;

import java.util.Scanner;

public class Main {
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

        // 4. Display the employee's name and their gross pay
        double grossPay = hoursWorked * payRate;

        System.out.println("The employee's name is " + userName);
        System.out.printf("%s's gross pay is: $%.2f%n", userName, grossPay);

        // Bonus: How would you apply the overtime rate?

        if (hoursWorked > 40) {
            double overTimeHours = hoursWorked - 40; // Separating the amount of overtime hours worked
            double overTimeRate = payRate * 1.5;
            double overTimePay = overTimeHours * overTimeRate;
            System.out.printf("%s's overtime pay is: $%.2f%n", userName, overTimePay);
        }

        // Close the scanner
        read.close();
    }
}