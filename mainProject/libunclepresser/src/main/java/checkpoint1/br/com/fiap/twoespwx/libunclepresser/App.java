/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Grupo: Elite Jobs
 * Autores:
 *      - Anna Yagyu     -   rm550360
 *      - Breno Silva     -   rm99275
 *      - Danilo Urze    -   rm99465
 *      - Pedro Henrique  -   rm550689
 */

package checkpoint1.br.com.fiap.twoespwx.libunclepresser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        String inputPath = "C:\\Users\\pedro\\Desktop\\Fiap\\DDD - Java\\check_point_fiap_esp_wx_s2_2024\\mainProject\\libunclepresser\\inputs\\input1.txt";
        String outputPath = "C:\\Users\\pedro\\Desktop\\Fiap\\DDD - Java\\check_point_fiap_esp_wx_s2_2024\\mainProject\\libunclepresser\\outputs\\OUTPUT1.TXT";

        try {
            String inputData = readInputFile(inputPath);
            String compressedData = runLengthEncode(inputData);
            writeOutputFile(outputPath, compressedData);

            Map<Character, Integer> frequencies = calculateFrequencies(inputData);

            displayInterface(inputPath, outputPath, inputData, compressedData, frequencies);

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

    public static String readInputFile(String inputPath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(inputPath));
        return new String(bytes, StandardCharsets.UTF_8).replaceAll("\\s+", "").toUpperCase();
    }

    public static String runLengthEncode(String data) {
        if (data.isEmpty()) return "";

        StringBuilder encoded = new StringBuilder();
        char currentChar = data.charAt(0);
        int count = 1;

        for (int i = 1; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == currentChar) {
                count++;
            } else {
                encoded.append(currentChar).append(count);
                currentChar = c;
                count = 1;
            }
        }
        encoded.append(currentChar).append(count);
        return encoded.toString();
    }

    public static void writeOutputFile(String outputPath, String data) throws IOException {
        Files.write(Paths.get(outputPath), data.getBytes(StandardCharsets.UTF_8));
    }

    private static Map<Character, Integer> calculateFrequencies(String data) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : data.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }

    private static void displayInterface(String inputPath, String outputPath, String inputData, String compressedData, Map<Character, Integer> frequencies) {
        int inputSize = inputData.length();
        int outputSize = compressedData.length();
        double compressionRate = ((double) outputSize / inputSize) * 100;

        System.out.println(" -----------------------------------------------------------");
        System.out.println("|           LIB UNCLE PRESSER - GRUPO Nexos           |");
        System.out.println("|-----------------------------------------------------------|");
        System.out.println("|                                                           |");
        System.out.println("| INPUT  FILENAME: " + Paths.get(inputPath).getFileName() + "                          |");
        System.out.println("| OUTPUT FILENAME: " + Paths.get(outputPath).getFileName() + "                         |");
        System.out.println("|                                                           |");
        System.out.println(" -----------------------------------------------------------");
        System.out.println("|                                                           |");
        System.out.println("| INPUT FILE SIZE: " + inputSize + " characters                    |");
        System.out.println("|                                                           |");

        System.out.println("| FREQUENCIES:                                              |");
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            double percentage = (entry.getValue() * 100.0) / inputSize;
            System.out.printf("| %c: %d (%.2f%%)                                        |\n", entry.getKey(), entry.getValue(), percentage);
        }

        System.out.println("|                                                           |");
        System.out.println("| ALGORITHM: Run-Length Encoding (RLE)                      |");
        System.out.println("| TEXT-CODIFICATION: UTF-8                                  |");
        System.out.printf("| COMPRESSION RATE: %.2f%%                                 |\n", 100 - compressionRate);
        System.out.println("|                                                           |");
        System.out.println("| OUTPUT FILE SIZE: " + outputSize + " characters                    |");
        System.out.println(" -----------------------------------------------------------");
        System.out.println("|                                                           |");
        System.out.println("| SCORE: WELL-DONE                                          |");
        System.out.println("|                                                           |");
        System.out.println(" -----------------------------------------------------------");
    }
}


