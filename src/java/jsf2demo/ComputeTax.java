/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf2demo;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Joshu
 */
@Named(value = "computeTax")
@ApplicationScoped
public class ComputeTax {

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
            if (income <= 18650) {
                tax = income * 0.10;
            } else if (income <= 75900) {
                tax = 18650 * 0.10 + (income - 18650) * 0.15;
            } else if (income <= 153100) {
                tax = 18650 * 0.10 + (75900 - 18650) * 0.15
                        + (income - 75900) * 0.25;
            } else if (income <= 233350) {
                tax = 18650 * 0.10 + (75900 - 18650) * 0.15
                        + (153100 - 75900) * 0.25 + (income - 153100) * 0.28;
            } else if (income <= 416700) {
                tax = 18650 * 0.10 + (75900 - 18650) * 0.15
                        + (153100 - 75900) * 0.25 + (233350 - 153100) * 0.28
                        + (income - 233350) * 0.33;
            } else if (income <= 470700) {
                tax = 18650 * 0.10 + (75900 - 18650) * 0.15
                        + (153100 - 75900) * 0.25 + (233350 - 153100) * 0.28
                        + (233350 - 470700) * 0.33 + (income - 470700) * 0.35;
            } else {
                tax = 18650 * 0.10 + (75900 - 18650) * 0.15
                        + (153100 - 75900) * 0.25 + (233350 - 153100) * 0.28
                        + (416700 - 233350) * 0.33 + (416700 - 470700) * 0.35
                        + (income - 470700) * 0.396;
            }

        } else if (status == 2) { // Compute tax for married separately
            // Left as exercise in Programming Exercise 3.13
            if (income <= 9325) {
                tax = income * 0.10;
            } else if (income <= 37950) {
                tax = 9325 * 0.10 + (income - 9325) * 0.15;
            } else if (income <= 76550) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (income - 37950) * 0.25;
            } else if (income <= 116675) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (76550 - 37950) * 0.25 + (income - 76550) * 0.28;
            } else if (income <= 208350) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (76550 - 37950) * 0.25 + (116675 - 76550) * 0.28
                        + (income - 116675) * 0.33;
            } else if (income <= 235350) {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (76550 - 37950) * 0.25 + (116675 - 76550) * 0.28
                        + (116675 - 235350) * 0.33 + (income - 235350) * 0.35;
            } else {
                tax = 9325 * 0.10 + (37950 - 9325) * 0.15
                        + (76550 - 37950) * 0.25 + (116675 - 76550) * 0.28
                        + (208350 - 116675) * 0.33 + (208350 - 235350) * 0.35
                        + (income - 235351) * 0.396;
            }
        } else if (status == 3) { // Compute tax for head of household
            // Left as exercise in Programming Exercise 3.13
            if (income <= 13350) {
                tax = income * 0.10;
            } else if (income <= 50800) {
                tax = 13350 * 0.10 + (income - 13350) * 0.15;
            } else if (income <= 131200) {
                tax = 13350 * 0.10 + (50800 - 13350) * 0.15
                        + (income - 50800) * 0.25;
            } else if (income <= 212500) {
                tax = 13350 * 0.10 + (50800 - 13350) * 0.15
                        + (131200 - 50800) * 0.25 + (income - 131200) * 0.28;
            } else if (income <= 416700) {
                tax = 13350 * 0.10 + (50800 - 13350) * 0.15
                        + (131200 - 50800) * 0.25 + (212500 - 131200) * 0.28
                        + (income - 212500) * 0.33;
            } else if (income <= 444550) {
                tax = 13350 * 0.10 + (50800 - 13350) * 0.15
                        + (131200 - 50800) * 0.25 + (212500 - 131200) * 0.28
                        + (212500 - 444550) * 0.33 + (income - 444550) * 0.35;

            } else {
                tax = 13350 * 0.10 + (50800 - 13350) * 0.15
                        + (131200 - 50800) * 0.25 + (212500 - 131200) * 0.28
                        + (416700 - 212500) * 0.33 + (416700 - 444550) * 0.35
                        + (income - 444550) * 0.396;
            }
        } else {
            //System.out.println("Error: invalid status");
            System.exit(1);
        }

        // Display the result
        // System.out.println("Tax is " + (int) (tax * 100) / 100.0);
        return ((int) (tax * 100) / 100.0);
    }
}
