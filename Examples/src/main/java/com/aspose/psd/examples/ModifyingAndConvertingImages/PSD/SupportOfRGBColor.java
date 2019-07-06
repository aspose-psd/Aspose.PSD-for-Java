/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.JpegOptions;
import com.aspose.psd.imageoptions.PsdOptions;


public class SupportOfRGBColor {
    public static void main(String[] args) 
    {
       //ExStart:SupportOfRGBColor
       String dataDir = Utils.getDataDir(SupportOfRGBColor.class) + "PSD/";
       
        // Support of RGB Color mode with 16bits/channel (64 bits per color)
        String sourceFileName = dataDir + "inRgb16.psd";
        String outputFilePathJpg = dataDir+ "outRgb16.jpg";
        String outputFilePathPsd = dataDir + "outRgb16.psd";
        
        
         PsdLoadOptions options = new PsdLoadOptions();
         
         PsdImage image = (PsdImage)Image.load(sourceFileName, options);
            
                image.save(outputFilePathPsd, new PsdOptions(image));
                JpegOptions saveOptions = new JpegOptions();
                saveOptions.setQuality(100);
                image.save(outputFilePathJpg, saveOptions);
            
       //ExEnd:SupportOfRGBColor
       
    }
}
