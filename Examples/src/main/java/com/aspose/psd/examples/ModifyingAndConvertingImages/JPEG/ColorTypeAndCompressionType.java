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
 *  
 */
public class ColorTypeAndCompressionType {
    
    public static void main(String[] args) 
    {
       //ExStart:ColorTypeAndCompressionType
       String dataDir = Utils.getDataDir(ColorTypeAndCompressionType.class) + "ModifyingAndConvertingImages/";
       
       PsdImage image = (PsdImage)Image.load(dataDir + "PsdImage.psd");
       
       
       JpegOptions options = new JpegOptions();
        options.setColorType(JpegCompressionColorMode.Grayscale);
        options.setCompressionType(JpegCompressionMode.Progressive) ;

        image.save(dataDir + "ColorTypeAndCompressionType_output.jpg", options);
       //ExEnd:ColorTypeAndCompressionType
    }
}
