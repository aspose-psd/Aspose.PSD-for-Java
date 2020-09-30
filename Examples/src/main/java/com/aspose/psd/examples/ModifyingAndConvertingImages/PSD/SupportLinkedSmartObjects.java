package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.FileFormat;
import com.aspose.psd.Image;
import com.aspose.psd.LoadOptions;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.smartobjects.SmartObjectLayer;
import com.aspose.psd.fileformats.psd.layers.smartobjects.SmartObjectType;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.FormatException;
import com.aspose.psd.system.Enum;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * This is a complex example because it contains a few sub-examples. All these sub-examples
 * demonstrate usage of linked smart objects and their APIs.
 */
public class SupportLinkedSmartObjects
{
	public static void main(String[] args)
	{
		String dataDir = Utils.GetDataDir_PSD();
		String outputDir = Utils.GetDataDir_Output();

		//ExStart:SupportLinkedSmartObjects
		class LocalScopeExtension
		{
		    boolean equals(Object a, Object b)
		    {
		        return (a == b) || (a != null && a.equals(b));
		    }
		
		    void assertAreEqual(Object actual, Object expected)
		    {
		        boolean areEqual = equals(actual, expected);
		        // Compare arrays if any
		        if (!areEqual &&
		                (actual != null && actual.getClass().isArray()) &&
		                (expected != null && expected.getClass().isArray()))
		        {
		            int length;
		            // Use Reflection for accessing arrays to support arrays of primitives
		            if ((length = Array.getLength(actual)) == Array.getLength(expected))
		            {
		                for (int i = 0; i < length; i++)
		                {
		                    if (!equals(Array.get(actual, i), Array.get(expected, i)))
		                    {
		                        break;
		                    }
		                }
		
		                areEqual = true;
		            }
		        }
		
		        if (!areEqual)
		        {
		            throw new FormatException(
		                    String.format("Actual value %s are not equal to expected %s.", actual, expected));
		        }
		    }
		
		    void exampleOfUpdatingSmartObjectLayer(
		            String filePath,
		            int contentsLength,
		            int left,
		            int top,
		            int right,
		            int bottom,
		            long format)
		    {
		        // This example demonstrates how to change the smart object layer in the PSD file and export / update its contents.
				filePath = dataDir + filePath;
		        final String fileName = getFileNameWithoutExtension(filePath);
		        String pngOutputPath = outputDir + fileName + "_modified.png";
		        String png2OutputPath = outputDir + fileName + "_updated_modified.png";
		        String psd2OutputPath = outputDir + fileName + "_updated_modified.psd";
		        String exportPath = outputDir + fileName + "_exported." + getFormatExt(format);
		
		        PsdImage image = (PsdImage)Image.load(filePath);
		        try
		        {
		            SmartObjectLayer smartObjectLayer = (SmartObjectLayer)image.getLayers()[0];
		
		            // Verify the content length and the layer bounds
		            assertAreEqual(contentsLength, smartObjectLayer.getContents().length);
		            assertAreEqual(left, smartObjectLayer.getContentsBounds().getLeft());
		            assertAreEqual(top, smartObjectLayer.getContentsBounds().getTop());
		            assertAreEqual(right, smartObjectLayer.getContentsBounds().getRight());
		            assertAreEqual(bottom, smartObjectLayer.getContentsBounds().getBottom());
		
		            int contentType = smartObjectLayer.getContentType();
		            if (contentType == SmartObjectType.AvailableLinked)
		            {
		                // Let's export the external smart object image from the PSD smart object layer to a new location
		                // because we are going to modify it.
		                smartObjectLayer.exportContents(exportPath);
		                smartObjectLayer.relinkToFile(exportPath);
		
		            }
		
		            // Let's invert the content of the smart object: inner (not cached) image
		            RasterImage innerImage = (RasterImage)smartObjectLayer.loadContents(new LoadOptions());
		            try
		            {
		                invertImage(innerImage);
		                ByteArrayOutputStream stream = new ByteArrayOutputStream();
		                try
		                {
		                    innerImage.save(stream);
		                    smartObjectLayer.setContents(stream.toByteArray());
		                }
		                finally
		                {
		                    try
		                    {
		                        stream.close();
		                    }
		                    catch (IOException e)
		                    {
		                        e.printStackTrace();
		                    }
		                }
		            }
		            finally
		            {
		                innerImage.dispose();
		            }
		
		            // Let's check whether the modified content does not affect rendering yet.
		            PngOptions pngOptions = new PngOptions();
		            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
		            image.save(pngOutputPath, pngOptions);
		
		            smartObjectLayer.updateModifiedContent();
		
		            // Let's check whether the updated content affects rendering and the psd image is saved correctly
		            image.save(psd2OutputPath, new PsdOptions(image));
		            PngOptions pngOptions1 = new PngOptions();
		            pngOptions1.setColorType(PngColorType.TruecolorWithAlpha);
		            image.save(png2OutputPath, pngOptions1);
		
		        }
		        finally
		        {
		            image.dispose();
		        }
		    }
		
		    void exampleOfEmbeddedSmartObjectLayerToLinkedConversion(
		            String filePath,
		            int contentsLength,
		            int left,
		            int top,
		            int right,
		            int bottom,
		            long format)
		    {
		        // This demonstrates how to convert an embedded smart object layer in the PSD file to external one.
				filePath = dataDir + filePath;
		        String formatExt = getFormatExt(format);
		        String fileName = getFileNameWithoutExtension(filePath);
		        String pngOutputPath = outputDir + fileName + "_to_external.png";
		        String psdOutputPath = outputDir + fileName + "_to_external.psd";
		        String externalPath = outputDir + fileName + "_external." + formatExt;
		
		        PsdImage image = (PsdImage)Image.load(filePath);
		        try
		        {
		            SmartObjectLayer smartObjectLayer = (SmartObjectLayer)image.getLayers()[0];
		            smartObjectLayer.convertToLinked(externalPath);
		
		            assertAreEqual(contentsLength, smartObjectLayer.getContents().length);
		            assertAreEqual(left, smartObjectLayer.getContentsBounds().getLeft());
		            assertAreEqual(top, smartObjectLayer.getContentsBounds().getTop());
		            assertAreEqual(right, smartObjectLayer.getContentsBounds().getRight());
		            assertAreEqual(bottom, smartObjectLayer.getContentsBounds().getBottom());
		            assertAreEqual(SmartObjectType.AvailableLinked, smartObjectLayer.getContentType());
		
		            // Let's check if the converted image is saved correctly
		            image.save(psdOutputPath, new PsdOptions(image));
		            PngOptions pngOptions = new PngOptions();
		            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
		            image.save(pngOutputPath, pngOptions);
		
		        }
		        finally
		        {
		            image.dispose();
		        }
		
		        PsdImage image1 = (PsdImage)Image.load(psdOutputPath);
		        try
		        {
		            SmartObjectLayer smartObjectLayer = (SmartObjectLayer)image1.getLayers()[0];
		            assertAreEqual(contentsLength, smartObjectLayer.getContents().length);
		            assertAreEqual(left, smartObjectLayer.getContentsBounds().getLeft());
		            assertAreEqual(top, smartObjectLayer.getContentsBounds().getTop());
		            assertAreEqual(right, smartObjectLayer.getContentsBounds().getRight());
		            assertAreEqual(bottom, smartObjectLayer.getContentsBounds().getBottom());
		            assertAreEqual(SmartObjectType.AvailableLinked, smartObjectLayer.getContentType());
		        }
		        finally
		        {
		            image1.dispose();
		        }
		    }
		
		    void exampleOfLinkedSmartObjectLayerToEmbeddedConversion(
		            String filePath,
		            int contentsLength,
		            int left,
		            int top,
		            int right,
		            int bottom,
		            long format)
		    {
		    	filePath = dataDir + filePath;
		        String fileName = getFileNameWithoutExtension(filePath);
		        String pngOutputPath = outputDir + fileName + "_to_embedded.png";
		        String psdOutputPath = outputDir + fileName + "_to_embedded.psd";
		
		        PsdImage image = (PsdImage)Image.load(filePath);
		        try
		        {
		            SmartObjectLayer smartObjectLayer0 = (SmartObjectLayer)image.getLayers()[0];
		            smartObjectLayer0.embedLinked();
		            assertAreEqual(contentsLength, smartObjectLayer0.getContents().length);
		            assertAreEqual(left, smartObjectLayer0.getContentsBounds().getLeft());
		            assertAreEqual(top, smartObjectLayer0.getContentsBounds().getTop());
		            assertAreEqual(right, smartObjectLayer0.getContentsBounds().getRight());
		            assertAreEqual(bottom, smartObjectLayer0.getContentsBounds().getBottom());
		            if (image.getLayers().length >= 2)
		            {
		                SmartObjectLayer smartObjectLayer1 = (SmartObjectLayer)image.getLayers()[1];
		                assertAreEqual(SmartObjectType.Embedded, smartObjectLayer0.getContentType());
		                assertAreEqual(SmartObjectType.AvailableLinked, smartObjectLayer1.getContentType());
		
		                image.getSmartObjectProvider().embedAllLinked();
		                for (Layer layer : image.getLayers())
		                {
		                    SmartObjectLayer smartLayer = (SmartObjectLayer)layer;
		                    if (smartLayer != null)
		                    {
		                        assertAreEqual(SmartObjectType.Embedded, smartLayer.getContentType());
		                    }
		                }
		            }
		
		            // Let's check if the converted image is saved correctly
		            image.save(psdOutputPath, new PsdOptions(image));
		            PngOptions pngOptions = new PngOptions();
		            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
		            image.save(pngOutputPath, pngOptions);
		
		        }
		        finally
		        {
		            image.dispose();
		        }
		
		        PsdImage image1 = (PsdImage)Image.load(psdOutputPath);
		        try
		        {
		            SmartObjectLayer smartObjectLayer = (SmartObjectLayer)image1.getLayers()[0];
		            assertAreEqual(contentsLength, smartObjectLayer.getContents().length);
		            assertAreEqual(left, smartObjectLayer.getContentsBounds().getLeft());
		            assertAreEqual(top, smartObjectLayer.getContentsBounds().getTop());
		            assertAreEqual(right, smartObjectLayer.getContentsBounds().getRight());
		            assertAreEqual(bottom, smartObjectLayer.getContentsBounds().getBottom());
		            assertAreEqual(SmartObjectType.Embedded, smartObjectLayer.getContentType());
		        }
		        finally
		        {
		            image1.dispose();
		        }
		    }
		
		    void exampleOfExternalSmartObjectLayerSupport(String filePath, int contentsLength, int left, int top, int right, int bottom, long format)
		    {
		    	filePath = dataDir + filePath;
		        String formatExt = getFormatExt(format);
		        String fileName = getFileNameWithoutExtension(filePath);
		        String pngOutputPath = outputDir + fileName + ".png";
		        String psdOutputPath = outputDir + fileName + ".psd";
		        String linkOutputPath = outputDir + fileName + "_inverted." + formatExt;
		        String png2OutputPath = outputDir + fileName + "_updated.png";
		        String psd2OutputPath = outputDir + fileName + "_updated.psd";
		        String exportPath = outputDir + fileName + "_export." + formatExt;
		
		        PsdImage image = (PsdImage)Image.load(filePath);
		        try
		        {
		            SmartObjectLayer smartObjectLayer = (SmartObjectLayer)image.getLayers()[image.getLayers().length - 1];
		            assertAreEqual(left, smartObjectLayer.getContentsBounds().getLeft());
		            assertAreEqual(top, smartObjectLayer.getContentsBounds().getTop());
		            assertAreEqual(right, smartObjectLayer.getContentsBounds().getRight());
		            assertAreEqual(bottom, smartObjectLayer.getContentsBounds().getBottom());
		            assertAreEqual(contentsLength, smartObjectLayer.getContents().length);
		            assertAreEqual(SmartObjectType.AvailableLinked, smartObjectLayer.getContentType());
		
		            // Let's export the linked smart object image from the PSD smart object layer
		            smartObjectLayer.exportContents(exportPath);
		
		            // Let's check if the original image is saved correctly
		            image.save(psdOutputPath, new PsdOptions(image));
		            PngOptions pngOptions = new PngOptions();
		            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
		            image.save(pngOutputPath, pngOptions);
		
		            RasterImage innerImage = (RasterImage)smartObjectLayer.loadContents(null);
		            try
		            {
		                assertAreEqual(format, innerImage.getFileFormat());
		
		                // Let's invert the linked smart object image
		                invertImage(innerImage);
		                innerImage.save(linkOutputPath);
		
		                // Let's replace the linked smart object image in the PSD layer
		                smartObjectLayer.replaceContents(linkOutputPath);
		            }
		            finally
		            {
		                innerImage.dispose();
		            }
		
		            // Let's check if the updated image is saved correctly
		            image.save(psd2OutputPath, new PsdOptions(image));
		            PngOptions pngOptions1 = new PngOptions();
		            pngOptions1.setColorType(PngColorType.TruecolorWithAlpha);
		            image.save(png2OutputPath, pngOptions1);
		
		        }
		        finally
		        {
		            image.dispose();
		        }
		    }
		
		    // Inverts the image.
		    void invertImage(RasterImage innerImage)
		    {
		        if (innerImage instanceof PsdImage)
		        {
		            PsdImage innerPsdImage = (PsdImage)innerImage;
		            invertRasterImage(innerPsdImage.getLayers()[0]);
		        }
		        else
		        {
		            invertRasterImage(innerImage);
		        }
		    }
		
		    // Inverts the raster image.
		    void invertRasterImage(RasterImage innerImage)
		    {
		        int[] pixels = innerImage.loadArgb32Pixels(innerImage.getBounds());
		        for (int i = 0; i < pixels.length; i++)
		        {
		            int pixel = pixels[i];
		            int alpha = (int)(pixel & 0xff000000);
		            pixels[i] = (~(pixel & 0x00ffffff)) | alpha;
		        }
		
		        innerImage.saveArgb32Pixels(innerImage.getBounds(), pixels);
		    }
		
		    // Gets the format extension.
		    String getFormatExt(long format)
		    {
		        String formatExt = format == FileFormat.Jpeg2000 ? "jpf" : Enum.getName(FileFormat.class, format).toLowerCase();
		        return formatExt;
		    }
		
		    String getFileNameWithoutExtension(String filePath)
		    {
		        return new File(filePath).getName().split("\\.")[0];
		    }
		}
		LocalScopeExtension $ = new LocalScopeExtension();
		
		// This example demonstrates how to update the external or embedded smart object layer using these methods:
		// RelinkToFile, UpdateModifiedContent, ExportContents
		$.exampleOfUpdatingSmartObjectLayer("rgb8_2x2_linked2.psd", 0x53, 0, 0, 2, 2, FileFormat.Png);
		$.exampleOfUpdatingSmartObjectLayer("r-embedded-png.psd", 0x207, 0, 0, 0xb, 0x10, FileFormat.Png);
		
		// This example demonstrates how to convert the embedded smart object to external linked contents using the ConvertToLinked method.
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("new_panama-papers-4.psd", 0x10caa, 0, 0, 0x280, 0x169, FileFormat.Jpeg);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r3-embedded.psd", 0x207, 0, 0, 0xb, 0x10, FileFormat.Png);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r-embedded-tiff.psd", 0xca94, 0, 0, 0xb, 0x10, FileFormat.Tiff);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r-embedded-bmp.psd", 0x278, 0, 0, 0xb, 0x10, FileFormat.Bmp);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r-embedded-gif.psd", 0x3ec, 0, 0, 0xb, 0x10, FileFormat.Gif);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r-embedded-jpeg.psd", 0x327, 0, 0, 0xb, 0x10, FileFormat.Jpeg);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r-embedded-jpeg2000.psd", 0x519f, 0, 0, 0xb, 0x10, FileFormat.Jpeg2000);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r-embedded-psd.psd", 0xc074, 0, 0, 0xb, 0x10, FileFormat.Psd);
		$.exampleOfEmbeddedSmartObjectLayerToLinkedConversion("r-embedded-png.psd", 0x207, 0, 0, 0xb, 0x10, FileFormat.Png);
		
		// This example demonstrates how to embed one external smart object layer or all linked layers in the PSD file using the EmbedLinked method.
		$.exampleOfLinkedSmartObjectLayerToEmbeddedConversion("rgb8_2x2_linked.psd", 0x53, 0, 0, 2, 2, FileFormat.Png);
		$.exampleOfLinkedSmartObjectLayerToEmbeddedConversion("rgb8_2x2_linked2.psd", 0x53, 0, 0, 2, 2, FileFormat.Png);
		
		// This example demonstrates how to change the Adobe® Photoshop® external smart object layer and export / update its contents
		// using the ExportContents and ReplaceContents methods.
		$.exampleOfExternalSmartObjectLayerSupport("rgb8_2x2_linked.psd", 0x53, 0, 0, 2, 2, FileFormat.Png);
		$.exampleOfExternalSmartObjectLayerSupport("rgb8_2x2_linked2.psd", 0x4aea, 0, 0, 10, 10, FileFormat.Psd);
		//ExEnd:SupportLinkedSmartObjects
	}
}
