/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.RotateFlipType;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.JpegOptions;

/**
 *
 * @author mfazi
 */
public class RotatinganImage {
    
    public static void main(String[] args)  
    {
       //ExStart:RotatinganImage
       String dataDir = Utils.getDataDir(RotatinganImage.class) + "DrawingAndFormattingImages/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "RotatingAnImage_out.jpg";
       
       // Load an existing image into an instance of RasterImage class
       Image image = Image.load(sourceFile);
        image.rotateFlip(RotateFlipType.Rotate270FlipNone);
        image.save(destName, new JpegOptions());
      //ExEnd:RotatinganImage
    }
    

}
