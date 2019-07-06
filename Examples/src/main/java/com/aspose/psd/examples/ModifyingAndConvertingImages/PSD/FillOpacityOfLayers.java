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

/**
 *
 *  
 */
public class FillOpacityOfLayers {
    
    
    public static void main(String[] args) 
    {
       //ExStart:FillOpacityOfLayers
       String dataDir = Utils.getDataDir(FillOpacityOfLayers.class) + "PSD/";
       
       // Change the Fill Opacity property
            String sourceFileName = dataDir+"FillOpacitySample.psd";
            String exportPath = dataDir+"FillOpacitySampleChanged.psd";

         PsdImage im = (PsdImage)(Image.load(sourceFileName));
            
                Layer layer = im.getLayers()[2];
                layer.setFillOpacity(5);
                im.save(exportPath);
            
       
       //ExEnd:FillOpacityOfLayers
    }
}
