/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.JpegOptions;

/**
 *
 *  
 */
public class ExpandAndCropImages {
    
    public static void main(String[] args) 
    {
       //ExStart:ExpandAndCropImages
     String dataDir = Utils.getDataDir(ExpandAndCropImages.class) + "DrawingAndFormattingImages/";
     
     String sourceFile = dataDir + "example1.psd";
     String destName = dataDir + "jpeg_out.jpg";
     
     RasterImage rasterImage = (RasterImage)Image.load(sourceFile);
     rasterImage.cacheData();
    // Create an instance of Rectangle class and define X,Y and Width, height of the rectangle, and Save output image
    Rectangle destRect = new Rectangle(-200, -200, 300, 300);
    rasterImage.save(destName, new JpegOptions(), destRect);
     //ExEnd:ExpandAndCropImages 
    }
}
