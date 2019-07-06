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


public class MergeOnePSDlayerToOther {
    public static void main(String[] args) 
    {
       //ExStart:MergeOnePSDlayerToOther
       String dataDir = Utils.getDataDir(MergeOnePSDlayerToOther.class) + "PSD/";
       
       String sourceFile1 = dataDir+"FillOpacitySample.psd";
        String sourceFile2 = dataDir + "ThreeRegularLayersSemiTransparent.psd";
        String exportPath = dataDir + "MergedLayersFromTwoDifferentPsd.psd";


           PsdImage im1 = (PsdImage)Image.load(sourceFile1);
            
                Layer layer1 = im1.getLayers()[1];

               PsdImage im2 = (PsdImage)Image.load(sourceFile2);
                
                    Layer layer2 = im2.getLayers()[0];

                    layer1.mergeLayerTo(layer2);
                    im2.save(exportPath);
                
            
       //ExEnd:MergeOnePSDlayerToOther
    }
}
