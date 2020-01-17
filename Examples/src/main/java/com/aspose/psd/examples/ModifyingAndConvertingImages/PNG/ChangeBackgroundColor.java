/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PNG;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;


public class ChangeBackgroundColor {
     public static void main(String[] args)
    {
       //ExStart:ChangeBackgroundColor
       String dataDir = Utils.getDataDir(ChangeBackgroundColor.class) + "ModifyingAndConvertingImages/";
       
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
       
       // Convert to PngImage based on PsdImage.
       
       PsdImage pngImage = new PsdImage(psdImage);
       
       int[] pixels = pngImage.loadArgb32Pixels(pngImage.getBounds());
                    // Iterate through the pixel array and Check the pixel information 
                    //that if it is a transparent color pixel and Change the pixel color to white
                    int transparent = pngImage.getTransparentColor().toArgb();
                    int replacementColor = Color.getYellow().toArgb();
                    for (int i = 0; i < pixels.length; i++)
                    {
                        if (pixels[i] == transparent)
                        {
                            pixels[i] = replacementColor;
                        }
                    }
                    // Replace the pixel array into the image.
                    pngImage.saveArgb32Pixels(pngImage.getBounds(), pixels);
                    pngImage.save(dataDir+"ChangeBackground_out.png");
       //ExEnd:ChangeBackgroundColor
    }
}
