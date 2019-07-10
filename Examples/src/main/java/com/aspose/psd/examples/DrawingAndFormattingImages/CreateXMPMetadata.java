/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.psd.examples.DrawingAndFormattingImages;

import com.aspose.psd.Rectangle;
import com.aspose.psd.examples.Utils.Utils;
import com.aspose.psd.fileformats.psd.PsdImage;
import com.aspose.psd.system.io.MemoryStream;
import com.aspose.psd.xmp.XmpHeaderPi;
import com.aspose.psd.xmp.XmpMeta;
import com.aspose.psd.xmp.XmpPacketWrapper;
import com.aspose.psd.xmp.XmpTrailerPi;
import com.aspose.psd.xmp.schemas.dublincore.DublinCorePackage;
import com.aspose.psd.xmp.schemas.photoshop.ColorMode;
import com.aspose.psd.xmp.schemas.photoshop.PhotoshopPackage;


public class CreateXMPMetadata {
    public static void main(String[] args) 
    {
       //ExStart:CreateXMPMetadata
       String dataDir = Utils.getDataDir(CreateXMPMetadata.class) + "DrawingAndFormattingImages/";
       
       // Specify the size of image by defining a Rectangle 
		Rectangle rect = new Rectangle(0, 0, 100, 200);

		
	

		// create the brand new image just for sample purposes
		
                PsdImage image = new PsdImage(rect.getWidth(), rect.getHeight());
		    // create an instance of XMP-Header
		    XmpHeaderPi xmpHeader = new XmpHeaderPi();
                   xmpHeader.setGuid(dataDir);
		    // create an instance of Xmp-TrailerPi 
		    XmpTrailerPi xmpTrailer = new XmpTrailerPi(true);

		    // create an instance of XMPmeta class to set different attributes
		    XmpMeta xmpMeta = new XmpMeta();
		    xmpMeta.addAttribute("Author", "Mr Smith");
		    xmpMeta.addAttribute("Description", "The fake metadata value");

		    // create an instance of XmpPacketWrapper that contains all metadata
		    XmpPacketWrapper xmpData = new XmpPacketWrapper(xmpHeader, xmpTrailer, xmpMeta);

		    // create an instacne of Photoshop package and set photoshop attributes
		    PhotoshopPackage photoshopPackage = new PhotoshopPackage();
		    photoshopPackage.setCity("London");
		    photoshopPackage.setCountry("England");
		    photoshopPackage.setColorMode(ColorMode.Rgb);
	
		    // add photoshop package into XMP metadata
		    xmpData.addPackage(photoshopPackage);

		    // create an instacne of DublinCore package and set dublinCore attributes
		    DublinCorePackage dublinCorePackage = new DublinCorePackage();
		    dublinCorePackage.setAuthor("Charles Bukowski");
		    dublinCorePackage.setTitle("Confessions of a Man Insane Enough to Live With the Beasts");
		    dublinCorePackage.addValue("dc:movie", "Barfly");

		    // add dublinCore Package into XMP metadata
		    xmpData.addPackage(dublinCorePackage);

		    MemoryStream ms = new MemoryStream();
		        // update XMP metadata into image
		        image.setXmpData(xmpData);
                            
		        // Save image on the disk or in memory stream
		        image.save(dataDir + "create_XMP_Metadata.psd");
       //ExEnd:CreateXMPMetadata
       
    }
}
