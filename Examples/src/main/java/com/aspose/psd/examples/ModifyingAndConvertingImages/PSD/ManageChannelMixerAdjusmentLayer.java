/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.ChannelMixerLayer;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.RgbChannelMixerLayer;

/**
 *
 * @author mfazi
 */
public class ManageChannelMixerAdjusmentLayer {
     public static void main(String[] args) 
    {
       //ExStart:ManageChannelMixerAdjusmentLayer
       String dataDir = Utils.getDataDir(ManageChannelMixerAdjusmentLayer.class) + "PSD/";
       
       // Rgb Channel Mixer
        String sourceFileName = dataDir+"ChannelMixerAdjustmentLayerRgb.psd";
        String psdPathAfterChange = dataDir + "ChannelMixerAdjustmentLayerRgbChanged.psd";
        
        PsdImage im = (PsdImage)Image.load(sourceFileName);
        
         for(int i=0; i < im.getLayers().length; i++ )
                {
                    if (im.getLayers()[i] instanceof RgbChannelMixerLayer)
                    {
                        RgbChannelMixerLayer rgbLayer = (RgbChannelMixerLayer)im.getLayers()[i];
                        rgbLayer.getRedChannel().setBlue((short)100);
                        rgbLayer.getBlueChannel().setGreen((short)-100);
                        rgbLayer.getGreenChannel().setConstant((short)50);
                    }
                }
         im.save(psdPathAfterChange);
         
         
         // Adding the new layer(Cmyk for this example)
            sourceFileName = dataDir+"CmykWithAlpha.psd";
            psdPathAfterChange =dataDir+ "ChannelMixerAdjustmentLayerCmykChanged.psd";

           PsdImage img = (PsdImage)Image.load(sourceFileName);
            
                ChannelMixerLayer newlayer = img.addChannelMixerAdjustmentLayer();
                newlayer.getChannelByIndex(2).setConstant((short)50);
                newlayer.getChannelByIndex(0).setConstant((short)50);

                img.save(psdPathAfterChange);
            
         
       //ExEnd:ManageChannelMixerAdjusmentLayer
    }
}
