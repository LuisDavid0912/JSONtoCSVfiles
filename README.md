<img width="483" height="196" alt="Screenshot 2025-09-25 at 11 06 15 a m" src="https://github.com/user-attachments/assets/a6958f98-b98f-46a9-9f17-41df6dc0734e" />

# Java JSON to CSV Converter

## 1. Overview

This is a command-line utility developed in Java for converting structured JSON files into CSV format. The application is built with Apache Maven and leverages standard libraries for robust file processing. Key features include a modular code structure and the ability to configure execution parameters dynamically via command-line arguments.

## 2. Features

* **JSON to CSV Conversion**: Parses a JSON file containing an array of objects and transforms the data into a corresponding CSV file with a header row.
* **Command-Line Parameterization**: Allows users to specify the input file path, output file path, and the CSV delimiter character at runtime.
* **Modular Design**: The source code is organized by function, with dedicated classes for JSON reading, CSV writing, and application orchestration.
* **Dependency Management**: Utilizes Maven to manage project dependencies, including Jackson, OpenCSV, and Apache Commons CLI.

## 3. Usage

### Prerequisites

* Java Development Kit (JDK) 17 or later
* Apache Maven

### Building the Project

First, clone the repository to your local machine. Navigate to the project's root directory and use Maven to compile the source code and download dependencies. The program can be executed from the command line using Maven.

Default Execution:
To run the program with default settings (input: src/main/resources/books.json, output: books_output.csv, delimiter: ,), use the following command:

mvn exec:java -Dexec.mainClass="com.luisdavid.file.Main"

Execution with Parameters:
To specify custom files and a different delimiter, use command-line arguments.

mvn exec:java -Dexec.mainClass="com.luisdavid.file.Main" -Dexec.args="--input your_file.json --output your_report.csv --delimiter ';'"


4. Command-Line Arguments
The following arguments are supported:

Option	Long Option	Description
-i	--input	Specifies the path to the input JSON file.
-o	--output	Specifies the path for the generated CSV file.
-d	--delimiter	Specifies the character to use as a CSV delimiter.

Export to Sheets

5. Project Structure.
The source code is organized into packages based on functionality:

com.luisdavid.file.json: Contains classes for JSON processing (Book, BookJsonReader).

com.luisdavid.file.csv: Contains the CSV writer class (WriteDataToCsv).

com.luisdavid.file.Main: Serves as the main entry point for the application, handling argument parsing and orchestrating the conversion process.

6. Dependencies:
Jackson Databind: For parsing JSON data.

OpenCSV: For writing data to CSV files.

Apache Commons CLI: For parsing command-line arguments.
# Java JSON to CSV Converter Project

This repository contains the deliverables for the Sprint 2 of the Back End in Java for Information Processing project. The primary goal of this stage was to develop a desktop Java program capable of reading data from a JSON file and converting it into a structured CSV file. This project demonstrates fundamental Java programming practices, including dependency management with Maven, file I/O operations, JSON parsing, CSV writing, and proper code documentation.

## Challenge Instructions Fulfillment

This project meticulously addresses each instruction outlined for Sprint 2:

1.  **Implement in Java: Use a popular library for JSON manipulation in Java.**
    * **Fulfillment:** The project is entirely implemented in Java. For JSON manipulation, the widely used **Jackson Databind** library (`com.fasterxml.jackson.core:jackson-databind`) has been integrated via Maven. This library provides robust and efficient functionalities for serializing and deserializing Java objects to and from JSON.

2.  **Create a Java class with a function to read JSON files. This function must: open the JSON file, parse the contents into an appropriate data structure, and handle possible exceptions.**
    * **Fulfillment:** The `BookJsonReader.java` class (`src/main/java/com/luisdavid/file/json/BookJsonReader.java`) is dedicated to reading JSON files.
        * It contains the `readBooksFromJson(String filePath)` method, which takes a file path as input.
        * It opens the JSON file using Java's `File` and Jackson's `ObjectMapper`.
        * It parses the contents into a `List<Book>` data structure, where `Book.java` acts as a Plain Old Java Object (POJO) representing the JSON structure.
        * Robust exception handling is implemented using a `try-catch` block to manage `IOException` (for file not found or reading errors) that might occur during file operations.

3.  **Write CSV files: Use a library to write CSV files in Java.**
    * **Fulfillment:** The **OpenCSV** library (`com.opencsv:opencsv`) is utilized for all CSV writing operations. This library simplifies the process of generating well-formatted CSV files, including handling delimiters and various cell formats.

