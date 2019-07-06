/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.bmp.BmpImage;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.resources.ThumbnailFormat;
import com.aspose.psd.fileformats.psd.resources.ThumbnailResource;

/**
 *
 * @author mfazi
 */
public class CreateThumbnailsFromPSDFiles {
    public static void main(String[] args) 
    {
       //ExStart:CreateThumbnailsFromPSDFiles
       String dataDir = Utils.getDataDir(CreateThumbnailsFromPSDFiles.class) + "PSD/";
       
       // Load a PSD file as an image and caste it into PsdImage
       
       PsdImage image = (PsdImage)Image.load(dataDir + "sample.psd");
       int index = 0;
       // Iterate over the PSD resources
       
       
       
       for (int i =0; i <image.getImageResources().length; i++)
                {
                    index++;
                    // Check if the resource is of thumbnail type
                    
                    if (image.getImageResources()[i] instanceof ThumbnailResource)
                    {
                        // Retrieve the ThumbnailResource and Check the format of the ThumbnailResource
                        ThumbnailResource thumbnail = (ThumbnailResource)image.getImageResources()[i];
                        if (thumbnail.getFormat()== ThumbnailFormat.KJpegRgb)
                        {
                            // Create a new BmpImage by specifying the width and height,  Store the pixels of thumbnail on to the newly created BmpImage and save image
                            BmpImage thumnailImage = new BmpImage(thumbnail.getWidth(), thumbnail.getHeight());
                            thumnailImage.savePixels(thumnailImage.getBounds(), thumbnail.getThumbnailData());
                            thumnailImage.save(dataDir + "CreateThumbnailsFromPSDFiles_out_"+i+".bmp");
                        }
                    }
                }
    }
}
