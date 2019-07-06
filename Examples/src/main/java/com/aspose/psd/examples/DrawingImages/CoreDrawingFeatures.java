/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.BmpOptions;

/**
 *
 * @author mfazi
 */
public class CoreDrawingFeatures {
    public static void main(String[] args) 
    {
       //ExStart:CoreDrawingFeatures
       String dataDir = Utils.getDataDir(CoreDrawingFeatures.class) + "DrawingImages/";
       
        // Create an instance of BmpOptions and set its various properties
        String loadpath = dataDir + "sample.psd";
        String outpath = dataDir + "CoreDrawingFeatures.bmp";
            // Create an instance of Image    
            
            PsdImage image = new PsdImage(loadpath);
            
            // load pixels
                int[] pixels = image.loadArgb32Pixels(new Rectangle(0, 0, 100, 10));

                for (int i = 0; i < pixels.length; i++)
                {
                    // specify pixel color value (gradient in this case).
                    pixels[i] = i;
                }

                // save modified pixels.
                image.saveArgb32Pixels(new Rectangle(0, 0, 100, 10), pixels);

                // export image to bmp file format.
                image.save(outpath, new BmpOptions());
    //ExEnd:CoreDrawingFeatures
    
    }
}
