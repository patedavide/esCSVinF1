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

            System.out.println("Nome, Punti, Vittorie, Pole Position, Squadra, Nazionalita");
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

                String output =p.getNome() + ", " +
                        p.getPunti() + ", " +
                        p.getVittorie() + ", " +
                        p.getPolePosition() + ", " +
                        p.getSquadra() + ", " +
                        p.getNazionalita();

                System.out.println(output);

                pw.println(output);
            }

            br.close();
            pw.close();

            for (int i = 0; i < nPiloti - 1; i++) {
                for (int j = 0; j < nPiloti - 1 - i; j++) {
                    if (piloti[j].getVittorie() < piloti[j + 1].getVittorie()) {
                        Pilota temp = piloti[j];
                        piloti[j] = piloti[j + 1];
                        piloti[j + 1] = temp;
                    }
                }
            }

            System.out.println("\nClassifica Piloti per Vittorie:");
            for (int i = 0; i < nPiloti; i++) {
                System.out.println(
                        piloti[i].getNome() +
                                " - Vittorie: " + piloti[i].getVittorie()
                );
            }

            RandomAccessFile raf = new RandomAccessFile("copia.csv", "rw");
            if (raf.length() > 6) {
                raf.seek(6);
                raf.write('*');
            }
            raf.close();

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }
}
