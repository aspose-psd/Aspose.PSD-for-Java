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
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.IopaResource;

/**
 *
 *  
 */
public class AddIopaResource {
    public static void main(String[] args) 
    {
       //ExStart:AddIopaResource
       String dataDir = Utils.getDataDir(AddIopaResource.class) + "PSD/";
       
       String sourceFileName = dataDir+ "FillOpacitySample.psd";
       String exportPath = dataDir+ "FillOpacitySampleChanged.psd";
       
       PsdImage im = (PsdImage)(Image.load(sourceFileName));
       
       Layer layer = im.getLayers()[2];
       
        LayerResource[] resources = layer.getResources();
        
         
         for (int i =0; i <resources.length; i++)
                {
                    if (resources[i] instanceof IopaResource)
                    {
                        IopaResource iopaResource = (IopaResource)resources[i];
                        iopaResource.setFillOpacity((byte)200);
                    }
                }

                im.save(exportPath);
       //ExEnd:AddIopaResource
    }
}
