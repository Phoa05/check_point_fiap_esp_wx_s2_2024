package br.com.fiap.twoespwx.generateNucleiotideo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int sequenceSize = 10;

        NucleotideoRandomGenerator generator = new RandomNucleotideGenerator();
        String sequence = generator.generate(sequenceSize);

        String outputFileName = "C:\\Users\\pedro\\Desktop\\Fiap\\DDD - Java\\check_point_fiap_esp_wx_s2_2024\\mainProject\\nucleotideoGenerate\\output\\outputCP2.txt";

        File outputFile = new File(outputFileName);
        outputFile.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(sequence);
            System.out.println("Sequência gerada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
