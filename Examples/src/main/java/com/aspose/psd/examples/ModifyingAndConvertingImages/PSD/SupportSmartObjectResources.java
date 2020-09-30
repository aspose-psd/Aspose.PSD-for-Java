package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.FileStreamContainer;
import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.linkresources.LiFdDataSource;
import com.aspose.psd.fileformats.psd.layers.layerresources.linkresources.LinkDataSourceType;
import com.aspose.psd.fileformats.psd.layers.layerresources.linkresources.Lnk2Resource;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.FormatException;
import java.util.UUID;

/**
 * This example demonstrates how to work with smart object resources (basically Lnk2Resource). The program loads several
 * Photoshop documents and exports their smart objects to raster file formats. Also the code demonstrates usage of
 * public methods of Lnk2Resource.
 */
public class SupportSmartObjectResources
{
    public static void main(String[] args)
    {
		String dataDir = Utils.getDataDir(SupportSmartObjectResources.class) + "ModifyingAndConvertingImages/PSD/SupportSmartObjectResources/";
		String outputDir = Utils.GetDataDir_Output();
		//ExStart:SupportSmartObjectResources
		class LocalScopeExtension
		{
		    void assertAreEqual(Object expected, Object actual)
		    {
		        if (!actual.equals(expected))
		        {
		            throw new FormatException(String.format("Actual value %s are not equal to expected %s.", actual, expected));
		        }
		    }
		
		    // Saves the data of a smart object into PSD file
		    void saveSmartObjectData(String filePath, byte[] data)
		    {
		        FileStreamContainer container = FileStreamContainer.createFileStream(filePath, false);
		        try
		        {
		            container.write(data);
		        }
		        finally
		        {
		            container.dispose();
		        }
		
		    }
		
		    // Loads the new data for a smart object from a file
		    byte[] loadNewData(String filePath)
		    {

		        FileStreamContainer container = FileStreamContainer.openFileStream(filePath);
		        try
		        {
		            return container.toBytes();
		        }
		        finally
		        {
		            container.dispose();
		        }
		    }
		
		    // Gets and sets properties of the PSD Lnk2 / Lnk3 Resource and its liFD data sources in PSD image
		    void exampleOfLnk2ResourceSupport(
		            String fileName,
		            int dataSourceCount,
		            int length,
		            int newLength,
		            Object[] dataSourceExpectedValues)
		    {
		        String srcPsdPath = dataDir + fileName;
		        String dstPsdPath = outputDir + "out_" + fileName;
		
		        PsdImage image = (PsdImage)Image.load(srcPsdPath);
		        try
		        {
		            // Search for Lnk2Resource
		            Lnk2Resource lnk2Resource = null;
		            for (LayerResource resource : image.getGlobalLayerResources())
		            {
		                if (resource instanceof Lnk2Resource)
		                {
		                    lnk2Resource = (Lnk2Resource)resource;
		
		                    // Verify properties of Lnk2Resource
		                    assertAreEqual(lnk2Resource.getDataSourceCount(), dataSourceCount);
		                    assertAreEqual(lnk2Resource.getLength(), length);
		                    assertAreEqual(lnk2Resource.isEmpty(), false);
		
		                    for (int i = 0; i < lnk2Resource.getDataSourceCount(); i++)
		                    {
		                        // Verify and change properties of LiFdDataSource
		                        LiFdDataSource lifdSource = lnk2Resource.get_Item(i);
		                        Object[] expected = (Object[])dataSourceExpectedValues[i];
		                        assertAreEqual(LinkDataSourceType.liFD, lifdSource.getType());
		                        assertAreEqual(expected[0], lifdSource.getUniqueId().toString());
		                        assertAreEqual(expected[1], lifdSource.getOriginalFileName());
		                        assertAreEqual(expected[2], lifdSource.getFileType().trim());
		                        assertAreEqual(expected[3], lifdSource.getFileCreator().trim());
		                        assertAreEqual(expected[4], lifdSource.getData().length);
		                        assertAreEqual(expected[5], lifdSource.getAssetModTime());
		                        assertAreEqual(expected[6], lifdSource.getChildDocId());
		                        assertAreEqual(expected[7], lifdSource.getVersion());
		                        assertAreEqual(expected[8], lifdSource.hasFileOpenDescriptor());
		                        assertAreEqual(expected[9], lifdSource.getLength());
		
		                        if (lifdSource.hasFileOpenDescriptor())
		                        {
		                            assertAreEqual(-1, lifdSource.getCompId());
		                            assertAreEqual(-1, lifdSource.getOriginalCompId());
		                            lifdSource.setCompId(Integer.MAX_VALUE);
		                        }
		
		                        saveSmartObjectData(
										outputDir + fileName + "_" + lifdSource.getOriginalFileName(),
		                                lifdSource.getData());
		                        lifdSource.setData(loadNewData(dataDir + "new_" + lifdSource.getOriginalFileName()));
		                        assertAreEqual(expected[10], lifdSource.getLength());
		
		                        lifdSource.setChildDocId(UUID.randomUUID().toString());
		                        lifdSource.setAssetModTime(Double.MAX_VALUE);
		                        lifdSource.setFileType("test");
		                        lifdSource.setFileCreator("me");
		                    }
		
		                    assertAreEqual(newLength, lnk2Resource.getLength());
		                    break;
		                }
		            }
		
		            // Make sure that Lnk2Resource was found
		            assertAreEqual(true, lnk2Resource != null);
		
		            // Make a copy of the loaded PSD
		            if (image.getBitsPerChannel() < 32) // 32 bit per channel saving is not supported yet
		            {
		                image.save(dstPsdPath, new PsdOptions(image));
		            }
		        }
		        finally
		        {
		            image.dispose();
		        }
		    }
		}
		LocalScopeExtension $ = new LocalScopeExtension();
		
		Object[] Lnk2ResourceSupportCases = new Object[]
		        {
		                new Object[]
		                        {
		                                "00af34a0-a90b-674d-a821-73ee508c5479",
		                                "rgb8_2x2.png",
		                                "png",
		                                "",
		                                0x53,
		                                0d,
		                                "",
		                                7,
		                                true,
		                                0x124L,
		                                0x74cL
		                        }
		        };
		
		Object[] LayeredLnk2ResourceSupportCases = new Object[]
		        {
		                new Object[]
		                        {
		                                "69ac1c0d-1b74-fd49-9c7e-34a7aa6299ef",
		                                "huset.jpg",
		                                "JPEG",
		                                "",
		                                0x9d46,
		                                0d,
		                                "xmp.did:0F94B342065B11E395B1FD506DED6B07",
		                                7,
		                                true,
		                                0x9E60L,
		                                0xc60cL
		                        },
		                new Object[]
		                        {
		                                "5a7d1965-0eae-b24e-a82f-98c7646424c2",
		                                "panama-papers.jpg",
		                                "JPEG",
		                                "",
		                                0xF56B,
		                                0d,
		                                "xmp.did:BDE940CBF51B11E59D759CDA690663E3",
		                                7,
		                                true,
		                                0xF694L,
		                                0x10dd4L
		                        },
		        };
		
		Object[] LayeredLnk3ResourceSupportCases = new Object[]
		        {
		                new Object[]
		                        {
		                                "2fd7ba52-0221-de4c-bdc4-1210580c6caa",
		                                "panama-papers.jpg",
		                                "JPEG",
		                                "",
		                                0xF56B,
		                                0d,
		                                "xmp.did:BDE940CBF51B11E59D759CDA690663E3",
		                                7,
		                                true,
		                                0xF694l,
		                                0x10dd4L
		                        },
		                new Object[]
		                        {
		                                "372d52eb-5825-8743-81a7-b6f32d51323d",
		                                "huset.jpg",
		                                "JPEG",
		                                "",
		                                0x9d46,
		                                0d,
		                                "xmp.did:0F94B342065B11E395B1FD506DED6B07",
		                                7,
		                                true,
		                                0x9E60L,
		                                0xc60cL
		                        },
		        };
		
		// This example demonstrates how to get and set properties of the PSD Lnk2 Resource and its liFD data sources for 8 bit per channel.
		$.exampleOfLnk2ResourceSupport("rgb8_2x2_embedded_png.psd", 1, 0x12C, 0x0000079c, Lnk2ResourceSupportCases);
		
		// This example demonstrates how to get and set properties of the PSD Lnk3 Resource and its liFD data sources for 32 bit per channel.
		$.exampleOfLnk2ResourceSupport("Layered PSD file smart objects.psd", 2, 0x19504, 0x0001d3e0, LayeredLnk3ResourceSupportCases);
		
		// This example demonstrates how to get and set properties of the PSD Lnk2 Resource and its liFD data sources for 16 bit per channel.
		$.exampleOfLnk2ResourceSupport("LayeredSmartObjects16bit.psd", 2, 0x19504, 0x0001d3e0, LayeredLnk2ResourceSupportCases);
		//ExEnd:SupportSmartObjectResources
    }
}
