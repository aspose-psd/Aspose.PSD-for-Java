package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Color;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.TextLayer;
import com.aspose.psd.fileformats.psd.layers.text.IText;
import com.aspose.psd.fileformats.psd.layers.text.ITextParagraph;
import com.aspose.psd.fileformats.psd.layers.text.ITextPortion;
import com.aspose.psd.fileformats.psd.layers.text.ITextStyle;
import com.aspose.psd.fileformats.psd.layers.text.rendering.FontBaseline;
import com.aspose.psd.fileformats.psd.layers.text.rendering.FontCaps;

/**
 * An example of applying different text styles to a single text layer of a PSD file. It
 * modifies the text style of an existing text layer and adds to one a few new text portions
 * styled differently then saves a changed copy of the document as a new PSD file.
 */
public class StyleTextPortions
{
    public static void main(String[] args)
    {
        //ExStart:StyleTextPortions
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String inPsdFilePath = sourceDir + "text212.psd";
        String outPsdFilePath = outputDir + "Output_text212.psd";

        // Load a PSD file containing predefined text layers
        PsdImage psdImage = (PsdImage)Image.load(inPsdFilePath);
        try
        {
            // Obtain a text container of a first layer
            TextLayer textLayer = (TextLayer)psdImage.getLayers()[1];
            IText textData = textLayer.getTextData();

            // Define a default text style
            ITextStyle defaultStyle = textData.producePortion().getStyle();
            defaultStyle.setFillColor(Color.getDimGray());
            defaultStyle.setFontSize(51);

            // Define a default text paragraph
            ITextParagraph defaultParagraph = textData.producePortion().getParagraph();

            // Style an existing text portion
            textData.getItems()[1].getStyle().setStrikethrough(true);

            // Create a few new text portions with default styling
            ITextPortion[] newTextPortions = textData.producePortions(new String[] {
                            "E=mc",  "2\r",  "Bold",  "Italic\r",  "Lowercasetext" },
                    defaultStyle, defaultParagraph);

            // Style the text portions differently
            newTextPortions[0].getStyle().setUnderline(true); // edit text style of "E=mc"
            newTextPortions[1].getStyle().setFontBaseline(FontBaseline.Superscript); // edit text style of "2\r"
            newTextPortions[2].getStyle().setFauxBold(true); // edit text style of "Bold"
            newTextPortions[3].getStyle().setFauxItalic(true); // edit text style of "Italic\r"
            newTextPortions[3].getStyle().setBaselineShift(-25); // edit text style of "Italic\r"
            newTextPortions[4].getStyle().setFontCaps(FontCaps.SmallCaps); // edit text style of "Lowercasetext"

            // Bind the text portions to the text layer
            for (ITextPortion newTextPortion : newTextPortions)
            {
                textData.addPortion(newTextPortion);
            }

            // Apply changes defined in the text portions to the text layer
            textData.updateLayerData();

            // Save a copy of loaded PSD file including the changes on the specified path
            psdImage.save(outPsdFilePath);
        }
        finally
        {
            psdImage.dispose();
        }
        //ExEnd:StyleTextPortions
    }
}
