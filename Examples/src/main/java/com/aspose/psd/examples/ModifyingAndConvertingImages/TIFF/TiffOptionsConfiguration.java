/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.TIFF;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.imageoptions.TiffOptions;

/**
 *
 * @author mfazi
 */
public class TiffOptionsConfiguration {
    public static void main(String[] args) 
    {
       //ExStart:TiffOptionsConfiguration
       String dataDir = Utils.getDataDir(TiffOptionsConfiguration.class) + "ModifyingAndConvertingImages/";
       
       // Load a PSD file as an image and cast it into PsdImage
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
       
        // Create an instance of TiffOptions while specifying desired format Passsing TiffExpectedFormat.TiffJpegRGB will set the compression to Jpeg and BitsPerPixel according to the RGB color space.
        TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffJpegRgb);
        psdImage.save(dataDir+"SampleTiff_out.tiff", options);
       //ExEnd:TiffOptionsConfiguration
       
    }
}
