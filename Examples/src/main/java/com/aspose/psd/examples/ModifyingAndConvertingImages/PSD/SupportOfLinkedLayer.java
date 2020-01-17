
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.examples.ModifyingAndConvertingImages.TIFF.ExportToMultiPageTiff;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.fileformats.psd.layers.Layer;


public class SupportOfLinkedLayer {

    public static void main(String[] args) throws Exception 
    {
       //ExStart:SupportOfLinkedLayer
       String dataDir = Utils.getDataDir(SupportOfLinkedLayer.class) + "ModifyingAndConvertingImages/";
       
       
       PsdImage psd = (PsdImage) Image.load(dataDir + "LinkedLayerexample.psd");
        try
        {
            Layer[] layers = psd.getLayers();

            
            short layersLinkGroupId = psd.getLinkedLayersManager().linkLayers(layers);

           
            short linkGroupId = psd.getLinkedLayersManager().getLinkGroupId(layers[0]);
            if (layersLinkGroupId != linkGroupId)
            {
                throw new Exception("layersLinkGroupId and linkGroupId are not equal.");
            }

            
            Layer[] linkedLayers = psd.getLinkedLayersManager().getLayersByLinkGroupId(linkGroupId);

           
            for (Layer linkedLayer : linkedLayers)
            {
                psd.getLinkedLayersManager().unlinkLayer(linkedLayer);
            }

            
            linkedLayers = psd.getLinkedLayersManager().getLayersByLinkGroupId(linkGroupId);
            if (linkedLayers != null)
            {
                throw new Exception("The linkedLayers field is not NULL.");
            }
            psd.save(dataDir + "LinkedLayerexample_output.psd");
        }
        finally
        {
            psd.dispose();
        }
       //ExEnd:SupportOfLinkedLayer
    }   
    
}
