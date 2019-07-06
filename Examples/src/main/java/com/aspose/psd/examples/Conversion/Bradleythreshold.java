/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class Bradleythreshold {
    
     public static void main(String[] args) 
    {
       //ExStart:Bradleythreshold
       String dataDir = Utils.getDataDir(Bradleythreshold.class) + "Conversion/";
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "binarized_out.png";
       
       // Load an image
       PsdImage image = (PsdImage)Image.load(sourceFile);
       
       // Define threshold value, Call BinarizeBradley method and pass the threshold value as parameter and Save the output image
        double threshold = 0.15;
        image.binarizeBradley(threshold);
        image.save(destName, new PngOptions());
       //ExEnd:Bradleythreshold
       
    }
}
