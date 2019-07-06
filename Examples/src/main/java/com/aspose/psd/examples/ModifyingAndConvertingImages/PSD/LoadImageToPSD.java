/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;

/**
 *
 *  
 */
public class LoadImageToPSD {
     public static void main(String[] args) 
    {
       //ExStart:LoadImageToPSD
       String dataDir = Utils.getDataDir(LoadImageToPSD.class) + "PSD/";
       
        String filePath = dataDir + "PsdExample.psd";
        String outputFilePath = dataDir + "PsdResult.psd";
        
        PsdImage image = new PsdImage(200, 200);
        Image im = Image.load(filePath);
        
         Layer layer = null;
         
         try
        {
            layer = new Layer((RasterImage)im);
            image.addLayer(layer);
        }
        catch (Exception e)
        {
            if (layer != null)
            {
                layer.dispose();
            }
           System.out.println(e);
        }
       //ExEnd:LoadImageToPSD
    }
}
