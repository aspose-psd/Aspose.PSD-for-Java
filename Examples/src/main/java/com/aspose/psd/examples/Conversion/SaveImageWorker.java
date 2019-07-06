/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.Image;
import com.aspose.psd.ImageOptionsBase;
import com.aspose.psd.coreexceptions.OperationInterruptedException;
import static com.aspose.psd.examples.Utils.Utils.getDateTime;
import com.aspose.psd.multithreading.InterruptMonitor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mfazi
 */
//ExStart:SaveImageWorker
public class SaveImageWorker {
    
    /// <summary>
        /// The path to the input image.
        /// </summary>
        private  String inputPath;

        /// <summary>
        /// The path to the output image.
        /// </summary>
        private  String outputPath;

        /// <summary>
        /// The interrupt monitor.
        /// </summary>
        private  InterruptMonitor monitor;

        /// <summary>
        /// The save options.
        /// </summary>
        private  ImageOptionsBase saveOptions;

        /// <summary>
        /// Initializes a new instance of the <see cref="SaveImageWorker" /> class.
        /// </summary>
        /// <param name="inputPath">The path to the input image.</param>
        /// <param name="outputPath">The path to the output image.</param>
        /// <param name="saveOptions">The save options.</param>
        /// <param name="monitor">The interrupt monitor.</param>
        public SaveImageWorker(String inputPath, String outputPath, ImageOptionsBase saveOptions, InterruptMonitor monitor)
        {
            this.inputPath = inputPath;
            this.outputPath = outputPath;
            this.saveOptions = saveOptions;
            this.monitor = monitor;
        }
        
         /// <summary>
        /// Tries to convert image from one format to another. Handles interruption.
        /// </summary>
        public String ThreadProc()
        {
            Image image = Image.load(this.inputPath);
            
                InterruptMonitor.setThreadLocalInstance(this.monitor);  

                try
                {
                    image.save(this.outputPath, this.saveOptions);
                }
                catch (OperationInterruptedException e)
                {
                    
                    System.out.println("The save thread # " + Thread.currentThread().getId() +  "finishes at" + getDateTime().toString() );
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
            return "Hello Aspose";
        }
}
//ExEnd:SaveImageWorker
