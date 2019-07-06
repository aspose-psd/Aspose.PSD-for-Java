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
import java.util.Properties; 


/**
 *
 * @author mfazi
 */
public class ReadAllEXIFTagList {
    
    public static void main(String[] args) 
    {
       //ExStart111:ReadAllEXIFTagList
       String dataDir = Utils.getDataDir(ReadAllEXIFTagList.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir + "1280px-Zebras_Serengeti.psd");
       
       // Iterate over resources.
                 for(int i =0; i < image.getImageResources().length; i++)
                {
                    // Find thumbnail resource. Typically they are in the Jpeg file format.
                    if (image.getImageResources()[i] instanceof ThumbnailResource || image.getImageResources()[i] instanceof Thumbnail4Resource)
                    {
                        // Extract thumbnail data and store it as a separate image file.
                        ThumbnailResource thumbnail = (ThumbnailResource)image.getImageResources()[i];
                        JpegExifData exifData = thumbnail.getJpegOptions().getExifData();
                        if (exifData != null)
                        {
                            
                           
                            for(int j =0; j < exifData.getProperties().length; j++ ){
                            
                                //System.out.println(exifData.getProperties(). + ":" + exifData.getProperties().getValue(exifData, null));
                            }

                        }
                    }
                }
       //ExEnd111:ReadAllEXIFTagList
    }
}
