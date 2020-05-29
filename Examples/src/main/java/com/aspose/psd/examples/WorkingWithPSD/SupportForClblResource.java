package com.aspose.psd.examples.WorkingWithPSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.ClblResource;
import com.aspose.psd.internal.Exceptions.FormatException;


public class SupportForClblResource {
    //ExStart:1
    public static void main(String[] args) {
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String sourceFileName = sourceDir + "SampleForClblResource.psd";
        String destinationFileName = outputDir + "SampleForClblResource_out.psd";

        PsdImage im = null;
        try
        {
            im = (PsdImage)Image.load(sourceFileName);
            ClblResource resource = getClblResource(im);
            assertassertTrue(resource.getBlendClippedElements(), "The ClblResource.BlendClippedElements should be true");

            // Test editing and saving
            resource.setBlendClippedElements(false);
            im.save(destinationFileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            if (im != null) im.dispose();
        }

        PsdImage im2 = null;
        try
        {
            im2 = (PsdImage)Image.load(destinationFileName);
            ClblResource resource = getClblResource(im2);
            assertassertTrue(!resource.getBlendClippedElements(), "The ClblResource.BlendClippedElements should change to false");
        } catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            if (im2 != null) im2.dispose();
        }

        System.out.println("SupportForClblResource executed successfully");
    }

    private static void assertassertTrue(boolean condition, String message)
    {
        if (!condition)
        {
            throw new FormatException(message);
        }
    }

    private static ClblResource getClblResource(PsdImage im) throws Exception {
        for (Layer layer : im.getLayers())
        {
            for (LayerResource layerResource : layer.getResources())
            {
                if (layerResource instanceof ClblResource)
                {
                    return (ClblResource)layerResource;
                }
            }
        }

        throw new Exception("The specified ClblResource not found");
    }
    //ExEnd:1
}
