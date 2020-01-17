
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.psd.fileformats.psd.layers.layerresources.SoCoResource;


public class SupportOfSoCoResource {

    public static void main(String[] args) throws Exception 
    {
       //ExStart:SupportOfSoCoResource
       String dataDir = Utils.getDataDir(SupportOfSoCoResource.class) + "ModifyingAndConvertingImages/";
       
       
       String sourceFileName = dataDir + "ColorFillLayer.psd";
        String exportPath = dataDir + "SoCoResource_Edited.psd";

        PsdImage im = (PsdImage) Image.load(sourceFileName);

        try
        {
            for (Layer layer : im.getLayers())
            {
                if (layer instanceof FillLayer)
                {
                    FillLayer fillLayer = (FillLayer)layer;
                    for (LayerResource resource : fillLayer.getResources())
                    {
                        if (resource instanceof SoCoResource)
                        {
                            SoCoResource socoResource = (SoCoResource)resource;
                            assert Color.fromArgb(63, 83, 141).equals(socoResource.getColor());
                            socoResource.setColor(Color.getRed());
                            break;
                        }
                    }
                    break;
                }
                im.save(exportPath);
            }
        }
        finally
        {
            im.dispose();
        }
       //ExEnd:SupportOfSoCoResource
    }
}
