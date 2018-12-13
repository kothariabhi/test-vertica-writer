/*
 * Copyright 2013 Keith D Swenson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// https://github.com/agilepro/mendocino/blob/master/src/org/workcast/streams/CSVHelper.java

package com.abhi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

//import com.netcore.p1dm.asuseractivity.Test;

/**
 * Helps to read and write a CSV file, all methods are static writeLine:
 * Converts list of String values into a line of a CSV file parseLine: read a
 * line from a LineNumberReader and return the list of Strings
 *
 * That should be all you need. Create or open the file & streams yourself from
 * whatever source you need to read from.. Everything in this class works on
 * characters, and not bytes.
 */
public class CSVHelper {
	final static Logger logger = Logger.getLogger(CSVHelper.class);

	public static void writeLine(Writer w, List<String> values) throws Exception {

		boolean firstVal = true;
		for (String val : values) {
			if (!firstVal) {
				w.write(",");
			}
			w.write("\"");
			for (int i = 0; i < val.length(); i++) {
				char ch = val.charAt(i);
				if (ch == '\"') {
					w.write("\""); // extra quote
				}
				w.write(ch);
			}
			w.write("\"");
			firstVal = false;
		}
		w.write("\n");
	}

	public static List<Object> parseLineToUpper(Reader r, char separator, boolean convertToUpper) throws Exception {
		int ch = r.read();
		while (ch == '\r') {
			// ignore linefeed characters wherever they are, particularly just before end of
			// file
			ch = r.read();
		}
		if (ch < 0) {
			return null;
		}
		ArrayList<Object> store = new ArrayList<Object>();
		StringBuffer curVal = new StringBuffer();
		boolean inquotes = false;
		boolean started = false;
		while (ch >= 0) {
			if (inquotes) {
				started = true;
				if (ch == '\"') {
					inquotes = false;
				} else {
					curVal.append((char) ch);
				}
			} else {
				if (ch == '\"') {
					inquotes = true;
					if (started) {
						// if this is the second quote in a value, add a quote
						// this is for the double quote in the middle of a value
						curVal.append('\"');
					}
				} else if (ch == separator) {
					if (convertToUpper) {
						store.add(curVal.toString().toUpperCase());
					} else {
						store.add(curVal.toString());
					}
					curVal = new StringBuffer();
					started = false;
				} else if (ch == '\r') {
					// ignore LF characters
				} else if (ch == '\n') {
					// end of a line, break out
					break;
				} else {
					curVal.append((char) ch);
				}
			}
			ch = r.read();
		}

		if (convertToUpper) {
			store.add(curVal.toString().toUpperCase());
		} else {
			store.add(curVal.toString());
		}
		return store;
	}

	/**
	 * returns a row of values as a list returns null if you are past the end of the
	 * line
	 */
	public static List<Object> parseLine(Reader r) throws Exception {
		return parseLineToUpper(r, ',', false);
	}

	public static List<Object> parseLine(Reader r, String separator, boolean convertToUpper) throws Exception {
		char importSeparator = (separator != null && !separator.trim().isEmpty()) ? separator.toCharArray()[0] : ',';
		return parseLineToUpper(r, importSeparator, convertToUpper);
	}

	public static void main(String[] args) throws Exception {

		// URL url = new
		// URL("http://emm16.netcore.co.in/mdownload/existing_emm16_mvc_gaurang_0.94069500%201456394125_244298884.csv");
		// String tDir = System.getProperty("java.io.tmpdir");
		String path = "/tmp/quote.csv";
		File file = new File(path);
		// file.deleteOnExit();
		// FileUtils.copyURLToFile(url, file);

		FileInputStream fis = new FileInputStream(file);
		Reader fr = new InputStreamReader(fis, "UTF-8");

		List<Object> values = CSVHelper.parseLine(fr);
		while (values != null) {
			logger.info(values);
			values = CSVHelper.parseLine(fr);
		}
		fr.close();
	}

}