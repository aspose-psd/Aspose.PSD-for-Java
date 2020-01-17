/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.ExposureLayer;


public class ManageExposureAdjustmentLayer {
     public static void main(String[] args) 
    {
       //ExStart:ManageExposureAdjustmentLayer
       String dataDir = Utils.getDataDir(ManageExposureAdjustmentLayer.class) + "PSD/";
    
       
      // Exposure layer editing
    String sourceFileName = dataDir+"ExposureAdjustmentLayer.psd";
    String psdPathAfterChange = dataDir + "ExposureAdjustmentLayerChanged.psd"; 
       
    PsdImage im = (PsdImage)Image.load(sourceFileName);
    
    for(int i=0; i < im.getLayers().length; i++ )
    {
        if (im.getLayers()[i] instanceof ExposureLayer)
        {
            ExposureLayer expLayer = (ExposureLayer)im.getLayers()[i];
            expLayer.setExposure(2);
            expLayer.setOffset(-0.25f);
            expLayer.setGammaCorrection(0.5f);
        }
    }
    
    im.save(psdPathAfterChange);
    
     // Exposure layer adding
            sourceFileName = dataDir+"PhotoExample.psd";
            psdPathAfterChange = dataDir + "PhotoExampleAddedExposure.psd";

            PsdImage img = (PsdImage)Image.load(sourceFileName);
            
                ExposureLayer newlayer = img.addExposureAdjustmentLayer(10, -0.25f, 2f);
                
                img.save(psdPathAfterChange);
            
    //ExEnd:ManageExposureAdjustmentLayer
    }
}
