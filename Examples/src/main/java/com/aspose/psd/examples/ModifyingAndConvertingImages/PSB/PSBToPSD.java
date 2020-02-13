
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSB;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.FileFormatVersion;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PsdOptions;


public class PSBToPSD {
    public static void main(String[] args) 
    {
       //ExStart:PSBToPSD
       String dataDir = Utils.getDataDir(PSBToPSD.class) + "PSB/";       
       String sourceFileName = dataDir + "2layers.psb";
     
       
       PsdImage image = (PsdImage)Image.load(sourceFileName);          
       
       PsdOptions options = new PsdOptions();
       options.setFileFormatVersion(FileFormatVersion.Psd);
       
       image.save(dataDir + "ConvertFromPsb_out.psd",options);
      
       //ExEnd:PSBToPSD
       
    }

}
