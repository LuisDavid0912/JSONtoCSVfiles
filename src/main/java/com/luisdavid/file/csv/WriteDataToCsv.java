package com.luisdavid.file.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.luisdavid.file.json.Book;
import com.opencsv.CSVWriter;

public class WriteDataToCsv {


    public void writeBooksToCsv(List<Book> books, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = {"Title", "ISBN", "Year", "Authors", "Publishers"};
            writer.writeNext(header);

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
            System.out.println("CSV creado exitosamente en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}