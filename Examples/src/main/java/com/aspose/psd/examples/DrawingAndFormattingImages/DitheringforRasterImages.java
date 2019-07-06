/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.DitheringMethod;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.BmpOptions;


public class DitheringforRasterImages {
    public static void main(String[] args) 
    {
       //ExStart:DitheringforRasterImages
     String dataDir = Utils.getDataDir(DitheringforRasterImages.class) + "DrawingAndFormattingImages/";
     String sourceFile = dataDir + "sample.psd";
     String destName = dataDir + "SampleImage_out.bmp";

            // Load an existing image into an instance of RasterImage class
            PsdImage image = (PsdImage)Image.load(sourceFile);
            
                // Peform Floyd Steinberg dithering on the current image and Save the resultant image
                image.dither(DitheringMethod.ThresholdDithering, 4);
                image.save(destName, new BmpOptions());
            
     
     //ExEnd:DitheringforRasterImages
    }
    
}
