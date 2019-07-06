/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imagefilters.filteroptions.GaussianBlurFilterOptions;
import com.aspose.psd.imageoptions.GifOptions;

/**
 *
 * @author mfazi
 */
public class BlurAnImage {
    public static void main(String[] args) 
    {
       //ExStart:BlurAnImage
       String dataDir = Utils.getDataDir(BlurAnImage.class) + "DrawingAndFormattingImages/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "BlurAnImage_out.gif";

        // Load an existing image into an instance of RasterImage class
        Image image = Image.load(sourceFile);
        // Convert the image into RasterImage, 
        //Pass Bounds[rectangle] of image and GaussianBlurFilterOptions instance to Filter method and Save the results
        RasterImage rasterImage = (RasterImage)image;

        rasterImage.filter(rasterImage.getBounds(), new GaussianBlurFilterOptions(15, 15));

        rasterImage.save(destName, new GifOptions());
       //ExEnd:BlurAnImage
    }
}
