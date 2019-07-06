/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PNG;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngFilterType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 * @author mfazi
 */
public class ApplyFilterMethod {
    public static void main(String[] args) 
    {
       //ExStart:ApplyFilterMethod
       String dataDir = Utils.getDataDir(ApplyFilterMethod.class) + "ModifyingAndConvertingImages/";
       
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
       
       // Create an instance of PngOptions, Set the PNG filter method and Save changes to the disc
                PngOptions options = new PngOptions();
                options.setFilterType(PngFilterType.Paeth);
                psdImage.save(dataDir+"ApplyFilterMethod_out.png", options);
       //ExEnd:ApplyFilterMethod
    }
}
