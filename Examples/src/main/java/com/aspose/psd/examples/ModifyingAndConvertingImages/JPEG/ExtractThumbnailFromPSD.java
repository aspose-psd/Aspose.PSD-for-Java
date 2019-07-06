/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.JPEG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.resources.Thumbnail4Resource;
import com.aspose.psd.fileformats.psd.resources.ThumbnailResource;
import com.aspose.psd.imageoptions.JpegOptions;

/**
 *
 * @author mfazi
 */
public class ExtractThumbnailFromPSD {
    
    public static void main(String[] args) 
    {
       //ExStart:ExtractThumbnailFromPSD
       String dataDir = Utils.getDataDir(ExtractThumbnailFromPSD.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir+"1280px-Zebras_Serengeti.psd");
       
       // Iterate over resources.
                for(int i =0; i < image.getImageResources().length; i++)
                {
                    // Find thumbnail resource. Typically they are in the Jpeg file format.
                    if (image.getImageResources()[i] instanceof ThumbnailResource || image.getImageResources()[i] instanceof Thumbnail4Resource)
                    {
                        // Extract thumbnail data and store it as a separate image file.
                        ThumbnailResource thumbnail = (ThumbnailResource)image.getImageResources()[i];
                        int[] data = ((ThumbnailResource)image.getImageResources()[i]).getThumbnailArgb32Data();
                        
                        PsdImage extractedThumnailImage = new PsdImage(thumbnail.getWidth(), thumbnail.getHeight());
                       
                            extractedThumnailImage.saveArgb32Pixels(extractedThumnailImage.getBounds(), data);
                            extractedThumnailImage.save(dataDir+"extracted_thumbnail.jpg", new JpegOptions());
                       
                    }
                }
       
       //ExEnd:ExtractThumbnailFromPSD
    }
}
