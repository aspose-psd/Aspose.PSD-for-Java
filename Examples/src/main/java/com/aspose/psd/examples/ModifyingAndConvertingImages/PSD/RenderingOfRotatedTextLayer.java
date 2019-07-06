/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.xmp.types.complex.colorant.ColorType;


public class RenderingOfRotatedTextLayer {
    public static void main(String[] args) 
    {
       //ExStart:RenderingOfRotatedTextLayer
       String dataDir = Utils.getDataDir(RenderingOfRotatedTextLayer.class) + "PSD/";
       
        String sourceFileName = dataDir + "TransformedText.psd";
        String exportPath = dataDir + "TransformedTextExport.psd";
        String exportPathPng = dataDir + "TransformedTextExport.png";
        PsdImage im = (PsdImage)Image.load(sourceFileName);
          
           PngOptions opt =  new PngOptions();
           opt.setColorType(PngColorType.Grayscale);
                im.save(exportPath);
                im.save(exportPathPng,opt);
            
       //ExEnd:RenderingOfRotatedTextLayer
    }
}
