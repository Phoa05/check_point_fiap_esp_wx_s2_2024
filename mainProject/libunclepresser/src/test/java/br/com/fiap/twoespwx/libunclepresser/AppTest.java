package br.com.fiap.twoespwx.generateNucleiotideo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import checkpoint1.br.com.fiap.twoespwx.libunclepresser.App;

public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Testa o método de codificação run-length encoding.
     */
    public void testRunLengthEncode() {
        String input = "AAAACCCTTG";
        String expectedOutput = "4A3C2T1G";
        String actualOutput = App.runLengthEncode(input);
        assertEquals("A codificação RLE não corresponde à saída esperada.", expectedOutput, actualOutput);

        input = "GGGGGGGGGG";
        expectedOutput = "10G";
        actualOutput = App.runLengthEncode(input);
        assertEquals("A codificação RLE não corresponde à saída esperada para sequência longa.", expectedOutput, actualOutput);

        input = "TGGGGGGGGC";
        expectedOutput = "1T8G1C";
        actualOutput = App.runLengthEncode(input);
        assertEquals("A codificação RLE não corresponde à saída esperada para sequência com caracteres únicos entre grupos.", expectedOutput, actualOutput);
    }

    /**
     * Testa o método de leitura de arquivo de entrada.
     */
    public void testReadInputFile() {
        try {
            String tempFilePath = "temp_input.txt";
            String fileContent = "ACGT\nACGT";
            Files.write(Paths.get(tempFilePath), fileContent.getBytes(StandardCharsets.UTF_8));

            String expectedContent = "ACGTACGT";
            String actualContent = App.readInputFile(tempFilePath);
            assertEquals("A leitura do arquivo de entrada não removeu os espaços corretamente.", expectedContent, actualContent);

            Files.delete(Paths.get(tempFilePath));
        } catch (IOException e) {
            fail("Falha ao testar leitura de arquivo: " + e.getMessage());
        }
    }

    /**
     * Testa o método de gravação de arquivo de saída.
     */
    public void testWriteOutputFile() {
        try {
            String tempOutputFilePath = "temp_output.txt";
            String dataToWrite = "4A3C2T1G";

            App.writeOutputFile(tempOutputFilePath, dataToWrite);

            String actualContent = new String(Files.readAllBytes(Paths.get(tempOutputFilePath)), StandardCharsets.UTF_8);
            assertEquals("A gravação no arquivo de saída não corresponde aos dados esperados.", dataToWrite, actualContent);

            Files.delete(Paths.get(tempOutputFilePath));
        } catch (IOException e) {
            fail("Falha ao testar gravação de arquivo: " + e.getMessage());
        }
    }

    /**
     * Teste geral para garantir que a aplicação consegue ler, comprimir e gravar corretamente.
     */
    public void testFullCompression() {
        String input = "AAAACCCGGTT";
        String expectedCompressedOutput = "4A3C2G2T";

        String compressedOutput = App.runLengthEncode(input);
        assertEquals("Compressão completa falhou ao produzir o output esperado.", expectedCompressedOutput, compressedOutput);
    }
}
