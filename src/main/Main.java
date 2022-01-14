package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lexer.Lexer;

public class Main {
   public static void main(String[] args) throws IOException {

    final String INPUT_FILE_PATH = "/home/gndhrv/Documents/Sem VI/SPCC/JavaCompiler/lib/inputFile.txt";
    final String OUTPUT_FILE_PATH = "/home/gndhrv/Documents/Sem VI/SPCC/JavaCompiler/lib/outputFile.txt";

    Path inputFilePath = Paths.get(INPUT_FILE_PATH);
    Path outputFilePath = Paths.get(OUTPUT_FILE_PATH);
    
    String sourceCodeString = Files.readString(inputFilePath, StandardCharsets.US_ASCII);

    Lexer lexer = new Lexer();
    lexer.tokenize(sourceCodeString);

    List<String> resultingTokenStringsList = lexer.getTokens().stream().map(token -> Objects.toString(token, null)).collect(Collectors.toList());

    Files.write(outputFilePath, resultingTokenStringsList, StandardCharsets.US_ASCII);
  }
}