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
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.BmpOptions;

/**
 *
 *  
 */
public class DrawingBezier {
    
    public static void main(String[] args) 
    {
       //ExStart:DrawingBezier
       String dataDir = Utils.getDataDir(DrawingBezier.class) + "DrawingImages/";
  
// Create an instance of BmpOptions and set its various properties
            String outpath = dataDir + "Bezier.bmp";
            // Create an instance of BmpOptions and set its various properties
            BmpOptions saveOptions = new BmpOptions();
            saveOptions.setBitsPerPixel(32);
            
            

            // Create an instance of Image
            Image image = new PsdImage(100, 100);
            
            // Create and initialize an instance of Graphics class and clear Graphics surface
                Graphics graphic = new Graphics(image);
                graphic.clear(Color.getYellow());

                // Initializes the instance of PEN class with black color and width
                Pen BlackPen = new Pen(Color.getBlack(), 3);
                float startX = 10;
                float startY = 25;
                float controlX1 = 20;
                float controlY1 = 5;
                float controlX2 = 55;
                float controlY2 = 10;
                float endX = 90;
                float endY = 25;

                // Draw a Bezier shape by specifying the Pen object having black color and co-ordinate Points and save all changes.
                graphic.drawBezier(BlackPen, startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY);

                // export image to bmp file format.
                image.save(outpath, saveOptions);
       //ExEnd:DrawingBezier
    }
}
