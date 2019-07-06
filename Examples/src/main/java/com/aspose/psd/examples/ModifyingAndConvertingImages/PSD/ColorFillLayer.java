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
import com.aspose.psd.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.psd.fileformats.psd.layers.fillsettings.FillType;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IColorFillSettings;


public class ColorFillLayer {
    
    public static void main(String[] args) throws Exception 
    {
       //ExStart:ColorFillLayer
       String dataDir = Utils.getDataDir(ColorFillLayer.class) + "PSD/";
       
       String sourceFileName = dataDir + "ColorFillLayer.psd";
       String exportPath     = dataDir + "ColorFillLayer_output.psd";

      PsdImage im = (PsdImage)Image.load(sourceFileName);
      
         
         for(int i=0; i < im.getLayers().length; i++)
                {
                    if (im.getLayers()[i] instanceof FillLayer)
                    {
                        FillLayer fillLayer = (FillLayer)im.getLayers()[i];

                        if (fillLayer.getFillSettings().getFillType() != FillType.Color)
                        {
                            throw new Exception("Wrong Fill Layer");
                        }

      IColorFillSettings settings = (IColorFillSettings)fillLayer.getFillSettings();

                        settings.setColor(Color.getRed());
                        fillLayer.update();
                        im.save(exportPath);
                        break;
                    }
                } 
       //ExEnd:ColorFillLayer
    }
}
