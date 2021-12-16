package crolling;

public class Stoc {
	private static String name = "";
	private static String previousClose;
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Stoc.name = name;
	}

	public static String getPreviousClose() {
		return previousClose;
	}

	public static void setPreviousClose(String previousClose) {
		Stoc.previousClose = previousClose;
	}

}
