/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.fillsettings.ColorFillSettings;
import com.aspose.psd.fileformats.psd.layers.layereffects.StrokeEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.PsdOptions;


public class StrokeEffectWithColorFill {
    
    public static void main(String[] args) 
    {
       //ExStart:StrokeEffectWithColorFill
       String dataDir = Utils.getDataDir(StrokeEffectWithColorFill.class) + "PSD/";
       // Implement rendering of Stroke effect with Color Fill for export
        String sourceFileName = dataDir + "StrokeComplex.psd";
        String exportPath = dataDir + "StrokeComplexRendering.psd";
        String exportPathPng = dataDir+"StrokeComplexRendering.png";
       
        PsdLoadOptions loadOptions = new PsdLoadOptions();
        loadOptions.setLoadEffectsResource(true);
        PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
            
                for (int i = 0; i < im.getLayers().length; i++)
                {
                    StrokeEffect effect = (StrokeEffect)im.getLayers()[i].getBlendingOptions().getEffects()[0];
                    ColorFillSettings settings = (ColorFillSettings)effect.getFillSettings();
                    settings.setColor(Color.getDeepPink());
                }

                // Save psd
                im.save(exportPath, new PsdOptions());

           PngOptions option =  new PngOptions();
           option.setColorType(PngColorType.TruecolorWithAlpha);
                // Save png
                im.save(exportPathPng, option);
             
       //ExEnd:StrokeEffectWithColorFill
    }
}
