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


public class PossibilityToFlattenLayers {
  
    public static void main(String[] args) 
    {
       //ExStart:PossibilityToFlattenLayers
       String dataDir = Utils.getDataDir(PossibilityToFlattenLayers.class) + "PSD/";
       
       // Flatten whole PSD
    String sourceFileName = dataDir + "ThreeRegularLayersSemiTransparent.psd";
    String exportPath = dataDir + "ThreeRegularLayersSemiTransparentFlattened.psd";
       PsdImage im = (PsdImage)Image.load(sourceFileName);
        im.flattenImage();
        im.save(exportPath);
        
        // Merge one layer in another
           exportPath = dataDir + "ThreeRegularLayersSemiTransparentFlattenedLayerByLayer.psd";
   
           
           PsdImage img = (PsdImage)Image.load(sourceFileName);      
            Layer bottomLayer = img.getLayers()[0];
                Layer middleLayer = img.getLayers()[1];
                Layer topLayer = img.getLayers()[2];

                Layer layer1 = im.mergeLayers(bottomLayer, middleLayer);
                Layer layer2 = im.mergeLayers(layer1, topLayer);

                // Set up merged layers
                img.setLayers( new Layer[] { layer2 });

                img.save(exportPath);

//ExEnd:PossibilityToFlattenLayers
       
    }
}
