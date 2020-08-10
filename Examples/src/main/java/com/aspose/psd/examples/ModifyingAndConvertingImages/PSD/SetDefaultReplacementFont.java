package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.psd.imageoptions.JpegOptions;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.TiffOptions;

/**
 * This example demonstrates how to set a Default Replacement Font during saving the image. The program applies
 * different default font replacements for different output files.
 */
public class SetDefaultReplacementFont
{
    public static void main(String[] args)
    {
		String dataDir = Utils.getResourcesDir() + "/ModifyingAndConvertingImages/PSD/SetDefaultReplacementFont/";
		String outputDir = Utils.GetDataDir_Output();
        //ExStart:SetDefaultReplacementFont
        // Please, don't install Konstanting Font, because this test should replace font that is not installed
		String srcPsdPath = dataDir + "sample_konstanting.psd";
		String[] dstPaths = new String[]
		        {
		                "replacedfont0.tiff",
		                "replacedfont1.png",
		                "replacedfont2.jpg"
		        };
		
		// Load a PSD that require a font that is not installed
		PsdImage image = (PsdImage)Image.load(srcPsdPath);
		try
		{
		    // This way you can use different fonts for different outputs
		    image.save(outputDir + dstPaths[0], new TiffOptions(TiffExpectedFormat.TiffJpegRgb));
		
		    PngOptions pngOptions = new PngOptions();
		    pngOptions.setDefaultReplacementFont("Verdana");
		    image.save(outputDir + dstPaths[1], pngOptions);
		
		    JpegOptions jpegOptions = new JpegOptions();
		    jpegOptions.setDefaultReplacementFont("Times New Roman");
		    image.save(outputDir + dstPaths[2], jpegOptions);
		}
		finally
		{
		    image.dispose();
		}
        //ExEnd:SetDefaultReplacementFont
    }
}
