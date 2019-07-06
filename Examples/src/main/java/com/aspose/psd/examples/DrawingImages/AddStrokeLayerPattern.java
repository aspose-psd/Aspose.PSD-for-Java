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
import com.aspose.psd.fileformats.psd.layers.layereffects.StrokeEffect;
import com.aspose.psd.fileformats.psd.layers.layerresources.PattResource;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import java.util.UUID;

/**
 *
 *  
 */
public class AddStrokeLayerPattern {
    
    public static void main(String[] args) 
    {
       //ExStart:AddStrokeLayerPattern
       String dataDir = Utils.getDataDir(AddStrokeLayerPattern.class) + "DrawingImages/";
       
        // Stroke effect. FillType - Pattern. Example
        String sourceFileName = dataDir+"Stroke.psd";
        String exportPath = dataDir+"StrokePatternChanged.psd";
       
         PsdLoadOptions loadOptions = new PsdLoadOptions();
         loadOptions.setLoadEffectsResource( true);
         // Preparing new data
            int[] newPattern = new int[]
            {
              Color.getAqua().toArgb(), Color.getRed().toArgb(), Color.getRed().toArgb(), Color.getAqua().toArgb(),
              Color.getAqua().toArgb(), Color.getWhite().toArgb(), Color.getWhite().toArgb(), Color.getAqua().toArgb(),
              Color.getAqua().toArgb(), Color.getWhite().toArgb(), Color.getWhite().toArgb(), Color.getAqua().toArgb(),
              Color.getAqua().toArgb(), Color.getRed().toArgb(), Color.getRed().toArgb(), Color.getAqua().toArgb(),
            };
            
            
            
            Rectangle newPatternBounds = new Rectangle(0, 0, 4, 4);
            UUID guid = UUID.randomUUID();
            
            PsdImage im = (PsdImage)Image.load(sourceFileName, loadOptions);
            
            
             StrokeEffect patternStroke = (StrokeEffect)im.getLayers()[3].getBlendingOptions().getEffects()[0];

                Assert.areEqual(BlendMode.Normal, patternStroke.getBlendMode());
                Assert.areEqual(255, patternStroke.getOpacity());
                Assert.areEqual(true, patternStroke.isVisible());

                PatternFillSettings fillSettings = (PatternFillSettings)patternStroke.getFillSettings();
                Assert.areEqual(FillType.Pattern, fillSettings.getFillType());

                patternStroke.setOpacity((byte)127);
                patternStroke.setBlendMode(BlendMode.Color);
                
                
                PattResource resource;
                
                
                for(int i =0; i < im.getGlobalLayerResources().length; i++ ){
                 
                if (im.getGlobalLayerResources()[i] instanceof PattResource)
                    {
                        resource = (PattResource)im.getGlobalLayerResources()[i];
                        resource.setPatternId(guid.toString());
                        resource.setName("$$$/Presets/Patterns/HorizontalLine1=Horizontal Line 9\0");

                        resource.setPattern(newPattern, newPatternBounds);
                    }
                }

                 ((PatternFillSettings)patternStroke.getFillSettings()).setPatternName( "$$$/Presets/Patterns/HorizontalLine1=Horizontal Line 9\0");

                ((PatternFillSettings)patternStroke.getFillSettings()).setPatternId(guid.toString() + "\0") ;
                im.save(exportPath);
               
                
                 // Test file after edit
                 
                 PsdImage img = (PsdImage)Image.load(sourceFileName, loadOptions);
                 
                 StrokeEffect patternStrokeEffect = (StrokeEffect)img.getLayers()[3].getBlendingOptions().getEffects()[0];

                PattResource resource1 = null;
                               
                for(int i = 0; i < img.getGlobalLayerResources().length; i++){
                    if (img.getGlobalLayerResources()[i] instanceof  PattResource)
                       {
                           resource1 = (PattResource)img.getGlobalLayerResources()[i];

                       }                
                }
                
                
                
                try
                {
                    // Check the pattern data
                    Assert.areEqual(newPattern, resource1.getPatternData());
                    Assert.areEqual(newPatternBounds, new Rectangle(0, 0, resource1.getWidth(), resource1.getHeight()));
                    Assert.areEqual(guid.toString(), resource1.getPatternId());

                    Assert.areEqual(BlendMode.Color, patternStrokeEffect.getBlendMode());
                    Assert.areEqual(127, patternStrokeEffect.getOpacity());
                    Assert.areEqual(true, patternStrokeEffect.isVisible());

                    PatternFillSettings fillSettings1 = (PatternFillSettings)patternStrokeEffect.getFillSettings();

                    Assert.areEqual(FillType.Pattern, fillSettings1.getFillType());
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());

                }
       //ExEnd:AddStrokeLayerPattern
    }
}
