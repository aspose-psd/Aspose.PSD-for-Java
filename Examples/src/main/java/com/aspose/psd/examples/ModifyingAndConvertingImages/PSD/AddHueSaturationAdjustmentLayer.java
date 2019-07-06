/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.HueSaturationLayer;
import com.aspose.psd.fileformats.psd.layers.layerresources.ColorRangeHsl;

/**
 *
 * @author mfazi
 */
public class AddHueSaturationAdjustmentLayer {
    public static void main(String[] args) 
    {
       //ExStart:AddHueSaturationAdjustmentLayer
       String dataDir = Utils.getDataDir(AddHueSaturationAdjustmentLayer.class) + "PSD/";
       
       // Hue/Saturation layer editing
       String sourceFileName = dataDir+"HueSaturationAdjustmentLayer.psd";
       String psdPathAfterChange = dataDir+ "HueSaturationAdjustmentLayerChanged.psd";
       
       PsdImage im = (PsdImage)Image.load(sourceFileName);
       
       
       
       for (int i =0; i <im.getLayers().length; i++)
                {
                    
                    if (im.getLayers()[i] instanceof HueSaturationLayer)
                    {
                        HueSaturationLayer hueLayer = (HueSaturationLayer)im.getLayers()[i];
                        hueLayer.setHue((short)-25);
                        hueLayer.setSaturation((short)-12);
                        hueLayer.setLightness((short)67);

                        ColorRangeHsl colorRange = hueLayer.getRange(2);
                        colorRange.setHue((short)-40);
                        colorRange.setSaturation((short)50);
                        colorRange.setLightness((short)-20);
                        colorRange.setMostLeftBorder((short)300);
                    }
                }

                im.save(psdPathAfterChange);
       
       // Hue/Saturation layer adding
            sourceFileName = dataDir + "PhotoExample.psd";
            psdPathAfterChange = dataDir + "PhotoExampleAddedHueSaturation.psd";
       
       PsdImage img = (PsdImage)Image.load (sourceFileName);
       
       //this.SaveForVisualTest(im, this.OutputPath, prefix + file, "before");
                HueSaturationLayer hueLayer = img.addHueSaturationAdjustmentLayer();
                hueLayer.setHue((short)-25);
                hueLayer.setSaturation((short)-12);
                hueLayer.setLightness((short)67);

                ColorRangeHsl colorRange = hueLayer.getRange(2);
                colorRange.setHue((short)-160);
                colorRange.setSaturation((short)100);
                colorRange.setLightness((short)20);
                colorRange.setMostLeftBorder((short)300);

                im.save(psdPathAfterChange);
       
       //ExEnd:AddHueSaturationAdjustmentLayer
    }
}
