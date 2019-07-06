/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.BmpOptions;
import com.aspose.psd.sources.StreamSource;
import com.aspose.psd.system.io.FileMode;
import com.aspose.psd.system.io.FileStream;
import com.aspose.psd.system.io.Stream;

/**
 *
 *  
 */
public class CreatingUsingStream {
   
    public static void main(String[] args) 
    {
       //ExStart:CreatingUsingStream
     String dataDir = Utils.getDataDir(CreatingUsingStream.class) + "DrawingAndFormattingImages/";
     String desName = dataDir + "CreatingImageUsingStream_out.bmp";
    // Creates an instance of BmpOptions and set its various properties
    BmpOptions ImageOptions = new BmpOptions();
    ImageOptions.setBitsPerPixel(24);

    // Create an instance of System.IO.Stream
    Stream stream = new FileStream(dataDir + "sample_out.bmp", FileMode.Create);
    // Define the source property for the instance of BmpOptions Second boolean parameter determines if the Stream is disposed once get out of scope
    ImageOptions.setSource( new StreamSource(stream, true));

    // Creates an instance of Image and call Create method by passing the BmpOptions object
    Image image = Image.create(ImageOptions, 500, 500);
    // Do some image processing
    image.save(desName);
       //ExEnd:CreatingUsingStream
    }
}
