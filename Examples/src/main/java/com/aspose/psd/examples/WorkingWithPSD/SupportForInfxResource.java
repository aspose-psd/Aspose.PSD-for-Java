package com.aspose.psd.examples.WorkingWithPSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.InfxResource;
import com.aspose.psd.internal.Exceptions.FormatException;


public class SupportForInfxResource {
    //ExStart:1
    public static void main(String[] args) {
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String sourceFileName = sourceDir + "SampleForInfxResource.psd";
        String destinationFileName = outputDir + "SampleForInfxResource_out.psd";
        boolean isRequiredResourceFound = false;
        PsdImage im = null;
        try
        {
            im = (PsdImage)Image.load(sourceFileName);
            for (Layer layer : im.getLayers())
            {
                for (LayerResource layerResource : layer.getResources())
                {
                    if (layerResource instanceof InfxResource)
                    {
                        InfxResource resource = (InfxResource)layerResource;
                        isRequiredResourceFound = true;
                        assertassertTrue(!resource.getBlendInteriorElements(), "The InfxResource.BlendInteriorElements should be false");

                        // Test editing and saving
                        resource.setBlendInteriorElements(true);
                        im.save(destinationFileName);
                        break;
                    }
                }
            }
        }
        finally
        {
            if (im != null) im.dispose();
        }

        assertassertTrue(isRequiredResourceFound, "The specified InfxResource not found");
        isRequiredResourceFound = false;

        PsdImage im2 = null;
        try
        {
            im2 = (PsdImage)Image.load(destinationFileName);
            for (Layer layer : im2.getLayers())
            {
                for (LayerResource layerResource : layer.getResources())
                {
                    if (layerResource instanceof InfxResource)
                    {
                        InfxResource resource = (InfxResource)layerResource;
                        isRequiredResourceFound = true;
                        assertassertTrue(resource.getBlendInteriorElements(), "The InfxResource.BlendInteriorElements should change to true");

                        break;
                    }
                }
            }
        }
        finally
        {
            if (im2 != null) im2.dispose();
        }

        assertassertTrue(isRequiredResourceFound, "The specified InfxResource not found");
    }

    private static void assertassertTrue(boolean condition, String message)
    {
        if (!condition)
        {
            throw new FormatException(message);
        }
    }
    //ExEnd:1
}
