/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Graphics;
import static com.aspose.psd.GraphicsUnit.Point;
import com.aspose.psd.Image;
import com.aspose.psd.Point;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class AddSignatureToImage {
    public static void main(String[] args) 
    {
       //ExStart:AddSignatureToImage
       String dataDir = Utils.getDataDir(AddSignatureToImage.class) + "DrawingImages/";
       
       // Create an instance of Image and load the primary image
       Image canvas = Image.load(dataDir + "layers.psd");
       
       // Create another instance of Image and load the secondary image containing the signature graphics
       
       Image signature = Image.load(dataDir + "sample.psd");
       
        // Create an instance of Graphics class and initialize it using the object of the primary image
        Graphics graphics = new Graphics(canvas);

        // Call the DrawImage method while passing the instance of secondary image and appropriate location. The following snippet tries to draw the secondary image at the right bottom of the primary image
        graphics.drawImage(signature, new Point(canvas.getHeight() - signature.getHeight(), canvas.getWidth() - signature.getWidth()));
        canvas.save(dataDir + "AddSignatureToImage_out.png", new PngOptions());
        //ExEnd:AddSignatureToImage
       
    }
}
