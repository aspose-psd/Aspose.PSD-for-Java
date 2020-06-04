package com.aspose.psd.examples.WorkingWithPSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.LspfResource;


public class SupportForLspfResource {
    //ExStart:1
    public static void main(String[] args) {
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();
        final String actualPropertyValueIsWrongMessage = "Expected property value is not equal to actual value";

        String sourceFileName = sourceDir + "SampleForLspfResource.psd";
        String destinationFileName = outputDir + "SampleForLspfResource_out.psd";
        boolean isRequiredResourceFound = false;
        PsdImage im = null;
        try
        {
            im = (PsdImage)Image.load(sourceFileName);
            for (Layer layer : im.getLayers())
            {
                for (LayerResource layerResource : layer.getResources())
                {
                    if (layerResource instanceof LspfResource)
                    {
                        LspfResource resource = (LspfResource)layerResource;

                        isRequiredResourceFound = true;

                        Assert.isTrue(!resource.isCompositeProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(!resource.isPositionProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(!resource.isTransparencyProtected(), actualPropertyValueIsWrongMessage);

                        // Test editing and saving
                        resource.setCompositeProtected(true);
                        Assert.isTrue(resource.isCompositeProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(!resource.isPositionProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(!resource.isTransparencyProtected(), actualPropertyValueIsWrongMessage);

                        resource.setCompositeProtected(false);
                        resource.setPositionProtected(true);
                        Assert.isTrue(!resource.isCompositeProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(resource.isPositionProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(!resource.isTransparencyProtected(), actualPropertyValueIsWrongMessage);

                        resource.setPositionProtected(false);
                        resource.setTransparencyProtected(true);
                        Assert.isTrue(!resource.isCompositeProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(!resource.isPositionProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(resource.isTransparencyProtected(), actualPropertyValueIsWrongMessage);

                        resource.setCompositeProtected(true);
                        resource.setPositionProtected(true);
                        resource.setTransparencyProtected(true);

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

        Assert.isTrue(isRequiredResourceFound, "The specified LspfResource not found");
        isRequiredResourceFound = false;

        PsdImage im2 = null;
        try
        {
            im2 = (PsdImage)Image.load(destinationFileName);
            for (Layer layer : im2.getLayers())
            {
                for (LayerResource layerResource : layer.getResources())
                {
                    if (layerResource instanceof LspfResource)
                    {
                        LspfResource resource = (LspfResource)layerResource;

                        isRequiredResourceFound = true;

                        Assert.isTrue(resource.isCompositeProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(resource.isPositionProtected(), actualPropertyValueIsWrongMessage);
                        Assert.isTrue(resource.isTransparencyProtected(), actualPropertyValueIsWrongMessage);

                        break;
                    }
                }
            }
        }
        finally
        {
            if (im2 != null) im2.dispose();
        }

        Assert.isTrue(isRequiredResourceFound, "The specified LspfResource not found");
        System.out.println("LspfResource updating works as expected. Press any key.");
    }
    //ExEnd:1
}
