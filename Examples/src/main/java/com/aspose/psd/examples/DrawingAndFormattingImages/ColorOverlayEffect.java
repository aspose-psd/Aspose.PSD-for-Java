/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 *
 *  
 */
public class ColorOverlayEffect
{
    public static void main(String[] args) 
    {
       //ExStart:ColorOverlayEffect
       String dataDir = Utils.getDataDir(ColorOverlayEffect.class) + "DrawingAndFormattingImages/";
       // ColorOverlay effect editing
        String sourceFileName = dataDir+"ColorOverlay.psd";
        String psdPathAfterChange =dataDir+ "ColorOverlayChanged.psd";

        PsdLoadOptions loadOptions = new PsdLoadOptions();
        loadOptions.setLoadEffectsResource(true); 
        
        PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
        
       com.aspose.psd.fileformats.psd.layers.layereffects.ColorOverlayEffect colorOverlay = (com.aspose.psd.fileformats.psd.layers.layereffects.ColorOverlayEffect)(im.getLayers()[1].getBlendingOptions().getEffects()[0]);
        
        colorOverlay.setColor(Color.getGreen()) ;
        colorOverlay.setOpacity((byte)128);

        im.save(psdPathAfterChange);
        //ExEnd:ColorOverlayEffect
    }
}
