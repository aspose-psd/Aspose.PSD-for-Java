/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import com.aspose.psd.Pen;
import com.aspose.psd.Point;
import com.aspose.psd.Rectangle;
import com.aspose.psd.brushes.LinearGradientBrush;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.BmpOptions;

/**
 *
 * @author mfazi
 */
public class DrawingUsingGraphics {
    public static void main(String[] args) 
    {
       //ExStart:DrawingUsingGraphics
       String dataDir = Utils.getDataDir(DrawingUsingGraphics.class) + "DrawingImages/";
        // Create an instance of Image
        
        PsdImage image = new PsdImage(500, 500);
       
        
        Graphics graphics = new Graphics(image);

                // Clear the image surface with white color and Create and initialize a Pen object with blue color
                graphics.clear(Color.getWhite());
                Pen pen = new Pen(Color.getBlue());

                // Draw Ellipse by defining the bounding rectangle of width 150 and height 100 also Draw a polygon using the LinearGradientBrush
                graphics.drawEllipse(pen, new Rectangle(10, 10, 150, 100));
                LinearGradientBrush linearGradientBrush = new LinearGradientBrush(image.getBounds(), Color.getRed(), Color.getWhite(), 45f);
                
               // graphics.fillPolygon(linearGradientBrush,  new Point(200, 200), new Point(400, 200), new Point(250, 350));
                
               
               Point[] points = { new Point(200, 200), new Point(400, 200), new Point(250, 350) };
               graphics.fillPolygon(linearGradientBrush, points);
                  // export modified image.
                image.save(dataDir+ "DrawingUsingGraphics_output.bmp", new BmpOptions());
       //ExEnd:DrawingUsingGraphics
    }
}
