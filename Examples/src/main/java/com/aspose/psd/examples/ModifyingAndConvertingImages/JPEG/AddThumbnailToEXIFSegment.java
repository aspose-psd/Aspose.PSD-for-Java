/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.JPEG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.exif.JpegExifData;
import com.aspose.psd.fileformats.jpeg.JpegImage;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.resources.Thumbnail4Resource;
import com.aspose.psd.fileformats.psd.resources.ThumbnailResource;

/**
 *
 * @author mfazi
 */
public class AddThumbnailToEXIFSegment {
    
    public static void main(String[] args) 
    {
       //ExStart:AddThumbnailToEXIFSegment
       String dataDir = Utils.getDataDir(AddThumbnailToEXIFSegment.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir+"1280px-Zebras_Serengeti.psd");
       
       // Iterate over resources.
               
                for(int i =0; i < image.getImageResources().length; i++)
                {
                    // Find thumbnail resource. Typically they are in the Jpeg file format.
                    if (image.getImageResources()[i] instanceof ThumbnailResource || image.getImageResources()[i] instanceof Thumbnail4Resource)
                    {
                        // Adjust thumbnail data.
                        ThumbnailResource thumbnail = (ThumbnailResource)image.getImageResources()[i];
                        JpegExifData exifData = new JpegExifData();
                        JpegImage thumbnailImage = new JpegImage(100, 100);
                        try
                        {
                            // Fill thumbnail data.
                            int[] pixels = new int[thumbnailImage.getWidth() * thumbnailImage.getHeight()];
                            for (int j = 0; j < pixels.length; j++)
                            {
                                pixels[j] = j;
                            }

                            // Assign thumbnail data.
                            thumbnailImage.saveArgb32Pixels(thumbnailImage.getBounds(), pixels);
                            exifData.setThumbnail(thumbnailImage);
                            thumbnail.getJpegOptions().setExifData(exifData);
                        }
                        catch(Exception e)
                        {
                            thumbnailImage.dispose();
                            
                        }
                    }
                }
                
                image.save();
       
       //ExEnd:AddThumbnailToEXIFSegment
       
    }
}
