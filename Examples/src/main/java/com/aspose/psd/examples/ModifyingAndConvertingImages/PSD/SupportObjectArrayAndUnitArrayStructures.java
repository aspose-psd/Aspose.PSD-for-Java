package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.OSTypeStructure;
import com.aspose.psd.fileformats.psd.layers.layerresources.smartobjectresources.PlLdResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.typetoolinfostructures.DescriptorStructure;
import com.aspose.psd.fileformats.psd.layers.layerresources.typetoolinfostructures.ObjectArrayStructure;
import com.aspose.psd.fileformats.psd.layers.layerresources.typetoolinfostructures.UnitArrayStructure;
import com.aspose.psd.fileformats.psd.layers.layerresources.typetoolinfostructures.UnitTypes;
import com.aspose.psd.internal.Exceptions.FormatException;

/**
 * This example proves that ObjectArrayStructure and UnitArrayStructure are supported by the library
 * so that we can read and write them. The program walks through the hierarchy of resource
 * structures in search of the valid UnitArrayStructure.
 */
public class SupportObjectArrayAndUnitArrayStructures
{
	public static void main(String[] args)
	{
		String dataDir = Utils.GetDataDir_PSD();

		//ExStart:SupportObjectArrayAndUnitArrayStructures
		// Define a local class just to keep reusable code (methods)
		class LocalScopeExtension
		{
		    void assertAreEqual(Object actual, Object expected)
		    {
		        if (!((actual == expected) || (actual != null && actual.equals(expected))))
		        {
		            throw new FormatException(String.format(
		                    "Actual value %s are not equal to expected %s.", actual, expected));
		        }
		    }
		}
		LocalScopeExtension $ = new LocalScopeExtension();
		
		String srcPsdPath = dataDir + "LayeredSmartObjects8bit2.psd";
		
		// Load a predefine PSD file containing a smart object with PlLdResource
		PsdImage image = (PsdImage)Image.load(srcPsdPath);
		try
		{
		    // Walk through the hierarchy of structures in search of UnitArrayStructure
		    UnitArrayStructure verticalStructure = null;
		    for (Layer imageLayer : image.getLayers())
		    {
		        for (LayerResource imageResource : imageLayer.getResources())
		        {
		            PlLdResource resource;
		            if (imageResource instanceof PlLdResource &&
		                    (resource = (PlLdResource)imageResource).isCustom())
		            {
		                for (OSTypeStructure structure : resource.getItems())
		                {
		                    if (structure.getKeyName().getClassName().equals("customEnvelopeWarp"))
		                    {
		                        // Make sure that the loaded file is what we expect
		                        $.assertAreEqual(DescriptorStructure.class, structure.getClass());
		                        DescriptorStructure custom = (DescriptorStructure)structure;
		                        $.assertAreEqual(custom.getStructures().length, 1);
		                        OSTypeStructure mesh = custom.getStructures()[0];
		                        $.assertAreEqual(ObjectArrayStructure.class, mesh.getClass());
		                        ObjectArrayStructure meshObjectArray = (ObjectArrayStructure)mesh;
		                        $.assertAreEqual(meshObjectArray.getStructures().length, 2);
		                        OSTypeStructure vertical = meshObjectArray.getStructures()[1];
		
		                        // Finally verify and assign the found UnitArrayStructure
		                        $.assertAreEqual(UnitArrayStructure.class, vertical.getClass());
		                        verticalStructure = (UnitArrayStructure)vertical;
		                        $.assertAreEqual(verticalStructure.getUnitType(), UnitTypes.Pixels);
		                        $.assertAreEqual(verticalStructure.getValueCount(), 16);
		
		                        break;
		                    }
		                }
		            }
		        }
		    }
		
		    $.assertAreEqual(true, verticalStructure != null);
		}
		finally
		{
		    image.dispose();
		}
		//ExEnd:SupportObjectArrayAndUnitArrayStructures
	}
}
