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


public class SupportOfLayerMask {
    public static void main(String[] args) 
    {
       //ExStart:SupportOfLayerMask
       String dataDir = Utils.getDataDir(SupportOfLayerMask.class) + "PSD/";
       // Export of the psd with complex mask
            String sourceFileName = dataDir + "MaskComplex.psd";
            String exportPath = dataDir + "MaskComplex.png";

            PsdImage im = (PsdImage)Image.load(sourceFileName);
            
                // Export to PNG
                PngOptions saveOptions = new PngOptions();
                saveOptions.setColorType(PngColorType.TruecolorWithAlpha);
                im.save(exportPath, saveOptions);
            
       
       //ExEnd:SupportOfLayerMask
       
    }
}
