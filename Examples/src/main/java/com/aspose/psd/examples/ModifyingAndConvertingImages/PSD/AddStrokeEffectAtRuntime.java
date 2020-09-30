package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.fillsettings.FillType;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IColorFillSettings;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IGradientFillSettings;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IPatternFillSettings;
import com.aspose.psd.fileformats.psd.layers.layereffects.StrokeEffect;
import com.aspose.psd.fileformats.psd.layers.layereffects.StrokePosition;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.PngOptions;

/**
 * This example shows how to add a stroke effect (border) to existing layers of PSD file in Java. There are three types
 * of the stroke: color, gradient and pattern. Each of the type has three ways (positions) in which the stroke is
 * rendered: inside, center and outside. This example demonstrates usage of all these cases.
 */
public class AddStrokeEffectAtRuntime
{
    public static void main(String[] args)
    {
        String dataDir = Utils.getDataDir(AddStrokeEffectAtRuntime.class) + "ModifyingAndConvertingImages/PSD/AddStrokeEffectAtRuntime/";
        String outputDir = Utils.GetDataDir_Output();
        //ExStart:AddStrokeEffectAtRuntime
        String srcPsdPath = dataDir + "StrokeEffectsSource.psd";
		String dstPngPath = outputDir + "output.png";
		
		PsdLoadOptions psdLoadOptions = new PsdLoadOptions();
		psdLoadOptions.setLoadEffectsResource(true);
		PsdImage psdImage = (PsdImage)Image.load(srcPsdPath, psdLoadOptions);
		try
		{
		    StrokeEffect strokeEffect;
		    IColorFillSettings colorFillSettings;
		    IGradientFillSettings gradientFillSettings;
		    IPatternFillSettings patternFillSettings;
		
		    // 1. Adds Color fill, at position Inside
		    strokeEffect = psdImage.getLayers()[1].getBlendingOptions().addStroke(FillType.Color);
		    strokeEffect.setSize(7);
		    strokeEffect.setPosition(StrokePosition.Inside);
		    colorFillSettings = (IColorFillSettings)strokeEffect.getFillSettings();
		    colorFillSettings.setColor(Color.getGreen());
		
		    // 2. Adds Color fill, at position Outside
		    strokeEffect = psdImage.getLayers()[2].getBlendingOptions().addStroke(FillType.Color);
		    strokeEffect.setSize(7);
		    strokeEffect.setPosition(StrokePosition.Outside);
		    colorFillSettings = (IColorFillSettings)strokeEffect.getFillSettings();
		    colorFillSettings.setColor(Color.getGreen());
		
		    // 3. Adds Color fill, at position Center
		    strokeEffect = psdImage.getLayers()[3].getBlendingOptions().addStroke(FillType.Color);
		    strokeEffect.setSize(7);
		    strokeEffect.setPosition(StrokePosition.Center);
		    colorFillSettings = (IColorFillSettings)strokeEffect.getFillSettings();
		    colorFillSettings.setColor(Color.getGreen());
		
		    // 4. Adds Gradient fill, at position Inside
		    strokeEffect = psdImage.getLayers()[4].getBlendingOptions().addStroke(FillType.Gradient);
		    strokeEffect.setSize(5);
		    strokeEffect.setPosition(StrokePosition.Inside);
		    gradientFillSettings = (IGradientFillSettings)strokeEffect.getFillSettings();
		    gradientFillSettings.setAlignWithLayer(false);
		    gradientFillSettings.setAngle(90);
		
		    // 5. Adds Gradient fill, at position Outside
		    strokeEffect = psdImage.getLayers()[5].getBlendingOptions().addStroke(FillType.Gradient);
		    strokeEffect.setSize(5);
		    strokeEffect.setPosition(StrokePosition.Outside);
		    gradientFillSettings = (IGradientFillSettings)strokeEffect.getFillSettings();
		    gradientFillSettings.setAlignWithLayer(true);
		    gradientFillSettings.setAngle(90);
		
		    // 6. Adds Gradient fill, at position Center
		    strokeEffect = psdImage.getLayers()[6].getBlendingOptions().addStroke(FillType.Gradient);
		    strokeEffect.setSize(5);
		    strokeEffect.setPosition(StrokePosition.Center);
		    gradientFillSettings = (IGradientFillSettings)strokeEffect.getFillSettings();
		    gradientFillSettings.setAlignWithLayer(true);
		    gradientFillSettings.setAngle(0);
		
		    // 7. Adds Pattern fill, at position Inside
		    strokeEffect = psdImage.getLayers()[7].getBlendingOptions().addStroke(FillType.Pattern);
		    strokeEffect.setSize(5);
		    strokeEffect.setPosition(StrokePosition.Inside);
		    patternFillSettings = (IPatternFillSettings)strokeEffect.getFillSettings();
		    patternFillSettings.setScale(200);
		
		    // 8. Adds Pattern fill, at position Outside
		    strokeEffect = psdImage.getLayers()[8].getBlendingOptions().addStroke(FillType.Pattern);
		    strokeEffect.setSize(10);
		    strokeEffect.setPosition(StrokePosition.Outside);
		    patternFillSettings = (IPatternFillSettings)strokeEffect.getFillSettings();
		    patternFillSettings.setScale(100);
		
		    // 9. Adds Pattern fill, at position Center
		    strokeEffect = psdImage.getLayers()[9].getBlendingOptions().addStroke(FillType.Pattern);
		    strokeEffect.setSize(10);
		    strokeEffect.setPosition(StrokePosition.Center);
		    patternFillSettings = (IPatternFillSettings)strokeEffect.getFillSettings();
		    patternFillSettings.setScale(75);
		
		    psdImage.save(dstPngPath, new PngOptions());
		}
		finally
		{
		    psdImage.dispose();
		}
		//ExEnd:AddStrokeEffectAtRuntime
    }
}
