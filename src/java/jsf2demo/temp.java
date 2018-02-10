/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf2demo;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.util.Scanner;

/**
 *
 * @author Joshu
 */
//@Named(value = "computeTax")
//@ApplicationScoped
public class temp {

    double taxableIncome;
    int filingStatus;

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public double getResponse() {
        double tax = taxableIncome;
        int status = filingStatus;
        double income = taxableIncome;
        if (status == 0) { // Compute tax for single filers
            if (income <= 9325) {
                tax = income * 0.10;
            } else if (income <= 37950) {
                tax = 9325 * 0.10 + (income - 9325) * 0.15;
            } else if (income <= 91900) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (income - 37950) * 0.25;
            } else if (income <= 191650) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (91900 - 37950) * 0.25 + (income - 91900) * 0.28;
            } else if (income <= 416700) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (91900 - 37950) * 0.25 + (191650 - 91900) * 0.28
                        + (income - 191650) * 0.33;
            } else if (income <= 418400) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (91900 - 37950) * 0.25 + (191650 - 91900) * 0.28
                        + (191650 - 418400) * 0.33 + (income - 418400) * 0.35;

            } else {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (91900 - 37950) * 0.25 + (191650 - 91900) * 0.28
                        + (416700 - 191650) * 0.33 + (416700 - 418400) * 0.35
                        + (income - 418400) * 0.396;
            }
        } else if (status == 1) { // Compute tax for married file jointly
            // Left as exercise in Programming Exercise 3.13

        } else if (status == 2) { // Compute tax for married separately
            // Left as exercise in Programming Exercise 3.13
        } else if (status == 3) { // Compute tax for head of household
            // Left as exercise in Programming Exercise 3.13
        } else {
            //System.out.println("Error: invalid status");
            System.exit(1);
        }

        // Display the result
        // System.out.println("Tax is " + (int) (tax * 100) / 100.0);
        return tax;
    }
}
