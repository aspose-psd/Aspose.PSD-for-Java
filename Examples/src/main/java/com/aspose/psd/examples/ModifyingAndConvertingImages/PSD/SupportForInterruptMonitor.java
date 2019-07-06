/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.ModifyingAndConvertingImages.PSD;

import com.aspose.psd.Image;
import com.aspose.psd.ImageOptionsBase;
import com.aspose.psd.coreexceptions.OperationInterruptedException;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.multithreading.InterruptMonitor;
import java.io.File;
import java.util.Date;

/**
 *
 *  
 */
public class SupportForInterruptMonitor {
    //ExStart:SupportForInterruptMonitor
    public static void main(String[] args) throws InterruptedException 
    {
       
       String dataDir = Utils.getDataDir(SupportForInterruptMonitor.class) + "PSD/";
       ImageOptionsBase saveOptions = new PngOptions();

	InterruptMonitor monitor = new InterruptMonitor();
	SaveImageWorker worker = new SaveImageWorker(dataDir + "big.psb", dataDir + "big_out.png", saveOptions, monitor);

	Thread thread = new Thread(worker);

	try
	{
		thread.start();

		// The timeout should be less than the time required for full image conversion (without interruption).
		Thread.sleep(3000);

		// Interrupt the process
		System.out.format("Interrupting the save thread #%d at %s\n", thread.getId(), new Date().toString());
		monitor.interrupt();

		// Wait for interruption...
		thread.join();
	}
	finally
	{
		// If the file to be deleted does not exist, no exception is thrown.
		File f = new File(dataDir + "big_out.png");
		f.delete();
	}
       
    }
    
    
}
/**
 * Initiates image conversion and waits for its interruption.
 */
 class SaveImageWorker implements Runnable
{
	/**
	 * The path to the input image.
	 */
	private final String inputPath;

	/**
	 *  The path to the output image.
	 */
	private final String outputPath;

	/**
	 * The interrupt monitor.
	 */
	private final InterruptMonitor monitor;

	/**
	 * The save options.
	 */
	private final ImageOptionsBase saveOptions;

	/**
	 * Initializes a new instance of the SaveImageWorker class.
	 * @param inputPath The path to the input image.
	 * @param outputPath The path to the output image.
	 * @param saveOptions The save options.
	 * @param monitor The interrupt monitor.
	 */
	public SaveImageWorker(String inputPath, String outputPath, ImageOptionsBase saveOptions, InterruptMonitor monitor)
	{
		this.inputPath = inputPath;
		this.outputPath = outputPath;
		this.saveOptions = saveOptions;
		this.monitor = monitor;
	}

	/**
	 * Tries to convert image from one format to another. Handles interruption.
	 */
	public void run()
	{
		Image image = Image.load(this.inputPath);
		try
		{
			InterruptMonitor.setThreadLocalInstance(this.monitor);

			try
			{
				image.save(this.outputPath, this.saveOptions);
			}
			catch (OperationInterruptedException e)
			{
				System.out.format("The save thread #%d finishes at %s\n", Thread.currentThread().getId(), new Date().toString());
				System.out.println(e);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				InterruptMonitor.setThreadLocalInstance(null);
			}
		}
		finally
		{
			image.dispose();
		}
                //ExEnd:SupportForInterruptMonitor
        
        }
}
//ExEnd:SupportForInterruptMonitor