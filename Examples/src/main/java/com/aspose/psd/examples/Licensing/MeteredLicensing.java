/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Licensing;

import com.aspose.psd.Metered;
import java.math.BigDecimal;


public class MeteredLicensing {
    
    public static void main(String[] args) 
        {
            //ExStart:MeteredLicensing
            
            // Create an instance of PSD Metered class
            Metered metered = new Metered();

            // Access the setMeteredKey property and pass public and private keys as parameters
            metered.setMeteredKey("*****", "*****");

            // Get metered data amount before calling API
                    
           System.out.println("Amount Consumed Before: " + Metered.getConsumptionQuantity());
           
            // Get metered data amount After calling API
           
            System.out.println("Amount Consumed After: " + Metered.getConsumptionQuantity());

            //ExEnd:MeteredLicensing
            
            //ExEnd:MeteredLicensing
            
        }
}
