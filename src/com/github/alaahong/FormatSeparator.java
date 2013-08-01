package com.github.alaahong;

public class FormatSeparator {
	public String formatSeparator(String measure) throws FormatException {
		switch (measure) {
		case "mile":
			measure = "mile";
			break;
		case "miles":
			measure = "mile";
			break;
		case "yard":
			measure = "yard";
			break;
		case "yards":
			measure = "yard";
			break;
		case "inch":
			measure = "inch";
			break;
		case "inches":
			measure = "inch";
			break;
		case "foot":
			measure = "foot";
			break;
		case "feet":
			measure = "foot";
			break;
		case "fath":
			measure = "fath";
			break;
		case "faths":
			measure = "fath";
			break;
		case "furlong":
			measure = "furlong";
			break;
		case "furlongs":
			measure = "furlong";
			break;
		case "m":
			measure = "m";
			break;
		case "meters":
			measure = "m";
			break;
		default:
			throw new FormatException(measure);
		}
		return measure;

	}

	public class FormatException extends Exception {
		/**
		 * define my exception
		 */
		private static final long serialVersionUID = 1L;

		public FormatException() {
			super();
			System.out.println("Formating Error!");
		}

		public FormatException(String msg) {
			super(msg);
			System.out.println("Formating Error!");
		}
	}
}
