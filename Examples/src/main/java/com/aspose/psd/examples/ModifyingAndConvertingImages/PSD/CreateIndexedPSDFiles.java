/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Graphics;
import com.aspose.psd.Image;
import com.aspose.psd.Pen;
import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.ColorModes;
import com.aspose.psd.fileformats.psd.CompressionMethod;
import com.aspose.psd.fileformats.psd.PsdColorPalette;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.sources.FileCreateSource;

/**
 *
 *  
 */
public class CreateIndexedPSDFiles {
    
    
    public static void main(String[] args) 
    {
       //ExStart:CreateIndexedPSDFiles
       String dataDir = Utils.getDataDir(CreateIndexedPSDFiles.class) + "PSD/";
       
        // Create an instance of PsdOptions and set it's properties
            PsdOptions createOptions = new PsdOptions();
            createOptions.setSource(new FileCreateSource(dataDir+"Newsample_out.psd", false));
            createOptions.setColorMode(ColorModes.Indexed);
            createOptions.setVersion(5);
            
            
             // Create a new color palette having RGB colors, Set Palette property & compression method
            Color[] palette = { Color.getRed(), Color.getGreen(), Color.getBlue(), Color.getYellow() };
            createOptions.setPalette(new PsdColorPalette(palette));
            createOptions.setCompressionMethod(CompressionMethod.RLE);
            
             // Create a new PSD with PsdOptions created previously
             Image psd = Image.create(createOptions, 500, 500);
             // Draw some graphics over the newly created PSD
                Graphics graphics = new Graphics(psd);
                graphics.clear(Color.getWhite());
                graphics.drawEllipse(new Pen(Color.getRed(), 6), new Rectangle(0, 0, 400, 400));
                psd.save();
       //ExEnd:CreateIndexedPSDFiles
    }
}
