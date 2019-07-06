/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.layereffects.ColorOverlayEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class RenderingColorEffect {
    
    public static void main(String[] args) throws InterruptedException 
    {
       //ExStart:RenderingColorEffect
     String dataDir = Utils.getDataDir(RenderingColorEffect.class) + "DrawingAndFormattingImages/";
     
     
    String sourceFileName = dataDir+"ColorOverlay.psd";
    String pngExportPath = dataDir+"ColorOverlayresult.png";
    
    PsdLoadOptions loadOptions = new PsdLoadOptions();
    loadOptions.setLoadEffectsResource(true);
    
    PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
    ColorOverlayEffect colorOverlay = (ColorOverlayEffect)(im.getLayers()[1].getBlendingOptions().getEffects()[0]);
     
    PngOptions saveOptions = new PngOptions();
    saveOptions.setColorType(PngColorType.TruecolorWithAlpha) ;
    im.save(pngExportPath, saveOptions);
     //ExEnd:RenderingColorEffect
    }
}
