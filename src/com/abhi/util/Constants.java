package com.abhi.util;

import java.util.Map;

public class Constants {

	private Map<String, String> props;
	public Constants(Map<String, String> props){
		this.props = props;
	}
	
	public String getProperty(String property){
		return this.props.get(property);
	}
	
	public String getProperty(String property, String def){
		String ret = this.props.get(property);
		if (ret == null )
			return def; 
		else
			return ret;
	}
	
}
