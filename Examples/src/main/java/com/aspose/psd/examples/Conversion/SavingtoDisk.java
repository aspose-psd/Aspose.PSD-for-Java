/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class SavingtoDisk {
    
    public static void main(String[] args)
    {
       //ExStart:SavingtoDisk
       String dataDir = Utils.getDataDir(SavingtoDisk.class) + "Conversion/";
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "result.png";

        // load PSD image and replace the non found fonts.
        Image image = Image.load(sourceFile);
        
        PsdImage psdImage = (PsdImage)image;
        psdImage.save(destName, new PngOptions());
        
       //ExEnd:SavingtoDisk
    }
}
