/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 */
public class FontReplacement
{
    public static void main(String[] args)
    {
        //ExStart:FontReplacement
        String dataDir = Utils.getDataDir(FontReplacement.class) + "DrawingAndFormattingImages/";

        // Load an image in an instance of image and setting default replacement font.
        PsdLoadOptions psdLoadOptions = new PsdLoadOptions();

        PsdImage psdImage = (PsdImage)Image.load(dataDir + "Cloud_AzPlat_Banner3A_SB_EN_US_160x600_chinese_font.psd", psdLoadOptions);

        PngOptions pngOptions = new PngOptions();
        pngOptions.setDefaultReplacementFont("Arial");
        psdImage.save(dataDir + "replaced_font.png", pngOptions);


        //ExEnd:FontReplacement
    }
}
