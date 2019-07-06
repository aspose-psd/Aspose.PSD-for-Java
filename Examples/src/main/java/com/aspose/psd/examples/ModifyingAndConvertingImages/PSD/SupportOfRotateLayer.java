/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.RotateFlipType;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;


public class SupportOfRotateLayer {
    public static void main(String[] args) 
    {
       //ExStart:SupportOfRotateLayer
       String dataDir = Utils.getDataDir(SupportOfRotateLayer.class) + "PSD/";
     
        String sourceFile = dataDir + "1.psd";
        String pngPath = dataDir + "RotateFlipTest2617.png";
        String psdPath = dataDir + "RotateFlipTest2617.psd";
        int flipType = RotateFlipType.Rotate270FlipXY;
            PsdImage im = (PsdImage)Image.load(sourceFile);
            
                im.rotateFlip(flipType);
                
                PngOptions options = new PngOptions();
                options.setColorType(PngColorType.TruecolorWithAlpha);
                im.save(pngPath,options);
                im.save(psdPath);
            
       
       //ExEnd:SupportOfRotateLayer
    }
}
