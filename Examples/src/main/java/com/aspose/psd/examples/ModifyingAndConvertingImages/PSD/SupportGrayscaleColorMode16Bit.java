package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.*;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.ColorModes;
import com.aspose.psd.fileformats.psd.CompressionMethod;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.system.Enum;

/**
 * An example of applying different combinations of color modes, bits per channel, channels
 * counts and compressions for specific layers.
 */
public class SupportGrayscaleColorMode16Bit
{
    public static void main(String[] args)
    {
        //ExStart:SupportGrayscaleColorMode16Bit
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        // Make a method be accessible from the local scope
        class LocalScopeExtension
        {
            void saveToPsdThenLoadAndSaveToPng(
                    String file,
                    short colorMode,
                    short channelBitsCount,
                    short channelsCount,
                    short compression,
                    int layerNumber)
            {
                String filePath = sourceDir + file + ".psd";
                String postfix = Enum.getName(ColorModes.class, colorMode) + channelBitsCount + "_" +
                        channelsCount + "_" + Enum.getName(CompressionMethod.class, compression);
                String exportPath = outputDir + file + postfix + ".psd";
                String pngExportPath = outputDir + file + postfix + ".png";

                // Load a predefined 16-bit grayscale PSD
                PsdImage image = (PsdImage)Image.load(filePath);
                try
                {
                    RasterCachedImage raster = layerNumber >= 0 ? image.getLayers()[layerNumber] : image;

                    // Draw a gray inner border around the perimeter of the layer
                    Graphics graphics = new Graphics(raster);
                    int width = raster.getWidth();
                    int height = raster.getHeight();
                    Rectangle rect = new Rectangle(
                            width / 3,
                            height / 3,
                            width - (2 * (width / 3)) - 1,
                            height - (2 * (height / 3)) - 1);
                    graphics.drawRectangle(new Pen(Color.getDarkGray(), 1), rect);

                    // Save a copy of PSD with specific characteristics
                    PsdOptions psdOptions = new PsdOptions();
                    psdOptions.setColorMode(colorMode);
                    psdOptions.setChannelBitsCount(channelBitsCount);
                    psdOptions.setChannelsCount(channelsCount);
                    psdOptions.setCompressionMethod(compression);
                    image.save(exportPath, psdOptions);
                }
                finally
                {
                    image.dispose();
                }

                // Load the saved PSD
                PsdImage image1 = (PsdImage)Image.load(exportPath);
                try
                {
                    // Convert the saved PSD to a grayscale PNG image
                    PngOptions pngOptions = new PngOptions();
                    pngOptions.setColorType(PngColorType.GrayscaleWithAlpha);
                    image1.save(pngExportPath, pngOptions); // here should be no exception
                }
                finally
                {
                    image1.dispose();
                }
            }
        }
        LocalScopeExtension $ = new LocalScopeExtension();

        $.saveToPsdThenLoadAndSaveToPng("grayscale5x5", ColorModes.Cmyk, (short)16, (short)5, CompressionMethod.RLE, 0);
        $.saveToPsdThenLoadAndSaveToPng("argb16bit_5x5", ColorModes.Grayscale, (short)16, (short)2, CompressionMethod.RLE, 0);
        $.saveToPsdThenLoadAndSaveToPng("argb16bit_5x5_no_layers", ColorModes.Grayscale, (short)16, (short)2, CompressionMethod.RLE, -1);
        $.saveToPsdThenLoadAndSaveToPng("argb8bit_5x5", ColorModes.Grayscale, (short)16, (short)2, CompressionMethod.RLE, 0);
        $.saveToPsdThenLoadAndSaveToPng("argb8bit_5x5_no_layers", ColorModes.Grayscale, (short)16, (short)2, CompressionMethod.RLE, -1);
        $.saveToPsdThenLoadAndSaveToPng("cmyk16bit_5x5_no_layers", ColorModes.Grayscale, (short)16, (short)2, CompressionMethod.RLE, -1);
        $.saveToPsdThenLoadAndSaveToPng("index8bit_5x5", ColorModes.Grayscale, (short)16, (short)2, CompressionMethod.RLE, -1);
        //ExEnd:SupportGrayscaleColorMode16Bit
    }
}
