package com.luisdavid.file;

import java.util.List;

import com.luisdavid.file.csv.WriteDataToCsv;
import com.luisdavid.file.json.Book;
import com.luisdavid.file.json.BookJsonReader;


public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando conversión de JSON a CSV ");

        BookJsonReader reader = new BookJsonReader();
        List<Book> books = reader.readBooksFromJson("src/main/resources/books.json");

        if (books != null && !books.isEmpty()) {
            System.out.println(books.size() + " libros leídos correctamente.");

            WriteDataToCsv writer = new WriteDataToCsv();
            writer.writeBooksToCsv(books, "libros_output.csv");
        } else {
            System.err.println("No se pudo leer ningún libro del archivo JSON. Terminando proceso.");
        }

        System.out.println("Proceso finalizado ");
    }
}