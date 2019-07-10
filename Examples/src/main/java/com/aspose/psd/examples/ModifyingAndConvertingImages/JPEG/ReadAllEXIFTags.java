/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.JPEG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.exif.JpegExifData;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.resources.Thumbnail4Resource;
import com.aspose.psd.fileformats.psd.resources.ThumbnailResource;


public class ReadAllEXIFTags {
    public static void main(String[] args) 
    {
       //ExStart:ReadAllEXIFTags
       String dataDir = Utils.getDataDir(ReadAllEXIFTags.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir+"1280px-Zebras_Serengeti.psd");
       
        // Iterate over resources.
                
                for(int i =0; i < image.getImageResources().length; i++)
                {
                    // Find thumbnail resource. Typically they are in the Jpeg file format.
                    if (image.getImageResources()[i] instanceof ThumbnailResource || image.getImageResources()[i] instanceof Thumbnail4Resource)
                    {
                        // Extract exif data and print to the console.
                        ThumbnailResource thumbnail = (ThumbnailResource)image.getImageResources()[i];
                        JpegExifData exif = thumbnail.getJpegOptions().getExifData();
                        if (exif != null)
                        {                            
                           
                            for(int j =0; j < exif.getProperties().length; j++ ){
                            
                                System.out.println(exif.getProperties()[j].getId() + ":" + exif.getProperties()[j].getValue());
                            }

                        }
                    }
                }
       
       //ExEnd:ReadAllEXIFTags
       
    }
}
