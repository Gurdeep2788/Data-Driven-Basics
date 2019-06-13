package com.w2a.rough;

import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		
		Date d = new Date();		
		String dateStammp = d.toString().replace(":", "_").replace(" ", "_");
		System.out.println(dateStammp);
				

	}

}
