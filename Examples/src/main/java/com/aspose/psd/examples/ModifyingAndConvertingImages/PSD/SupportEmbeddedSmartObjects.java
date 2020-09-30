package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.FileFormat;
import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.smartobjects.SmartObjectLayer;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.FormatException;
import com.aspose.psd.system.Enum;

/**
 * This example demonstrates how to change the smart object layer in the PSD file and export /
 * update smart object original embedded contents.
 */
public class SupportEmbeddedSmartObjects
{
	public static void main(String[] args)
	{
		String dataDir = Utils.GetDataDir_PSD();
		String outputDir = Utils.GetDataDir_Output();

		//ExStart:SupportEmbeddedSmartObjects
		class LocalScopeExtension
		{
		    void assertAreEqual(Object actual, Object expected)
		    {
		        if (actual != null && !actual.equals(expected))
		        {
		            throw new FormatException(String.format("Actual value %s are not equal to expected %s.", actual, expected));
		        }
		    }
		}
		LocalScopeExtension $ = new LocalScopeExtension();
		
		final int left = 0;
		final int top = 0;
		final int right = 0xb;
		final int bottom = 0x10;
		long[] formats = new long[]
		{
		    FileFormat.Png, FileFormat.Psd, FileFormat.Bmp, FileFormat.Jpeg, FileFormat.Gif, FileFormat.Tiff, FileFormat.Jpeg2000
		};
		
		for (long format : formats)
		{
		    // Resolve suitable text representation of the file format extension
		    String sFileFormat = Enum.getName(FileFormat.class, format).toLowerCase();
		    String fileFormatExt = format == FileFormat.Jpeg2000 ? "jpf" : sFileFormat;
		
		    // Build paths
		    String filename = "r-embedded-" + sFileFormat;
		    String srcPsdPath = dataDir + filename + ".psd";
		    String dstPngPath = outputDir + filename + "_output.png";
		    String dstPsdPath = outputDir + filename + "_output.psd";
		    String dstPngPath1 = outputDir + filename + "_updated.png";
		    String dstPsdPath1 = outputDir + filename + "_updated.psd";
		    String exportPath = outputDir + filename + "_export." + fileFormatExt;
		
		    // Load a predefined PSD file containing a smart object
		    PsdImage image = (PsdImage)Image.load(srcPsdPath);
		    try
		    {
		        // Find a smart object layer
		        SmartObjectLayer smartObjectLayer = (SmartObjectLayer)image.getLayers()[0];
		
		        // Verify its position
		        $.assertAreEqual(left, smartObjectLayer.getContentsBounds().getLeft());
		        $.assertAreEqual(top, smartObjectLayer.getContentsBounds().getTop());
		        $.assertAreEqual(right, smartObjectLayer.getContentsBounds().getRight());
		        $.assertAreEqual(bottom, smartObjectLayer.getContentsBounds().getBottom());
		
		        // Export the embedded smart object image into appropriate file format
		        smartObjectLayer.exportContents(exportPath);
		
		        // Check if the original image is saved correctly
		        image.save(dstPsdPath, new PsdOptions(image));
		        PngOptions pngOptions = new PngOptions();
		        pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
		        image.save(dstPngPath, pngOptions);
		
		        // Load smart object as a raster image
		        RasterImage innerImage = (RasterImage)smartObjectLayer.loadContents(null);
		        try
		        {
		            $.assertAreEqual(format, innerImage.getFileFormat());
		
		            // Load raster image pixels and invert them
		            int[] pixels = innerImage.loadArgb32Pixels(innerImage.getBounds());
		            for (int i = 0; i < pixels.length; i++)
		            {
		                int pixel = pixels[i];
		                int alpha = (int)(pixel & 0xff000000);
		                pixels[i] = (~(pixel & 0x00ffffff)) | alpha;
		            }
		
		            // Replace original pixels with inverted ones
		            innerImage.saveArgb32Pixels(innerImage.getBounds(), pixels);
		
		            // Replace the original smart object image with inverted one
		            smartObjectLayer.replaceContents(innerImage);
		        }
		        finally
		        {
		            innerImage.dispose();
		        }
		
		        // Check if the updated image is saved correctly
		        image.save(dstPsdPath1, new PsdOptions(image));
		        PngOptions pngOptions1 = new PngOptions();
		        pngOptions1.setColorType(PngColorType.TruecolorWithAlpha);
		        image.save(dstPngPath1, pngOptions1);
		
		    }
		    finally
		    {
		        image.dispose();
		    }
		    //ExEnd:SupportEmbeddedSmartObjects
		}
	}
}
