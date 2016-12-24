package com.cummins.historical;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class StockDownloader {
	/*public static final int DATE=0;
	public static final int OPEN=1;
	public static final int HIGH=2;
	public static final int LOW=3;
	public static final int CLOSE=4;
	public static final int VOLUME=5;
	public static final int ADJCLOSE=6;
	*/
	
	
	private ArrayList<GregorianCalendar> dates;
	private ArrayList<Double> opens;
	private ArrayList<Double> highs;
	private ArrayList<Double> lows;
	private ArrayList<Double> closes;
	private ArrayList<Integer> volumes;
	private ArrayList<Double> adjcloses;
	
	
	
	public StockDownloader(String symbol,GregorianCalendar start,GregorianCalendar end){
		dates=new ArrayList<GregorianCalendar>();
		opens=new ArrayList<Double>();
		highs=new ArrayList<Double>();
		lows=new ArrayList<Double>();
		closes=new ArrayList<Double>();
		volumes=new ArrayList<Integer>();
		adjcloses=new ArrayList<Double>();
		
	System.out.println(end.get(Calendar.MONTH));
		//http://real-chart.finance.yahoo.com/table.csv?s=AXISBANK.NS&d=11&e=24&f=2016&g=d&a=10&b=27&c=1998&ignore=.csv
			//http://real-chart.finance.yahoo.com/table.csv?s=ICICIBANK.NS&d=11&e=24&f=2016&g=d&a=6&b=1&c=2002&ignore=.csv
	String url="http://real-chart.finance.yahoo.com/table.csv?s="+symbol+".NS&d="+start.get(Calendar.MONTH)+"&e="+start.get(Calendar.DAY_OF_MONTH)+"&f="+start.get(Calendar.YEAR)+"&g=d&a="+end.get(Calendar.MONTH)+"&b="+end.get(Calendar.DAY_OF_MONTH)+"&c="+end.get(Calendar.YEAR)+"&ignore=.csv";
	
	try
	{
		URL yhoofin=new URL(url);
		URLConnection data=yhoofin.openConnection();
		Scanner in=new Scanner(data.getInputStream());
		if(in.hasNext())
			in.nextLine();
		
		
		while(in.hasNextLine())
		{
			String line=in.nextLine();
			String[] attributes = line.split(",");


			DateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
			Date       date = format.parse(attributes[0] );
			Calendar   calendar = new GregorianCalendar();
			
			calendar.setTime( date );


			double open=Double.parseDouble(attributes[1]);
			double high=Double.parseDouble(attributes[2]);
			double low=Double.parseDouble(attributes[3]);
			double close=Double.parseDouble(attributes[4]);
			int volume=Integer.parseInt(attributes[5]);
			double adjclose=Double.parseDouble(attributes[6]);
			
			opens.add(open);
			highs.add(high);
			lows.add(low);
			closes.add(close);
			volumes.add(volume);
			adjcloses.add(adjclose);
			
		}
		
			
	}
	catch(Exception e)
	{
		System.err.println(e);
	}
}
	
	public ArrayList<GregorianCalendar> getDates()
	{
		return dates;
	}
	
	public ArrayList<Double> getOpens()
	{
		return opens;
	}
	public ArrayList<Double> getHighs()
	{
		return highs;
	}
	public ArrayList<Double> getLows()
	{
		return lows;
	}
	public ArrayList<Double> getCoses()
	{
		return closes;
	}
	public ArrayList<Integer> getVolumes()
	{
		return volumes;
	}
	public ArrayList<Double> getAdjcloses()
	{
		return adjcloses;
	}
	
	
}
