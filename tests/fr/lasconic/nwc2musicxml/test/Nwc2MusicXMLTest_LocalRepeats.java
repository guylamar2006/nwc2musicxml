package fr.lasconic.nwc2musicxml.test;

import static org.junit.Assert.*;

import fr.lasconic.nwc2musicxml.convert.Nwc2MusicXML;
import fr.lasconic.nwc2musicxml.utils.IOUtils;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class Nwc2MusicXMLTest_LocalRepeats {

	@Test
	public void testMain() {
		String[] args = new String[2];
		args[0] = "TestFiles/TestLocalRepeatCloseRepeat3.nwctxt";
		args[1] = "bin/LocalRepeatCloseRepeat3.xml";
		Nwc2MusicXML.main(args);
		
		String refFile = "TestFiles/LocalRepeatCloseRepeat3.xml";
		
		try {
			InputStream in1 = new FileInputStream(args[1]);
			InputStream in2 = new FileInputStream(refFile);
	
			if (!IOUtils.contentExceptEncodingDateEquals(in1, in2))
				fail("Files Different: Repeats");
		} catch (IOException ioe) {
			fail("IOException " + ioe.getMessage());
		}
		System.out.println("Test Success: Repeats");
	}
}
