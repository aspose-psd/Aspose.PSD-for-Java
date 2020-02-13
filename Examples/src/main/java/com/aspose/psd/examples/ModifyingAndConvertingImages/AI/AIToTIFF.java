
package com.aspose.psd.examples.ModifyingAndConvertingImages.AI;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.ai.AiImage;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.imageoptions.TiffOptions;


public class AIToTIFF {
    
    public static void main(String[] args) 
    {
       //ExStart:AIToTIFF
       String dataDir = Utils.getDataDir(AIToPSD.class) + "AI/"; 
       
       String sourceFileName    = dataDir + "34992OStroke.ai";       
       String outFileName       = dataDir + "34992OStroke.tiff";
       
       AiImage image = (AiImage)Image.load(sourceFileName);
       
             
       image.save(outFileName, new TiffOptions(TiffExpectedFormat.TiffDeflateRgba));
       //ExEnd:AIToTIFF
    }

}
