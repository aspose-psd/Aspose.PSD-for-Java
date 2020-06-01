package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.ResourceBlock;
import com.aspose.psd.fileformats.psd.resources.BorderInformationResource;
import com.aspose.psd.fileformats.psd.resources.resolutionenums.PhysicalUnit;

/**
 * An example of reading, modifying and saving a PSD file that contains a border information
 * resource.
 */
public class SupportBorderInformationResource
{
	public static void main(String[] args)
	{
        //ExStart:SupportBorderInformationResource
		String sourceDir = Utils.GetDataDir_PSD();
		String outputDir = Utils.GetDataDir_Output();

		String inPsdFilePath = sourceDir + "SupportBorderInformationResource.psd";
		String outPsdFilePath = outputDir + "SupportBorderInformationResource_output.psd";
		
		// Load a PSD file containing a predefined image resource
		PsdImage psdImage = (PsdImage)Image.load(inPsdFilePath);
		try
		{
		    ResourceBlock[] imageResources = psdImage.getImageResources();
		
		    // Find first border information resource in image resources
		    BorderInformationResource borderInfoResource = null;
		    for (ResourceBlock imageResource : imageResources)
		    {
		        if (imageResource instanceof BorderInformationResource)
		        {
		            borderInfoResource = (BorderInformationResource)imageResource;
		            break;
		        }
		    }
		
		    // Update some properties of the border information resource
		    borderInfoResource.setWidth(0.1);
		    borderInfoResource.setUnit(PhysicalUnit.Inches);
		
		    // Save a modified copy of loaded PSD file on the path
		    psdImage.save(outPsdFilePath);
		}
		finally
		{
		    psdImage.dispose();
		}
		//ExEnd:SupportBorderInformationResource
	}
}
