package es.eternalshadow.util;

import java.util.Scanner;

public class Input {
	private static Scanner scan = new Scanner(System.in);
	
	public static int toScanInteger(String s) {
		System.out.println(s);
		return scan.nextInt();
	}
	
	public static String toScan(String s) {
		System.out.println(s);
		return scan.nextLine();
	}
	
	public static int crearMenu(String[] menu, String s) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + ") " + menu[i]);
		}
		int num = toScanInteger(s);
		return num;
	}
}
