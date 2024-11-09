package br.com.fiap.twoespwx.generateNucleiotideo;

public class SingleNucleotideGenerator implements NucleotideoRandomGenerator {
    private final char nucleotide;

    public SingleNucleotideGenerator(char nucleotide) {
        this.nucleotide = nucleotide;
    }

    @Override
    public String generate(int sequenceSize) {
        return String.valueOf(nucleotide).repeat(sequenceSize);
    }
}
