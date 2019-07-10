/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.sources.StreamSource;
import com.aspose.psd.system.io.FileStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 *  
 */
public class ExportImagesinMultiThreadEnv {
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        
       //ExStart:ExportImagesinMultiThreadEnv
       String dataDir = Utils.getDataDir(ExportImagesinMultiThreadEnv.class) + "Conversion/";
       
       String imageDataPath = dataDir + "sample.psd";
        try {
             
       
      FileInputStream fileStream = new FileInputStream(imageDataPath);
      
      PsdOptions psdOptions = new PsdOptions();
      
      
      // Set the source property of the imaging option class object.      
      psdOptions.setSource(new StreamSource(fileStream));
      
      // Following is the sample processing on the image.
      RasterImage image = (RasterImage)Image.create(psdOptions, 10, 10);
      Color[] pixels = new Color[4];
        for (int i = 0; i < 4; ++i)
        {
            pixels[i] = Color.fromArgb(40, 30, 20, 10);
        }
        image.savePixels(new Rectangle(0, 0, 2, 2), pixels);
        image.save();
        } 
       finally
            {
                // Delete the output file.
                File f = new File(imageDataPath);
                if (f.exists())
                {
                    f.delete();
                }
            }
       //ExEnd:ExportImagesinMultiThreadEnv
    }
}
