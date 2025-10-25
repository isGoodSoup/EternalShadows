package es.eternalshadow.util;

import java.util.Scanner;

public class Utilidades {
	private static Scanner scan = new Scanner(System.in);
	
	public int toScanInteger(String s) {
		System.out.println(s);
		return scan.nextInt();
	}
	
	public String toScan(String s) {
		System.out.println(s);
		return scan.nextLine();
	}
	
	public void toGetString(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.print(" " + s + " ");
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public int crearMenu(String[] menu, String s) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i + 1 + ") " + menu[i]);
		}
		int num = toScanInteger(s);
		return num;
	}
}
