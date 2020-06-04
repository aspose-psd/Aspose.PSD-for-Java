package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.BlendMode;
import com.aspose.psd.fileformats.psd.layers.layereffects.GradientOverlayEffect;

/**
 * An example of changing the blending mode for a gradient overlay effect.
 */
public class ChangeBlendModeInGradientOverlayEffect
{
    public static void main(String[] args)
    {
        //ExStart:ChangeBlendModeInGradientOverlayEffect
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String inPsdFilePath = sourceDir + "psdnet585.psd";
        String outPsdFilePath = outputDir + "out_psdnet585.psd";

        // Load a PSD file containing an image layer
        PsdImage psdImage = (PsdImage)Image.load(inPsdFilePath);
        try
        {
            GradientOverlayEffect gradientOverlayEffect =
                    psdImage.getLayers()[1].getBlendingOptions().addGradientOverlay();

            // Change the blend mode for the gradient overlay effect
            gradientOverlayEffect.setBlendMode(BlendMode.Subtract);

            // Save a modified copy of loaded PSD file on the path
            psdImage.save(outPsdFilePath);
        }
        finally
        {
            psdImage.dispose();
        }
        //ExEnd:ChangeBlendModeInGradientOverlayEffect
    }
}
