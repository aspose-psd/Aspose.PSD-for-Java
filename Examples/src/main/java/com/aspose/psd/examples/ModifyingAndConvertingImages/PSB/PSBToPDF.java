
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSB;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PdfOptions;


public class PSBToPDF {

    public static void main(String[] args) 
    {
       //ExStart:PSBToPDF
       String dataDir = Utils.getDataDir(PSBToPDF.class) + "PSB/";       
       String sourceFileName = dataDir + "Simple.psb";
     
       
       PsdImage image = (PsdImage)Image.load(sourceFileName);          
       
       image.save(dataDir + "Simple_output.pdf",new PdfOptions());
      
       //ExEnd:PSBToPDF
       
    }
}
