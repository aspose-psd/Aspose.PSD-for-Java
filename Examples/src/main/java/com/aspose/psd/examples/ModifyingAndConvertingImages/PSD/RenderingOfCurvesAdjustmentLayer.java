/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.CurvesLayer;
import com.aspose.psd.fileformats.psd.layers.layerresources.CurvesContinuousManager;
import com.aspose.psd.fileformats.psd.layers.layerresources.CurvesDiscreteManager;
import com.aspose.psd.imageoptions.PngOptions;


public class RenderingOfCurvesAdjustmentLayer {
   
    public static void main(String[] args) 
    {
       //ExStart:RenderingOfCurvesAdjustmentLayer
       String dataDir = Utils.getDataDir(RenderingOfCurvesAdjustmentLayer.class) + "PSD/";
       
       // Curves layer editing
        String sourceFileName = dataDir + "CurvesAdjustmentLayer";
        String psdPathAfterChange = dataDir + "CurvesAdjustmentLayerChanged";
        String pngExportPath = dataDir + "CurvesAdjustmentLayerChanged";
       
        
          for (int j = 1; j < 2; j++)
            {
                PsdImage im = (PsdImage)Image.load(sourceFileName + Integer.toString(j) + ".psd");
                
                    for(int i=0; i < im.getLayers().length; i++ )
                    {
                        if (im.getLayers()[i] instanceof CurvesLayer)
                        {
                            CurvesLayer curvesLayer = (CurvesLayer)im.getLayers()[i];
                            if (curvesLayer.isDiscreteManagerUsed())
                            {
                                CurvesDiscreteManager manager = (CurvesDiscreteManager)curvesLayer.getCurvesManager();

                                for (int k = 10; k < 50; k++)
                                {
                                    manager.setValueInPosition(0, (byte)k, (byte)(15 + (k * 2)));
                                }
                            }
                            else
                            {
                                CurvesContinuousManager manager = (CurvesContinuousManager)curvesLayer.getCurvesManager();
                                manager.addCurvePoint((byte)0, (byte)50, (byte)100);
                                manager.addCurvePoint((byte)0, (byte)150, (byte)130);
                            }
                        }
                    }
               
                // Save PSD
                im.save(psdPathAfterChange + Integer.toString(j) + ".psd");

                // Save PNG
                PngOptions saveOptions = new PngOptions();
                saveOptions.setColorType(PngColorType.TruecolorWithAlpha);
                im.save(pngExportPath + Integer.toString(j) + ".png", saveOptions);
            
        }
       //ExEnd:RenderingOfCurvesAdjustmentLayer
    }
}
