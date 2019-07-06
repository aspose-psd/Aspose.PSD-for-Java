/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Cache;
import com.aspose.psd.CacheType;
import com.aspose.psd.Color;
import com.aspose.psd.ColorPalette;
import com.aspose.psd.Image;
import com.aspose.psd.RasterImage;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.GifOptions;
import com.aspose.psd.sources.StreamSource;
import com.aspose.psd.system.io.MemoryStream;

/**
 *
 *  
 */
public class ControllCacheReallocation {
    public static void main(String[] args) 
    {
       //ExStart:ControllCacheReallocation
       String dataDir = Utils.getDataDir(ControllCacheReallocation.class) + "PSD/";
       
       // By default the cache folder is set to the local temp directory.  You can specify a different cache folder from the default this way:
            Cache.setCacheFolder(dataDir);

            // Set cache on disk.
            Cache.setCacheType(CacheType.CacheOnDiskOnly);

            // The default cache max value is 0, which means that there is no upper limit
            Cache.setMaxDiskSpaceForCache(1073741824); // 1 gigabyte
            Cache.setMaxMemoryForCache(1073741824); // 1 gigabyte

            // We do not recommend that you change the following property because it may greatly affect performance
            Cache.setExactReallocateOnly(false);

            // At any time you can check how many bytes are currently allocated for the cache in memory or on disk By examining the following properties
            long l1 = Cache.getAllocatedDiskBytesCount();
            long l2 = Cache.getAllocatedMemoryBytesCount();
            GifOptions options = new GifOptions();
            
           Color[] color = { Color.getRed(), Color.getBlue(), Color.getBlack(), Color.getWhite() };
            options.setPalette(new ColorPalette(color)) ;
            options.setSource(new StreamSource(new MemoryStream(), true));
            
            RasterImage image = (RasterImage)Image.create(options, 100, 100);
            Color[] pixels = new Color[10000];
                for (int i = 0; i < pixels.length; i++)
                {
                    pixels[i] = Color.getWhite();
                }

                image.savePixels(image.getBounds(), pixels);

                // After executing the code above 40000 bytes are allocated to disk.
                long diskBytes = Cache.getAllocatedDiskBytesCount();
                long memoryBytes = Cache.getAllocatedMemoryBytesCount();
       
                
                // The allocation properties may be used to check whether all Aspose.Imaging objects were properly disposed. If you've forgotten to call dispose on an object the cache values will not be 0.
            l1 = Cache.getAllocatedDiskBytesCount();
            l2 = Cache.getAllocatedMemoryBytesCount();
       //ExEnd:ControllCacheReallocation
    }
}
