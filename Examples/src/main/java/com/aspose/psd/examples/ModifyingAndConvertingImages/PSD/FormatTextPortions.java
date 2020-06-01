package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.TextLayer;
import com.aspose.psd.fileformats.psd.layers.text.ITextPortion;
import com.aspose.psd.fileformats.psd.layers.text.ITextStyle;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.Exception;

/**
 * An example of editing text portions and their text style. It loads a predefined PSD file
 * and verifies text properties of a single text layer then edits justification and styling
 * of the text and saves a changed copy of the document as a new PSD file.
 */
public class FormatTextPortions
{
    public static void main(String[] args)
    {
        //ExStart:FormatTextPortions
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String inPsdFilePath = sourceDir + "ThreeColorsParagraphs.psd";
        String outPsdFilePath = outputDir + "ThreeColorsParagraph_out.psd";

        // Load a predefine PSD file containing a text layer
        PsdImage psdImage = (PsdImage)Image.load(inPsdFilePath);
        try
        {
            for (Layer layer : psdImage.getLayers())
            {
                // Filter any non-text layer
                if (!(layer instanceof TextLayer))
                {
                    continue;
                }

                TextLayer textLayer = (TextLayer)layer;

                ITextPortion[] portions = textLayer.getTextData().getItems();
                for (ITextPortion portion : portions)
                {
                    ITextStyle style = portion.getStyle();

                    if (style.getAutoLeading() ||
                            style.getHindiNumbers() ||
                            style.getKerning() != 0 ||
                            style.getLeading() != 0 ||
                            !style.getStrokeColor().equals(Color.fromArgb(255, 175, 90, 163)) ||
                            style.getTracking() != 50)
                    {
                        throw new Exception();
                    }
                }

                // Example of text editing
                portions[0].setText("Hello ");
                portions[1].setText("World");

                // Example of text portions removing
                textLayer.getTextData().removePortion(3);
                textLayer.getTextData().removePortion(2);

                // Example of adding new text portion
                ITextPortion createdPortion = textLayer.getTextData().producePortion();
                createdPortion.setText("!!!\r");
                textLayer.getTextData().addPortion(createdPortion);

                portions = textLayer.getTextData().getItems();

                // Example of paragraph and style editing for portions
                // Set right justification
                portions[0].getParagraph().setJustification(1);
                portions[1].getParagraph().setJustification(1);
                portions[2].getParagraph().setJustification(1);

                // Different colors for each style.
                // The colors will be changed, but rendering is not fully supported yet
                portions[0].getStyle().setFillColor(Color.getAquamarine());
                portions[1].getStyle().setFillColor(Color.getViolet());
                portions[2].getStyle().setFillColor(Color.getLightBlue());

                // Different font.
                // The font will be changed, but rendering is not fully supported yet
                portions[0].getStyle().setFontSize(6);
                portions[1].getStyle().setFontSize(8);
                portions[2].getStyle().setFontSize(10);

                // Apply the changes defined in the text portions to the text
                textLayer.getTextData().updateLayerData();

                // Save a copy of the loaded PSD file including the changes with the original image
                // options on the specified path
                psdImage.save(outPsdFilePath, new PsdOptions(psdImage));

                break;
            }
        }
        finally
        {
            psdImage.dispose();
        }
        //ExEnd:FormatTextPortions
    }
}
