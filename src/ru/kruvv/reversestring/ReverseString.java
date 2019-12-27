package ru.kruvv.reversestring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * This class consists of a method that expands the string in the reverse order 
 * and measures the running time of this method for 1000, 10 000, 100 000 repetitions.
 * You need to design it in the form of stand alone java applications with console line input. 
 * The result of the work should be a line, an expanded line and 3 digits (working time).
 * @author Viktor Krupkin.
 *
 */
public class ReverseString {
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.print("Введите строку: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		
		
		System.out.println("Прямой вывод строки: " + str );
		
		long time1 = timer(() -> {
			for (int i = 0; i < 1000; i++) {
				reverse(str);
			}
		}, TimeUnit.NANOSECONDS);
		
		
		long time2 = timer(() -> {
			
			for (int i = 0; i < 10000; i++) {
				reverse(str);
			}
		}, TimeUnit.NANOSECONDS);
		
		
		
		long time3 = timer(() -> {
			String result = "";
			for (int i = 0; i < 100000; i++) {
				result = reverse(str);
			}
			System.out.println("Развернутая строка: " + result);
		}, TimeUnit.NANOSECONDS);
		
		reader.close();
		
		System.out.println("Время работы при 1000/10000/100000 циклах повторений: " + time1 + "/" + time2 + "/" + time3 + " ns.");
	
	    
	}

    /**
     * This method expands the string. 
     * @param str
     * @return
     */
	private static String reverse(String str) {		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(str);
		return stringBuffer.reverse().toString();
	
	}	
	
	/**
	 * This method measures code runtime in nanoseconds.
	 * @param method
	 * @param timeUnit
	 * @return
	 */
	private static long timer(Runnable method, TimeUnit timeUnit) {
		long time = System.nanoTime();
		method.run();
		time = System.nanoTime() - time;
		return TimeUnit.NANOSECONDS.convert(time, timeUnit);
	}

}
