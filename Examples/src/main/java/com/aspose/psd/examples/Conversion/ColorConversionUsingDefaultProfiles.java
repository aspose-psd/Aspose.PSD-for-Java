/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Color;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.jpeg.JpegCompressionColorMode;
import com.aspose.psd.fileformats.jpeg.JpegImage;
import com.aspose.psd.imageoptions.JpegOptions;
import com.aspose.psd.sources.StreamSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 *  
 */
public class ColorConversionUsingDefaultProfiles {
    
     public static void main(String[] args) throws FileNotFoundException 
    {
       //ExStart:ColorConversionUsingDefaultProfiles
       String dataDir = Utils.getDataDir(ColorConversionUsingDefaultProfiles.class) + "Conversion/";
       
       JpegImage image = new JpegImage(500, 500);
       // Fill image data.
                int count = image.getWidth() * image.getHeight();
                int[] pixels = new int[count];
                int r = 0;
                int g = 0;
                int b = 0;
                int channel = 0;
                for (int i = 0; i < count; i++)
                {
                    if (channel % 3 == 0)
                    {
                        r++;
                        if (r == 256)
                        {
                            r = 0;
                            channel++;
                        }
                    }
                    else if (channel % 3 == 1)
                    {
                        g++;
                        if (g == 256)
                        {
                            g = 0;
                            channel++;
                        }
                    }
                    else
                    {
                        b++;
                        if (b == 256)
                        {
                            b = 0;
                            channel++;
                        }
                    }

                    pixels[i] = Color.fromArgb(r, g, b).toArgb();
                }
                
                 // Save the newly created pixels.
                image.saveArgb32Pixels(image.getBounds(), pixels);

                // Save the newly created image.
                image.save(dataDir+"Default.jpg");

                // Update color profile.
                
                File rgbFile = new File(dataDir + "eciRGB_v2.icc");
                FileInputStream rgbInputStream = new FileInputStream(rgbFile);
                StreamSource rgbprofile = new StreamSource(rgbInputStream);
                
                File cmykFile = new File(dataDir + "ISOcoated_v2_FullGamut4.icc");
                FileInputStream cmykInputStream = new FileInputStream(cmykFile);
                StreamSource cmykprofile = new StreamSource(cmykInputStream);
               
                
                image.setDestinationRgbColorProfile(rgbprofile);
                image.setDestinationCmykColorProfile(cmykprofile);

                // Save the resultant image with new YCCK profiles. You will notice differences in color values if compare the images.
                JpegOptions options = new JpegOptions();
                options.setColorType(JpegCompressionColorMode.Cmyk) ;
                image.save(dataDir + "Cmyk_Default_profiles.jpg", options);
       //ExEnd:ColorConversionUsingDefaultProfiles
    }
}
