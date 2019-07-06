/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Font;
import com.aspose.psd.Graphics;
import com.aspose.psd.Image;
import com.aspose.psd.RectangleF;
import com.aspose.psd.StringAlignment;
import com.aspose.psd.StringFormat;
import com.aspose.psd.brushes.SolidBrush;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 * @author mfazi
 */
public class AddWatermark {
    
    public static void main(String[] args) 
    {
       //ExStart:AddWatermark
       String dataDir = Utils.getDataDir(AddWatermark.class) + "PSD/";
       // Load a PSD file as an image and cast it into PsdImage
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
       
             // Create graphics object to perform draw operations.
                Graphics graphics = new Graphics(psdImage);

                // Create font to draw watermark with.
                Font font = new Font("Arial", 20.0f);

                // Create a solid brush with color alpha set near to 0 to use watermarking effect. 
               SolidBrush brush = new SolidBrush(Color.fromArgb(50, 128, 128, 128));
               
               // Specify string alignment to put watermark at the image center.
                    StringFormat sf = new StringFormat();
                    sf.setAlignment(StringAlignment.Center);
                    sf.setLineAlignment(StringAlignment.Center);

                    // Draw watermark using font, partly-transparent brush and rotation matrix at the image center.
                    graphics.drawString("Some watermark text", font, brush, new RectangleF(0, 0, psdImage.getWidth(), psdImage.getHeight()), sf);
               
                    
                    // Export the image into PNG file format.
                psdImage.save(dataDir+"AddWatermark_output.png", new PngOptions());
       //ExEnd:AddWatermark
    }
}
