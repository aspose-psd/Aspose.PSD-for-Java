package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.ProgressEventHandler;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.png.PngColorType;
import com.aspose.psd.fileformats.psd.ColorModes;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.imageloadoptions.PsdLoadOptions;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.imageoptions.PsdOptions;
import com.aspose.psd.progressmanagement.EventType;
import com.aspose.psd.progressmanagement.ProgressEventHandlerInfo;
import com.aspose.psd.system.Enum;

import java.io.ByteArrayOutputStream;

/**
 * An example of usage of the progress handler for loading and saving operations.
 * The program uses different saving options to fire progress events.
 */
public class ShowProgressOnConversion
{
    public static void main(String[] args)
    {
        //ExStart:ShowProgressOnConversion
        String sourceDir = Utils.GetDataDir_PSD();
        String sourceFilePath = sourceDir + "Apple.psd";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Create a progress handler that writes progress info to the console
        ProgressEventHandler localProgressEventHandler = new ProgressEventHandler()
        {
            @Override
            public void invoke(ProgressEventHandlerInfo progressInfo)
            {
                String message = String.format(
                        "%s %s: %s out of %s",
                        progressInfo.getDescription(),
                        Enum.getName(EventType.class, progressInfo.getEventType()),
                        progressInfo.getValue(),
                        progressInfo.getMaxValue());
                System.out.println(message);
            }
        };

        System.out.println("---------- Loading Apple.psd ----------");
        PsdLoadOptions loadOptions = new PsdLoadOptions();
        // Bind the progress handler to show loading progress
        loadOptions.setProgressEventHandler(localProgressEventHandler);
        // Load PSD using specific loading options
        PsdImage image = (PsdImage)Image.load(sourceFilePath, loadOptions);
        try
        {
            System.out.println("---------- Saving Apple.psd to PNG format ----------");
            PngOptions pngOptions = new PngOptions();
            // Make the output image coloured and non-transparent
            pngOptions.setColorType(PngColorType.Truecolor);
            // Bind the progress handler to show saving progress
            pngOptions.setProgressEventHandler(localProgressEventHandler);
            // Convert PSD to PNG with specific characteristics
            image.save(outputStream, pngOptions);

            System.out.println("---------- Saving Apple.psd to PSD format ----------");
            PsdOptions psdOptions = new PsdOptions();
            // Make the output PSD coloured
            psdOptions.setColorMode(ColorModes.Rgb);
            // Set a channel for each color (red, green, and blue) plus a composite channel
            psdOptions.setChannelsCount((short)4);
            // Bind the progress handler to show saving progress
            psdOptions.setProgressEventHandler(localProgressEventHandler);
            // Save a copy of PSD with specific characteristics
            image.save(outputStream, psdOptions);
        }
        finally
        {
            image.dispose();
        }
        //ExEnd:ShowProgressOnConversion
    }
}
