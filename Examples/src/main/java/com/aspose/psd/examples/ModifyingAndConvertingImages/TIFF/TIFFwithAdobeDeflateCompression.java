/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.TIFF;

import com.aspose.psd.Color;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.tiff.TiffFrame;
import com.aspose.psd.fileformats.tiff.TiffImage;
import com.aspose.psd.fileformats.tiff.TiffRational;
import com.aspose.psd.fileformats.tiff.enums.TiffCompressions;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.psd.fileformats.tiff.enums.TiffPlanarConfigs;
import com.aspose.psd.fileformats.tiff.enums.TiffResolutionUnits;
import com.aspose.psd.imageoptions.TiffOptions;

/**
 *
 * @author mfazi
 */
public class TIFFwithAdobeDeflateCompression {
    
    public static void main(String[] args) 
    {
       //ExStart:TIFFwithAdobeDeflateCompression
       String dataDir = Utils.getDataDir(TIFFwithAdobeDeflateCompression.class) + "ModifyingAndConvertingImages/";
       
       // Create an instance of TiffOptions and set its various properties
            TiffOptions options = new TiffOptions(TiffExpectedFormat.Default);
            
            int[] ushort = { 8, 8, 8 };
            options.setBitsPerSample(ushort) ;
            options.setPhotometric(TiffPhotometrics.Rgb) ;
            options.setXresolution(new TiffRational(72)) ;
            options.setYresolution(new TiffRational(72));
            options.setResolutionUnit(TiffResolutionUnits.Inch);
            options.setPlanarConfiguration(TiffPlanarConfigs.Contiguous);

            // Set the Compression to AdobeDeflate
            options.setCompression(TiffCompressions.AdobeDeflate);
            
            // Create a new TiffImage with specific size and TiffOptions settings
            TiffImage tiffImage = new TiffImage(new TiffFrame(options, 100, 100));
            
                // Loop over the pixels to set the color to red
                for (int j = 0; j < tiffImage.getHeight(); j++)
                {
                    for (int i = 0; i < tiffImage.getWidth(); i++)
                    {
                        tiffImage.getActiveFrame().setPixel(i, j, Color.getRed());
                    }
                }

                // Save resultant image
                tiffImage.save(dataDir+"TIFFwithAdobeDeflateCompression_output.tif");
            
       //ExEnd:TIFFwithAdobeDeflateCompression
    }
}
