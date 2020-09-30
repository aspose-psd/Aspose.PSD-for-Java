package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.PlLdResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.PlacedLayerType;
import com.aspose.psd.fileformats.psd.layers.layerresources.typetoolinfostructures.UnitTypes;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.FormatException;

import java.lang.reflect.Array;
import java.util.UUID;

/**
 * This example shows how to get or set the Placed layer resource properties of the PSD file.
 */
public class SupportPlLdResource
{
	public static void main(String[] args)
	{
		String dataDir = Utils.GetDataDir_PSD();
		String outputDir = Utils.GetDataDir_Output();

		//ExStart:SupportPlLdResource
		// Define a local class just to keep reusable code (methods)
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
		}
		LocalScopeExtension $ = new LocalScopeExtension();
		
		String srcPsdPath = dataDir + "LayeredSmartObjects8bit2.psd";
		String dstPsdPath = outputDir + "LayeredSmartObjects8bit2_output.psd";
		Object[][] expectedValues = new Object[][]
		        {
		                new Object[]
		                        {
		                                true,
		                                "76f05a3b-7523-5e42-a1bb-27f4735bffa0",
		                                1,
		                                1,
		                                0x10,
		                                PlacedLayerType.Raster,
		                                new double[]
		                                {
		                                        29.937922786050663,
		                                        95.419959734187131,
		                                        126.85445817782261,
		                                        1.0540625423957124,
		                                        172.20861031651307,
		                                        47.634102808208553,
		                                        75.292074924741144,
		                                        142
		                                },
		                                0d,
		                                0d,
		                                0d,
		                                0d,
		                                0d,
		                                149d,
		                                310d,
		                                4,
		                                4,
		                                UnitTypes.Pixels,
		                                new double[]
		                                {
		                                        0.0d, 103.33333333333333d, 206.66666666666666d, 310.0d,
		                                        0.0d, 103.33333333333333d, 206.66666666666666d, 310.0d,
		                                        0.0d, 103.33333333333333d, 206.66666666666666d, 310.0d,
		                                        0.0d, 103.33333333333333d, 206.66666666666666d, 310.0d
		                                },
		                                UnitTypes.Pixels,
		                                new double[]
		                                {
		                                        0.0d, 0.0d, 0.0d, 0.0d,
		                                        49.666666666666664d, 49.666666666666664d, 49.666666666666664d, 49.666666666666664d,
		                                        99.333333333333329d, 99.333333333333329d, 99.333333333333329d, 99.333333333333329d,
		                                        149, 149, 149, 149,
		                                },
		                        },
		                new Object[]
		                        {
		                                true,
		                                "cf0477a8-8f92-ac4f-9462-f78e26234851",
		                                1,
		                                1,
		                                0x10,
		                                PlacedLayerType.Raster,
		                                new double[]
		                                {
		                                        37.900314592235681,
		                                        -0.32118219433001371,
		                                        185.94210608826535,
		                                        57.7076819802063,
		                                        153.32047433609358,
		                                        140.9311755779743,
		                                        5.2786828400639294,
		                                        82.902311403437977,
		                                },
		                                0d,
		                                0d,
		                                0d,
		                                0d,
		                                0d,
		                                721d,
		                                1280d,
		                                4,
		                                4,
		                                UnitTypes.Pixels,
		                                new double[]
		                                {
		                                        0.0, 426.66666666666663, 853.33333333333326, 1280,
		                                        0.0, 426.66666666666663, 853.33333333333326, 1280,
		                                        0.0, 426.66666666666663, 853.33333333333326, 1280,
		                                        0.0, 426.66666666666663, 853.33333333333326, 1280,
		                                },
		                                UnitTypes.Pixels,
		                                new double[]
		                                {
		                                        0.0, 0.0, 0.0, 0.0,
		                                        240.33333333333331, 240.33333333333331, 240.33333333333331, 240.33333333333331,
		                                        480.66666666666663, 480.66666666666663, 480.66666666666663, 480.66666666666663,
		                                        721, 721, 721, 721,
		                                },
		                                0,
		                                0
		                        }
		        };
		
		// Load a predefined PSD file containing PlLdResource
		PsdImage image = (PsdImage)Image.load(srcPsdPath);
		try
		{
		    PlLdResource resource = null;
		    int index = 0;
		    for (Layer imageLayer : image.getLayers())
		    {
		        for (LayerResource imageResource : imageLayer.getResources())
		        {
		            if (imageResource instanceof PlLdResource)
		            {
		                // Make sure the loaded resource is what we expect at the same time
		                // demonstrate API usage of PlLdResource
		                resource = (PlLdResource)imageResource;
		                Object[] expectedValue = expectedValues[index++];
		                $.assertAreEqual(expectedValue[0], resource.isCustom());
		                $.assertAreEqual(expectedValue[1], resource.getUniqueId().toString());
		                $.assertAreEqual(expectedValue[2], resource.getPageNumber());
		                $.assertAreEqual(expectedValue[3], resource.getTotalPages());
		                $.assertAreEqual(expectedValue[4], resource.getAntiAliasPolicy());
		                $.assertAreEqual(expectedValue[5], resource.getPlacedLayerType());
		                $.assertAreEqual(8, resource.getTransformMatrix().length);
		                $.assertAreEqual(expectedValue[6], resource.getTransformMatrix());
		                $.assertAreEqual(expectedValue[7], resource.getValue());
		                $.assertAreEqual(expectedValue[8], resource.getPerspective());
		                $.assertAreEqual(expectedValue[9], resource.getPerspectiveOther());
		                $.assertAreEqual(expectedValue[10], resource.getTop());
		                $.assertAreEqual(expectedValue[11], resource.getLeft());
		                $.assertAreEqual(expectedValue[12], resource.getBottom());
		                $.assertAreEqual(expectedValue[13], resource.getRight());
		                $.assertAreEqual(expectedValue[14], resource.getUOrder());
		                $.assertAreEqual(expectedValue[15], resource.getVOrder());
		                if (resource.isCustom())
		                {
		                    $.assertAreEqual(expectedValue[16], resource.getHorizontalMeshPointUnit());
		                    $.assertAreEqual(expectedValue[17], resource.getHorizontalMeshPoints());
		                    $.assertAreEqual(expectedValue[18], resource.getVerticalMeshPointUnit());
		                    $.assertAreEqual(expectedValue[19], resource.getVerticalMeshPoints());
		                    double[] temp = resource.getVerticalMeshPoints();
		                    resource.setVerticalMeshPoints(resource.getHorizontalMeshPoints());
		                    resource.setHorizontalMeshPoints(temp);
		                }
		
		                // This values should be changed they are given just for an example,
		                // to demonstrate API usage of PlLdResource
		                resource.setUniqueId(UUID.randomUUID());
		                resource.setPageNumber(2);
		                resource.setTotalPages(3);
		                resource.setAntiAliasPolicy(30);
		                resource.setPlacedLayerType(PlacedLayerType.Vector);
		                resource.setValue(1.23456789);
		                resource.setPerspective(0.123456789);
		                resource.setPerspectiveOther(0.987654321);
		                resource.setTop(-126);
		                resource.setLeft(-215);
		                resource.setBottom(248);
		                resource.setRight(145);
		                resource.setUOrder(6);
		                resource.setVOrder(9);
		
		                break;
		            }
		        }
		    }
		
		    // Make sure the resource were found
		    $.assertAreEqual(true, resource != null);
		    image.save(dstPsdPath, new PsdOptions(image));
		}
		finally
		{
		    image.dispose();
		}
		//ExEnd:SupportPlLdResource
	}
}
