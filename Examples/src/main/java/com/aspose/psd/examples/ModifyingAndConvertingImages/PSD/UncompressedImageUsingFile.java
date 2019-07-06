/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Graphics;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.CompressionMethod;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PsdOptions;


public class UncompressedImageUsingFile {
    
    public static void main(String[] args) 
    {
       //ExStart:UncompressedImageUsingFile
       String dataDir = Utils.getDataDir(UncompressedImageUsingFile.class) + "PSD/";
       
        // Load a PSD file as an image and cast it into PsdImage
     PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
            
    PsdOptions saveOptions = new PsdOptions();
    saveOptions.setCompressionMethod(CompressionMethod.Raw);
    psdImage.save(dataDir+"uncompressed_out.psd", saveOptions);
         
    // Now reopen the newly created image.
            PsdImage img = (PsdImage)Image.load(dataDir+"uncompressed_out.psd");
            
                Graphics graphics = new Graphics(img);
                // Perform graphics operations.
            
       //ExEnd:UncompressedImageUsingFile
    }
}
