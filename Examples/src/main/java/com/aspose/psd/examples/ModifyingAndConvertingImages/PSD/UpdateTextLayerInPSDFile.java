/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.Point;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.TextLayer;


public class UpdateTextLayerInPSDFile {
    public static void main(String[] args) 
    {
       //ExStart:UpdateTextLayerInPSDFile
       String dataDir = Utils.getDataDir(UpdateTextLayerInPSDFile.class) + "PSD/";
       
       // Load a PSD file as an image and cast it into PsdImage
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
       
       for(int i=0; i < psdImage.getLayers().length; i++ )
                {
                    if (psdImage.getLayers()[i] instanceof TextLayer)
                    {
                        TextLayer textLayer = (TextLayer)psdImage.getLayers()[i]  ;
                        textLayer.updateText("test update", new Point(0, 0), 15.0f, Color.getPurple());
                    }
                }

                psdImage.save(dataDir + "UpdateTextLayerInPSDFile_out.psd");
       //ExEnd:UpdateTextLayerInPSDFile
    }
}
