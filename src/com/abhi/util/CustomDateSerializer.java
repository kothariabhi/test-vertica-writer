package com.abhi.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


public class CustomDateSerializer extends DateSerializer {

	    @Override
	    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
	        throws IOException, JsonProcessingException {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String format = formatter.format(value);
	        jgen.writeString(format);
	    }

	}
