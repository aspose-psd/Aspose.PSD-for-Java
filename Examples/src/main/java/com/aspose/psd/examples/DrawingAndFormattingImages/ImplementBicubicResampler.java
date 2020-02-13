
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Image;
import com.aspose.psd.ResizeType;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PsdOptions;


public class ImplementBicubicResampler {

    public static void main(String[] args) 
    {
       //ExStart:ImplementBicubicResampler
       String dataDir = Utils.getDataDir(ImplementBicubicResampler.class) + "DrawingAndFormattingImages/";
       
       String filePath = dataDir + "sample_bicubic.psd";
       String destNameCubicConvolution = dataDir + "ResamplerCubicConvolutionStripes_after.psd";
    
       PsdImage image = (PsdImage)Image.load(filePath);       
       image.resize(300, 300, ResizeType.CubicConvolution);
       image.save(destNameCubicConvolution, new PsdOptions(image));
       
       
       String destNameBell = dataDir +"ResamplerBellStripes_after.psd";
       PsdImage imageBellStripes = (PsdImage)Image.load(filePath);       
       imageBellStripes.resize(300, 300, ResizeType.Bell);
       imageBellStripes.save(destNameCubicConvolution, new PsdOptions(imageBellStripes));
       
       
        //ExEnd:ImplementBicubicResampler
    }
}
