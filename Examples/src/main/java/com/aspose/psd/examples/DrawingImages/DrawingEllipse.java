/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import com.aspose.psd.Image;
import com.aspose.psd.Pen;
import com.aspose.psd.Rectangle;
import com.aspose.psd.brushes.SolidBrush;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.BmpOptions;

/**
 *
 * @author mfazi
 */
public class DrawingEllipse {
    
    public static void main(String[] args) 
    {
       //ExStart:DrawingEllipse
       String dataDir = Utils.getDataDir(DrawingEllipse.class) + "DrawingImages/";
       
        // Create an instance of BmpOptions and set its various properties
            String outpath = dataDir + "Ellipse.bmp";
            // Create an instance of BmpOptions and set its various properties
            BmpOptions saveOptions = new BmpOptions();
            saveOptions.setBitsPerPixel(32);
            
            // Create an instance of Image
            Image image = new PsdImage(100, 100);

            // Create and initialize an instance of Graphics class and Clear Graphics surface                    
                Graphics graphic = new Graphics(image);
                graphic.clear(Color.getYellow());

                // Draw a dotted ellipse shape by specifying the Pen object having red color and a surrounding Rectangle
                graphic.drawEllipse(new Pen(Color.getRed()), new Rectangle(30, 10, 40, 80));

                // Draw a continuous ellipse shape by specifying the Pen object having solid brush with blue color and a surrounding Rectangle
                graphic.drawEllipse(new Pen(new SolidBrush(Color.getBlue())), new Rectangle(10, 30, 80, 40));

                // export image to bmp file format.
                image.save(outpath, saveOptions);
       //ExEnd:DrawingEllipse
    }
    
}
