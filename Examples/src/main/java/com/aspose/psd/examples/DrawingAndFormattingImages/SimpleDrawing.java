package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import com.aspose.psd.Pen;
import com.aspose.psd.Rectangle;
import com.aspose.psd.brushes.SolidBrush;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;

/**
 * An example of drawing on a layer created by no-argument constructor. It adds a manually
 * initialized layer to the document and draws a couple of simple figures on it then saves
 * a changed copy of the document as a new PSD file.
 */
public class SimpleDrawing
{
    public static void main(String[] args)
    {
        String outputDir = Utils.GetDataDir_Output();

        String outPsdFilePath = outputDir + "output.psd";

        int width = 100;
        int height = 100;

        // Create a new document of the appropriate size
        PsdImage image = new PsdImage(width, height);
        try
        {
            // Add a layer created by no-argument constructor to the document
            Layer layer = new Layer();
            layer.setBottom(height);
            layer.setRight(width);
            image.addLayer(layer);

            Graphics graphic = new Graphics(layer);

            // Clear the canvas and paint it up with a yellow color
            graphic.clear(Color.getYellow());

            // Draw a rectangle using the Pen tool
            graphic.drawRectangle(new Pen(Color.getRed()), new Rectangle(30, 10, 40, 80));

            // Draw another rectangle using Solid Brush with a Blue color
            graphic.drawRectangle(new Pen(new SolidBrush(Color.getBlue())), new Rectangle(10, 30, 80, 40));

            // Save a copy of the loaded PSD file including the changes on the specified path
            image.save(outPsdFilePath);
        }
        finally
        {
            image.dispose();
        }
    }
}
