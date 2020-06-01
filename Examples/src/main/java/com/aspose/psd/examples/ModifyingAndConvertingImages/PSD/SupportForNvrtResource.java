package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.InvertAdjustmentLayer;
import com.aspose.psd.fileformats.psd.layers.layerresources.NvrtResource;

/**
 * An example of finding NvrtResource of an invert adjustment layer.
 */
public class SupportForNvrtResource
{
    public static void main(String[] args)
    {
        //ExStart:SupportForNvrtResource
        String sourceDir = Utils.GetDataDir_PSD();
        String inPsdFilePath = sourceDir + "InvertAdjustmentLayer.psd";

        NvrtResource nvrtResource = null;

        // Load a predefined PSD containing an invert adjustment layer
        PsdImage psdImage = (PsdImage)Image.load(inPsdFilePath);
        try
        {
            // Try to find a resource of the invert adjustment layer
            for (Layer layer : psdImage.getLayers())
            {
                if (layer instanceof InvertAdjustmentLayer)
                {
                    for (LayerResource layerResource : layer.getResources())
                    {
                        if (layerResource instanceof NvrtResource)
                        {
                            // The NvrtResource is found
                            nvrtResource = (NvrtResource)layerResource;
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

        Assert.isNotNull(nvrtResource);
        //ExEnd:SupportForNvrtResource
    }
}
