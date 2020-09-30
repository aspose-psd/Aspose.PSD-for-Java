package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.linkresources.LinkDataSourceType;
import com.aspose.psd.fileformats.psd.layers.layerresources.linkresources.LnkeResource;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.FormatException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * An example of linking different types of assets (raster images, CC libraries) to PSD. Also API of LnkeResource is
 * considered.
 */
public class SupportLnkeResource
{
    public static void main(String[] args)
    {
		String dataDir = Utils.getResourcesDir() + "/ModifyingAndConvertingImages/PSD/SupportLnkeResource/";
		String outputDir = Utils.GetDataDir_Output();
        //ExStart:SupportLnkeResource
        // A class that keeps methods in the local scope
		class LocalScopeExtension
		{
		    void assertIsTrue(boolean condition)
		    {
		        if (!condition)
		        {
		            throw new FormatException("ExampleOfLnkEResourceSupport works incorrectly.");
		        }
		    }
		
		    void assertAreEqual(Object actual, Object expected)
		    {
		        assertIsTrue(actual != null && actual.equals(expected));
		    }
		
		    // This example demonstrates how to get and set properties of the Photoshop Psd LnkE
		    // Resource that contains information about an external linked file.
		    void exampleOfLnkEResourceSupport(
		            String fileName,
		            int length,
		            int length2,
		            int length3,
		            int length4,
		            String fullPath,
		            String date,
		            double assetModTime,
		            String childDocId,
		            boolean locked,
		            String uid,
		            String name,
		            String originalFileName,
		            String fileType,
		            long size)
		    {
		        String srcPsdPath = dataDir + fileName;
		        String dstPsdPath = outputDir + "out_" + fileName;
		        String dstPngPath = dstPsdPath.replace(".psd", ".png");
		
		        // Load a predefined PSD
		        PsdImage image = (PsdImage)Image.load(srcPsdPath);
		        try
		        {
		            // Search LnkeResource among global resources
		            LnkeResource lnkeResource = null;
		            for (LayerResource resource : image.getGlobalLayerResources())
		            {
		                if (resource instanceof LnkeResource)
		                {
		                    lnkeResource = (LnkeResource)resource;
		
		                    // Verify LnkeResource properties
		                    assertAreEqual(lnkeResource.getLength(), length);
		                    assertAreEqual(lnkeResource.get_Item(0).getUniqueId(), UUID.fromString(uid));
		                    assertAreEqual(lnkeResource.get_Item(0).getFullPath(), fullPath);
		                    assertAreEqual(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(lnkeResource.get_Item(0).getDate()), date);
		                    assertAreEqual(lnkeResource.get_Item(0).getAssetModTime(), assetModTime);
		                    assertAreEqual(lnkeResource.get_Item(0).getAssetLockedState(), locked);
		                    assertAreEqual(lnkeResource.get_Item(0).getFileName(), name);
		                    assertAreEqual(lnkeResource.get_Item(0).getFileSize(), size);
		                    assertAreEqual(lnkeResource.get_Item(0).getChildDocId(), childDocId);
		                    assertAreEqual(lnkeResource.get_Item(0).getVersion(), 7);
		                    assertAreEqual(lnkeResource.get_Item(0).getFileType().trim(), fileType);
		                    assertAreEqual(lnkeResource.get_Item(0).getFileCreator().trim(), "");
		                    assertAreEqual(lnkeResource.get_Item(0).getOriginalFileName(), originalFileName);
		                    assertAreEqual(lnkeResource.get_Item(0).getCompId(), -1);
		                    assertAreEqual(lnkeResource.get_Item(0).getOriginalCompId(), -1);
		                    assertIsTrue(lnkeResource.get_Item(0).hasFileOpenDescriptor());
		                    assertIsTrue(!lnkeResource.isEmpty());
		                    assertIsTrue(lnkeResource.get_Item(0).getType() == LinkDataSourceType.liFE);
		
		                    // Update LnkeResource properties
		                    lnkeResource.get_Item(0).setFullPath("file:///C:/Aspose/net/Aspose.Psd/test/testdata/Images/Psd/SmartObjects/rgb8_2x2.png");
		                    assertAreEqual(lnkeResource.getLength(), length2);
		                    lnkeResource.get_Item(0).setFileName("rgb8_2x23.png");
		                    assertAreEqual(lnkeResource.getLength(), length3);
		                    lnkeResource.get_Item(0).setChildDocId(UUID.randomUUID().toString());
		                    assertAreEqual(lnkeResource.getLength(), length4);
		                    lnkeResource.get_Item(0).setDate(new Date());
		                    lnkeResource.get_Item(0).setAssetModTime(Double.MAX_VALUE);
		                    lnkeResource.get_Item(0).setFileSize(Long.MAX_VALUE);
		                    lnkeResource.get_Item(0).setFileType("test");
		                    lnkeResource.get_Item(0).setFileCreator("file");
		                    lnkeResource.get_Item(0).setCompId(Integer.MAX_VALUE);
		                    break;
		                }
		            }
		
		            // Make sure LnkeResource is supported
		            assertIsTrue(lnkeResource != null);
		
		            // Save a copy of the loaded PSD
		            image.save(dstPsdPath, new PsdOptions(image));
		        }
		        finally
		        {
		            image.dispose();
		        }
		
		        // Load the saved copy
		        PsdImage image1 = (PsdImage)Image.load(dstPsdPath);
		        try
		        {
		            // Convert PSD to PNG file format (with alpha channel for transparency)
		            PngOptions pngOptions = new PngOptions();
		            pngOptions.setColorType(PngColorType.TruecolorWithAlpha);
		            image1.save(dstPngPath, pngOptions);
		        }
		        finally
		        {
		            image1.dispose();
		        }
		
		    }
		}
		LocalScopeExtension $ = new LocalScopeExtension();
		
		// This example demonstrates how to get and set properties of the Psd LnkE Resource that
		// contains information about external linked JPEG file.
		$.exampleOfLnkEResourceSupport(
		        "photooverlay_5_new.psd",
		        0x21c,
		        0x26c,
		        0x274,
		        0x27c,
		        "file:///C:/Users/cvallejo/Desktop/photo.jpg",
		        "05/09/2017 22:24:51",
		        0,
		        "F062B9DB73E8D124167A4186E54664B0",
		        false,
		        "02df245c-36a2-11e7-a9d8-fdb2b61f07a7",
		        "photo.jpg",
		        "photo.jpg",
		        "JPEG",
		        0x1520d);
		
		// This example demonstrates how to get and set properties of the PSD LnkE Resource that
		// contains information about an external linked PNG file.
		$.exampleOfLnkEResourceSupport(
		        "rgb8_2x2_linked.psd",
		        0x284,
		        0x290,
		        0x294,
		        0x2dc,
		        "file:///C:/Aspose/net/Aspose.Psd/test/testdata/Issues/PSDNET-491/rgb8_2x2.png",
		        "04/14/2020 14:23:44",
		        0,
		        "",
		        false,
		        "5867318f-3174-9f41-abca-22f56a75247e",
		        "rgb8_2x2.png",
		        "rgb8_2x2.png",
		        "png",
		        0x53);
		
		// This example demonstrates how to get and set properties of the Photoshop Psd LnkE Resource
		// that contains information about an external linked CC Libraries Asset.
		$.exampleOfLnkEResourceSupport(
		        "rgb8_2x2_asset_linked.psd",
		        0x398,
		        0x38c,
		        0x388,
		        0x3d0,
		        "CC Libraries Asset “rgb8_2x2_linked/rgb8_2x2” (Feature is available in Photoshop CC 2015)",
		        "01/01/0001 00:00:00",
		        1588890915488.0d,
		        "",
		        false,
		        "ec15f0a8-7f13-a640-b928-7d29c6e9859c",
		        "rgb8_2x2_linked",
		        "rgb8_2x2.png",
		        "png",
		        0);
        //ExEnd:SupportLnkeResource
    }
}
