/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.sources.FileCreateSource;

/**
 *
 * @author mfazi
 */
public class CombiningImages {
    public static void main(String[] args) 
    {
       //ExStart:CombiningImages
       String dataDir = Utils.getDataDir(CombiningImages.class) + "DrawingAndFormattingImages/";
       
       // Create an instance of PsdOptions and set its various properties
       PsdOptions imageOptions = new PsdOptions();
       
       // Create an instance of FileCreateSource and assign it to Source property
            imageOptions.setSource(new FileCreateSource(dataDir+"Two_images_result_out.psd", false)) ;
            
            Image image = Image.create(imageOptions, 600, 600);
            
            // Create and initialize an instance of Graphics, Clear the image surface with white color and Draw Image
            Graphics graphics = new Graphics(image);
            graphics.clear(Color.getWhite());
            graphics.drawImage(Image.load(dataDir+"example1.psd"), 0, 0, 300, 600);
            graphics.drawImage(Image.load(dataDir+"example2.psd"), 300, 0, 300, 600);
            image.save();
       //ExEnd:CombiningImages
    }
}
