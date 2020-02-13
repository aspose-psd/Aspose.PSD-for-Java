
package com.aspose.psd.examples.ModifyingAndConvertingImages.AI;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.ai.AiImage;
import com.aspose.psd.imageoptions.PsdOptions;


public class AIToPSD {
    
    public static void main(String[] args) 
    {
       //ExStart:AIToPSD
       String dataDir = Utils.getDataDir(AIToPSD.class) + "AI/"; 
       
       String sourceFileName    = dataDir + "34992OStroke.ai";       
       String outFileName       = dataDir + "34992OStroke.psd";
       
       AiImage image = (AiImage)Image.load(sourceFileName);
       
       PsdOptions options = new PsdOptions();
             
       image.save(outFileName, options);
       //ExEnd:AIToPSD
    }

}
