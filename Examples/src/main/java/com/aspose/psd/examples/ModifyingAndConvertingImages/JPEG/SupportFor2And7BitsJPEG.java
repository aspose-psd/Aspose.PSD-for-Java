/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.JPEG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.psd.fileformats.jpeg.JpegCompressionMode;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.JpegOptions;

/**
 *
 * @author mfazi
 */
public class SupportFor2And7BitsJPEG {
    
    public static void main(String[] args) 
    {
       //ExStart:SupportFor2And7BitsJPEG
       String dataDir = Utils.getDataDir(SupportFor2And7BitsJPEG.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir + "PsdImage.psd");
       
        JpegOptions options = new JpegOptions();

                // Set 2 bits per sample to see the difference in size and quality
                byte bpp = 2;

                //Just replace one line given below in examples to use YCCK instead of CMYK
                //options.ColorType = JpegCompressionColorMode.Cmyk;
                options.setColorType(JpegCompressionColorMode.Cmyk);
                options.setCompressionType(JpegCompressionMode.JpegLs);
                options.setBitsPerChannel(bpp);

                // The default profiles will be used.
                options.setRgbColorProfile(null);
                options.setCmykColorProfile(null);

                image.save(dataDir+ "2_7BitsJPEG_output.jpg", options);
       //ExEnd:SupportFor2And7BitsJPEG
    }
}
