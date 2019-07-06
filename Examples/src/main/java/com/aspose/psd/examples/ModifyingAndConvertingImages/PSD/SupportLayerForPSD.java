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


public class SupportLayerForPSD {
    
    public static void main(String[] args) 
    {
       //ExStart:SupportLayerForPSD
       String dataDir = Utils.getDataDir(SupportLayerForPSD.class) + "PSD/";
       
       String sourceFileName = dataDir+"layers.psd";
       String output = dataDir+"layers.png";
       
       
       PsdLoadOptions imageLoadOptions = new PsdLoadOptions();
       imageLoadOptions.setLoadEffectsResource(true);
       imageLoadOptions.setUseDiskForLoadEffectsResource(true);
       
       PsdImage image =(PsdImage)Image.load(sourceFileName,imageLoadOptions);
       
       PngOptions saveOptions = new PngOptions();
       saveOptions.setColorType(PngColorType.TruecolorWithAlpha);
       
       image.save(output,saveOptions);
       
       //ExEnd:SupportLayerForPSD
    }
}
