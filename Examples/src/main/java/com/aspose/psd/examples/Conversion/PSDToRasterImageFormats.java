/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.BmpOptions;
import com.aspose.psd.imageoptions.GifOptions;
import com.aspose.psd.imageoptions.Jpeg2000Options;
import com.aspose.psd.imageoptions.JpegOptions;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.TiffOptions;

/**
 *
 * @author mfazi
 */
public class PSDToRasterImageFormats {
    
    public static void main(String[] args)
    {
       //ExStart:PSDToRasterImageFormats
       String dataDir = Utils.getDataDir(PSDToRasterImageFormats.class) + "Conversion/";
       
       String srcPath = dataDir + "sample.psd";
       String destName = dataDir+ "export";
       
       // Load an existing PSD image as Image
       Image image = Image.load(srcPath);
       
       // Create an instance of PngOptions class
        PngOptions pngOptions = new PngOptions();

        // Create an instance of BmpOptions class
        BmpOptions bmpOptions = new BmpOptions();
       

        // Create an instance of GifOptions class
        GifOptions gifOptions = new GifOptions();

        // Create an instance of JpegOptions class
        JpegOptions jpegOptions = new JpegOptions();

        // Create an instance of Jpeg2000Options class
        Jpeg2000Options jpeg2000Options = new Jpeg2000Options();
        
        // Call the save method, provide output path and export options to convert PSD file to various raster file formats.
        image.save(destName + ".png", pngOptions);
        image.save(destName + ".bmp", bmpOptions);        
        image.save(destName + ".gif", gifOptions);
        image.save(destName + ".jpeg", jpegOptions);
        image.save(destName + ".jp2", jpeg2000Options);
       //ExEnd:PSDToRasterImageFormats
    }
}
