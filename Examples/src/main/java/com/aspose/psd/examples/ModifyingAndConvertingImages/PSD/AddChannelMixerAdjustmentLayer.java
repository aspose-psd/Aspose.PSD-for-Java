/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.ChannelMixerLayer;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.CmykChannelMixerLayer;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.RgbChannelMixerLayer;

/**
 *
 * @author mfazi
 */
public class AddChannelMixerAdjustmentLayer {
    public static void main(String[] args) 
    {
       //ExStart:AddChannelMixerAdjustmentLayer
       String dataDir = Utils.getDataDir(AddChannelMixerAdjustmentLayer.class) + "PSD/";
       
       String sourceFileName = dataDir+"ChannelMixerAdjustmentLayerRgb.psd";
       String psdPathAfterChange = dataDir+ "ChannelMixerAdjustmentLayerRgbChanged.psd";
       
       PsdImage im = (PsdImage)Image.load(sourceFileName);
       
       for (int i =0; i <im.getLayers().length; i++)
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
                
                 // Cmyk Channel Mixer
            sourceFileName = dataDir+"ChannelMixerAdjustmentLayerCmyk.psd";
            psdPathAfterChange = dataDir + "ChannelMixerAdjustmentLayerCmykChanged.psd";
            
           
             PsdImage img = (PsdImage)Image.load(sourceFileName);
             
             for (int i =0; i <img.getLayers().length; i++)
                {
                    if (img.getLayers()[i] instanceof CmykChannelMixerLayer)
                    {
                        CmykChannelMixerLayer cmykLayer = (CmykChannelMixerLayer)img.getLayers()[i];
                        cmykLayer.getCyanChannel().setBlack((short)20);
                        cmykLayer.getMagentaChannel().setYellow((short)50);
                        cmykLayer.getYellowChannel().setCyan((short)-25);
                        cmykLayer.getBlackChannel().setYellow((short)25);
                    }
                }
              img.save(psdPathAfterChange);
              
              // Adding the new layer(Cmyk for this example)
            sourceFileName = dataDir+"CmykWithAlpha.psd";
            psdPathAfterChange = dataDir+"ChannelMixerAdjustmentLayerCmykChanged.psd";

            PsdImage img1 = (PsdImage)Image.load(sourceFileName);
            
                ChannelMixerLayer newlayer = img1.addChannelMixerAdjustmentLayer();
                newlayer.getChannelByIndex(2).setConstant((short)50);
                newlayer.getChannelByIndex(0).setConstant((short)50);

                im.save(psdPathAfterChange);
            
       //ExEnd:AddChannelMixerAdjustmentLayer
    }
}
