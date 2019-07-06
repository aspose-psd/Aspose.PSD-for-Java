/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.TIFF;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.tiff.enums.TiffCompressions;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.imageoptions.TiffOptions;

/**
 *
 * @author mfazi
 */
public class TIFFWithDeflateCompression {
    public static void main(String[] args) 
    {
       //ExStart:TIFFWithDeflateCompression
       String dataDir = Utils.getDataDir(TIFFWithDeflateCompression.class) + "ModifyingAndConvertingImages/";
       
       
        // Load a PSD file as an image and cast it into PsdImage
        PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
        // Create an instance of TiffOptions while specifying desired format and compression
        TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffDeflateRgb);
        options.setCompression(TiffCompressions.AdobeDeflate);
        psdImage.save(dataDir+ "TIFFwithDeflateCompression_out.tiff", options);
       //ExEnd:TIFFWithDeflateCompression
       
    }
}
