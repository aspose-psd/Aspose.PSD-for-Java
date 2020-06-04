package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.LayerResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.VsmsResource;
import com.aspose.psd.fileformats.psd.layers.layerresources.vectorpaths.LengthRecord;
import com.aspose.psd.fileformats.psd.layers.layerresources.vectorpaths.PathOperations;

/**
 * An example of changing path operations when working with shapes. The program reads
 * a predefined vector path records (LengthRecord) and changes their path operations then
 * saves a modified copy of the document as a new PSD file.
 */
public class SupportLengthRecordDataProperties
{
    public static void main(String[] args)
    {
        //ExStart:SupportLengthRecordDataProperties
        String sourceDir = Utils.GetDataDir_PSD();
        String outputDir = Utils.GetDataDir_Output();

        String inPsdFilePath = sourceDir + "PathOperationsShape.psd";
        String outPsdFilePath = outputDir + "out_PathOperationsShape.psd";

        // Load a PSD file containing a predefined vsms resource
        PsdImage psdImage = (PsdImage)Image.load(inPsdFilePath);
        try
        {
            // Find first VsmsResource in resources of the predefined layer
            VsmsResource resource = null;
            for (LayerResource layerResource : psdImage.getLayers()[1].getResources())
            {
                if (layerResource instanceof VsmsResource)
                {
                    resource = (VsmsResource)layerResource;
                    break;
                }
            }

            LengthRecord lengthRecord0 = (LengthRecord)resource.getPaths()[2];
            LengthRecord lengthRecord1 = (LengthRecord)resource.getPaths()[7];
            LengthRecord lengthRecord2 = (LengthRecord)resource.getPaths()[11];

            // Change the way in which shapes are combined
            lengthRecord0.setPathOperations(PathOperations.ExcludeOverlappingShapes);
            lengthRecord1.setPathOperations(PathOperations.IntersectShapeAreas);
            lengthRecord2.setPathOperations(PathOperations.SubtractFrontShape);

            // Save a modified copy of loaded PSD file on the path
            psdImage.save(outPsdFilePath);
        }
        finally
        {
            psdImage.dispose();
        }
        //ExEnd:SupportLengthRecordDataProperties
    }
}
