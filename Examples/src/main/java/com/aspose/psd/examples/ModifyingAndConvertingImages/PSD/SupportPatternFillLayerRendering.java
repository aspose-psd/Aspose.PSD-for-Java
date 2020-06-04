package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IPatternFillSettings;
import com.aspose.psd.imageoptions.PsdOptions;

import java.util.UUID;

public class SupportPatternFillLayerRendering
{
    public static void main(String[] args)
    {
        //ExStart:SupportPatternFillLayerRendering
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String sourceFile = sourceDir + "sample.psd";
        String outputFile = outputDir + "sample_out.psd";

        // Load an existing image into an instance of PsdImage class
        PsdImage image = (PsdImage)Image.load(sourceFile);
        try
        {
            for (Layer layer : image.getLayers())
            {
                if (layer instanceof FillLayer)
                {
                    FillLayer fillLayer = (FillLayer)layer;
                    IPatternFillSettings settings = (IPatternFillSettings)fillLayer.getFillSettings();
                    settings.setHorizontalOffset(-5);
                    settings.setVerticalOffset(12);
                    settings.setScale(300);
                    settings.setLinked(true);
                    settings.setPatternData(new int[]
                            {
                                    Color.getBlack().toArgb(), Color.getRed().toArgb(),
                                    Color.getGreen().toArgb(), Color.getBlue().toArgb(),
                                    Color.getWhite().toArgb(), Color.getAliceBlue().toArgb(),
                                    Color.getViolet().toArgb(), Color.getChocolate().toArgb(),
                                    Color.getIndianRed().toArgb(), Color.getDarkOliveGreen().toArgb(),
                                    Color.getCadetBlue().toArgb(), Color.getYellowGreen().toArgb(),
                                    Color.getBlack().toArgb(), Color.getAzure().toArgb(),
                                    Color.getForestGreen().toArgb(), Color.getSienna().toArgb(),
                            });

                    settings.setPatternHeight(4);
                    settings.setPatternWidth(4);

                    settings.setPatternName("$$$/Presets/Patterns/ColorfulSquare=Colorful Square New\0");
                    settings.setPatternId(UUID.randomUUID() + "\0");

                    fillLayer.update();
                    break;
                }
            }

            image.save(outputFile, new PsdOptions(image));
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:SupportPatternFillLayerRendering
    }
}
