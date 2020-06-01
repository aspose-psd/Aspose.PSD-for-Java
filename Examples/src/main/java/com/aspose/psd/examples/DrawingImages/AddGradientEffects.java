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

        Assert.areEqual(BlendMode.Normal, gradientOverlay.getBlendMode());
        Assert.areEqual(255, gradientOverlay.getOpacity());
        Assert.areEqual(true, gradientOverlay.isVisible());

        GradientFillSettings settings = gradientOverlay.getSettings();
        Assert.areEqual(Color.getEmpty(), settings.getColor());
        Assert.areEqual(FillType.Gradient, settings.getFillType());
        Assert.areEqual(true, settings.getAlignWithLayer());
        Assert.areEqual(GradientType.Linear, settings.getGradientType());
        Assert.isTrue(Math.abs(33 - settings.getAngle()) < 0.001, "Angle is incorrect");
        Assert.areEqual(false, settings.getDither());
        Assert.areEqual(Math.abs(129 - settings.getHorizontalOffset()) < 0.001, "Horizontal offset is incorrect");
        Assert.isTrue(Math.abs(156 - settings.getVerticalOffset()) < 0.001, "Vertical offset is incorrect");
        Assert.areEqual(false, settings.getReverse());

        // Color Points
        IGradientColorPoint[] colorPoints = settings.getColorPoints();
        Assert.areEqual(3, colorPoints.length);

        Assert.areEqual(Color.fromArgb(9, 0, 178), colorPoints[0].getColor());
        Assert.areEqual(0, colorPoints[0].getLocation());
        Assert.areEqual(50, colorPoints[0].getMedianPointLocation());

        Assert.areEqual(Color.getRed(), colorPoints[1].getColor());
        Assert.areEqual(2048, colorPoints[1].getLocation());
        Assert.areEqual(50, colorPoints[1].getMedianPointLocation());

        Assert.areEqual(Color.fromArgb(255, 252, 0), colorPoints[2].getColor());
        Assert.areEqual(4096, colorPoints[2].getLocation());
        Assert.areEqual(50, colorPoints[2].getMedianPointLocation());

        // Transparency points
        IGradientTransparencyPoint[] transparencyPoints = settings.getTransparencyPoints();
        Assert.areEqual(2, transparencyPoints.length);

        Assert.areEqual(0, transparencyPoints[0].getLocation());
        Assert.areEqual(50, transparencyPoints[0].getMedianPointLocation());
        Assert.areEqual(100, transparencyPoints[0].getOpacity());

        Assert.areEqual(4096, transparencyPoints[1].getLocation());
        Assert.areEqual(50, transparencyPoints[1].getMedianPointLocation());
        Assert.areEqual(100, transparencyPoints[1].getOpacity());

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
        Assert.areEqual(BlendMode.Lighten, gradientOverlayEffect.getBlendMode());
        Assert.areEqual(193, gradientOverlayEffect.getOpacity());
        Assert.areEqual(true, gradientOverlayEffect.isVisible());

        GradientFillSettings fillSettings = gradientOverlayEffect.getSettings();
        Assert.areEqual(Color.getEmpty(), fillSettings.getColor());
        Assert.areEqual(FillType.Gradient, fillSettings.getFillType());

        // Check color points
        Assert.areEqual(4, fillSettings.getColorPoints().length);

        IGradientColorPoint point = fillSettings.getColorPoints()[0];
        Assert.areEqual(50, point.getMedianPointLocation());
        Assert.areEqual(Color.fromArgb(9, 0, 178), point.getColor());
        Assert.areEqual(0, point.getLocation());

        point = fillSettings.getColorPoints()[1];
        Assert.areEqual(50, point.getMedianPointLocation());
        Assert.areEqual(Color.getRed(), point.getColor());
        Assert.areEqual(2048, point.getLocation());

        point = fillSettings.getColorPoints()[2];
        Assert.areEqual(50, point.getMedianPointLocation());
        Assert.areEqual(Color.fromArgb(255, 252, 0), point.getColor());
        Assert.areEqual(3000, point.getLocation());

        // Check transparent points
        Assert.areEqual(3, fillSettings.getTransparencyPoints().length);

        IGradientTransparencyPoint transparencyPoint1 = fillSettings.getTransparencyPoints()[0];
        Assert.areEqual(50, transparencyPoint1.getMedianPointLocation());
        Assert.areEqual(100, transparencyPoint1.getOpacity());
        Assert.areEqual(0, transparencyPoint1.getLocation());

        transparencyPoint1 = fillSettings.getTransparencyPoints()[1];
        Assert.areEqual(50, transparencyPoint.getMedianPointLocation());
        Assert.areEqual(100, transparencyPoint.getOpacity());
        Assert.areEqual(2315, transparencyPoint.getLocation());
        //ExEnd:AddGradientEffects
    }
}
