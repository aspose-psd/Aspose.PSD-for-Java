/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingImages;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.BlendMode;
import com.aspose.psd.fileformats.psd.layers.IGradientColorPoint;
import com.aspose.psd.fileformats.psd.layers.fillsettings.*;
import com.aspose.psd.fileformats.psd.layers.layereffects.GradientOverlayEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 *
 */
public class AddGradientEffects
{
    public static void main(String[] args)
    {
        //ExStart:AddGradientEffects
        String dataDir = Utils.getDataDir(AddGradientEffects.class) + "DrawingImages/";

        // Gradient overlay effect. Example
        String sourceFileName = dataDir + "GradientOverlay.psd";
        String exportPath = dataDir + "GradientOverlayChanged.psd";

        PsdLoadOptions loadOptions = new PsdLoadOptions();
        loadOptions.setLoadEffectsResource(true);

        PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);

        GradientOverlayEffect gradientOverlay = (GradientOverlayEffect)im.getLayers()[1].getBlendingOptions().getEffects()[0];

        Assert.assertEquals(BlendMode.Normal, gradientOverlay.getBlendMode());
        Assert.assertEquals(255, gradientOverlay.getOpacity());
        Assert.assertEquals(true, gradientOverlay.isVisible());

        GradientFillSettings settings = gradientOverlay.getSettings();
        Assert.assertEquals(Color.getEmpty(), settings.getColor());
        Assert.assertEquals(FillType.Gradient, settings.getFillType());
        Assert.assertEquals(true, settings.getAlignWithLayer());
        Assert.assertEquals(GradientType.Linear, settings.getGradientType());
        Assert.assertTrue(Math.abs(33 - settings.getAngle()) < 0.001, "Angle is incorrect");
        Assert.assertEquals(false, settings.getDither());
        Assert.assertEquals(Math.abs(129 - settings.getHorizontalOffset()) < 0.001, "Horizontal offset is incorrect");
        Assert.assertTrue(Math.abs(156 - settings.getVerticalOffset()) < 0.001, "Vertical offset is incorrect");
        Assert.assertEquals(false, settings.getReverse());

        // Color Points
        IGradientColorPoint[] colorPoints = settings.getColorPoints();
        Assert.assertEquals(3, colorPoints.length);

        Assert.assertEquals(Color.fromArgb(9, 0, 178), colorPoints[0].getColor());
        Assert.assertEquals(0, colorPoints[0].getLocation());
        Assert.assertEquals(50, colorPoints[0].getMedianPointLocation());

        Assert.assertEquals(Color.getRed(), colorPoints[1].getColor());
        Assert.assertEquals(2048, colorPoints[1].getLocation());
        Assert.assertEquals(50, colorPoints[1].getMedianPointLocation());

        Assert.assertEquals(Color.fromArgb(255, 252, 0), colorPoints[2].getColor());
        Assert.assertEquals(4096, colorPoints[2].getLocation());
        Assert.assertEquals(50, colorPoints[2].getMedianPointLocation());

        // Transparency points
        IGradientTransparencyPoint[] transparencyPoints = settings.getTransparencyPoints();
        Assert.assertEquals(2, transparencyPoints.length);

        Assert.assertEquals(0, transparencyPoints[0].getLocation());
        Assert.assertEquals(50, transparencyPoints[0].getMedianPointLocation());
        Assert.assertEquals(100, transparencyPoints[0].getOpacity());

        Assert.assertEquals(4096, transparencyPoints[1].getLocation());
        Assert.assertEquals(50, transparencyPoints[1].getMedianPointLocation());
        Assert.assertEquals(100, transparencyPoints[1].getOpacity());

        // Test editing
        settings.setColor(Color.getGreen());

        gradientOverlay.setOpacity((byte)193);
        gradientOverlay.setBlendMode(BlendMode.Lighten);

        settings.setAlignWithLayer(false);
        settings.setGradientType(GradientType.Radial);
        settings.setAngle(45);
        settings.setDither(true);
        settings.setHorizontalOffset(15);
        settings.setVerticalOffset(11);
        settings.setReverse(true);

        // Add new color point
        GradientColorPoint colorPoint = settings.addColorPoint();
        colorPoint.setColor(Color.getGreen());
        colorPoint.setLocation(4096);
        colorPoint.setMedianPointLocation(75);

        // Change location of previous point
        settings.getColorPoints()[2].setLocation(3000);

        // Add new transparency point
        GradientTransparencyPoint transparencyPoint = settings.addTransparencyPoint();
        transparencyPoint.setOpacity(25);
        transparencyPoint.setMedianPointLocation(25);
        transparencyPoint.setLocation(4096);

        // Change location of previous transparency point
        settings.getTransparencyPoints()[1].setLocation(2315);
        im.save(exportPath);

        // Test file after edit
        PsdImage img = (PsdImage)Image.load(sourceFileName, loadOptions);

        GradientOverlayEffect gradientOverlayEffect = (GradientOverlayEffect)img.getLayers()[1].getBlendingOptions().getEffects()[0];
        Assert.assertEquals(BlendMode.Lighten, gradientOverlayEffect.getBlendMode());
        Assert.assertEquals(193, gradientOverlayEffect.getOpacity());
        Assert.assertEquals(true, gradientOverlayEffect.isVisible());

        GradientFillSettings fillSettings = gradientOverlayEffect.getSettings();
        Assert.assertEquals(Color.getEmpty(), fillSettings.getColor());
        Assert.assertEquals(FillType.Gradient, fillSettings.getFillType());

        // Check color points
        Assert.assertEquals(4, fillSettings.getColorPoints().length);

        IGradientColorPoint point = fillSettings.getColorPoints()[0];
        Assert.assertEquals(50, point.getMedianPointLocation());
        Assert.assertEquals(Color.fromArgb(9, 0, 178), point.getColor());
        Assert.assertEquals(0, point.getLocation());

        point = fillSettings.getColorPoints()[1];
        Assert.assertEquals(50, point.getMedianPointLocation());
        Assert.assertEquals(Color.getRed(), point.getColor());
        Assert.assertEquals(2048, point.getLocation());

        point = fillSettings.getColorPoints()[2];
        Assert.assertEquals(50, point.getMedianPointLocation());
        Assert.assertEquals(Color.fromArgb(255, 252, 0), point.getColor());
        Assert.assertEquals(3000, point.getLocation());

        // Check transparent points
        Assert.assertEquals(3, fillSettings.getTransparencyPoints().length);

        IGradientTransparencyPoint transparencyPoint1 = fillSettings.getTransparencyPoints()[0];
        Assert.assertEquals(50, transparencyPoint1.getMedianPointLocation());
        Assert.assertEquals(100, transparencyPoint1.getOpacity());
        Assert.assertEquals(0, transparencyPoint1.getLocation());

        transparencyPoint1 = fillSettings.getTransparencyPoints()[1];
        Assert.assertEquals(50, transparencyPoint.getMedianPointLocation());
        Assert.assertEquals(100, transparencyPoint.getOpacity());
        Assert.assertEquals(2315, transparencyPoint.getLocation());
        //ExEnd:AddGradientEffects
    }
}
