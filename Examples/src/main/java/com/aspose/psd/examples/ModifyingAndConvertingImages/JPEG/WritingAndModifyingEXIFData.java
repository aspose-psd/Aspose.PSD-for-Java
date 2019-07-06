/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.JPEG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.exif.JpegExifData;
import com.aspose.psd.exif.enums.ExifFlash;
import com.aspose.psd.exif.enums.ExifWhiteBalance;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.resources.Thumbnail4Resource;
import com.aspose.psd.fileformats.psd.resources.ThumbnailResource;

/**
 *
 * @author mfazi
 */
public class WritingAndModifyingEXIFData {
    public static void main(String[] args) 
    {
       //ExStart:WritingAndModifyingEXIFData
       String dataDir = Utils.getDataDir(WritingAndModifyingEXIFData.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir+"1280px-Zebras_Serengeti.psd");
       

       // Iterate over resources.
                for(int i =0; i < image.getImageResources().length; i++)
                {
                    // Find thumbnail resource. Typically they are in the Jpeg file format.
                    if (image.getImageResources()[i] instanceof ThumbnailResource || image.getImageResources()[i] instanceof Thumbnail4Resource)
                    {
                        // Extract exif data and print to the console.
                        JpegExifData exif = ((ThumbnailResource)image.getImageResources()[i]).getJpegOptions().getExifData();
                        if (exif != null)
                        {
                            // Set LensMake, WhiteBalance, Flash information Save the image
                            exif.setLensMake("Sony");
                            exif.setWhiteBalance(ExifWhiteBalance.Auto);
                            exif.setFlash(ExifFlash.Fired);
                            
                        }
                    }
                }

                image.save(dataDir+"aspose_out.psd");
   //ExEnd:WritingAndModifyingEXIFData
    }
}
