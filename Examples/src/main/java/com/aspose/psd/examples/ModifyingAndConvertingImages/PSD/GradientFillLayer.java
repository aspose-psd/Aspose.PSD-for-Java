/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.IGradientColorPoint;
import com.aspose.psd.fileformats.psd.layers.filllayers.FillLayer;
import com.aspose.psd.fileformats.psd.layers.fillsettings.FillType;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientColorPoint;
import com.aspose.psd.fileformats.psd.layers.fillsettings.GradientTransparencyPoint;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IGradientFillSettings;
import com.aspose.psd.fileformats.psd.layers.fillsettings.IGradientTransparencyPoint;
import com.aspose.psd.imageoptions.PsdOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GradientFillLayer {
     public static void main(String[] args) throws Exception 
    {
       //ExStart:GradientFillLayer
       String dataDir = Utils.getDataDir(GradientFillLayer.class) + "PSD/";
       
        String sourceFileName = dataDir + "ComplexGradientFillLayer.psd";
        String outputFile = dataDir + "ComplexGradientFillLayer_output.psd";
        PsdImage image = (PsdImage)Image.load(sourceFileName);
        
        for(int i=0; i < image.getLayers().length; i++)
                {
                    if (image.getLayers()[i] instanceof FillLayer)
                    {
                        FillLayer fillLayer = (FillLayer)image.getLayers()[i];
                        if (fillLayer.getFillSettings().getFillType() != FillType.Gradient)
                        {
                            throw new Exception("Wrong Fill Layer");
                        }
                        IGradientFillSettings settings = (IGradientFillSettings)fillLayer.getFillSettings();

                        if (
                         Math.abs(settings.getAngle() - 45) > 0.25 ||
                         !settings.getDither() ||
                         settings.getAlignWithLayer() ||
                         settings.getReverse() ||
                         Math.abs(settings.getHorizontalOffset() - (-39)) > 0.25 ||
                         Math.abs(settings.getVerticalOffset() - (-5)) > 0.25 ||
                         settings.getTransparencyPoints().length != 3 ||
                         settings.getColorPoints().length != 2 ||
                         Math.abs(100.0 - settings.getTransparencyPoints()[0].getOpacity()) > 0.25 ||
                         settings.getTransparencyPoints()[0].getLocation() != 0 ||
                         settings.getTransparencyPoints()[0].getMedianPointLocation() != 50 ||
                         !settings.getColorPoints()[0].getColor().equals(Color.fromArgb(203, 64, 140)) ||
                         settings.getColorPoints()[0].getLocation() != 0 ||
                         settings.getColorPoints()[0].getMedianPointLocation() != 50)
                        {
                            throw new Exception("Gradient Fill was not read correctly");
                        }

                        settings.setAngle(0.0);
                        settings.setDither(false);
                        settings.setAlignWithLayer(true);
                        settings.setReverse(true);
                        settings.setHorizontalOffset(25);
                        settings.setVerticalOffset(-15);

                        List<IGradientColorPoint> colorPoints = new ArrayList<IGradientColorPoint>();
                        Collections.addAll(colorPoints, settings.getColorPoints());
                        List<IGradientTransparencyPoint> transparencyPoints = new ArrayList<IGradientTransparencyPoint>();
                        Collections.addAll(transparencyPoints, settings.getTransparencyPoints());

                        GradientColorPoint gr1 = new GradientColorPoint();
                        gr1.setColor(Color.getViolet());
                        gr1.setLocation(4096);
                        gr1.setMedianPointLocation(75);

                        colorPoints.add(gr1);

                        colorPoints.get(1).setLocation(3000);

        GradientTransparencyPoint gr2 = new GradientTransparencyPoint();
                    gr2.setOpacity(80.0);
                    gr2.setLocation(4096);
                    gr2.setMedianPointLocation(25);
 
                    transparencyPoints.add(gr2);
 
                    transparencyPoints.get(2).setLocation(3000);
                        settings.setColorPoints(colorPoints.toArray(new IGradientColorPoint[0]));
                    settings.setTransparencyPoints(transparencyPoints.toArray(new IGradientTransparencyPoint[0]));
                    fillLayer.update();
                        image.save(outputFile, new PsdOptions(image));
                        
                        break;
                    }
                }
       //ExEnd:GradientFillLayer
    }
}
