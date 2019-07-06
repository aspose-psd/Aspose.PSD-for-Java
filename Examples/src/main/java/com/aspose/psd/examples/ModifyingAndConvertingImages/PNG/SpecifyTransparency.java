/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PNG;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngImage;
import com.aspose.psd.fileformats.psd.PsdImage;

/**
 *
 * @author mfazi
 */
public class SpecifyTransparency {
     public static void main(String[] args) 
    {
       //ExStart:SpecifyTransparency
       String dataDir = Utils.getDataDir(SpecifyTransparency.class) + "ModifyingAndConvertingImages/";
       
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
       
        // Initialize PNG image with psd image pixel data.
        PngImage pngImage = new PngImage(psdImage);
        
         // specify the PNG image transparency options and save to file.
                    pngImage.setTransparentColor(Color.getWhite());
                    pngImage.setTransparentColor(true);
                    pngImage.save(dataDir+"Specify_Transparency_result.png");
    //ExEnd:SpecifyTransparency
    }
}
