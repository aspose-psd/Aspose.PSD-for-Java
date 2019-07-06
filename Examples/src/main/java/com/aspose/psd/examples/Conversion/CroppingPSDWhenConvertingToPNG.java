/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 * @author mfazi
 */
public class CroppingPSDWhenConvertingToPNG {
    
    public static void main(String[] args) 
    {
       //ExStart:CroppingPSDWhenConvertingToPNG
       String dataDir = Utils.getDataDir(ColorConversionUsingICCProfiles.class) + "Conversion/";
       
       String srcPath = dataDir + "sample.psd";
       String destName = dataDir + "export.png";

       // Load an existing PSD image
       RasterImage image = (RasterImage)Image.load(srcPath);
       // Create an instance of Rectangle class by passing x,y and width,height 
        // Call the crop method of Image class and pass the rectangle class instance
        image.crop(new Rectangle(0, 0, 350, 450));

        // Create an instance of PngOptions class
        PngOptions pngOptions = new PngOptions();

        // Call the save method, provide output path and PngOptions to convert the PSD file to PNG and save the output
        image.save(destName, pngOptions);

       //ExEnd:CroppingPSDWhenConvertingToPNG
    }
}
