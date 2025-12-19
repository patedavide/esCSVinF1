import java.io.*;

class Main {
    public static void main(String[] args) {

        Pilota[] piloti = new Pilota[10];
        int nPiloti = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("f1.csv"));
            PrintWriter pw = new PrintWriter(new FileWriter("copia.csv"));

            String linea;

            br.readLine();

            while ((linea = br.readLine()) != null && nPiloti < piloti.length) {
                String[] campi = linea.split(",");

                Pilota p = new Pilota(
                        campi[0],
                        Integer.parseInt(campi[1]),
                        Integer.parseInt(campi[2]),
                        Integer.parseInt(campi[3]),
                        campi[4],
                        campi[5]
                );

                piloti[nPiloti] = p;
                nPiloti++;

                String output = "Nome: " + p.getNome() +
                        ", Punti: " + p.getPunti() +
                        ", Vittorie: " + p.getVittorie() +
                        ", Pole: " + p.getPolePosition() +
                        ", Squadra: " + p.getSquadra() +
                        ", Nazionalità: " + p.getNazionalita();

                System.out.println(output);

                pw.println(output);
            }

            br.close();
            pw.close();

            RandomAccessFile raf = new RandomAccessFile("copia.csv", "rw");
            if (raf.length() > 6) {
                raf.seek(6);
                raf.write('*');
            }
            raf.close();

            System.out.println("\nOggetti Pilota creati: " + nPiloti);

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }
}
