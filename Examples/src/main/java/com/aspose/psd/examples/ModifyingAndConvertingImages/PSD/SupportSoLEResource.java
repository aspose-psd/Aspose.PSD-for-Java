package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.PlacedLayerType;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.SmartObjectResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.SoLeResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.typetoolinfostructures.UnitTypes;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.internal.Exceptions.FormatException;

import java.lang.reflect.Array;
import java.util.UUID;

/**
 * This example demonstrates API usage of SoLEResource and proves that reading and writing
 * SoLEResources works as expected so the resource is supported.
 */
public class SupportSoLEResource
{
	public static void main(String[] args)
	{
		String dataDir = Utils.GetDataDir_PSD();
		String outputDir = Utils.GetDataDir_Output();

		//ExStart:SupportSoLEResource
		class LocalScopeExtension
		{
		    void assertIsTrue(boolean condition)
		    {
		        if (!condition)
		        {
		            throw new FormatException("Expected true");
		        }
		    }
		
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
		
		    void checkSmartObjectResourceValues(Object[] expectedValue, SmartObjectResource resource)
		    {
		        assertAreEqual(expectedValue[0], resource.isCustom());
		        assertAreEqual(expectedValue[2], resource.getPageNumber());
		        assertAreEqual(expectedValue[3], resource.getTotalPages());
		        assertAreEqual(expectedValue[4], resource.getAntiAliasPolicy());
		        assertAreEqual(expectedValue[5], resource.getPlacedLayerType());
		        assertAreEqual(8, resource.getTransformMatrix().length);
		        assertAreEqual(expectedValue[6], resource.getTransformMatrix());
		        assertAreEqual(expectedValue[7], resource.getValue());
		        assertAreEqual(expectedValue[8], resource.getPerspective());
		        assertAreEqual(expectedValue[9], resource.getPerspectiveOther());
		        assertAreEqual(expectedValue[10], resource.getTop());
		        assertAreEqual(expectedValue[11], resource.getLeft());
		        assertAreEqual(expectedValue[12], resource.getBottom());
		        assertAreEqual(expectedValue[13], resource.getRight());
		        assertAreEqual(expectedValue[14], resource.getUOrder());
		        assertAreEqual(expectedValue[15], resource.getVOrder());
		
		        assertAreEqual(expectedValue[16], resource.getCrop());
		        assertAreEqual(expectedValue[17], resource.getFrameStepNumerator());
		        assertAreEqual(expectedValue[18], resource.getFrameStepDenominator());
		        assertAreEqual(expectedValue[19], resource.getDurationNumerator());
		        assertAreEqual(expectedValue[20], resource.getDurationDenominator());
		        assertAreEqual(expectedValue[21], resource.getFrameCount());
		        assertAreEqual(expectedValue[22], resource.getWidth());
		        assertAreEqual(expectedValue[23], resource.getHeight());
		        assertAreEqual(expectedValue[24], resource.getResolution());
		        assertAreEqual(expectedValue[25], resource.getResolutionUnit());
		        assertAreEqual(expectedValue[26], resource.getComp());
		        assertAreEqual(expectedValue[27], resource.getCompId());
		        assertAreEqual(expectedValue[28], resource.getOriginalCompId());
		        assertAreEqual(expectedValue[29], resource.getPlacedId().toString());
		        assertAreEqual(expectedValue[30], resource.getNonAffineTransformMatrix());
		        if (resource.isCustom())
		        {
		            assertAreEqual(expectedValue[31], resource.getHorizontalMeshPointUnit());
		            assertAreEqual(expectedValue[32], resource.getHorizontalMeshPoints());
		            assertAreEqual(expectedValue[33], resource.getVerticalMeshPointUnit());
		            assertAreEqual(expectedValue[34], resource.getVerticalMeshPoints());
		        }
		    }
		
		    void setNewSmartValues(SmartObjectResource resource, Object[] newValues)
		    {
		        // This values we do not change in resource
		        newValues[0] = resource.isCustom();
		        newValues[1] = resource.getUniqueId().toString();
		        newValues[5] = resource.getPlacedLayerType();
		        newValues[14] = resource.getUOrder();
		        newValues[15] = resource.getVOrder();
		        newValues[28] = resource.getOriginalCompId();
		
		        // This values should be changed in the PlLdResource (with the specified UniqueId) as well
		        // and some of them must be in accord with the underlining smart object in the LinkDataSource
		        resource.setPageNumber((Integer)newValues[2]); // 2;
		        resource.setTotalPages((Integer)newValues[3]); // 3;
		        resource.setAntiAliasPolicy((Integer)newValues[4]); // 0;
		        resource.setTransformMatrix((double[])newValues[6]);
		        resource.setValue((Double)newValues[7]); // 1.23456789;
		        resource.setPerspective((Double)newValues[8]); // 0.123456789;
		        resource.setPerspectiveOther((Double)newValues[9]); // 0.987654321;
		        resource.setTop((Double)newValues[10]); // -126;
		        resource.setLeft((Double)newValues[11]); // -215;
		        resource.setBottom((Double)newValues[12]); // 248;
		        resource.setRight((Double)newValues[13]); // 145;
		        resource.setCrop((Integer)newValues[16]); // 5;
		        resource.setFrameStepNumerator((Integer)newValues[17]); // 1;
		        resource.setFrameStepDenominator((Integer)newValues[18]); // 601;
		        resource.setDurationNumerator((Integer)newValues[19]); // 2;
		        resource.setDurationDenominator((Integer)newValues[20]); // 602;
		        resource.setFrameCount((Integer)newValues[21]); // 11;
		        resource.setWidth((Double)newValues[22]); // 541;
		        resource.setHeight((Double)newValues[23]); // 249;
		        resource.setResolution((Double)newValues[24]); // 144;
		        resource.setResolutionUnit((Integer)newValues[25]);
		        resource.setComp((Integer)newValues[26]); // 21;
		        resource.setCompId((Integer)newValues[27]); // 22;
		        resource.setNonAffineTransformMatrix((double[])newValues[30]);
		
		        // This unique Id should be changed in references if any
		        resource.setPlacedId(UUID.fromString((String)newValues[29]));  // "12345678-9abc-def0-9876-54321fecba98");
		        if (resource.isCustom())
		        {
		            resource.setHorizontalMeshPointUnit((Integer)newValues[31]);
		            resource.setHorizontalMeshPoints((double[])newValues[32]);
		            resource.setVerticalMeshPointUnit((Integer)newValues[33]);
		            resource.setVerticalMeshPoints((double[])newValues[34]);
		        }
		
		        // Be careful with some parameters: the saved image may become unreadable by Adobe® Photoshop®
		        //resource.setUOrder(6);
		        //resource.setVOrder(9);
		
		        // Do no change this otherwise you won't be able to use free transform
		        // or change the underlining smart object to the vector type
		        //resource.setPlacedLayerType(PlacedLayerType.Vector);
		
		        // There should be valid PlLdResource with this unique Id
		        //resource.setUniqueId(UUID.fromString("98765432-10fe-cba0-1234-56789abcdef0"));
		    }
		}
		LocalScopeExtension $ = new LocalScopeExtension();
		
		Object[] newSmartValues = new Object[]
		        {
		                true,
		                null,
		                2,
		                3,
		                0,
		                PlacedLayerType.ImageStack,
		                new double[]
		                {
		                        12.937922786050663,
		                        19.419959734187131,
		                        2.85445817782261,
		                        1.0540625423957124,
		                        7.20861031651307,
		                        14.634102808208553,
		                        17.292074924741144,
		                        4
		                },
		                1.23456789,
		                0.123456789,
		                0.987654321,
		                -126d,
		                -215d,
		                248d,
		                145d,
		                4,
		                4,
		                5,
		                1,
		                601,
		                2,
		                602,
		                11,
		                541d,
		                249d,
		                144d,
		                UnitTypes.Percent,
		                21,
		                22,
		                23,
		                "12345678-9abc-def0-9876-54321fecba98",
		                new double[]
		                {
		                        129.937922786050663,
		                        195.419959734187131,
		                        26.85445817782261,
		                        12.0540625423957124,
		                        72.20861031651307,
		                        147.634102808208553,
		                        175.292074924741144,
		                        42
		                },
		                UnitTypes.Points,
		                new double[]
		                {
		                        0.01d, 103.33333333333433d, 206.66686666666666d, 310.02d,
		                        0.20d, 103.33333333333533d, 206.69666666666666d, 310.03d,
		                        30.06d, 103.33333333336333d, 206.66660666666666d, 310.04d,
		                        04.05d, 103.33333333373333d, 206.66666166666666d, 310.05d
		                },
		                UnitTypes.Distance,
		                new double[]
		                {
		                        0.06d, 0.07d, 0.08d, 0.09d,
		                        49.066666666666664d, 49.266666666666664d, 49.566666666666664d, 49.766666666666664d,
		                        99.133333333333329d, 99.433333333333329d, 99.633333333333329d, 99.833333333333329d,
		                        140, 141, 142, 143,
		                },
		        };
		
		Object[] expectedValues = new Object[]
		        {
		                new Object[]
		                        {
		                                false,
		                                "5867318f-3174-9f41-abca-22f56a75247e",
		                                1,
		                                1,
		                                0x10,
		                                PlacedLayerType.Raster,
		                                new double[]
		                                {
		                                        0, 0, 2, 0, 2, 2, 0, 2
		                                },
		                                0d,
		                                0d,
		                                0d,
		                                0d,
		                                0d,
		                                2d,
		                                2d,
		                                4,
		                                4,
		                                1,
		                                0,
		                                600,
		                                0,
		                                600,
		                                1,
		                                2d,
		                                2d,
		                                72d,
		                                UnitTypes.Density,
		                                -1,
		                                -1,
		                                -1,
		                                "64b3997c-06e0-be40-a349-41acf397c897",
		                                new double[]
		                                {
		                                        0, 0, 2, 0, 2, 2, 0, 2
		                                },
		                        }
		        };
		
		String srcPsdPath = dataDir + "rgb8_2x2_linked.psd";
		String dstPsdPath = outputDir + "rgb8_2x2_linked_output.psd";
		
		PsdImage image = (PsdImage)Image.load(srcPsdPath);
		try
		{
		    SoLeResource soleResource = null;
		    int index = 0;
		
		    // Find SoLeResource
		    for (Layer imageLayer : image.getLayers())
		    {
		        for (LayerResource imageResource : imageLayer.getResources())
		        {
		
		            if (imageResource instanceof SoLeResource)
		            {
		                soleResource = (SoLeResource)imageResource;
		                Object[] expectedValue = (Object[])expectedValues[index++];
		                $.assertAreEqual(expectedValue[1], soleResource.getUniqueId().toString());
		                $.checkSmartObjectResourceValues(expectedValue, soleResource);
		                $.setNewSmartValues(soleResource, newSmartValues);
		
		                break;
		            }
		        }
		    }
		
		    $.assertIsTrue(soleResource != null);
		    soleResource = null; // clear the value to reuse the variable a bit later
		
		    // Save the changes to a PSD file for further verification
		    image.save(dstPsdPath, new PsdOptions(image));
		
		    // Load just saved PSD file
		    PsdImage savedImage = (PsdImage)Image.load(dstPsdPath);
		    try
		    {
		        // Find SoLeResource
		        for (Layer imageLayer : image.getLayers())
		        {
		            for (LayerResource imageResource : imageLayer.getResources())
		            {
		                if (imageResource instanceof SoLeResource)
		                {
		                    soleResource = (SoLeResource)imageResource;
		
		                    // Make sure that the resource was saved correctly
		                    $.checkSmartObjectResourceValues(newSmartValues, soleResource);
		
		                    break;
		                }
		            }
		        }
		    }
		    finally
		    {
		        savedImage.dispose();
		    }
		
		    $.assertIsTrue(soleResource != null);
		}
		finally
		{
		    image.dispose();
		}
		//ExEnd:SupportSoLEResource
	}
}
