/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf2demo;

import java.math.BigInteger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
/**
 *
 * @author Joshu
 */
@Named(value = "factorialBean")
@ApplicationScoped
public class FactorialBean {

    int number = 10;
    //int j = 0;
    //private String factorial;
    /**
     * Creates a new instance of TimeBean
     */
    public FactorialBean() {
    }

    public String getTime() {
        return new java.util.Date().toString();
    }

    public BigInteger fact(int number) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial ;
    }
    public String getFactorial(){
        String table = "<table  padding=\"2\" border=\"1\">";
        table += "<tr><th>Number</th><th>Factorial</th></tr>";
        for (int j = 0; j <= number; j++) {
           table += "<tr><td>" + j + "</td><td>" + fact(j) + "</td></tr>";
        }
        table += "</table></body></html>";

        return table;
    }
}
