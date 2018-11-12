
package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Util {

	private Util() {
	};

	static Random rand = new Random();

	public static long fakultaet(int zahl) {
		if (zahl < 0 || zahl > 20) {
			throw new IllegalArgumentException("Number must be between 0 and 20 (exclusive)");
		}
		long returnValue = 1;
		for (int i = 1; i <= zahl; i++) {
			returnValue *= i;
		}
		return returnValue;
	}

	public static int[] generateHZE(int number) {
		int[] returnValue = new int[3];
		int hunderter;
		int zehner;
		int einer;

		hunderter = number / 100;
		zehner = (number / 10) - hunderter * 10;
		einer = number - (hunderter * 100 + zehner * 10);

		returnValue[0] = einer;
		returnValue[1] = zehner;
		returnValue[2] = hunderter;

		return returnValue;

	}

	public static long exponetial(int zahl, int exponent) {
		long returnValue = zahl;
		for (int i = 1; i < exponent; i++) {
			returnValue *= zahl;
		}
		return returnValue;
	}

	public static int ziffernsumme(int zahl) {
		int[] hunZehEin = generateHZE(zahl);

		int einer = hunZehEin[0];
		int zehner = hunZehEin[1];
		int hunderter = hunZehEin[2];
		int ziffernsumme = einer + zehner + hunderter;

		return ziffernsumme;

	}

	public static String mirrorString(String input) {
		String returnValue = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			returnValue += input.charAt(i);
		}
		return returnValue;

	}

	public static int maximum(int... zahlen) {
		int[] sortiert = Arrays.copyOf(zahlen, zahlen.length);
		Arrays.sort(sortiert);

		return sortiert[sortiert.length - 1];
	}

	public static float maximum(float... zahlen) {
		float[] sortiert = Arrays.copyOf(zahlen, zahlen.length);
		Arrays.sort(sortiert);

		return sortiert[sortiert.length - 1];
	}

	public static int minimum(int... zahlen) {

		int[] sortiert = Arrays.copyOf(zahlen, zahlen.length);
		Arrays.sort(sortiert);

		return zahlen[0];

	}

	public static float minimum(float... zahlen) {

		float[] sortiert = Arrays.copyOf(zahlen, zahlen.length);
		Arrays.sort(sortiert);

		return zahlen[0];

	}

	public static double durchschnitt(int[] zahlen) {

		double sum = 0.0;
		double returnValue;

		for (int i = 0; i < zahlen.length; i++) {

			sum += zahlen[i];

		}

		returnValue = sum / zahlen.length;

		return returnValue;

	}

	public static int[] generateRandomIntArray(int size, int maxValue) {

		int[] zahlen = new int[size];

		for (int i = 0; i < zahlen.length; i++) {

			zahlen[i] = rand.nextInt(maxValue) + 1;

		}

		return zahlen;

	}

	public static int[] generateRandomIntArray(int size, int maxValue, int minValue) {

		int[] zahlen = new int[size];

		for (int i = 0; i < zahlen.length; i++) {

			zahlen[i] = rand.nextInt(maxValue - minValue) + minValue;

		}

		return zahlen;

	}

	public static String printArray(int[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + " ";

		}

		return returnValue;

	}

	public static String printArray(char[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + " ";

		}

		return returnValue;

	}

	public static String printArray(boolean[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + ", ";

		}

		return returnValue;

	}

	public static String printArray(String[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + " ";

		}

		return returnValue;

	}

	public static String printArray(long[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + ", ";

		}

		return returnValue;

	}

	public static String printArray(byte[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + ", ";

		}

		return returnValue;

	}

	public static String printArray(short[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + ", ";

		}

		return returnValue;

	}

	public static String printArray(float[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + ", ";

		}

		return returnValue;

	}

	public static String printArray(double[] array) {

		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i] + ", ";

		}

		return returnValue;

	}

	public static <T> String printArray(T[] array) {
		String returnValue = "";

		for (int i = 0; i < array.length; i++) {

			returnValue += array[i].toString() + " ";

		}

		return returnValue;
	}

	public static String printArray(int[][] arr) {
		String returnValue = "[";
		for (int[] a : arr) {
			returnValue += Arrays.toString(a);
		}
		returnValue += ']';
		return returnValue;
	}

	public static String intToTime(int number) {

		String numberString = String.valueOf(number);
		String returnValue = "";

		if (numberString.length() == 1) {

			returnValue += "00:00:0" + numberString.charAt(numberString.length() - 1);

		} else if (numberString.length() == 2) {

			returnValue += "00:00:" + numberString;

		} else if (numberString.length() == 3) {

			returnValue += "00:0" + numberString.substring(numberString.length() - 3, numberString.length() - 2) + ":"
					+ numberString.substring(numberString.length() - 2, numberString.length());

		} else if (numberString.length() == 4) {

			returnValue += "00:" + numberString.substring(numberString.length() - 4, numberString.length() - 2) + ":"
					+ numberString.substring(numberString.length() - 2, numberString.length());

		} else if (numberString.length() == 5) {

			returnValue += "0" + numberString.charAt(numberString.length() - 5) + ":"
					+ numberString.substring(numberString.length() - 4, numberString.length() - 2) + ":"
					+ numberString.substring(numberString.length() - 2, numberString.length());

		} else {

			returnValue += numberString.substring(numberString.length() - 6, numberString.length() - 4) + ":"
					+ numberString.substring(numberString.length() - 4, numberString.length() - 2) + ":"
					+ numberString.substring(numberString.length() - 2, numberString.length());

		}

		return returnValue;

	}

	public static int[] primzahlen(int maxValue) {

		List<Integer> primzahlen = new ArrayList<>();
		boolean primzahl = true;

		for (int i = 2; i <= maxValue; i++) {

			primzahl = true;

			for (int j = 2; j < i; j++) {

				if (i % j == 0) {

					primzahl = false;

				}

			}

			if (primzahl) {

				primzahlen.add(i);

			}

		}

		int[] returnValue = new int[primzahlen.size()];

		for (int i = 0; i < primzahlen.size(); i++) {

			returnValue[i] = primzahlen.get(i);

		}

		return returnValue;

	}

	public static int differenz(int zahl1, int zahl2) {

		int returnValue = zahl1 - zahl2;
		if (returnValue < 0) {

			returnValue = -returnValue;

		}

		return returnValue;

	}

	public static int[] getRandomSequence(int n) {
		if (n <= 10000) {
			int[] returnValue = new int[n];
			try {
				URL url = new URL("https://www.random.org/sequences/?min=1&max=" + n + "&col=1&format=plain&rnd=new");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				for (int i = 0; i < n; i++) {
					returnValue[i] = Integer.parseInt(read.readLine());
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return returnValue;
		} else {
			int[] res = new int[n];
			for (int i = 0; i < n; i++) {
				int d = rand.nextInt(i + 1);
				res[i] = res[d];
				res[d] = i;
			}
			for (int i = 0; i < res.length; i++) {
				res[i] += 1;
			}
			return res;
		}
	}

	public static void delDupliks(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if (numOfContains(arr, num) > 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (num == arr[j]) {
						arr[j] = 0;
					}
				}
			}
		}
	}

	public static int numOfContains(int[] arr, int num) {
		int returnValue = 0;
		for (int i : arr) {
			if (i == num) {
				returnValue++;
			}
		}
		return returnValue;
	}

	public static int[] concatArrays(int[] a, int[] b) {
		int[] returnValue = Arrays.copyOf(a, a.length + b.length);
		for (int i = a.length; i < returnValue.length; i++) {
			returnValue[i] = b[i - a.length];
		}
		return returnValue;
	}

	public static boolean arraysEqual(int[] arg0, int[] arg1) {
		if (!(arg0.length == arg1.length)) {
			return false;
		}
		for (int i = 0; i < arg0.length; i++) {
			if (!(arg0[i] == arg1[i])) {
				return false;
			}
		}
		return true;
	}

	public static int[] removeFromArray(int[] arg0) {
		int[] returnValue = new int[arg0.length - 1];
		for (int i = 1; i < arg0.length; i++) {
			returnValue[i] = arg0[i];
		}
		return returnValue;
	}

	public static int[] addToArray(int[] arg0, int arg1) {
		int[] returnValue = new int[arg0.length + 1];
		for (int i = 0; i < arg0.length; i++) {
			returnValue[i] = arg0[i];
		}
		returnValue[arg0.length] = arg1;
		return returnValue;
	}

	public static char[] addToArray(char[] arg0, char arg1) {
		char[] returnValue = new char[arg0.length + 1];
		for (int i = 0; i < arg0.length; i++) {
			returnValue[i] = arg0[i];
		}
		returnValue[arg0.length] = arg1;
		return returnValue;
	}

	public static boolean arrayContains(char[] arg0, char arg1) {
		for (char i : arg0) {
			if (i == arg1)
				return true;
		}
		return false;
	}

	public static boolean arrayContains(int[] arg0, int arg1) {
		for (int i : arg0) {
			if (i == arg1)
				return true;
		}
		return false;
	}

	public static boolean arrayContains(boolean[] arg0, boolean arg1) {
		for (boolean i : arg0) {
			if (i == arg1)
				return true;
		}
		return false;
	}

	public static void fillArray(boolean[] arr, boolean bol) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = bol;
		}
	}

	public static int numOfContains(char[] arr, char num) {
		int returnValue = 0;
		for (char i : arr) {
			if (i == num) {
				returnValue++;
			}
		}
		return returnValue;
	}

	public static int[] einfuegen(int[] arr, int idx, int num) {
		int[] returnValue = Arrays.copyOf(arr, arr.length + 1);
		for (int i = arr.length - 1; i >= idx; i--) {
			returnValue[i + 1] = returnValue[i];
		}
		returnValue[idx] = num;
		return returnValue;
	}

	public static int[] remove(int[] arr, int idx) {
		int[] temp = Arrays.copyOf(arr, arr.length);
		temp[idx] = 0;
		Arrays.sort(temp);
		int[] returnValue = Arrays.copyOfRange(temp, 1, temp.length);
		return returnValue;
	}

	public static int firstIndexOf(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;
	}

	public static void printStackTrace(PrintStream out) {
		out.println("Printing Stack Trace");
		try {
			throw new Exception();
		} catch (Exception e) {
			StackTraceElement[] arr = e.getStackTrace();
			StackTraceElement[] dum = Arrays.copyOfRange(arr, 1, arr.length);
			Arrays.stream(dum).forEach(s -> out.printf("\tat %s%n", s.toString()));
		}
	}

	public static boolean equals(Object obj1, Object obj2) throws IllegalArgumentException, IllegalAccessException {
		if (obj1 == obj2)
			return true;
		if (obj1.getClass() != obj2.getClass())
			return false;
		Class<?> clazz = obj1.getClass();
		List<Field> fields = new ArrayList<>();
		
		addAll(fields, clazz.getDeclaredFields());
		fields.forEach(f -> f.setAccessible(true));
		
		for(Field field : fields) {
			if(!field.get(obj1).equals(field.get(obj2)))
				return false;
		}
		
		return true;
	}
	
	public static<T> void addAll(List<T> list, T[] arr) {
		for(T t : arr) {
			list.add(t);
		}
	}
	
		public static List<Pair<Character, Integer>> numberOfEqualCharsInSequence(String s) {

		if (s != null && s.length() < 1) {
			throw new IllegalArgumentException();
		}
		List<Pair<Character, Integer>> list = new ArrayList<>();
		
		char lastChar = s.charAt(0);
		int num = 1;
		
		for (int i = 1; i < s.length(); i++) {
			if (lastChar == s.charAt(i)) {
				num++;
			} else {
				list.add(new Pair<Character, Integer>(s.charAt(i - 1), num));
				lastChar = s.charAt(i);
				num = 1;
			}
		}
		
		list.add(new Pair<Character, Integer>(lastChar, num));

		return list;
	}

}
