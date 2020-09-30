package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.LayerGroup;

/**
 * This example demonstrates how to add a nested layer group to PSD programmatically.
 */
public class SupportNestedLayerGroups
{
    public static void main(String[] args)
    {
		String outputDir = Utils.GetDataDir_Output();
        //ExStart:SupportNestedLayerGroups
        String dstPsdPath = outputDir + "output.psd";
		
		// Create an image with the size of 1x1 pixels to work with
		PsdImage psdImage = new PsdImage(1, 1);
		try
		{
		    // Add a parent layer group ("true" means to open the layer group on start)
		    LayerGroup group1 = psdImage.addLayerGroup("Group 1", 0, true);
		    // Add a nested layer group
		    LayerGroup group2 = group1.addLayerGroup("Group 2", 0);
		
		    if (group1.getLayers().length != 2)
		    {
		        throw new RuntimeException("Group 1 must contain two layers of Group 2.");
		    }
		
		    // Verify that there are no exceptions on saving just created layer groups
		    psdImage.save(dstPsdPath);
		}
		finally
		{
		    psdImage.dispose();
		}
        //ExEnd:SupportNestedLayerGroups
    }
}
