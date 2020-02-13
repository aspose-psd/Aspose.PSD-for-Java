
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;


public class InvertAdjustmentLayer {
        
    public static void main(String[] args) 
    {
       //ExStart:InvertAdjustmentLayer
       String dataDir = Utils.getDataDir(InvertAdjustmentLayer.class) + "DrawingAndFormattingImages/";
       
       String filePath = dataDir + "InvertStripes_before.psd";
       String outputPath = dataDir +  "InvertStripes_after.psd";
       
       PsdImage im = (PsdImage)Image.load(filePath);
       
       im.addInvertAdjustmentLayer();
       im.save(outputPath);
       //ExEnd:InvertAdjustmentLayer
    }

}
