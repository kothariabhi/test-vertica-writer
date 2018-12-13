package com.abhi.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;

class CustomDateDeseralizer extends UntypedObjectDeserializer {

    private static final long serialVersionUID = -2275951539867772400L;
//    private static ISO8601DateFormat isodf = new ISO8601DateFormat();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public Object deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

    	if (jp.getCurrentTokenId() == JsonTokenId.ID_STRING) {
            try {
            	return sdf.parse(jp.getText());
                
            } catch (ParseException e) {
            	return super.deserialize(jp, ctxt);
            }

            
        } else {
            return super.deserialize(jp, ctxt);
        }
    }
}
