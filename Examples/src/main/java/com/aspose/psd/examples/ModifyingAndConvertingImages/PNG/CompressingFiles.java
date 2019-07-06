/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PNG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class CompressingFiles {
     public static void main(String[] args) 
    {
       //ExStart:CompressingFiles
       String dataDir = Utils.getDataDir(ApplyFilterMethod.class) + "ModifyingAndConvertingImages/";
       
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
       // Loop over possible CompressionLevel range
                for (int i = 0; i <= 9; i++)
                {
                    // Create an instance of PngOptions for each resultant PNG, Set CompressionLevel and  Save result on disk
                    PngOptions options = new PngOptions();
                    options.setCompressionLevel(i);
                    psdImage.save(dataDir+i + "_out.png", options);
                }
       //ExEnd:CompressingFiles
    }
    
}
