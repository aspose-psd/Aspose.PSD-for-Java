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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;



public class UncompressedImageStreamObject {
     public static void main(String[] args) 
    {
       //ExStart:UncompressedImageStreamObject
       String dataDir = Utils.getDataDir(UncompressedImageStreamObject.class) + "PSD/";
       
      ByteArrayOutputStream ms = new ByteArrayOutputStream();
        
// Load a PSD file as an image and cast it into PsdImage
    PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
    

     PsdOptions saveOptions = new PsdOptions();
    saveOptions.setCompressionMethod(CompressionMethod.Raw);
    psdImage.save(ms, saveOptions);
    
     // Now reopen the newly created image. But first seek to the beginning of stream since after saving seek is at the end now.
              
               ms.reset();
                
               
 PsdImage img = (PsdImage)Image.load(new ByteArrayInputStream(ms.toByteArray()));
  Graphics graphics = new Graphics(psdImage);
                    // Perform graphics operations.
                
       //ExEnd:UncompressedImageStreamObject
    }
}
