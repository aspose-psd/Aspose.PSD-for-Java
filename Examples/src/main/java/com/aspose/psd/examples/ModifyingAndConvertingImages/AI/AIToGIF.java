
package com.aspose.psd.examples.ModifyingAndConvertingImages.AI;

import com.aspose.psd.Image;
import com.aspose.psd.ImageOptionsBase;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.ai.AiImage;
import com.aspose.psd.imageoptions.GifOptions;


public class AIToGIF {

     public static void main(String[] args) 
    {
       //ExStart:AIToGIF
       String dataDir = Utils.getDataDir(AIToGIF.class) + "AI/"; 
       
       String sourceFileName    = dataDir + "34992OStroke.ai";       
       String outFileName       = dataDir + "34992OStroke.gif";
       
       AiImage image = (AiImage)Image.load(sourceFileName);
       
       GifOptions options = new GifOptions();
       options.setDoPaletteCorrection(false);
       image.save(outFileName, options);
       //ExEnd:AIToGIF
    }
}
