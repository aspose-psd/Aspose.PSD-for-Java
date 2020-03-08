package com.aspose.psd.examples.WorkingWithPSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.adjustmentlayers.BlackWhiteAdjustmentLayer;
import com.aspose.psd.fileformats.psd.layers.layerresources.BlwhResource;
import com.aspose.psd.internal.Exceptions.FormatException;


public class SupportForBlwhResource {
    //ExStart:1
    private static final String actualPropertyValueIsWrongMessage = "Expected property value is not equal to actual value";
    public static void main(String[] args) {
        exampleSupportOfBlwhResource(
                "BlackWhiteAdjustmentLayerStripesMask.psd",
                0x28,
                0x3c,
                0x28,
                0x3c,
                0x14,
                0x50,
                false,
                1,
                "\0",
                225.00045776367188,
                211.00067138671875,
                179.00115966796875,
                -1977421,
                -5925001);

        exampleSupportOfBlwhResource(
                "BlackWhiteAdjustmentLayerStripesMask2.psd",
                0x80,
                0x40,
                0x20,
                0x10,
                0x08,
                0x04,
                true,
                4,
                "\0",
                239.996337890625,
                127.998046875,
                63.9990234375,
                -1015744,
                -4963324);

        System.out.println("BlwhResource updating works as expected. Press any key.");
    }

    private static void assertIsTrue(boolean condition, String message)
    {
        if (!condition)
        {
            throw new FormatException(message);
        }
    }

    private static void exampleSupportOfBlwhResource(
            String sourceFileName,
            int reds,
            int yellows,
            int greens,
            int cyans,
            int blues,
            int magentas,
            boolean useTint,
            int bwPresetKind,
            String bwPresetFileName,
            double tintColorRed,
            double tintColorGreen,
            double tintColorBlue,
            int tintColor,
            int newTintColor)
    {
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String destinationFileName = outputDir + "Output" + sourceFileName;
        boolean isRequiredResourceFound = false;
        PsdImage im = null;
        try
        {
            im = (PsdImage)Image.load(sourceDir + sourceFileName);

            for (Layer layer : im.getLayers())
            {
                for (LayerResource layerResource : layer.getResources())
                {
                    if (layerResource instanceof BlwhResource)
                    {
                        BlwhResource blwhResource = (BlwhResource)layerResource;
                        BlackWhiteAdjustmentLayer blwhLayer = (BlackWhiteAdjustmentLayer)layer;
                        isRequiredResourceFound = true;

                        assertIsTrue(blwhResource.getReds() == reds, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getYellows() == yellows, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getGreens() == greens, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getCyans() == cyans, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getBlues() == blues, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getMagentas() == magentas, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getUseTint() == useTint, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getTintColor() == tintColor, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getBwPresetKind() == bwPresetKind, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getBlackAndWhitePresetFileName().equals(bwPresetFileName), actualPropertyValueIsWrongMessage);
                        assertIsTrue(Math.abs(blwhLayer.getTintColorRed() - tintColorRed) < 1e-6, actualPropertyValueIsWrongMessage);
                        assertIsTrue(Math.abs(blwhLayer.getTintColorGreen() - tintColorGreen) < 1e-6, actualPropertyValueIsWrongMessage);
                        assertIsTrue(Math.abs(blwhLayer.getTintColorBlue() - tintColorBlue) < 1e-6, actualPropertyValueIsWrongMessage);

                        // Test editing and saving
                        blwhResource.setReds(reds - 15);
                        blwhResource.setYellows(yellows - 15);
                        blwhResource.setGreens(greens + 15);
                        blwhResource.setCyans(cyans + 15);
                        blwhResource.setBlues(blues - 15);
                        blwhResource.setMagentas(magentas - 15);
                        blwhResource.setUseTint(!useTint);
                        blwhResource.setBwPresetKind(4);
                        blwhResource.setBlackAndWhitePresetFileName("bwPresetFileName");
                        blwhLayer.setTintColorRed(tintColorRed - 60);
                        blwhLayer.setTintColorGreen(tintColorGreen - 60);
                        blwhLayer.setTintColorBlue(tintColorBlue - 60);

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

        assertIsTrue(isRequiredResourceFound, "The specified BlwhResource not found");
        isRequiredResourceFound = false;

        PsdImage im2 = null;
        try
        {
            im2 = (PsdImage)Image.load(destinationFileName);

            for (Layer layer : im2.getLayers())
            {
                for (LayerResource layerResource : layer.getResources())
                {
                    if (layerResource instanceof BlwhResource)
                    {
                        BlwhResource blwhResource = (BlwhResource)layerResource;
                        BlackWhiteAdjustmentLayer blwhLayer = (BlackWhiteAdjustmentLayer)layer;
                        isRequiredResourceFound = true;

                        assertIsTrue(blwhResource.getReds() == reds - 15, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getYellows() == yellows - 15, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getGreens() == greens + 15, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getCyans() == cyans + 15, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getBlues() == blues - 15, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getMagentas() == magentas - 15, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getUseTint() == !useTint, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getTintColor() == newTintColor, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getBwPresetKind() == 4, actualPropertyValueIsWrongMessage);
                        assertIsTrue(blwhResource.getBlackAndWhitePresetFileName().equals("bwPresetFileName"), actualPropertyValueIsWrongMessage);
                        assertIsTrue(Math.abs(blwhLayer.getTintColorRed() - tintColorRed + 60) < 1e-6, actualPropertyValueIsWrongMessage);
                        assertIsTrue(Math.abs(blwhLayer.getTintColorGreen() - tintColorGreen + 60) < 1e-6, actualPropertyValueIsWrongMessage);
                        assertIsTrue(Math.abs(blwhLayer.getTintColorBlue() - tintColorBlue + 60) < 1e-6, actualPropertyValueIsWrongMessage);

                        break;
                    }
                }
            }
        }
        finally
        {
            if (im2 != null) im2.dispose();
        }

        assertIsTrue(isRequiredResourceFound, "The specified BlwhResource not found");
    }
    //ExEnd:1
}
