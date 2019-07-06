/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.imageoptions.TiffOptions;

/**
 *
 *  
 */
public class CMYKPSDtoCMYKTiff {
    
    public static void main(String[] args) 
    {
       //ExStart:CMYKPSDtoCMYKTiff
       String dataDir = Utils.getDataDir(CMYKPSDtoCMYKTiff.class) + "Conversion/";
       
       String sourceFile = dataDir + "sample.psd";
       String destName = dataDir + "output.tiff";
       
       Image image = Image.load(sourceFile);
       image.save(destName, new TiffOptions(TiffExpectedFormat.TiffLzwCmyk));
       //ExEnd:CMYKPSDtoCMYKTiff
    }
}
