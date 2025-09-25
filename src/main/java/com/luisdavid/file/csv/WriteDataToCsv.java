package com.luisdavid.file.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.luisdavid.file.json.Book;
import com.opencsv.CSVWriter;

/** Handles the writing of book data into a CSV file. This class uses the OpenCSV library to generate a CSV file from a list of Book objects. */

public class WriteDataToCsv {

    public void writeBooksToCsv(List<Book> books, String filePath, char delimiter) {
        // I modified the CSVWriter constructor and now uses the provided delimiter.

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                                              delimiter,
                                              CSVWriter.DEFAULT_QUOTE_CHARACTER,
                                              CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                              CSVWriter.DEFAULT_LINE_END)) {
            // This Writes the header
            String[] header = {"Title", "ISBN", "Year", "Authors", "Publishers"};
            writer.writeNext(header);

            // I Write the data for each book
            for (Book book : books) {
                String authors = String.join(", ", book.getAuthors());
                String publishers = String.join(", ", book.getPublishers());
                String[] row = {
                    book.getTitle(),
                    book.getIsbn(),
                    String.valueOf(book.getYear()),
                    authors,
                    publishers
                };
                writer.writeNext(row);
            }
            System.out.println("CSV created successfully at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
            // Optionally, log the stack trace or handle the exception as needed.
        }
    }
} 