package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.BrightnessContrastLayer;
import com.aspose.psd.fileformats.psd.layers.layerresources.BritResource;
import com.aspose.psd.imageoptions.PsdOptions;

/**
 * This Example demonstrates how you can programmatically change the PSD Image Brightness/Contrast Layer Resource -
 * BritResource. This is a Low-Level Aspose.PSD API. You can use Brightness/Contrast Layer through its API, which will
 * be much easier, but direct PhotoShop resource editing gives you more control over the PSD file content.
 */
public class SupportBritResource
{
    public static void main(String[] args)
    {
		String dataDir = Utils.getResourcesDir() + "/ModifyingAndConvertingImages/PSD/SupportBritResource/";
		String outputDir = Utils.GetDataDir_Output();
        //ExStart:SupportBritResource
        String srcPath = dataDir + "BrightnessContrastPS6.psd";
		String dstPath = outputDir + "BrightnessContrastPS6_output.psd";
		
		// Load a Photoshop document containing a Brightness / Contrast adjustment layer
		PsdImage psdImage = (PsdImage)Image.load(srcPath);
		try
		{
		    // Search for BritResource
		    for (Layer layer : psdImage.getLayers())
		    {
		        if (layer instanceof BrightnessContrastLayer)
		        {
		            for (LayerResource layerResource : layer.getResources())
		            {
		                if (layerResource instanceof BritResource)
		                {
		                    BritResource resource = (BritResource)layerResource;
		
		                    // Verify resource properties
		                    if (resource.getBrightness() != -40 ||
		                            resource.getContrast() != 10 ||
		                            resource.getLabColor() ||
		                            resource.getMeanValueForBrightnessAndContrast() != 127)
		                    {
		                        throw new RuntimeException("BritResource was read wrong");
		                    }
		
		                    // Update resource properties
		                    resource.setBrightness((short)25);
		                    resource.setContrast((short)-14);
		                    resource.setLabColor(true);
		                    resource.setMeanValueForBrightnessAndContrast((short)200);
		
		                    // Save a copy of the updated PSD
		                    psdImage.save(dstPath, new PsdOptions());
		                    break;
		                }
		            }
		        }
		    }
		}
		finally
		{
		    psdImage.dispose();
		}
        //ExEnd:SupportBritResource
    }
}
