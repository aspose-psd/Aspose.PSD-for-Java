/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Assert;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.layerresources.SheetColorHighlightEnum;

public class SheetColorHighlighting
{
    public static void main(String[] args)
    {
        //ExStart:SheetColorHighlighting
        String dataDir = Utils.getDataDir(SheetColorHighlighting.class) + "PSD/";

        String sourceFileName = dataDir + "SheetColorHighlightExample.psd";
        String exportPath = dataDir + "SheetColorHighlightExampleChanged.psd";

        // Load a PSD file as an image and cast it into PsdImage
        PsdImage im = (PsdImage)Image.load(sourceFileName);

        Layer layer1 = im.getLayers()[0];
        Assert.assertEquals(SheetColorHighlightEnum.Violet, layer1.getSheetColorHighlight());

        Layer layer2 = im.getLayers()[1];
        Assert.assertEquals(SheetColorHighlightEnum.Orange, layer2.getSheetColorHighlight());

        layer1.setSheetColorHighlight(SheetColorHighlightEnum.Yellow);

        im.save(exportPath);
        //ExEnd:SheetColorHighlighting
    }
}
