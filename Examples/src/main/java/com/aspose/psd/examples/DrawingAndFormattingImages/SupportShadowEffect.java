/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.layereffects.DropShadowEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 *
 * @author mfazi
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

        Assert.areEqual(Color.getBlack(), shadowEffect.getColor());
        Assert.areEqual(255, shadowEffect.getOpacity());
        Assert.areEqual(3, shadowEffect.getDistance());
        Assert.areEqual(7, shadowEffect.getSize());
        Assert.areEqual(true, shadowEffect.getUseGlobalLight());
        Assert.areEqual(90, shadowEffect.getAngle());
        Assert.areEqual(0, shadowEffect.getSpread());
        Assert.areEqual(0, shadowEffect.getNoise());

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
