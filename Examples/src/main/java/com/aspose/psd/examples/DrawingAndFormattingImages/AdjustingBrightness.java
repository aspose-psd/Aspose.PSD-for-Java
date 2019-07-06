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
public class AdjustingBrightness {
    
    public static void main(String[] args) 
    {
       //ExStart:AdjustingBrightness
       String dataDir = Utils.getDataDir(AdjustingBrightness.class) + "DrawingAndFormattingImages/";
       
        String sourceFile = dataDir + "sample.psd";
        String destName = dataDir + "AdjustBrightness_out.tiff";

        // Load an existing image into an instance of RasterImage class
        Image image = Image.load(sourceFile);
         // Cast object of Image to RasterImage
        RasterImage rasterImage = (RasterImage)image;

        // Check if RasterImage is cached and Cache RasterImage for better performance
        if (!rasterImage.isCached())
        {
            rasterImage.cacheData();
        }

        // Adjust the brightness
        rasterImage.adjustBrightness(-50);

       int[] ushort =  { 8, 8, 8 };
        // Create an instance of TiffOptions for the resultant image, Set various properties for the object of TiffOptions and Save the resultant image
        TiffOptions tiffOptions = new TiffOptions(TiffExpectedFormat.Default);
        tiffOptions.setBitsPerSample(ushort);
        tiffOptions.setPhotometric(TiffPhotometrics.Rgb);

        rasterImage.save(destName, tiffOptions);
        
       //ExEnd:AdjustingBrightness
       
    }
}
