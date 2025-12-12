import java.io.*;

class Main {
    void main(String[] args) {
        // Creiamo i primi 10 piloti
        Pilota p1 = new Pilota("Lando Norris", 423, 7, 7, "McLaren", "GBR");
        Pilota p2 = new Pilota("Max Verstappen", 421, 8, 8, "Red Bull", "NLD");
        Pilota p3 = new Pilota("Oscar Piastri", 410, 7, 6, "McLaren", "AUS");
        Pilota p4 = new Pilota("George Russell", 319, 2, 3, "Mercedes", "GBR");
        Pilota p5 = new Pilota("Charles Leclerc", 242, 0, 0, "Ferrari", "MCO");
        Pilota p6 = new Pilota("Lewis Hamilton", 156, 0, 0, "Ferrari", "GBR");
        Pilota p7 = new Pilota("Kimi Antonelli", 150, 0, 0, "Mercedes", "ITA");
        Pilota p8 = new Pilota("Alexander Albon", 73, 0, 0, "Williams", "THA");
        Pilota p9 = new Pilota("Carlos Sainz", 64, 0, 0, "Williams", "ESP");
        Pilota p10 = new Pilota("Fernando Alonso", 56, 0, 0, "Aston Martin", "ESP");

        Pilota[] piloti = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};

        try {
            // Scrittura su file usando PrintWriter
            PrintWriter pr = new PrintWriter(new FileWriter("f1.csv"));
            pr.println("Nome,Punti,Vittorie,Pole Position,Squadra,Nazionalita"); // intestazione
            for (Pilota pilota : piloti) {
                pr.println(pilota.toCSV());
            }
            pr.flush();
            pr.close();

            // Lettura e stampa a terminale
            BufferedReader br = new BufferedReader(new FileReader("f1.csv"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campi = linea.split(",");
                System.out.println("Nome: " + campi[0] +
                        ", Punti: " + campi[1] +
                        ", Vittorie: " + campi[2] +
                        ", Pole: " + campi[3] +
                        ", Squadra: " + campi[4] +
                        ", Nazionalità: " + campi[5]);
            }
            br.close();

            // Accesso diretto: modifica del 7° byte
            RandomAccessFile raf = new RandomAccessFile("copia.csv", "rw");
            if (raf.length() > 6) {
                raf.seek(6);
                raf.write('*'); // sostituisci il carattere
            }
            raf.close();

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }
}