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
public class DrawingRectangle {
    
    public static void main(String[] args) 
    {
       //ExStart:DrawingRectangle
       String dataDir = Utils.getDataDir(DrawingRectangle.class) + "DrawingImages/";
       
       // Create an instance of BmpOptions and set its various properties
            String outpath = dataDir + "Rectangle.bmp";
            // Create an instance of BmpOptions and set its various properties
            BmpOptions saveOptions = new BmpOptions();
            saveOptions.setBitsPerPixel(32);
             // Create an instance of Image
            Image image = new PsdImage(100, 100);
            
            
             // Create and initialize an instance of Graphics class,  Clear Graphics surface, Draw a rectangle shapes and  save all changes.
                Graphics graphic = new Graphics(image);
                graphic.clear(Color.getYellow());
                graphic.drawRectangle(new Pen(Color.getRed()), new Rectangle(30, 10, 40, 80));
                graphic.drawRectangle(new Pen(new SolidBrush(Color.getBlue())), new Rectangle(10, 30, 80, 40));

                // export image to bmp file format.
                image.save(outpath, saveOptions);
            
       //ExEnd:DrawingRectangle
    }
}
