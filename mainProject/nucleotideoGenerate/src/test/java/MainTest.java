import static org.junit.jupiter.api.Assertions.*;

import br.com.fiap.twoespwx.generateNucleiotideo.NucleotideoRandomGenerator;
import br.com.fiap.twoespwx.generateNucleiotideo.RandomNucleotideGenerator;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MainTest {

    @Test
    public void testSequenceGeneration() {
        int sequenceSize = 10;

        NucleotideoRandomGenerator generator = new RandomNucleotideGenerator();
        String sequence = generator.generate(sequenceSize);

        assertEquals(sequenceSize, sequence.length(), "A sequência gerada deve ter o tamanho correto.");
    }

    @Test
    public void testFileCreation() {
        int sequenceSize = 10;
        String outputFileName = "C:\\Users\\pedro\\Desktop\\Fiap\\DDD - Java\\check_point_fiap_esp_wx_s2_2024\\mainProject\\nucleotideoGenerate\\output\\outputCP2.txt";

        NucleotideoRandomGenerator generator = new RandomNucleotideGenerator();
        String sequence = generator.generate(sequenceSize);

        File outputFile = new File(outputFileName);
        try {
            outputFile.getParentFile().mkdirs();
            Files.write(outputFile.toPath(), sequence.getBytes());
        } catch (IOException e) {
            fail("Erro ao criar ou escrever no arquivo: " + e.getMessage());
        }

        assertTrue(outputFile.exists(), "O arquivo de saída deve ser criado.");

        try {
            String fileContent = new String(Files.readAllBytes(outputFile.toPath()));
            assertEquals(sequence, fileContent, "O conteúdo do arquivo deve ser igual à sequência gerada.");
        } catch (IOException e) {
            fail("Erro ao ler o arquivo de saída: " + e.getMessage());
        }
    }
}

