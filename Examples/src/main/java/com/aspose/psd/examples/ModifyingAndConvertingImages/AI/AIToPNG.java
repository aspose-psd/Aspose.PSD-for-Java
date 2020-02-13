
package com.aspose.psd.examples.ModifyingAndConvertingImages.AI;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.ai.AiImage;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.imageoptions.PngOptions;


public class AIToPNG {
    
    public static void main(String[] args) 
    {
       //ExStart:AIToPNG
       String dataDir = Utils.getDataDir(AIToPNG.class) + "AI/"; 
       
       String sourceFileName    = dataDir + "34992OStroke.ai";       
       String outFileName       = dataDir + "34992OStroke.png";
       
       AiImage image = (AiImage)Image.load(sourceFileName);
       
       PngOptions options = new PngOptions();
       options.setColorType(PngColorType.TruecolorWithAlpha);
       
       image.save(outFileName, options);
       //ExEnd:AIToPNG
    }

}
