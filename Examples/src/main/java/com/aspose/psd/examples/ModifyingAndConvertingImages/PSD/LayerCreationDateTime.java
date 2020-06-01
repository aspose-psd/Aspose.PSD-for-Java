/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *  
 */
public class LayerCreationDateTime {
    public static void main(String[] args) 
    {
       //ExStart:LayerCreationDateTime
       String dataDir = Utils.getDataDir(LayerCreationDateTime.class) + "PSD/";
       
       String sourceName = dataDir + "OneLayer.psd";
        // Load a PSD file as an image and cast it into PsdImage
        
        PsdImage im = (PsdImage) Image.load(sourceName);
        
              Layer layer = im.getLayers()[0];
                Date creationDateTime = layer.getLayerCreationDateTime();
                
                 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	         Date expectedDateTime = new Date("2018/7/17 8:57:24");
                
               Assert.areEqual(expectedDateTime, creationDateTime);

                Date now = new Date();
                Layer createdLayer = im.addLevelsAdjustmentLayer();

               
                //ExEnd:LayerCreationDateTime
    }
}
