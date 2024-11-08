package br.com.fiap.twoespwx.libunclepresser;

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
        String expectedOutput = "A4C3T2G1";
        String actualOutput = App.runLengthEncode(input);
        assertEquals("A codificação RLE não corresponde à saída esperada.", expectedOutput, actualOutput);

        input = "GGGGGGGGGG";
        expectedOutput = "G10";
        actualOutput = App.runLengthEncode(input);
        assertEquals("A codificação RLE não corresponde à saída esperada para sequência longa.", expectedOutput, actualOutput);

        input = "TGGGGGGGGC";
        expectedOutput = "T1G8C1";
        actualOutput = App.runLengthEncode(input);
        assertEquals("A codificação RLE não corresponde à saída esperada para sequência com caracteres únicos entre grupos.", expectedOutput, actualOutput);
    }

    /**
     * Testa o método de leitura de arquivo de entrada.
     */
    public void testReadInputFile() {
        try {
            // Criação de um arquivo temporário para teste
            String tempFilePath = "temp_input.txt";
            String fileContent = "ACGT\nACGT";
            Files.write(Paths.get(tempFilePath), fileContent.getBytes(StandardCharsets.UTF_8));

            String expectedContent = "ACGTACGT";
            String actualContent = App.readInputFile(tempFilePath);
            assertEquals("A leitura do arquivo de entrada não removeu os espaços corretamente.", expectedContent, actualContent);

            // Remover o arquivo temporário
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
            String dataToWrite = "A4C3T2G1";

            App.writeOutputFile(tempOutputFilePath, dataToWrite);

            // Ler o conteúdo do arquivo de saída e verificar
            String actualContent = new String(Files.readAllBytes(Paths.get(tempOutputFilePath)), StandardCharsets.UTF_8);
            assertEquals("A gravação no arquivo de saída não corresponde aos dados esperados.", dataToWrite, actualContent);

            // Remover o arquivo temporário
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
        String expectedCompressedOutput = "A4C3G2T2";

        String compressedOutput = App.runLengthEncode(input);
        assertEquals("Compressão completa falhou ao produzir o output esperado.", expectedCompressedOutput, compressedOutput);
    }
}
