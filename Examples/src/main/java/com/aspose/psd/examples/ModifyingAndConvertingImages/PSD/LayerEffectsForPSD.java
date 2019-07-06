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
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 * @author mfazi
 */
public class LayerEffectsForPSD {
    
     public static void main(String[] args) 
    {
       //ExStart:LayerEffectsForPSD
       String dataDir = Utils.getDataDir(LayerEffectsForPSD.class) + "PSD/";
       
       String sourceFileName = dataDir+ "LayerWithText.psd";
       String exportPath = dataDir+ "LayerEffectsForPSD.png";
       
       PsdLoadOptions loadOptions = new PsdLoadOptions();
       loadOptions.setLoadEffectsResource(true);
       loadOptions.setUseDiskForLoadEffectsResource(true);
       
       PsdImage image =(PsdImage)Image.load(sourceFileName,loadOptions);
       
       PngOptions options = new PngOptions();
       options.setColorType(PngColorType.TruecolorWithAlpha);
       
       image.save(exportPath,options);
       //ExEnd:LayerEffectsForPSD
    }
}
