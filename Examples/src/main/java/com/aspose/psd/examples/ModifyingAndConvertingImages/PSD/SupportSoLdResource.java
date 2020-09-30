package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.PlacedLayerType;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.SoLdResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.typetoolinfostructures.UnitTypes;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.FormatException;

import java.lang.reflect.Array;
import java.util.UUID;

/**
 * This example shows how to get or set the smart object layer data properties of the PSD file.
 */
public class SupportSoLdResource
{
	public static void main(String[] args)
	{
		String dataDir = Utils.GetDataDir_PSD();
		String outputDir = Utils.GetDataDir_Output();

		//ExStart:SupportSoLdResource
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
		                                0.0,
		                                0.0,
		                                0.0,
		                                0d,
		                                0d,
		                                149d,
		                                310d,
		                                4,
		                                4,
		                                1,
		                                0,
		                                600,
		                                0,
		                                600,
		                                1,
		                                310d,
		                                149d,
		                                72d,
		                                UnitTypes.Density,
		                                -1,
		                                -1,
		                                -1,
		                                "d3388655-19e4-9742-82f2-f553bb01046a",
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
		                                0.0,
		                                0.0,
		                                0.0,
		                                0d,
		                                0d,
		                                721d,
		                                1280d,
		                                4,
		                                4,
		                                1,
		                                0,
		                                600,
		                                0,
		                                600,
		                                1,
		                                1280d,
		                                721d,
		                                72d,
		                                UnitTypes.Density,
		                                -1,
		                                -1,
		                                -1,
		                                "625cc4b9-2c5f-344f-8636-03caf2bd3489",
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
		
		// Load a predefined PSD file containing SoLdResource
		PsdImage image = (PsdImage)Image.load(srcPsdPath);
		try
		{
		    SoLdResource resource = null;
		    int index = 0;
		    for (Layer imageLayer : image.getLayers())
		    {
		        for (LayerResource imageResource : imageLayer.getResources())
		        {
		            if (imageResource instanceof SoLdResource)
		            {
		                // Make sure the loaded resource is what we expect at the same time
		                // demonstrate API usage of SoLdResource
		                resource = (SoLdResource)imageResource;
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
		
		                $.assertAreEqual(expectedValue[16], resource.getCrop());
		                $.assertAreEqual(expectedValue[17], resource.getFrameStepNumerator());
		                $.assertAreEqual(expectedValue[18], resource.getFrameStepDenominator());
		                $.assertAreEqual(expectedValue[19], resource.getDurationNumerator());
		                $.assertAreEqual(expectedValue[20], resource.getDurationDenominator());
		                $.assertAreEqual(expectedValue[21], resource.getFrameCount());
		                $.assertAreEqual(expectedValue[22], resource.getWidth());
		                $.assertAreEqual(expectedValue[23], resource.getHeight());
		                $.assertAreEqual(expectedValue[24], resource.getResolution());
		                $.assertAreEqual(expectedValue[25], resource.getResolutionUnit());
		                $.assertAreEqual(expectedValue[26], resource.getComp());
		                $.assertAreEqual(expectedValue[27], resource.getCompId());
		                $.assertAreEqual(expectedValue[28], resource.getOriginalCompId());
		                $.assertAreEqual(expectedValue[29], resource.getPlacedId().toString());
		                $.assertAreEqual(expectedValue[30], resource.getNonAffineTransformMatrix());
		                if (resource.isCustom())
		                {
		                    $.assertAreEqual(expectedValue[31], resource.getHorizontalMeshPointUnit());
		                    $.assertAreEqual(expectedValue[32], resource.getHorizontalMeshPoints());
		                    $.assertAreEqual(expectedValue[33], resource.getVerticalMeshPointUnit());
		                    $.assertAreEqual(expectedValue[34], resource.getVerticalMeshPoints());
		                    double[] temp = resource.getVerticalMeshPoints();
		                    resource.setVerticalMeshPoints(resource.getHorizontalMeshPoints());
		                    resource.setHorizontalMeshPoints(temp);
		                }
		
		                // This values should be changed in the PlLdResource (with the specified UniqueId) as well
		                // and some of them must be in accord with the underlining smart object in the LinkDataSource
		                resource.setPageNumber(2);
		                resource.setTotalPages(3);
		                resource.setAntiAliasPolicy(0);
		                resource.setValue(1.23456789);
		                resource.setPerspective(0.123456789);
		                resource.setPerspectiveOther(0.987654321);
		                resource.setTop(-126);
		                resource.setLeft(-215);
		                resource.setBottom(248);
		                resource.setRight(145);
		                resource.setCrop(4);
		                resource.setFrameStepNumerator(1);
		                resource.setFrameStepDenominator(601);
		                resource.setDurationNumerator(2);
		                resource.setDurationDenominator(602);
		                resource.setFrameCount(11);
		                resource.setWidth(541);
		                resource.setHeight(249);
		                resource.setResolution(144);
		                resource.setComp(21);
		                resource.setCompId(22);
		                resource.setTransformMatrix(new double[]
		                        {
		                                12.937922786050663,
		                                19.419959734187131,
		                                2.85445817782261,
		                                1.0540625423957124,
		                                7.20861031651307,
		                                14.634102808208553,
		                                17.292074924741144,
		                                4
		                        });
		                resource.setNonAffineTransformMatrix(new double[]
		                        {
		                                129.937922786050663,
		                                195.419959734187131,
		                                26.85445817782261,
		                                12.0540625423957124,
		                                72.20861031651307,
		                                147.634102808208553,
		                                175.292074924741144,
		                                42
		                        });
		
		                // This unique Id should be changed in references if any
		                resource.setPlacedId(UUID.fromString("12345678-9abc-def0-9876-54321fecba98"));
		
		                // Be careful with some parameters: image may became unreadable by Adobe® Photoshop®
		                ////resource.UOrder = 6;
		                ////resource.VOrder = 9;
		
		                // Do no change this otherwise you won't be able to use free transform
		                // or change the underlining smart object to the vector type
		                ////resource.PlacedLayerType = PlacedLayerType.Vector;
		
		                // There should be valid PlLdResource with this unique Id
		                ////resource.UniqueId = new Guid("98765432-10fe-cba0-1234-56789abcdef0");
		
		                break;
		            }
		        }
		    }
		
		    $.assertAreEqual(true, resource != null);
		    image.save(dstPsdPath, new PsdOptions(image));
		}
		finally
		{
		    image.dispose();
		}
		//ExEnd:SupportSoLdResource
	}
}
