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
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.LevelsLayer;
import com.aspose.psd.fileformats.psd.layers.layerresources.LevelChannel;
import com.aspose.psd.imageoptions.PngOptions;


public class RenderingOfLevelAdjustmentLayer {
    
    public static void main(String[] args) 
    {
       //ExStart:RenderingOfLevelAdjustmentLayer
       String dataDir = Utils.getDataDir(RenderingOfLevelAdjustmentLayer.class) + "PSD/";
       
        String sourceFileName = dataDir +"LevelsAdjustmentLayer.psd";
        String psdPathAfterChange = dataDir + "LevelsAdjustmentLayerChanged.psd";
        String pngExportPath = dataDir + "LevelsAdjustmentLayerChanged.png";
        
        
          PsdImage im = (PsdImage)Image.load(sourceFileName);
            
                for(int i=0; i < im.getLayers().length; i++ )
                    {
                 if (im.getLayers()[i] instanceof LevelsLayer)
                    {
                        LevelsLayer levelsLayer = (LevelsLayer)im.getLayers()[i];
                        LevelChannel channel = levelsLayer.getChannel(0);
                        channel.setInputMidtoneLevel(2.0f);
                        channel.setInputShadowLevel((short)10);
                        channel.setInputHighlightLevel((short)230);
                        channel.setOutputShadowLevel((short)20);
                        channel.setOutputHighlightLevel((short)200);
                    }
                }

                // Save PSD
                im.save(psdPathAfterChange);

                // Save PNG
                PngOptions saveOptions = new PngOptions();
                saveOptions.setColorType(PngColorType.TruecolorWithAlpha);
                im.save(pngExportPath, saveOptions);
            
       //ExEnd:RenderingOfLevelAdjustmentLayer
    }
}
