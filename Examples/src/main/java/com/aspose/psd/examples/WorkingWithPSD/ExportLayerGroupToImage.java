package com.aspose.psd.examples.WorkingWithPSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.LayerGroup;
import com.aspose.psd.imageoptions.PngOptions;


public class ExportLayerGroupToImage {
    public static void main(String[] args) {
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        //ExStart:1
        PsdImage psdImage = null;
        try
        {
            psdImage = (PsdImage)Image.load(sourceDir + "ExportLayerGroupToImageSample.psd");

            // folder with background
            LayerGroup bgFolder = (LayerGroup)psdImage.getLayers()[0];
            // folder with content
            LayerGroup contentFolder = (LayerGroup)psdImage.getLayers()[4];

            bgFolder.save(outputDir + "background.png", new PngOptions());
            contentFolder.save(outputDir + "content.png", new PngOptions());
        }
        finally
        {
            if (psdImage != null) psdImage.dispose();
        }
        //ExEnd:1

        System.out.println("ExportLayerGroupToImage executed successfully");
    }
}
