/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.TIFF;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.tiff.TiffFrame;
import com.aspose.psd.fileformats.tiff.TiffImage;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.imageoptions.TiffOptions;
import java.util.ArrayList;

/**
 *
 * @author mfazi
 */
public class ExportToMultiPageTiff {
    
     public static void main(String[] args) 
    {
       //ExStart:ExportToMultiPageTiff
       String dataDir = Utils.getDataDir(ExportToMultiPageTiff.class) + "ModifyingAndConvertingImages/";
    
       // Load a PSD file as an image and cast it into PsdImage
       PsdImage psdImage = (PsdImage)Image.load(dataDir + "layers.psd");
       
        // Initialize tiff frame list.
                ArrayList<TiffFrame> frames = new ArrayList<TiffFrame>();

                // Iterate over each layer of PsdImage and convert it to Tiff frame.
                
                
        TiffOptions options = new TiffOptions(TiffExpectedFormat.TiffLzwCmyk);
        
                for(int i=0; i < psdImage.getLayers().length; i++)
                {
                    TiffFrame frame = new TiffFrame(psdImage.getLayers()[i],options );
                    frames.add(frame);
                }

                // Create a new TiffImage with frames created earlier and save to disk.
                TiffFrame[] tiffFrames = frames.toArray(new TiffFrame[frames.size()]);  
                TiffImage tiffImage = new TiffImage(tiffFrames);
                tiffImage.save(dataDir+ "ExportToMultiPageTiff_output.tif");
       //ExEnd:ExportToMultiPageTiff
       
    }
}
