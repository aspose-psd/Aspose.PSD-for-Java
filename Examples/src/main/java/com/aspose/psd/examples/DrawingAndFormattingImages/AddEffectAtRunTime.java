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
import com.aspose.psd.fileformats.psd.layers.BlendMode;
import com.aspose.psd.fileformats.psd.layers.layereffects.ColorOverlayEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 *
 *  
 */
public class AddEffectAtRunTime {
    
    public static void main(String[] args) 
    {
       //ExStart:AddEffectAtRunTime
       String dataDir = Utils.getDataDir(AddEffectAtRunTime.class) + "DrawingAndFormattingImages/";
       
        String sourceFileName =dataDir+"ThreeRegularLayers.psd";
        String exportPath = dataDir+"ThreeRegularLayersChanged.psd";

        PsdLoadOptions loadOptions = new PsdLoadOptions();
        loadOptions.setLoadEffectsResource(true);
        
        PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
        
                ColorOverlayEffect effect = im.getLayers()[1].getBlendingOptions().addColorOverlay();
                effect.setColor(Color.getGreen()) ;
                effect.setOpacity((byte)128);
                effect.setBlendMode(BlendMode.Normal) ;

                im.save(exportPath);
        
       
       //ExEnd:AddEffectAtRunTime
    }
    
}
