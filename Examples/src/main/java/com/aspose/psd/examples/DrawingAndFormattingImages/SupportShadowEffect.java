/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assertions;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.layereffects.DropShadowEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 *
 *  
 */
public class SupportShadowEffect {
    public static void main(String[] args)  
    {
       //ExStart:SupportShadowEffect
       String dataDir = Utils.getDataDir(SupportShadowEffect.class) + "DrawingAndFormattingImages/";
       
       String sourceFileName = dataDir+"Shadow.psd";
        String psdPathAfterChange = dataDir+"ShadowChanged.psd";
        
         PsdLoadOptions loadOptions = new PsdLoadOptions();
         loadOptions.setLoadEffectsResource(true);
         
         PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
         
         DropShadowEffect shadowEffect = (DropShadowEffect)(im.getLayers()[1].getBlendingOptions().getEffects()[0]);

        Assertions.assertEquals(Color.getBlack(), shadowEffect.getColor());
        Assertions.assertEquals(255, shadowEffect.getOpacity());
        Assertions.assertEquals(3, shadowEffect.getDistance());
        Assertions.assertEquals(7, shadowEffect.getSize());
        Assertions.assertEquals(true, shadowEffect.getUseGlobalLight());
        Assertions.assertEquals(90, shadowEffect.getAngle());
        Assertions.assertEquals(0, shadowEffect.getSpread());
        Assertions.assertEquals(0, shadowEffect.getNoise());

        shadowEffect.setColor( Color.getGreen());
        shadowEffect.setOpacity((byte)128);
        shadowEffect.setDistance(11);
        shadowEffect.setUseGlobalLight(false);
        shadowEffect.setSize(9);
        shadowEffect.setAngle(45);
        shadowEffect.setSpread(3);
        shadowEffect.setNoise(50);

        im.save(psdPathAfterChange);
       //ExEnd:SupportShadowEffect
    }
}
