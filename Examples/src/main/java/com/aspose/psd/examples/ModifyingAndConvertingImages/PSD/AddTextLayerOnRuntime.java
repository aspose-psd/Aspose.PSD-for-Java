/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.TextLayer;

/**
 *
 * @author mfazi
 */
public class AddTextLayerOnRuntime {
  
    public static void main(String[] args) 
    {
       //ExStart:AddTextLayerOnRuntime
       String dataDir = Utils.getDataDir(AddTextLayerOnRuntime.class) + "PSD/";
       
       
       String sourceFileName = dataDir+"OneLayer.psd";
       String psdPath = dataDir + "ImageWithTextLayer.psd";
       
       Image img = Image.load(sourceFileName);
       
       PsdImage im = (PsdImage)img;
                Rectangle rect = new Rectangle(
                    (int)(im.getWidth() * 0.25),
                    (int)(im.getHeight() * 0.25),
                    (int)(im.getWidth() * 0.5),
                    (int)(im.getHeight() * 0.5));

                TextLayer layer = im.addTextLayer("Added text", rect);

                im.save(psdPath);
       
       //ExEnd:AddTextLayerOnRuntime
    }
}
