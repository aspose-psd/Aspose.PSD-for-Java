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
public class SupportForJPEGLSWithCMYK {
    
    public static void main(String[] args) 
    {
       //ExStart:SupportForJPEGLSWithCMYK
       String dataDir = Utils.getDataDir(SupportForJPEGLSWithCMYK.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir + "PsdImage.psd");
       
       JpegOptions options = new JpegOptions();
                //Just replace one line given below in examples to use YCCK instead of CMYK
                //options.ColorType = JpegCompressionColorMode.Cmyk;
                options.setColorType(JpegCompressionColorMode.Cmyk);
                options.setCompressionType(JpegCompressionMode.JpegLs);

                // The default profiles will be used.
                options.setRgbColorProfile(null);
                options.setCmykColorProfile(null);

                image.save(dataDir+"output.jpg", options);
                
                
                PsdImage image1 = (PsdImage)Image.load(dataDir + "PsdImage.psd");
                
                
                 JpegOptions options1 = new JpegOptions();
                //Just replace one line given below in examples to use YCCK instead of CMYK
                //options.ColorType = JpegCompressionColorMode.Cmyk;
                options1.setColorType(JpegCompressionColorMode.Cmyk);
                options1.setCompressionType(JpegCompressionMode.Lossless);

                // The default profiles will be used.
                options1.setRgbColorProfile(null);
                options1.setCmykColorProfile(null);

                image1.save(dataDir + "output2.jpg", options1);
       //ExEnd:SupportForJPEGLSWithCMYK
    }
}
