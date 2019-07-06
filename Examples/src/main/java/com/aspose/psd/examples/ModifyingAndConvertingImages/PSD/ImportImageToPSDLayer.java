/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import com.aspose.psd.Image;
import com.aspose.psd.Point;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngImage;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;

/**
 *
 * @author mfazi
 */
public class ImportImageToPSDLayer {
    
    public static void main(String[] args) 
    {
       //ExStart:ImportImageToPSDLayer
       String dataDir = Utils.getDataDir(ImportImageToPSDLayer.class) + "PSD/";
       // Load a PSD file as an image and caste it into PsdImage
       PsdImage image = (PsdImage)Image.load(dataDir+"sample.psd");
       
       //Extract a layer from PSDImage
       Layer layer = image.getLayers()[1];
       
       // Create an image that is needed to be imported into the PSD file.
       PngImage drawImage = new PngImage(200, 200);
       
        // Fill image surface as needed.
        Graphics g = new Graphics(drawImage);
        g.clear(Color.getYellow());

        // Call DrawImage method of the Layer class and pass the image instance.
        layer.drawImage(new Point(10, 10), drawImage);
        
        // Save the results to output path.
        image.save(dataDir+"ImportImageToPSDLayer_out.psd");
       //ExEnd:ImportImageToPSDLayer
    }
}
