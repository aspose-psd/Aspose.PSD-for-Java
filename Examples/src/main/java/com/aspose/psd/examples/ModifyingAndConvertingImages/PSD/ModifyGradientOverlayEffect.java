package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.BlendMode;
import com.aspose.psd.fileformats.psd.layers.IGradientColorPoint;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientColorPoint;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientFillSettings;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientType;
import com.aspose.psd.fileformats.psd.layers.layereffects.BlendingOptions;
import com.aspose.psd.fileformats.psd.layers.layereffects.GradientOverlayEffect;
import com.aspose.psd.fileformats.psd.layers.layereffects.ILayerEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 * An example of applying the gradient overlay effect for an image layer.
 */
public class ModifyGradientOverlayEffect
{
	public static void main(String[] args)
	{
        //ExStart:ModifyGradientOverlayEffect
		String sourceDir = Utils.GetDataDir_PSD();
		String outputDir = Utils.GetDataDir_Output();

		String inPsdFilePath = sourceDir + "psdnet256.psd";
		String outPsdFilePath = outputDir + "psdnet256.psd_output.psd";
		
		// Support layer effects, if any
		PsdLoadOptions psdLoadOptions = new PsdLoadOptions();
		psdLoadOptions.setLoadEffectsResource(true);
		
		// Load a PSD file containing an image
		PsdImage psdImage = (PsdImage)Image.load(inPsdFilePath, psdLoadOptions);
		try
		{
		    BlendingOptions layerBlendOptions = psdImage.getLayers()[1].getBlendingOptions();
		
		    // Search GradientOverlayEffect in a layer
		    GradientOverlayEffect gradientOverlayEffect = null;
		    for (ILayerEffect effect : layerBlendOptions.getEffects())
		    {
		        gradientOverlayEffect = (GradientOverlayEffect)effect;
		        if (gradientOverlayEffect != null)
		        {
		            break;
		        }
		    }
		
		    if (gradientOverlayEffect == null)
		    {
		        // Create a new GradientOverlayEffect if it not exists
		        gradientOverlayEffect = layerBlendOptions.addGradientOverlay();
		    }
		
		    // Add a bit of transparency to the effect
		    gradientOverlayEffect.setOpacity((byte)200);
		
		    // Change the blend mode of gradient effect
		    gradientOverlayEffect.setBlendMode(BlendMode.Hue);
		
		    // Get GradientFillSettings object to configure gradient overlay settings
		    GradientFillSettings settings = gradientOverlayEffect.getSettings();
		
		    // Set a new gradient with two colors
		    settings.setColorPoints(new IGradientColorPoint[]
		            {
		                    new GradientColorPoint(Color.getGreenYellow(), 0, 50),
		                    new GradientColorPoint(Color.getBlueViolet(), 4096, 50),
		            });
		
		    // Set an inclination of the gradient at an angle of 80 degrees
		    settings.setAngle(80);
		
		    // Scale gradient effect up to 150%
		    settings.setScale(150);
		
		    // Set type of gradient
		    settings.setGradientType(GradientType.Linear);
		
		    // Make the gradient opaque by setting the opacity to 100% at each transparency point
		    settings.getTransparencyPoints()[0].setOpacity(100);
		    settings.getTransparencyPoints()[1].setOpacity(100);
		
		    psdImage.save(outPsdFilePath);
		}
		finally
		{
		    psdImage.dispose();
		}
		//ExEnd:ModifyGradientOverlayEffect
	}
}
