package com.luisdavid.file.json;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookJsonReader {

    /**
      @param filePath
     @return 
     */

     
    public List<Book> readBooksFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File booksJsonFile = new File(filePath);
            return objectMapper.readValue(booksJsonFile, new TypeReference<List<Book>>() {});
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}