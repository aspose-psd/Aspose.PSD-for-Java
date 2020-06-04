/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.BlendMode;
import com.aspose.psd.fileformats.psd.layers.fillsettings.FillType;
import com.aspose.psd.fileformats.psd.layers.fillsettings.PatternFillSettings;
import com.aspose.psd.fileformats.psd.layers.layereffects.PatternOverlayEffect;
import com.aspose.psd.fileformats.psd.layers.layerresources.PattResource;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

import java.util.UUID;

/**
 *
 */
public class AddPatternEffects
{
    public static void main(String[] args)
    {
        //ExStart:AddPatternEffects
        String dataDir = Utils.getDataDir(AddPatternEffects.class) + "DrawingImages/";

        // Pattern overlay effect. Example
        String sourceFileName = dataDir + "PatternOverlay.psd";
        String exportPath = dataDir + "PatternOverlayChanged.psd";

        int[] newPattern = new int[]
                {
                        Color.getAqua().toArgb(), Color.getRed().toArgb(), Color.getRed().toArgb(), Color.getAqua().toArgb(),
                        Color.getAqua().toArgb(), Color.getWhite().toArgb(), Color.getWhite().toArgb(), Color.getAqua().toArgb(),

                };

        Rectangle newPatternBounds = new Rectangle(0, 0, 4, 2);
        UUID guid = UUID.randomUUID();
        String newPatternName = "$$$/Presets/Patterns/Pattern=Some new pattern name\0";

        PsdLoadOptions loadOptions = new PsdLoadOptions();
        loadOptions.setLoadEffectsResource(true);

        PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);

        PatternOverlayEffect patternOverlay = (PatternOverlayEffect)im.getLayers()[1].getBlendingOptions().getEffects()[0];
        Assert.areEqual(BlendMode.Normal, patternOverlay.getBlendMode());
        Assert.areEqual(127, patternOverlay.getOpacity());
        Assert.areEqual(true, patternOverlay.isVisible());

        PatternFillSettings settings = patternOverlay.getSettings();
        Assert.areEqual(Color.getEmpty(), settings.getColor());
        Assert.areEqual(FillType.Pattern, settings.getFillType());
        Assert.areEqual("85163837-eb9e-5b43-86fb-e6d5963ea29a\0", settings.getPatternId());
        Assert.areEqual("$$$/Presets/Patterns/OpticalSquares=Optical Squares\0", settings.getPatternName());
        Assert.areEqual(null, settings.getPointType());
        Assert.areEqual(100, settings.getScale());

        Assert.areEqual(false, settings.getLinked());
        Assert.isTrue(Math.abs(0 - settings.getHorizontalOffset()) < 0.001, "Horizontal offset is incorrect");
        Assert.isTrue(Math.abs(0 - settings.getVerticalOffset()) < 0.001, "Vertical offset is incorrect");

        // Test editing
        settings.setColor(Color.getGreen());

        patternOverlay.setOpacity((byte)193);
        patternOverlay.setBlendMode(BlendMode.Difference);
        settings.setHorizontalOffset(15);
        settings.setVerticalOffset(11);

        PattResource resource;

        for (int i = 0; i < im.getGlobalLayerResources().length; i++)
        {
            if (im.getGlobalLayerResources()[i] instanceof PattResource)
            {
                resource = (PattResource)im.getGlobalLayerResources()[i];
                resource.setPatternId(guid.toString());
                resource.setName(newPatternName);
                resource.setPattern(newPattern, newPatternBounds);
            }
        }

        settings.setPatternName(newPatternName);

        settings.setPatternId(guid.toString() + "\0");
        im.save(exportPath);

        // Test file after edit
        PsdImage img = (PsdImage)Image.load(sourceFileName, loadOptions);

        PatternOverlayEffect patternOverlayEffect = (PatternOverlayEffect)img.getLayers()[1].getBlendingOptions().getEffects()[0];
        try
        {
            Assert.areEqual(BlendMode.Difference, patternOverlayEffect.getBlendMode());
            Assert.areEqual(193, patternOverlayEffect.getOpacity());
            Assert.areEqual(true, patternOverlayEffect.isVisible());

            PatternFillSettings fillSetting = patternOverlayEffect.getSettings();
            Assert.areEqual(Color.getEmpty(), fillSetting.getColor());
            Assert.areEqual(FillType.Pattern, fillSetting.getFillType());

            PattResource resources = null;

            for (int i = 0; i < img.getGlobalLayerResources().length; i++)
            {
                if (img.getGlobalLayerResources()[i] instanceof PattResource)
                {
                    resources = (PattResource)img.getGlobalLayerResources()[i];

                }
            }

            // Check the pattern data
            Assert.areEqual(newPattern, resources.getPatternData());
            Assert.areEqual(newPatternBounds, new Rectangle(0, 0, resources.getWidth(), resources.getHeight()));
            Assert.areEqual(guid.toString(), resources.getPatternId());
            Assert.areEqual(newPatternName, resources.getName());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        //ExEnd:AddPatternEffects         
    }
}
