/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.JpegOptions;


public class MergePSDLayers {

 public static void main(String[] args) 
    {
       //ExStart:MergePSDLayers
       String dataDir = Utils.getDataDir(MergePSDLayers.class) + "PSD/";
       
       // Load a PSD file as an image and cast it into PsdImage
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
       
       // Create JPEG option class object, Set its properties and save image
        JpegOptions jpgOptions = new JpegOptions();
        psdImage.save(dataDir + "MergePSDlayers_output.jpg", jpgOptions);
       //ExEnd:MergePSDLayers
    }
}
