/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PNG;

import com.aspose.psd.Image;
import com.aspose.psd.ResolutionSetting;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 * @author mfazi
 */
public class SettingResolution {
     public static void main(String[] args) 
    {
       //ExStart:SettingResolution
       String dataDir = Utils.getDataDir(SettingResolution.class) + "ModifyingAndConvertingImages/";
       
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "sample.psd");
       
        // Create an instance of PngOptions, Set the horizontal & vertical resolutions and Save the result on disc
        PngOptions options = new PngOptions();
        options.setResolutionSettings(new ResolutionSetting(72, 96));
        psdImage.save(dataDir+"SettingResolution_output.png", options);
       //ExEnd:SettingResolution
    }
}
