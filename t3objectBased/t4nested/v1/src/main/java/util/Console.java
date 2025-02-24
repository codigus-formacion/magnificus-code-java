package util;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.Arrays; // quitar
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Console {

	private static Console instance;

	public static Console instance() {
		if (Console.instance == null) {
			Console.instance = new Console();
		}
		return Console.instance;
	}

	private String data;
	private static BufferedReader input;
	private static PrintStream output;
	private static PrintWriter inputLog;
	private static PrintWriter inputOutputLog;

	private static final String EXTENSION = ".log";
	private static final String HEAD_PATH = "./src/main/resources/logs/";
	private static final String TAIL_PATH = "-"
	+ LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-"
	+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss")) + EXTENSION;
	private static final String INPUT_PATH = HEAD_PATH + "input" + TAIL_PATH;
	private static final String INPUT_OUTPUT_PATH = HEAD_PATH + "inputOutput" + TAIL_PATH;

	private static final Pattern charPattern = Pattern.compile("^c$");
	private static final Pattern intPattern = Pattern.compile("^-?\\d+$");
	private static final Pattern doublePattern = Pattern
			.compile("^-?(\\d+(\\.\\d+)?([eE][+-]?\\d+)?|\\.\\d+([eE][+-]?\\d+)?)$");

	private Console() {
		Console.input = new BufferedReader(new InputStreamReader(System.in));
		Console.output = System.out;
		try {
			Console.inputLog = new PrintWriter(INPUT_PATH);
			Console.inputOutputLog = new PrintWriter(INPUT_OUTPUT_PATH);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	public static void close() {
		try {
			if (Console.inputLog != null) {
				Console.inputLog.close();
			}
			if (Console.inputOutputLog != null){
				Console.inputOutputLog.close();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void close(String name) {
		Console.close();
		List<String> namePaths = Arrays.asList(
				HEAD_PATH + "input-" + name + EXTENSION,
				HEAD_PATH + "inputOutput-"+ name + EXTENSION);
		List<String> generatedPaths = Arrays.asList(INPUT_PATH, INPUT_OUTPUT_PATH);
		IntStream.range(0, 2)
				.forEach(i -> {
					File input = new File(namePaths.get(i));
					if (input.exists()) {
						input.delete();
					}
					new File(generatedPaths.get(i)).renameTo(input);
				});
	}

	public String readString() {
		return this.readString("");
	}

	public String readString(String title) {
		assert title != null;

		this.write(title);
		try {
			this.data = Console.input.readLine();
			Console.inputLog.println(this.data);
			Console.inputOutputLog.println(this.data);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return this.data;
	}

	public void write(String string) {
		assert string != null;

		Console.output.print(string);
		Console.inputOutputLog.print(string);
	}

	public void writeln(String string) {
		this.write(string + "\n");
	}

	public void writeln(){
		this.writeln("");
	}

	public char readChar() {
		return this.readChar("");
	}

	public char readChar(String title) {
		assert title != null;

		char characterInput = ' ';
		boolean ok;
		do {
			this.data = this.readString(title);
			ok = charPattern.matcher(this.data).find();
			if (ok) {
				characterInput = this.data.charAt(0);
			} else {
				this.writeError(charPattern.toString());
			}
		} while (!ok);
		return characterInput;
	}

	public void write(char character) {
		Console.output.print(character);
		Console.inputOutputLog.print(character);
	}

	public void writeln(char character) {
		this.write(character + "\n");
	}

	public int readInt() {
		return this.readInt("");
	}

	public int readInt(String title) {
		assert title != null;

		int intInput = ' ';
		boolean ok;
		do {
			this.data = this.readString(title);
			ok = intPattern.matcher(this.data.trim()).find();
			if (ok) {
				intInput = Integer.parseInt(this.data);
			} else {
				this.writeError(intPattern.toString());
			}
		} while (!ok);
		return intInput;
	}

	public void write(int value) {
		Console.output.print(value);
		Console.inputOutputLog.print(value);
	}

	public void writeln(int value) {
		this.write(value + "\n");
	}

	public double readDouble() {
		return this.readInt("");
	}

	public double readDouble(String title) {
		assert title != null;

		double doubleInput = ' ';
		boolean ok;
		do {
			this.data = this.readString(title);
			ok = doublePattern.matcher(this.data.trim()).find();
			if (ok) {
				doubleInput = Integer.parseInt(this.data);
			} else {
				this.writeError(doublePattern.toString());
			}
		} while (!ok);
		return doubleInput;
	}

	public void write(double value) {
		Console.output.print(value);
		Console.inputOutputLog.print(value);
	}

	public void writeln(double value) {
		this.write(value + "\n");
	}

	private void writeError(String message) {
		message = "Fallo!!! Por tu error al aplicar defectuasamente esta regla: " + message;
		Console.output.println(message);
		Console.inputOutputLog.println(message);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Console.instance().writeln(Console.instance().readString());
			Console.instance().writeln(Console.instance().readChar());
			Console.instance().writeln(Console.instance().readInt());
		}
		Console.close("test");
	}


}
