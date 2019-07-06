/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;

/**
 *
 *  
 */
public class DetectFlattenedPSD {
    public static void main(String[] args) 
    {
       //ExStart:DetectFlattenedPSD
       String dataDir = Utils.getDataDir(DetectFlattenedPSD.class) + "PSD/";
       
       // Load a PSD file as an image and cast it into PsdImage
            PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
            
                // Do processing, Get the true value if PSD is flatten and false in case the PSD is not flatten.
                System.out.println(psdImage.isFlatten());
            
       
       //ExEnd:DetectFlattenedPSD
    }
}
