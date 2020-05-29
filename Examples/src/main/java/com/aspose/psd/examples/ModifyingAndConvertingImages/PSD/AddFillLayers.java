package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.psd.fileformats.psd.layers.fillsettings.FillType;

/**
 * An example of adding fill layers of different types to a Photoshop document.
 */
public class AddFillLayers
{
    public static void main(String[] args)
    {
        String outputDir = Utils.GetDataDir_Output();
        String outPsdFilePath = outputDir + "output.psd";

        // Create a Photoshop document with an empty canvas
        PsdImage psdImage = new PsdImage(100, 100);
        try
        {
            // Add fill layers of different types to PSD
            FillLayer colorFillLayer = FillLayer.createInstance(FillType.Color);
            colorFillLayer.setDisplayName("Color Fill Layer");
            psdImage.addLayer(colorFillLayer);

            FillLayer gradientFillLayer = FillLayer.createInstance(FillType.Gradient);
            gradientFillLayer.setDisplayName("Gradient Fill Layer");
            psdImage.addLayer(gradientFillLayer);

            FillLayer patternFillLayer = FillLayer.createInstance(FillType.Pattern);
            patternFillLayer.setDisplayName("Pattern Fill Layer");
            patternFillLayer.setOpacity((byte)50);
            psdImage.addLayer(patternFillLayer);

            // Save a modified copy of loaded PSD file on the path
            psdImage.save(outPsdFilePath);
        }
        finally
        {
            psdImage.dispose();
        }
    }
}
