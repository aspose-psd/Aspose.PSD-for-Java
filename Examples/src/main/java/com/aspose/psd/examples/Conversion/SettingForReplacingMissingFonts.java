/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class SettingForReplacingMissingFonts
{
    public static void main(String[] args)
    {
       //ExStart:SettingForReplacingMissingFonts
       String dataDir = Utils.getDataDir(SettingForReplacingMissingFonts.class) + "Conversion/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "result.png";
          
       PsdLoadOptions loadOptions = new PsdLoadOptions();
       loadOptions.setDefaultReplacementFont("Arial");
       
        // load PSD image and replace the non found fonts.
        Image image = Image.load(sourceFile,loadOptions);
            
        PsdImage psdImage = (PsdImage)image;
        
        PngOptions Options = new PngOptions();
        Options.setColorType(PngColorType.TruecolorWithAlpha);
        psdImage.save(destName, Options);
            
       
       //ExEnd:SettingForReplacingMissingFonts
    }
}
