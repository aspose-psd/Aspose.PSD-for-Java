/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.JPEG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.exif.JpegExifData;
import com.aspose.psd.fileformats.jpeg.JFIFData;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.resources.Thumbnail4Resource;
import com.aspose.psd.fileformats.psd.resources.ThumbnailResource;

/**
 *
 * @author mfazi
 */
public class ExtractThumbnailFromJFIF {
    
    public static void main(String[] args) 
    {
       //ExStart:ExtractThumbnailFromJFIF
       String dataDir = Utils.getDataDir(ExtractThumbnailFromJFIF.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir+"1280px-Zebras_Serengeti.psd");
       
       // Iterate over resources.
                for(int i =0; i < image.getImageResources().length; i++)
                {
                    // Find thumbnail resource. Typically they are in the Jpeg file format.
                    if (image.getImageResources()[i] instanceof ThumbnailResource || image.getImageResources()[i] instanceof Thumbnail4Resource)
                    {
                        // Extract thumbnail data and store it as a separate image file.
                        ThumbnailResource thumbnail = (ThumbnailResource)image.getImageResources()[i];
                        JFIFData jfif = thumbnail.getJpegOptions().getJfif();
                        if (jfif != null)
                        {
                            // extract JFIF data and process.
                        }

                        JpegExifData exif = thumbnail.getJpegOptions().getExifData();
                        if (exif != null)
                        {
                            // extract Exif data and process.
                        }
                    }
                }
       //ExEnd:ExtractThumbnailFromJFIF
    }
    
}
