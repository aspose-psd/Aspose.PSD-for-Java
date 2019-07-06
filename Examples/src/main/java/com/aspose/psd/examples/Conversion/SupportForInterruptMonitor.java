/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.Conversion;

import com.aspose.psd.ImageOptionsBase;
import com.aspose.psd.examples.Utils.Utils;
import static com.aspose.psd.examples.Utils.Utils.getDateTime;
import com.aspose.psd.imageoptions.PngOptions;
import com.aspose.psd.multithreading.InterruptMonitor;
import com.aspose.psd.system.Threading.ThreadStart;
import java.io.File;

/**
 *
 *  
 */
public class SupportForInterruptMonitor {
    public static void main(String[] args) throws InterruptedException
    {
       //ExStart:SupportForInterruptMonitor
       String dataDir = Utils.getDataDir(SupportForInterruptMonitor.class) + "Conversion/";
       
       
            ImageOptionsBase saveOptions = new PngOptions();
            
            InterruptMonitor monitor = new InterruptMonitor();
            String source = dataDir+ "big2.psb";
            String output = dataDir+ "big_out.png";
           
            SaveImageWorker worker = new SaveImageWorker(source, output, saveOptions, monitor);
       
            Thread thread = new Thread(worker.ThreadProc());
            try
            {
                thread.start();

                // The timeout should be less than the time required for full image conversion (without interruption).
                Thread.sleep(3000);

                // Interrupt the process
                monitor.interrupt();
                System.out.println("Interrupting the save thread #" +thread.getId() +   " at" + getDateTime().toString());

                // Wait for interruption...
                thread.join();
            }
            finally
            {
                // Delete the output file.
                File f = new File(output);
                if (f.exists())
                {
                    f.delete();
                }
            }
       //ExEnd:SupportForInterruptMonitor
    }
}
