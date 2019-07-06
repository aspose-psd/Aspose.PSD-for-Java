/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;

/**
 *
 *  
 */
public class SupportBlendModes {
    
     public static void main(String[] args)  
    {
       //ExStart:SupportBlendModes
       String dataDir = Utils.getDataDir(SupportBlendModes.class) + "DrawingAndFormattingImages/";
       
       //ExStart:SupportBlendModes
	String[] files = new String[]
	  {
	       "Normal",
	       "Dissolve",
	       "Darken",
	       "Multiply",
	       "ColorBurn",
	       "LinearBurn",
	       "DarkerColor",
	       "Lighten",
	       "Screen",
	       "ColorDodge",
	       "LinearDodgeAdd",
	       "LightenColor",
	       "Overlay",
	       "SoftLight",
	       "HardLight",
	       "VividLight",
	       "LinearLight",
	       "PinLight",
	       "HardMix",
	       "Difference",
	       "Exclusion",
	       "Subtract",
	       "Divide",
	        "Hue",
	       "Saturation",
	        "Color",
	       "Luminosity",
			};
        
        for (int i=0; i< files.length; i++)
        {
            PsdImage im = (PsdImage)Image.load(dataDir + files[i] + ".psd");
            
            // Export to PNG
            PngOptions saveOptions = new PngOptions();
            saveOptions.setColorType(PngColorType.TruecolorWithAlpha);
            String pngExportPath100 = dataDir + "BlendMode" + files[i] + "_Test100.png";
            im.save(pngExportPath100, saveOptions);
            
            
            // Set opacity 50%
            im.getLayers()[1].setOpacity((byte)127);
            String pngExportPath50 = dataDir+ "BlendMode" + files[i] + "_Test50.png";
            im.save(pngExportPath50, saveOptions);
        }
            
       //ExEnd:SupportBlendModes
       
    }
}
