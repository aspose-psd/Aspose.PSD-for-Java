package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.TextLayer;
import com.aspose.psd.imageoptions.PngOptions;


public class RenderTextWithDifferentColorsInTextLayer {
    public static void main(String[] args) {
        //ExStart:1
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String targetFilePath = sourceDir + "text_ethalon_different_colors.psd";
        String resultFilePath = outputDir + "RenderTextWithDifferentColorsInTextLayer_out.png";

        PsdImage psdImage = null;
        try
        {
            psdImage = (PsdImage) Image.load(targetFilePath);
            TextLayer txtLayer = (TextLayer)psdImage.getLayers()[1];
            txtLayer.getTextData().updateLayerData();
            PngOptions pngOptions = new PngOptions();
            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
            psdImage.save(resultFilePath, pngOptions);
        }
        finally
        {
            if (psdImage != null) psdImage.dispose();
        }
        //ExEnd:1

        System.out.println("RenderTextWithDifferentColorsInTextLayer executed successfully");
    }
}
