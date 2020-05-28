/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Image;
import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.PsdOptions;

/**
 *
 *  
 */
public class AddNewRegularLayerToPSD {
    public static void main(String[] args) 
    {
       //ExStart:AddNewRegularLayerToPSD
       String dataDir = Utils.getDataDir(AddNewRegularLayerToPSD.class) + "DrawingImages/";
       
      // Make ability to add the newly generated regular layer to PsdImage
        String sourceFileName = dataDir + "OneLayer.psd";
        String exportPath = dataDir + "OneLayerEdited.psd";
        String exportPathPng = dataDir + "OneLayerEdited.png";
 
        PsdImage im = (PsdImage)Image.load(sourceFileName);
       
        // Preparing two int arrays
                int[] data1 = new int[2500];
                int[] data2 = new int[2500];

                Rectangle rect1 = new Rectangle(0, 0, 50, 50);
                Rectangle rect2 = new Rectangle(0, 0, 100, 25);
                
                
                for (int i = 0; i < 2500; i++)
                {
                    data1[i] = -10000000;
                    data2[i] = -10000000;
                }
                
                
                 Layer layer1 = im.addRegularLayer();
                layer1.setLeft( 25);
                layer1.setTop(25);
                layer1.setRight(75);
                layer1.setBottom(75);
                layer1.saveArgb32Pixels(rect1, data1);

                Layer layer2 = im.addRegularLayer();
                layer2.setLeft( 25);
                layer2.setTop(150);
                layer2.setRight(1255);
                layer2.setBottom(175);
                layer2.saveArgb32Pixels(rect2, data2);
                
                 // Save psd
                im.save(exportPath, new PsdOptions());

                // Save png
                im.save(exportPathPng, new PngOptions());
       //ExEnd:AddNewRegularLayerToPSD
       
    }
}
