package com.abhi.testmongo;

public class TestDate {
	
	public static void main(String[] args) {
		String ts = "2017-10-30 00:01:11";
		System.out.println(ts);
		ts = ts.replaceAll("[-: ]", "");
		System.out.println(ts);
		System.out.println(ts.substring(2, 8));
		System.out.println(ts.substring(8));
		
	}

}
