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
public class CroppingbyRectangle {
    public static void main(String[] args) 
    {
       //ExStart:CroppingbyRectangle
     String dataDir = Utils.getDataDir(CroppingbyRectangle.class) + "DrawingAndFormattingImages/";
     
     String sourceFile = dataDir + "sample.psd";
    String destName = dataDir + "CroppingByRectangle_out.jpg";

    // Load an existing image into an instance of RasterImage class
    RasterImage rasterImage = (RasterImage)Image.load(sourceFile);
    
     if (!rasterImage.isCached())
    {
        rasterImage.cacheData();
    }

    // Create an instance of Rectangle class with desired size, 
    //Perform the crop operation on object of Rectangle class and Save the results to disk
    Rectangle rectangle = new Rectangle(20, 20, 20, 20);

    rasterImage.crop(rectangle);
    rasterImage.save(destName, new JpegOptions());
    
     //ExEnd:CroppingbyRectangle
    }
}