4.  **Create a Java class with a function to write data to a CSV file. This function must: create and write data into a CSV file, configure delimiters and cell formats as needed, and handle possible exceptions.**
    * **Fulfillment:** The `WriteDataToCsv.java` class (`src/main/java/com/luisdavid/file/csv/WriteDataToCsv.java`) is responsible for writing data to CSV files.
        * It features the `writeBooksToCsv(List<Book> books, String filePath)` method.
        * This function creates a new CSV file at the specified `filePath`.
        * It configures the initial row as a header and then iterates through a list of `Book` objects to write each book's data as a row in the CSV. The `CSVWriter` from OpenCSV automatically handles delimiters (commas by default) and quoting for cell formats.
        * `IOException` is caught and handled to manage potential write errors.

5.  **Document using JavaDoc: Include JavaDoc comments in each function and class to explain their purpose, parameters, and return values.**
    * **Fulfillment:** Comprehensive JavaDoc comments have been added to all relevant classes (`Main.java`, `Book.java`, `BookJsonReader.java`, `WriteDataToCsv.java`) and their public methods. These comments clearly describe the purpose of each component, its parameters (`@param`), and its return values (`@return`), ensuring clear and useful documentation.

6.  **GitHub Repository: Create a GitHub repository, include a README.md, all files, and proper access permissions.**
    * **Fulfillment:** This `README.md` file serves as the project description. All code files, `pom.xml`, and resource files are organized in a structured manner within this repository. Access permissions are configured for review. The `README.md` also details the steps required to review and run the repository content.

## Key Learning Points from this Challenge

Throughout this challenge, significant experience was gained in several key areas:

* **Modular Programming in Java:** Understanding the importance of separating concerns into distinct classes (e.g., `BookJsonReader` for reading, `WriteDataToCsv` for writing, and `Main` for orchestration) to promote code reusability, maintainability, and readability.
* **Maven for Dependency Management:** Learning how to effectively use `pom.xml` to declare and manage external libraries like Jackson and OpenCSV, ensuring project builds are consistent and dependencies are correctly resolved.
* **JSON Parsing:** Gaining practical experience with a popular JSON library (Jackson Databind) to deserialize JSON arrays into Java objects, handling complex data structures within JSON.
* **CSV Writing:** Implementing file writing operations to produce structured CSV output from parsed data, utilizing the OpenCSV library for simplified CSV formatting.
* **Exception Handling:** Applying `try-catch` blocks for robust error management in file I/O operations, making the application more resilient to common issues like file not found or corrupted data.
* **JavaDoc Documentation:** Practicing the creation of professional-grade documentation directly within the source code, enhancing clarity and future maintainability.
* **Git Version Control:** Reinforcing best practices in Git, including staging changes, crafting meaningful commit messages, and understanding how to manage repository history.

## How to Run the Project

To review and execute this project, follow these steps:

1.  **Clone the Repository:**
    Open your terminal or command prompt and clone the repository:
    ```bash
    git clone [https://github.com/luisdavid/](https://github.com/luisdavid/)[YOUR_REPO_NAME].git
    ```
    Navigate into the cloned directory:
    ```bash
    cd [YOUR_REPO_NAME]
    ```

2.  **Build the Project with Maven:**
    Ensure you have Apache Maven installed. From the project's root directory (where `pom.xml` is located), execute the following command to compile the project and download its dependencies:
    ```bash
    mvn clean install
    ```

3.  **Execute the Application:**
    You can run the `Main.java` class directly from your Integrated Development Environment (IDE) like IntelliJ IDEA, VS Code, or Eclipse. Alternatively, you can execute it via Maven from the terminal:
    ```bash
    mvn exec:java -Dexec.mainClass="com.luisdavid.file.Main"
    ```

### What to Expect When Running the Application

Upon successful execution of the `Main.java` class:

* **Console Output:**
    You will observe messages in your console indicating the progress of the conversion process, such as:
    ```
    --- Initiating JSON to CSV conversion ---
    3 books read successfully.
    CSV created successfully in: libros_output.csv
    --- Process completed ---
    ```

* **File Output:**
    A new file named `libros_output.csv` will be created in the **root directory of your project** (the same folder where your `pom.xml` and `README.md` files reside). This CSV file will contain the book data parsed from `books.json`, structured with a header row and each book's details in a separate row.

## Dependencies

The project relies on the following external libraries, managed by Maven:

* **Jackson Databind**: `com.fasterxml.jackson.core:jackson-databind` (Version 2.13.3)
    * Used for reading and parsing JSON files, mapping JSON data to Java objects.
* **OpenCSV**: `com.opencsv:opencsv` (Version 5.9)
    * Used for writing data to CSV files, handling CSV formatting and output.

## References

1.  Java JSON Parsing with `org.json`: https://www.youtube.com/watch?v=iyBH1_EoR9w
2.  JSON file handling example (Mkyong): https://github.com/Jesusale1234/JSONCSVRespository/blob/master/src/main/java/com/mkyong/json/jsonsimple/JSONfile.java
3.  Introduction to `org.json` (Baeldung): https://www.baeldung.com/java-org-json
4.  JSON Simple example (Mkyong): https://mkyong.com/java/json-simple-example-read-and-write-json/
