/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;

import java.util.Objects;

/**
 *
 *  
 */
public class ColorReplacementInPSD {
    
    public static void main(String[] args) 
    {
       //ExStart:ColorReplacementInPSD
       String dataDir = Utils.getDataDir(ColorReplacementInPSD.class) + "PSD/";
       
    // Load a PSD file as an image and caste it into PsdImage
    PsdImage image = (PsdImage)Image.load(dataDir + "sample.psd");
            
            for (int i =0; i <image.getLayers().length; i++)
                {
                    if (Objects.equals(image.getLayers()[i].getName(), "Rectangle 1"))
                    {
                        Layer layer = image.getLayers()[i];
                        int dd = 0;
                        layer.hasBackgroundColor();
                        layer.setBackgroundColor(Color.getOrange());
                    }

                }

                image.save(dataDir + "asposeImage02.psd");
     //ExEnd:ColorReplacementInPSD
    }
    
}
