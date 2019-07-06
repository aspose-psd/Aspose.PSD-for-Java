/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import static com.aspose.psd.ColorAdjustType.Pen;
import com.aspose.psd.Graphics;
import com.aspose.psd.Image;
import com.aspose.psd.Pen;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.BmpOptions;

/**
 *
 *  
 */
public class DrawingArc {
    
    public static void main(String[] args) 
    {
       //ExStart:DrawingArc
       String dataDir = Utils.getDataDir(DrawingArc.class) + "DrawingImages/";
    // Create an instance of BmpOptions and set its various properties
        String outpath = dataDir + "Arc.bmp";
        // Create an instance of BmpOptions and set its various properties
        BmpOptions saveOptions = new BmpOptions();
        saveOptions.setBitsPerPixel(32);
        // Create an instance of Image
        Image image = new PsdImage(100, 100);
        
        
  // Create and initialize an instance of Graphics class and clear Graphics surface
                Graphics graphic = new Graphics(image);
                graphic.clear(Color.getYellow());

                // Draw an arc shape by specifying the Pen object having red black color and coordinates, height, width, start & end angles                 
                int width = 100;
                int height = 200;
                int startAngle = 45;
                int sweepAngle = 270;

                // Draw arc to screen and save all changes.
                graphic.drawArc(new Pen(Color.getBlack()), 0, 0, width, height, startAngle, sweepAngle);

                // export image to bmp file format.
                image.save(outpath, saveOptions);      
    //ExEnd:DrawingArc
    }
    
}
