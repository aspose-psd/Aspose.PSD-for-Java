/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.BlendMode;
import com.aspose.psd.fileformats.psd.layers.fillsettings.ColorFillSettings;
import com.aspose.psd.fileformats.psd.layers.fillsettings.FillType;
import com.aspose.psd.fileformats.psd.layers.layereffects.StrokeEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 *
 * @author mfazi
 */
public class AddStrokeLayerColor {
    
    public static void main(String[] args) 
    {
       //ExStart:AddStrokeLayerColor
       String dataDir = Utils.getDataDir(AddStrokeLayerColor.class) + "DrawingImages/";
       
       // Stroke effect. FillType - Color. Example
        String sourceFileName = dataDir+ "Stroke.psd";
        String exportPath = dataDir+"StrokeGradientChanged.psd";
    
        PsdLoadOptions loadOptions = new PsdLoadOptions();
        loadOptions.setLoadEffectsResource( true);
        
        PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
        
        StrokeEffect colorStroke = (StrokeEffect)im.getLayers()[1].getBlendingOptions().getEffects()[0];

        Assert.areEqual(BlendMode.Normal, colorStroke.getBlendMode());
        Assert.areEqual(255, colorStroke.getOpacity());
        Assert.areEqual(true, colorStroke.isVisible());

        ColorFillSettings fillSettings = (ColorFillSettings)colorStroke.getFillSettings();
        Assert.areEqual(Color.getBlack(), fillSettings.getColor());
        Assert.areEqual(FillType.Color, fillSettings.getFillType());

        fillSettings.setColor(Color.getYellow());

        colorStroke.setOpacity((byte)127);
        colorStroke.setBlendMode(BlendMode.Color);
        im.save(exportPath);
        
        //ExEnd:AddStrokeLayerColor
    }
}
