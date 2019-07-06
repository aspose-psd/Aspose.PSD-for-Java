/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imagefilters.filteroptions.MedianFilterOptions;
import com.aspose.psd.imageoptions.GifOptions;

/**
 *
 *  
 */
public class ApplyMedianAndWienerFilters {
    public static void main(String[] args) 
    {
       //ExStart:ApplyMedianAndWienerFilters
       String dataDir = Utils.getDataDir(ApplyMedianAndWienerFilters.class) + "Conversion/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "median_test_denoise_out.gif";
       
       Image image = Image.load(sourceFile);
       // Cast the image into RasterImage
        RasterImage rasterImage = (RasterImage)image;
        if (rasterImage == null)
        {
            return;
        }
       
        // Create an instance of MedianFilterOptions class and set the size, Apply MedianFilterOptions filter to RasterImage object and Save the resultant image
        MedianFilterOptions options = new MedianFilterOptions(4);
        rasterImage.filter(image.getBounds(), options);
        image.save(destName, new GifOptions());
       //ExEnd:ApplyMedianAndWienerFilters
       
    }
}
