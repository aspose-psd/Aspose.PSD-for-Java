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
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class ExportPSDLayerToRasterImage {
    
    public static void main(String[] args) 
    {
       //ExStart:ExportPSDLayerToRasterImage
       String dataDir = Utils.getDataDir(ExportPSDLayerToRasterImage.class) + "PSD/";
       
       // Load a PSD file as an image and caste it into PsdImage
          PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
            
                // Create an instance of PngOptions class
                PngOptions pngOptions = new PngOptions();
                pngOptions.setColorType(PngColorType.TruecolorWithAlpha);

                // Loop through the list of layers
                for (int i = 0; i < psdImage.getLayers().length; i++)
                {
                    // Convert and save the layer to PNG file format.
                    psdImage.getLayers()[i].save(String.format("layer_out{0}.png", i + 1), pngOptions);
                }
            
       //ExEnd:ExportPSDLayerToRasterImage
    }
}
