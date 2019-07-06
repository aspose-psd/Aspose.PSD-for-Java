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
import com.aspose.psd.system.io.FileMode;
import com.aspose.psd.system.io.FileStream;
import com.aspose.psd.system.io.MemoryStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author mfazi
 */
public class LoadingFromStream {
    
    public static void main(String[] args) throws FileNotFoundException
    {
       //ExStart:LoadingFromStream
       String dataDir = Utils.getDataDir(LoadingFromStream.class) + "Conversion/";
       
        String sourceFile = dataDir + "sample.psd";
        String destName = dataDir + "result.png";
                
         
         FileInputStream inputStream = new FileInputStream(sourceFile);
         Image image = Image.load(inputStream);
         
         PsdImage psdImage = (PsdImage)image;
        MemoryStream stream = new MemoryStream();
        FileOutputStream outputStream = new FileOutputStream(sourceFile);
        psdImage.save(outputStream, new PngOptions());
        
       //ExEnd:LoadingFromStream
       
    }
}
