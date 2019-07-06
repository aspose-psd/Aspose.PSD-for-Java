/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import static com.aspose.psd.GraphicsUnit.Point;
import com.aspose.psd.Image;
import com.aspose.psd.Pen;
import com.aspose.psd.Point;
import com.aspose.psd.brushes.SolidBrush;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.BmpOptions;

/**
 *
 *  
 */
public class DrawingLines {
    
    public static void main(String[] args) 
    {
       //ExStart:DrawingLines
       String dataDir = Utils.getDataDir(DrawingLines.class) + "DrawingImages/";
       
       // Create an instance of BmpOptions and set its various properties
            String outpath = dataDir + "Lines.bmp";
            BmpOptions saveOptions = new BmpOptions();
            saveOptions.setBitsPerPixel(32);
            // Create an instance of Image
            Image image = new PsdImage(100, 100);

            
            
            // Create and initialize an instance of Graphics class and Clear Graphics surface
                Graphics graphic = new Graphics(image);
                graphic.clear(Color.getYellow());

                // Draw two dotted diagonal lines by specifying the Pen object having blue color and co-ordinate Points
                graphic.drawLine(new Pen(Color.getBlue()), 9, 9, 90, 90);
                graphic.drawLine(new Pen(Color.getBlue()), 9, 90, 90, 9);

                // Draw a four continuous line by specifying the Pen object having Solid Brush with red color and two point structures
                graphic.drawLine(new Pen(new SolidBrush(Color.getRed())), new Point(9, 9), new Point(9, 90));
                graphic.drawLine(new Pen(new SolidBrush(Color.getAqua())), new Point(9, 90), new Point(90, 90));
                graphic.drawLine(new Pen(new SolidBrush(Color.getBlack())), new Point(90, 90), new Point(90, 9));
                graphic.drawLine(new Pen(new SolidBrush(Color.getWhite())), new Point(90, 9), new Point(9, 9));
                image.save(outpath, saveOptions);
       //ExEnd:DrawingLines
       
    }
}
