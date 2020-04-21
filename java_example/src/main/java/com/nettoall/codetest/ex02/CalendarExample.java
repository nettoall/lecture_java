package com.nettoall.codetest.ex02;

import java.util.Calendar;
import java.util.Scanner;
/**
 * 월을 입력받아 해당 달력을 출력
 * @author dongwook
 *
 */
public class CalendarExample {
	Calendar cal;
	int year;
	int month;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("달력을 보고자 하는 년을 입력하세요");
		System.out.print("> ");
		int iYear = scanner.nextInt();
		System.out.println("월을 입력하세요");
		System.out.print("> ");
		int iMonth = scanner.nextInt();
		CalendarExample exam = new CalendarExample();
		exam.init();
		exam.setDate(iYear,iMonth);
		exam.printWeek();
		exam.printDays();
	}
	
	public void init() {
		cal = Calendar.getInstance();
	}
	
	public void setDate(int year, int month) {
		setDate(year,month,1);
	}
	
	public void setDate(int year, int month, int date) {
		this.year = year;
		this.month = month;
		cal.set(this.year,this.month-1,date);
	}
	
	public void print() {
		
		//System.out.println(cal.getFirstDayOfWeek());

		System.out.println(cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(cal.getMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(Calendar.FRIDAY);
		System.out.println(cal.getTime());
	}
	
	public void printWeek() {
		System.out.printf("YEAR : %d, MONTH: %d\n", this.year, this.month);
		System.out.println("SUN\tMON\tTUES\tWEN\tTHUR\tFRI\tSAT\t");
		System.out.println("-------------------------------------------------------");
	}
	
	public void printDays() {
		int dayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		StringBuilder sb = new StringBuilder();
		int count = 1;
		
		for(int i = 1; i <= dayOfMonth; i++) {
			if(i == 1) {
				for(int j = 1; j < dayOfWeek; j++) {
					sb.append("\t");
					count++;
				}
				sb.append(i);
				
				if(count % 8 == 0) {
					sb.append("\n");
					count = 1;
				}else {
					sb.append("\t");
					count++;
				}
			}else {
				sb.append(i);
				count++;
				if(count % 8 ==0) {
					sb.append("\n");
					count = 1;
				}else {
					sb.append("\t");
				}
			}
			
		}
		System.out.print(sb.toString());
	}

}
