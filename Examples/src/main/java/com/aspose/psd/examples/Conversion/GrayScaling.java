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
import java.io.FileNotFoundException;

/**
 *
 *  
 */
public class GrayScaling {
    
     public static void main(String[] args) 
    {
       //ExStart:GrayScaling
       String dataDir = Utils.getDataDir(GrayScaling.class) + "Conversion/";
       
        String sourceFile = dataDir + "sample.psd";
        String destName = dataDir +"Grayscaling_out.jpg";
        
        Image image = Image.load(sourceFile);
        // Cast the image to RasterCachedImage and Check if image is cached
        RasterCachedImage rasterCachedImage = (RasterCachedImage)image;
        if (!rasterCachedImage.isCached())
        {
            // Cache image if not already cached
            rasterCachedImage.cacheData();
        }

        // Transform image to its grayscale representation and Save the resultant image
        rasterCachedImage.grayscale();
        rasterCachedImage.save(destName, new JpegOptions());
       //ExEnd:GrayScaling
       
    }
}
