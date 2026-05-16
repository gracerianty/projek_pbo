package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import projek_pbo.*;
import threadingTrapesium.ThreadExecutor;

public class Projek_pbo {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            int pilihan;

            do {
                System.out.println("\n=== Program Perhitungan Geometri ===");
                System.out.println("1. Trapesium");
                System.out.println("2. Limas Trapesium");
                System.out.println("3. Prisma Trapesium");
                System.out.println("4. Hitung Semua (MULTITHREADING)");
                System.out.println("5. Exit");
                System.out.print("Masukkan pilihan : ");

                try {
                    pilihan = input.nextInt();

                    switch (pilihan) {

                        case 1:
                            System.out.println("\n--- Trapesium ---");

                            System.out.print("Alas atas : ");
                            double aa = input.nextDouble();

                            System.out.print("Alas bawah : ");
                            double ab = input.nextDouble();

                            System.out.print("Sisi miring : ");
                            double sm = input.nextDouble();

                            System.out.print("Tinggi : ");
                            double t = input.nextDouble();

                            Trapesium tr = new Trapesium(aa, ab, sm, t);

                            System.out.println("Luas = " + tr.hitungLuas());
                            System.out.println("Keliling = " + tr.hitungKeliling());
                            break;

                        case 2:
                            System.out.println("\n--- Limas Trapesium ---");

                            System.out.print("Alas atas : ");
                            double aaL = input.nextDouble();

                            System.out.print("Alas bawah : ");
                            double abL = input.nextDouble();

                            System.out.print("Sisi miring : ");
                            double smL = input.nextDouble();

                            System.out.print("Tinggi trapesium : ");
                            double ttL = input.nextDouble();

                            System.out.print("Tinggi limas : ");
                            double tl = input.nextDouble();

                            LimasTrapesium lt =
                                    new LimasTrapesium(aaL, abL, smL, ttL, tl);

                            System.out.println("Volume = " + lt.hitungVolume());
                            System.out.println("Luas Permukaan = " + lt.hitungLuasPermukaan());
                            break;

                        case 3:
                            System.out.println("\n--- Prisma Trapesium ---");

                            System.out.print("Alas atas : ");
                            double aaP = input.nextDouble();

                            System.out.print("Alas bawah : ");
                            double abP = input.nextDouble();

                            System.out.print("Sisi miring : ");
                            double smP = input.nextDouble();

                            System.out.print("Tinggi trapesium : ");
                            double ttP = input.nextDouble();

                            System.out.print("Tinggi prisma : ");
                            double tp = input.nextDouble();

                            PrismaTrapesium pt =
                                    new PrismaTrapesium(aaP, abP, smP, ttP, tp);

                            System.out.println("Volume = " + pt.hitungVolume());
                            System.out.println("Luas Permukaan = " + pt.hitungLuasPermukaan());
                            break;

                        case 4:

                            System.out.println("\n=== PROSES GEOMETRI ACAK (MULTITHREADING) ===");

                            System.out.print("Masukkan jumlah objek per bentuk geometri: ");
                            int n = input.nextInt();

                            List<BendaGeometri> shapes = new ArrayList<>();
                            Random rand = new Random();

                            for (int i = 0; i < n; i++) {

                                shapes.add(new Trapesium(
                                        5 + rand.nextInt(20),
                                        5 + rand.nextInt(20),
                                        5 + rand.nextInt(10),
                                        5 + rand.nextInt(15)
                                ));

                                shapes.add(new LimasTrapesium(
                                        5 + rand.nextInt(20),
                                        5 + rand.nextInt(20),
                                        5 + rand.nextInt(10),
                                        5 + rand.nextInt(15),
                                        5 + rand.nextInt(10)
                                ));

                                shapes.add(new PrismaTrapesium(
                                        5 + rand.nextInt(20),
                                        5 + rand.nextInt(20),
                                        5 + rand.nextInt(10),
                                        5 + rand.nextInt(15),
                                        5 + rand.nextInt(10)
                                ));
                            }
                            System.out.println("\nMemulai pemrosesan " + shapes.size() + " objek");
                            System.out.println("==============================================");

                            ThreadExecutor.processShapes(shapes);
                            
                            break;

                        case 5:
                            System.out.println("Program selesai.");
                            break;

                        default:
                            System.out.println("Pilihan tidak valid.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input harus angka.");
                    input.nextLine();
                    pilihan = 0;
                }

            } while (pilihan != 5);

        }
    }
}