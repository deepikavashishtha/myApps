package com.example.colors;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.colors.customer.Customer;
import com.example.colors.customer.OrderHandler;
import com.example.colors.customer.OrderHandlerImpl;
import com.example.colors.rules.exception.RuleException;

/**
 * PaintManager class is an entry point for Managing the paint batch. 
 * @author Deepika Vashishtha
 *
 */
public class PaintManager {
	private static OrderHandler orderHandler = new OrderHandlerImpl();
	private static Pattern keyValuePattern = Pattern.compile("(\\d)+ ([GM]+?)");

	public static void main(String[] args) throws IOException {
		checkUsage(args);
		PaintManager paintManager = new PaintManager();
		paintManager.managePaint(args[0]);
	}

	/**
	 * This method accepts resource File , which can have customer requirement, based on customer requirement color batches are printed.
	 * @param args
	 * @throws IOException
	 */
	public void managePaint(String resourceFile) throws IOException {
		try {
			List<Customer> customers = readInput(resourceFile);
			orderHandler.processOrders(customers);
			deliverOrder();
		} catch (RuleException re) {
			System.out.println(re);
			System.out.println("No Solution Exists");
		}
	}

	private static void deliverOrder() {
		ColorBatchPool.instance().getColorPool().forEach((k, v) -> {
			System.out.print(v.getSymbol() + " ");
		});
	}

	private static List<Customer> readInput(String fileName) throws IOException {
		try (Scanner scanner = new Scanner(Paths.get(fileName))) {
			orderHandler.colorCount(scanner.nextLine());
			List<Customer> customers = new ArrayList<>();
			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				Matcher matcher = keyValuePattern.matcher(line);
				final Map<String, String> map = new HashMap<>();
				final Map<Integer, ColorType> colorsOrdered = new HashMap<>();
				while (matcher.find()) {
					map.put(matcher.group(1), matcher.group(2));
					colorsOrdered.put(Integer.parseInt(matcher.group(1)), ColorType.getColorType(matcher.group(2)));
				}
				customers.add(new Customer(colorsOrdered));
			}

			return customers;
		}
	}

	private static void checkUsage(String[] args) {
		if (args.length != 1) {
			System.err.println("USAGE :: java PaintManager <FilePath>");
			System.exit(1);
		}
	}
}
