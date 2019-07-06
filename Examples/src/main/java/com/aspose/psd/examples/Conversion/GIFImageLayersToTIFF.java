/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.imageoptions.TiffOptions;
import java.io.FileNotFoundException;

/**
 *
 * @author mfazi
 */
public class GIFImageLayersToTIFF {
    
     public static void main(String[] args)
    {
       //ExStart:GIFImageLayersToTIFF
       String dataDir = Utils.getDataDir(GIFImageLayersToTIFF.class) + "Conversion/";
       
        String sourceFile = dataDir + "sample.psd";
        

        // Load a PSD image and Convert the image's layers to Tiff images.
        PsdImage image = (PsdImage)Image.load(sourceFile);
        
        // Iterate through array of PSD layers
                for (int i = 0; i < image.getLayers().length; i++)
                {
                    // Get PSD layer.
                    Layer layer = image.getLayers()[i];

                    // Create an instance of TIFF Option class and Save the PSD layer as TIFF image
                    TiffOptions objTiff = new TiffOptions(TiffExpectedFormat.TiffDeflateRgb);
                    layer.save("output" + i + "_out.tiff", objTiff);
                }
       //ExEnd:GIFImageLayersToTIFF
       
    }
}
