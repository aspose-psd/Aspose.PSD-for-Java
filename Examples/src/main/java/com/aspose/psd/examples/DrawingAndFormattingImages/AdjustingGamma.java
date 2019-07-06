/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.psd.imageoptions.TiffOptions;

/**
 *
 * @author mfazi
 */
public class AdjustingGamma {
    
    public static void main(String[] args) 
    {
       //ExStart:AdjustingGamma
       String dataDir = Utils.getDataDir(AdjustingGamma.class) + "DrawingAndFormattingImages/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "AdjustGamma_out.tiff";

       // Load an existing image into an instance of RasterImage class
       Image image = Image.load(sourceFile);
              
         // Cast object of Image to RasterImage
        RasterImage rasterImage = (RasterImage)image;

        // Check if RasterImage is cached and Cache RasterImage for better performance
        if (!rasterImage.isCached())
        {
            rasterImage.cacheData();
        }

        // Adjust the gamma
        rasterImage.adjustGamma(2.2f, 2.2f, 2.2f);
        // Create an instance of TiffOptions for the resultant image,  Set various properties for the object of TiffOptions and Save the resultant image to TIFF format
        TiffOptions tiffOptions = new TiffOptions(TiffExpectedFormat.Default);
         int[] ushort =  { 8, 8, 8 };
        tiffOptions.setBitsPerSample(ushort);
        tiffOptions.setPhotometric(TiffPhotometrics.Rgb);
        rasterImage.save(destName, tiffOptions);
        //ExEnd:AdjustingGamma
       
    }
}
