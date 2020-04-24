/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.JpegOptions;

/**
 *
 *  
 */
public class CroppingByShifts
{
    public static void main(String[] args) 
    {
       //ExStart:CroppingByShifts
     String dataDir = Utils.getDataDir(CroppingByShifts.class) + "DrawingAndFormattingImages/";
     String sourceFile = dataDir + "sample.psd";
     String destName = dataDir + "CroppingByShifts_out.jpg";
    
     // Load an existing image into an instance of RasterImage class
     RasterImage rasterImage = (RasterImage)Image.load(sourceFile);
     
    // Before cropping, the image should be cached for better performance
      if (!rasterImage.isCached())
      {
          rasterImage.cacheData();
      }

      // Define shift values for all four sides
      int leftShift = 10;
      int rightShift = 10;
      int topShift = 10;
      int bottomShift = 10;

      // Based on the shift values, apply the cropping on image Crop method will shift the image bounds toward the center of image and Save the results to disk
      rasterImage.crop(leftShift, rightShift, topShift, bottomShift);
      rasterImage.save(destName, new JpegOptions());

    //ExEnd:CroppingByShifts
    }
}
