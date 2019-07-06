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
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.PhotoFilterLayer;


public class ManagePhotoFilterAdjustmentLayer {
public static void main(String[] args) 
    {
       //ExStart:ManagePhotoFilterAdjustmentLayer
       String dataDir = Utils.getDataDir(ManagePhotoFilterAdjustmentLayer.class) + "PSD/";
       
        // Photo Filter layer editing
        String sourceFileName = dataDir + "PhotoFilterAdjustmentLayer.psd";
        String psdPathAfterChange = dataDir + "PhotoFilterAdjustmentLayerChanged.psd";
        
        PsdImage im = (PsdImage)Image.load(sourceFileName);
        
        for(int i=0; i < im.getLayers().length; i++ )
                {
                     if (im.getLayers()[i] instanceof PhotoFilterLayer)
                    {
                        PhotoFilterLayer photoLayer = (PhotoFilterLayer)im.getLayers()[i];
                        photoLayer.setColor(Color.fromArgb(255, 60, 60));
                        photoLayer.setDensity(78);
                        photoLayer.setPreserveLuminosity(false);
                    }
                }
                im.save(psdPathAfterChange);
                
                
                
         // Photo Filter layer adding
            sourceFileName = dataDir+"PhotoExample.psd";
            psdPathAfterChange = dataDir + "PhotoExampleAddedPhotoFilter.psd";

           PsdImage img = (PsdImage)Image.load(sourceFileName);            
                PhotoFilterLayer layer = img.addPhotoFilterLayer(Color.fromArgb(25, 255, 35));

                im.save(psdPathAfterChange);
                   
       //ExEnd:ManagePhotoFilterAdjustmentLayer
       
    }
}
