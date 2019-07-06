/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.RasterCachedImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.JpegOptions;

/**
 *
 * @author mfazi
 */
public class BinarizationWithFixedThreshold {
    
    public static void main(String[] args) 
    {
       //ExStart:BinarizationWithFixedThreshold
       String dataDir = Utils.getDataDir(BinarizationWithFixedThreshold.class) + "Conversion/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "BinarizationWithFixedThreshold_out.jpg";
       
       Image image = Image.load(sourceFile);
       RasterCachedImage rasterCachedImage = (RasterCachedImage)image;
       if (!rasterCachedImage.isCached())
        {
            // Cache image if not already cached
            rasterCachedImage.cacheData();
        }
       
       // Binarize image with predefined fixed threshold and Save the resultant image
        rasterCachedImage.binarizeFixed((byte)100);
        rasterCachedImage.save(destName, new JpegOptions());
       //ExEnd:BinarizationWithFixedThreshold
       
    }
}
