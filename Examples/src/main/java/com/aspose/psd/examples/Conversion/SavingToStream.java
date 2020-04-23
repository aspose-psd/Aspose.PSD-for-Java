/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.system.io.MemoryStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 *  
 */
public class SavingtoStream {
    public static void main(String[] args) throws FileNotFoundException
    {
       //ExStart:SavingtoStream
       String dataDir = Utils.getDataDir(SavingtoStream.class) + "Conversion/";
       
       

            String sourceFile = dataDir + "sample.psd";
            String destName = dataDir + "result.png";

            // load PSD image and replace the non found fonts.
             Image image = Image.load(sourceFile);
            
            PsdImage psdImage = (PsdImage)image;
            FileOutputStream outputStream = new FileOutputStream(destName);
            psdImage.save(outputStream, new PngOptions());
            
       //ExEnd:SavingtoStream
    }
}
