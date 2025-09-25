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