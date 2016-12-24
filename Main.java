package com.cummins.historical;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		GregorianCalendar today = new GregorianCalendar();
		int todayMonth = today.get(Calendar.MONTH);

	    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);

	    int todayYear = today.get(Calendar.YEAR);
	    
	    Calendar calendar = Calendar.getInstance(); // this would default to now
	    //System.out.println("Date 2 weeks-"calendar.add(Calendar.DATE, -14));
	    calendar.add(Calendar.DATE, -14);
	    int historyMonth=calendar.get(Calendar.MONTH);
	    int historyDayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
	    int historyYear=calendar.get(Calendar.YEAR);
	   
	    
	    
	   
	    GregorianCalendar start=new GregorianCalendar(todayYear,todayMonth,todayDayOfMonth);
	    GregorianCalendar end=new GregorianCalendar(historyYear,historyMonth,historyDayOfMonth);
		
	    System.out.println("Enter the company name");
	    String symbol=in.nextLine();
		StockDownloader stock=new StockDownloader(symbol,start,end);
		/*stock.getDates();
		stock.getOpens();
		stock.getHighs();
		stock.getLows();
		stock.getCoses();
		stock.getVolumes();
		stock.getAdjcloses();*/
	}

}
