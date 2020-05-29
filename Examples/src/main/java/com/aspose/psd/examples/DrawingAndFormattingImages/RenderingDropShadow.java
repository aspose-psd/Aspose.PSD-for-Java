/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.layereffects.DropShadowEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.Color;
import com.aspose.psd.examples.Utils.Assertions;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class RenderingDropShadow {
    
    public static void main(String[] args)  
    {
       //ExStart:RenderingDropShadow
     String dataDir = Utils.getDataDir(RenderingDropShadow.class) + "DrawingAndFormattingImages/";
     
     String sourceFileName = dataDir+ "Shadow.psd";
     String pngExportPath = dataDir+"Shadowchanged1.png";
    
     PsdLoadOptions loadOptions = new PsdLoadOptions();
     loadOptions.setLoadEffectsResource(true);
    
      PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
      DropShadowEffect shadowEffect = (DropShadowEffect)(im.getLayers()[1].getBlendingOptions().getEffects()[0]);
      
     Assertions.assertEquals(Color.getBlack(), shadowEffect.getColor());
    Assertions.assertEquals(255, shadowEffect.getOpacity());
    Assertions.assertEquals(3, shadowEffect.getDistance());
    Assertions.assertEquals(7, shadowEffect.getSize());
    Assertions.assertEquals(true, shadowEffect.getUseGlobalLight());
    Assertions.assertEquals(90, shadowEffect.getAngle());
    Assertions.assertEquals(0, shadowEffect.getSpread());
    Assertions.assertEquals(0, shadowEffect.getNoise());

  // Save PNG
    PngOptions saveOptions = new PngOptions();
    saveOptions.setColorType(PngColorType.TruecolorWithAlpha) ;
    im.save(pngExportPath, saveOptions);
     //ExEnd:RenderingDropShadow
     
    }
}
