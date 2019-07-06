/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Figure;
import com.aspose.psd.Font;
import com.aspose.psd.Graphics;
import com.aspose.psd.GraphicsPath;
import com.aspose.psd.HatchStyle;
import com.aspose.psd.Pen;
import com.aspose.psd.RectangleF;
import com.aspose.psd.StringFormat;
import com.aspose.psd.brushes.HatchBrush;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.shapes.EllipseShape;
import com.aspose.psd.shapes.RectangleShape;
import com.aspose.psd.shapes.TextShape;

/**
 *
 * @author mfazi
 */
public class DrawingUsingGraphicsPath {
    
    public static void main(String[] args) 
    {
       //ExStart:DrawingUsingGraphicsPath
       String dataDir = Utils.getDataDir(DrawingUsingGraphicsPath.class) + "DrawingImages/";
       
       // Create an instance of Image and initialize an instance of Graphics
       PsdImage image = new PsdImage(500, 500);
       
       // create graphics surface.
                Graphics graphics = new Graphics(image);
                graphics.clear(Color.getWhite());

                // Create an instance of GraphicsPath and Instance of Figure, add EllipseShape, RectangleShape and TextShape to the figure
                GraphicsPath graphicspath = new GraphicsPath();
                Figure figure = new Figure();
                figure.addShape(new EllipseShape(new RectangleF(0, 0, 499, 499)));
                figure.addShape(new RectangleShape(new RectangleF(0, 0, 499, 499)));
                figure.addShape(new TextShape("Aspose.PSD", new RectangleF(170, 225, 170, 100), new Font("Arial", 20), StringFormat.getGenericTypographic()));
                
             Figure[] fig =   { figure };
               graphicspath.addFigures(fig);
               
                graphics.drawPath(new Pen(Color.getBlue()), graphicspath);

                // Create an instance of HatchBrush and set its properties also Fill path by supplying the brush and GraphicsPath objects
                HatchBrush hatchbrush = new HatchBrush();
                hatchbrush.setBackgroundColor(Color.getBrown());
                hatchbrush.setForegroundColor(Color.getBlue());
                hatchbrush.setHatchStyle(HatchStyle.Vertical);
                graphics.fillPath(hatchbrush, graphicspath);
                image.save(dataDir + "DrawingUsingGraphicsPath_output.psd");
                
       //ExEnd:DrawingUsingGraphicsPath
    }
    
}
