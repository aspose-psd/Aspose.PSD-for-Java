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
import com.aspose.psd.fileformats.psd.layers.fillsettings.FillType;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientColorPoint;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientFillSettings;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientTransparencyPoint;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientType;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IGradientTransparencyPoint;
import com.aspose.psd.fileformats.psd.layers.layereffects.StrokeEffect;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;

/**
 *
 *  
 */
public class AddStrokeLayerGradient {
    
    public static void main(String[] args) 
    {
       //ExStart:AddStrokeLayerGradient
       String dataDir = Utils.getDataDir(AddStrokeLayerGradient.class) + "DrawingImages/";
        // Stroke effect. FillType - Gradient. Example
        String sourceFileName = dataDir+ "Stroke.psd";
        String exportPath = dataDir+"StrokeGradientChanged.psd";
        
        PsdLoadOptions loadOptions = new PsdLoadOptions();
        loadOptions.setLoadEffectsResource(true);

           PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
           
           
    StrokeEffect gradientStroke = (StrokeEffect)im.getLayers()[2].getBlendingOptions().getEffects()[0];

                Assert.assertEquals(BlendMode.Normal, gradientStroke.getBlendMode());
                Assert.assertEquals(255, gradientStroke.getOpacity());
                Assert.assertEquals(true, gradientStroke.isVisible());

                GradientFillSettings fillSettings = (GradientFillSettings)gradientStroke.getFillSettings();
                Assert.assertEquals(Color.getBlack(), fillSettings.getColor());
                Assert.assertEquals(FillType.Gradient, fillSettings.getFillType());
                Assert.assertEquals(true, fillSettings.getAlignWithLayer());
                Assert.assertEquals(GradientType.Linear, fillSettings.getGradientType());
                Assert.assertTrue(Math.abs(90 - fillSettings.getAngle()) < 0.001, "Angle is incorrect");
                Assert.assertEquals(false, fillSettings.getDither());
                Assert.assertTrue(Math.abs(0 - fillSettings.getHorizontalOffset()) < 0.001, "Horizontal offset is incorrect");
                Assert.assertTrue(Math.abs(0 - fillSettings.getVerticalOffset()) < 0.001, "Vertical offset is incorrect");
                Assert.assertEquals(false, fillSettings.getReverse());

                // Color Points
                IGradientColorPoint[] colorPoints = fillSettings.getColorPoints();
                Assert.assertEquals(2, colorPoints.length);

                Assert.assertEquals(Color.getBlack(), colorPoints[0].getColor());
                Assert.assertEquals(0, colorPoints[0].getLocation());
                Assert.assertEquals(50, colorPoints[0].getMedianPointLocation());

                Assert.assertEquals(Color.getWhite(), colorPoints[1].getColor());
                Assert.assertEquals(4096, colorPoints[1].getLocation());
                Assert.assertEquals(50, colorPoints[1].getMedianPointLocation());

                // Transparency points
                IGradientTransparencyPoint[] transparencyPoints = fillSettings.getTransparencyPoints();
                Assert.assertEquals(2, transparencyPoints.length);

                Assert.assertEquals(0, transparencyPoints[0].getLocation());
                Assert.assertEquals(50, transparencyPoints[0].getMedianPointLocation());
                Assert.assertEquals(100, transparencyPoints[0].getOpacity());

                Assert.assertEquals(4096, transparencyPoints[1].getLocation());
                Assert.assertEquals(50, transparencyPoints[1].getMedianPointLocation());
                Assert.assertEquals(100, transparencyPoints[1].getOpacity());
                
                
                
                // Test editing
                fillSettings.setColor(Color.getGreen());

                gradientStroke.setOpacity((byte)127);
                gradientStroke.setBlendMode(BlendMode.Color);

                fillSettings.setAlignWithLayer(false);
                fillSettings.setGradientType(GradientType.Radial);
                fillSettings.setAngle(45);
                fillSettings.setDither(true);
                fillSettings.setHorizontalOffset(15);
                fillSettings.setVerticalOffset(11);
                fillSettings.setReverse(true);

                // Add new color point
                GradientColorPoint colorPoint = fillSettings.addColorPoint();
                colorPoint.setColor(Color.getGreen());
                colorPoint.setLocation(4096);
                colorPoint.setMedianPointLocation(75);

                // Change location of previous point
                fillSettings.getColorPoints()[1].setLocation(1899);

                // Add new transparency point
                GradientTransparencyPoint transparencyPoint = fillSettings.addTransparencyPoint();
                transparencyPoint.setOpacity(25);
                transparencyPoint.setMedianPointLocation(25);
                transparencyPoint.setLocation(4096);

                // Change location of previous transparency point
                fillSettings.getTransparencyPoints()[1].setLocation(2411);

                im.save(exportPath);
                
                
                // Test file after edit
                
                PsdImage img = (PsdImage)Image.load(exportPath, loadOptions);
                
    StrokeEffect gradientStrokeEffect = (StrokeEffect)img.getLayers()[2].getBlendingOptions().getEffects()[0];

                Assert.assertEquals(BlendMode.Color, gradientStrokeEffect.getBlendMode());
                Assert.assertEquals(127, gradientStrokeEffect.getOpacity());
                Assert.assertEquals(true, gradientStrokeEffect.isVisible());

                GradientFillSettings fillSetting = (GradientFillSettings)gradientStrokeEffect.getFillSettings();
                Assert.assertEquals(Color.getGreen(), fillSetting.getColor());
                Assert.assertEquals(FillType.Gradient, fillSetting.getFillType());

                // Check color points
                Assert.assertEquals(3, fillSetting.getColorPoints().length);

                IGradientColorPoint point = fillSetting.getColorPoints()[0];
                Assert.assertEquals(50, point.getMedianPointLocation());
                Assert.assertEquals(Color.getBlack(), point.getColor());
                Assert.assertEquals(0, point.getLocation());

                point = fillSettings.getColorPoints()[1];
                Assert.assertEquals(50, point.getMedianPointLocation());
                Assert.assertEquals(Color.getWhite(), point.getColor());
                Assert.assertEquals(1899, point.getLocation());

                point = fillSettings.getColorPoints()[2];
                Assert.assertEquals(75, point.getMedianPointLocation());
                Assert.assertEquals(Color.getGreen(), point.getColor());
                Assert.assertEquals(4096, point.getLocation());

                // Check transparent points
                Assert.assertEquals(3, fillSettings.getTransparencyPoints().length);

                IGradientTransparencyPoint transparencyPoint1 = fillSettings.getTransparencyPoints()[0];
                Assert.assertEquals(50, transparencyPoint1.getMedianPointLocation());
                Assert.assertEquals(100, transparencyPoint1.getOpacity());
                Assert.assertEquals(0, transparencyPoint1.getLocation());

                transparencyPoint1 = fillSettings.getTransparencyPoints()[1];
                Assert.assertEquals(50, transparencyPoint.getMedianPointLocation());
                Assert.assertEquals(100, transparencyPoint.getOpacity());
                Assert.assertEquals(2411, transparencyPoint.getLocation());

                transparencyPoint1 = fillSettings.getTransparencyPoints()[2];
                Assert.assertEquals(25, transparencyPoint.getMedianPointLocation());
                Assert.assertEquals(25, transparencyPoint.getOpacity());
                Assert.assertEquals(4096, transparencyPoint.getLocation());
       //ExEnd:AddStrokeLayerGradient
    
    }
}
