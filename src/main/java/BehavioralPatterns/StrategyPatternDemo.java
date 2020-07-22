package BehavioralPatterns;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StrategyPatternDemo {

	static PrintStream myout = new PrintStream(new FileOutputStream(FileDescriptor.out));
	static final Logger LOGGER = LogManager.getLogger(StrategyPatternDemo.class);
	static Properties props = new Properties();

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner scan = new Scanner(System.in);

		float i, j;

		while (true) {

			try {
				System.out.print("Enter the 1st num: ");
				i = scan.nextFloat();
				System.out.print("Enter the 2nd num: ");
				j = scan.nextFloat();
			} catch (Exception e) {
				System.out.println("please enter valid numbers");
				LOGGER.warn("Entered invalid num");
				continue;
			}

			LOGGER.info("Addition class started");
			Context context = new Context(new Addition());
			myout.println("Addition = " + context.executeStrategy(i, j));

			LOGGER.info("Subtraction class started");
			context = new Context(new Subtraction());
			myout.println("Subtraction = " + context.executeStrategy(i, j));

			LOGGER.info("Multiplication class started");
			context = new Context(new Multiplication());
			myout.println("Multiplication = " + context.executeStrategy(i, j));

			scan.close();
			return;

		}
	}
}
