package com.bank.utility;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Utility {
	
	public List<String> getFromDateToDate(int month,String year){
		List<String> dateList=new ArrayList<>();
		Calendar gc = new GregorianCalendar();
	    gc.set(Calendar.YEAR, Integer.parseInt(year));
        gc.set(Calendar.MONTH, month-1);
        gc.set(Calendar.DAY_OF_MONTH, 1);
        Date monthStart = gc.getTime();
        gc.add(Calendar.MONTH, 1);
        gc.add(Calendar.DAY_OF_MONTH, -1);
        Date monthEnd = gc.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");

        
			dateList.add(format.format(monthStart));
			dateList.add(format.format(monthEnd));
		
		return dateList;
	}

	public int getMonth(String month) {
		switch(month) {
        case "JANUARY":
        case "JAN":
        	month = "1";
        break;

        case "FEBRUARY":
        case "FEB":
        	month = "2";
        break;

        case "MARCH":
        case "MAR":
        	month = "3";
        break;

        case "APRIL":
        case "APR":
        	month = "4";
        break;

        case "MAY":
        	month = "5";
        break;

        case "JUNE":
        case "JUN":
        	month = "6";
        break;

        case "JULY":
        case "JUL":
        	month = "7";
        break;
        
        case "AUGUST":
        case "AUG":
        	month = "8";
        break;
        
        case "SEPTEMBER":
        case "SEP":
        	month = "9";
        break;
        
        case "OCTUBER":
        case "OCT":
        	month = "10";
        break;
        
        case "NOVEMBER":
        case "NOV":
        	month = "11";
        break;
        
        case "DECEMBER":
        case "DEC":
        	month = "12";
        break;
		}
		
		return Integer.parseInt(month);
	}

	public  String generateUserId() {
		 
		Random rand = new Random();
		String accountNum = "U";
		for (int i = 0; i < 5; i++) {
			int n = rand.nextInt(10) + 0;
			accountNum  += Integer.toString(n);
		}
		return accountNum ;
	}
	
	public  String generateAccountNumber() {
		 
		Random rand = new Random();
		String accountNum = "";
		for (int i = 0; i < 14; i++) {
			int n = rand.nextInt(10) + 0;
			accountNum  += Integer.toString(n);
		}
		return accountNum ;
	}

	public  String generateTransId() {
	
		Random rand = new Random();
		String transId = "TR";
		for (int i = 0; i < 6; i++) {
			int n = rand.nextInt(10) + 0;
			transId += Integer.toString(n);
		}
		return transId;
	}

	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); 
		 
		 
			return format.format(date);
	}
	
	public LocalDateTime getCurrentLocalDate() {
		LocalDateTime date = LocalDateTime.now();
		//SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); 
		 
		 
		return date;
	}

}
