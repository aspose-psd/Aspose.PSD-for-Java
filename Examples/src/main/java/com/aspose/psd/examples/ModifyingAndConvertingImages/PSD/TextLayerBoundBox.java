/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.Size;
import com.aspose.psd.examples.Utils.Assertions;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.TextLayer;

public class TextLayerBoundBox
{
    public static void main(String[] args)
    {
        //ExStart:TextLayerBoundBox
        String dataDir = Utils.getDataDir(TextLayerBoundBox.class) + "PSD/";

        String sourceFileName = dataDir + "LayerWithText.psd";

        Size correctOpticalSize = new Size(127, 45);
        Size correctBoundBox = new Size(172, 62);

        PsdImage im = (PsdImage)Image.load(sourceFileName);

        TextLayer textLayer = (TextLayer)im.getLayers()[1];

        // Size of the layer is the size of the rendered area
        Size opticalSize = textLayer.getSize();
        Assertions.assertEquals(correctOpticalSize, opticalSize);

        // TextBoundBox is the maximum layer size for Text Layer.
        // In this area PS will try to fit your text
        Size boundBox = textLayer.getTextBoundBox();
        Assertions.assertEquals(correctBoundBox, boundBox);
        //ExEnd:TextLayerBoundBox
    }
}
