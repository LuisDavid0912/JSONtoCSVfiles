package com.luisdavid.file;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.luisdavid.file.csv.WriteDataToCsv;
import com.luisdavid.file.json.Book;
import com.luisdavid.file.json.BookJsonReader;

/**
Main class that executes the JSON to CSV conversion process.
This program allows you to configure the input and output files, as well as the CSV delimiter, through command line arguments. */


public class Main {
    public static void main(String[] args) {
        // Configuring command line parameters ---
        Options options = new Options();

        options.addOption("i", "input", true, "Input JSON file path");
        options.addOption("o", "output", true, "Output CSV file path");
        options.addOption("d", "delimiter", true, "CSV delimiter character (e.g., ';')");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            formatter.printHelp("JSONtoCSVConverter", options);
            System.exit(1);
            return;
        }

        // Obtain parameter values or use default values ---
        String inputFile = cmd.getOptionValue("input", "src/main/resources/books.json");
        String outputFile = cmd.getOptionValue("output", "books_output.csv");
        char delimiter = cmd.getOptionValue("delimiter", ",").charAt(0);

        System.out.println("--- Starting JSON to CSV conversion ---");
        System.out.println("Input file: " + inputFile);
        System.out.println("Output file: " + outputFile);
        System.out.println("CSV Delimiter: '" + delimiter + "'");

        // Run the conversion process ---
        BookJsonReader reader = new BookJsonReader();
        List<Book> books = reader.readBooksFromJson(inputFile);

        if (books != null && !books.isEmpty()) {
            System.out.println(books.size() + " books read successfully.");

            WriteDataToCsv writer = new WriteDataToCsv();
            writer.writeBooksToCsv(books, outputFile, delimiter);
        } else {
            System.err.println("No books could be read from the JSON file. Terminating process.");
        }

        System.out.println("--- Process finished ---");
    }
}