/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import com.aspose.psd.Pen;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.bmp.BmpImage;
import com.aspose.psd.fileformats.psd.ColorModes;
import com.aspose.psd.fileformats.psd.CompressionMethod;
import com.aspose.psd.imageoptions.PsdOptions;

/**
 *
 * @author mfazi
 */
public class ExportImageToPSD {
    public static void main(String[] args) 
    {
       //ExStart:ExportImageToPSD
       String dataDir = Utils.getDataDir(ExportImageToPSD.class) + "PSD/";
       
       // Create a new image from scratch.
            BmpImage bmpImage = new BmpImage(300, 300);
            
                // Fill image data.
                Graphics graphics = new Graphics(bmpImage);
                graphics.clear(Color.getWhite());
                Pen pen = new Pen(Color.getBrown());
                graphics.drawRectangle(pen, bmpImage.getBounds());

                // Create an instance of PsdOptions, Set it's various properties Save image to disk in PSD format
                PsdOptions psdOptions = new PsdOptions();
                psdOptions.setColorMode(ColorModes.Rgb);
                psdOptions.setCompressionMethod(CompressionMethod.Raw);
                psdOptions.setVersion(4);
                bmpImage.save(dataDir+"ExportImageToPSD_output.psd", psdOptions);
             
       
       //ExEnd:ExportImageToPSD
    }
}
