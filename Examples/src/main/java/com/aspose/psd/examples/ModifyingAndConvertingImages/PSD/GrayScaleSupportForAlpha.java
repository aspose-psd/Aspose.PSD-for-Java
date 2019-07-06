/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class GrayScaleSupportForAlpha {
    public static void main(String[] args) 
    {
       //ExStart:GrayScaleSupportForAlpha
       String dataDir = Utils.getDataDir(GrayScaleSupportForAlpha.class) + "PSD/";
       
       // Load a PSD file as an image and cast it into PsdImage
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
       // Create an instance of PngOptions class
        PngOptions pngOptions = new PngOptions();
        pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
        psdImage.save(dataDir+ "GrayScaleSupportForAlpha_out.png", pngOptions);
       //ExEnd:GrayScaleSupportForAlpha
    }
    
}
