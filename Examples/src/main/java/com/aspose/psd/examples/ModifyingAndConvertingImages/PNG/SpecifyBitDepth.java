/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PNG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 * @author mfazi
 */
public class SpecifyBitDepth {
     public static void main(String[] args) 
    {
       //ExStart:SpecifyBitDepth
       String dataDir = Utils.getDataDir(SpecifyBitDepth.class) + "ModifyingAndConvertingImages/";
       
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
       // Create an instance of PngOptions, Set the desired ColorType, BitDepth according to the specified ColorType and save image
                PngOptions options = new PngOptions();
                options.setColorType(PngColorType.Grayscale);
                options.setBitDepth((byte)1);
                psdImage.save(dataDir+"SpecifyBitDepth_out.png", options);
       //ExEnd:SpecifyBitDepth
    }
}
