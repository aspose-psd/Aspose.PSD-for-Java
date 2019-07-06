/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imagefilters.filteroptions.GaussWienerFilterOptions;
import com.aspose.psd.imageoptions.GifOptions;


public class ApplyGausWienerFilters {
    public static void main(String[] args) 
    {
       //ExStart:ApplyGausWienerFilters
       String dataDir = Utils.getDataDir(ApplyGausWienerFilters.class) + "Conversion/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "gauss_wiener_out.gif";
       
       
       Image image = Image.load(sourceFile);
       RasterImage rasterImage = (RasterImage)image ;
       if (rasterImage == null)
        {
            return;
        }
       // Create an instance of GaussWienerFilterOptions class and set the radius size and smooth value.
        GaussWienerFilterOptions options = new GaussWienerFilterOptions(12, 3);
        options.setGrayscale(true);
        
        // Apply MedianFilterOptions filter to RasterImage object and Save the resultant image
        rasterImage.filter(image.getBounds(), options);
        
        image.save(destName, new GifOptions());
        
        //ExEnd:ApplyGausWienerFilters
    }
}
