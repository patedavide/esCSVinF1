import java.io.FileWriter;
import java.io.IOException;

// Classe Pilota
class Pilota {
    private String nome;
    private int punti;
    private int vittorie;
    private int polePosition;
    private String squadra;
    private String nazionalita;

    public Pilota(String nome, int punti, int vittorie, int polePosition, String squadra, String nazionalita) {
        this.nome = nome;
        this.punti = punti;
        this.vittorie = vittorie;
        this.polePosition = polePosition;
        this.squadra = squadra;
        this.nazionalita = nazionalita;
    }

    public String toCSV() {
        return nome + "," + punti + "," + vittorie + "," + polePosition + "," + squadra + "," + nazionalita;
    }
}


