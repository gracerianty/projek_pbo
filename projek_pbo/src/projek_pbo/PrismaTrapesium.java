package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrismaTrapesium extends Trapesium {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaTrapesium( double alasAtas,double alasBawah,double sisiMiring, double tinggi, double tinggiPrisma) {
        super(alasAtas, alasBawah, sisiMiring, tinggi);
        this.tinggiPrisma = tinggiPrisma;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = super.luas * tinggiPrisma;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasAlas = super.luas;
        double kelilingAlas = super.keliling;
        luasPermukaan = 2 * luasAlas + kelilingAlas * tinggiPrisma;
        return luasPermukaan;
    }

    public double hitungVolume(double alasAtasBaru, double alasBawahBaru, double sisiMiringBaru, double tinggiBaru, double tinggiPrismaBaru) {
        volume = (0.5 * (alasAtasBaru + alasBawahBaru) * tinggiBaru) * tinggiPrismaBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double alasAtasBaru, double alasBawahBaru, double sisiMiringBaru, double tinggiBaru, double tinggiPrismaBaru) {
        double luasAlas = super.hitungLuas(alasAtasBaru, alasBawahBaru, sisiMiringBaru, tinggiBaru);
        double kelilingAlas = super.hitungKeliling(alasAtasBaru, alasBawahBaru, sisiMiringBaru, tinggiBaru);
        luasPermukaan = 2 * luasAlas + kelilingAlas * tinggiPrismaBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas atas, alas bawah, sisi miring, tinggi, dan tinggi prisma? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {
                while (true) {
                    try {
                        System.out.print("Masukkan Alas Atas Baru: ");
                        double newAlasAtas = inp.nextDouble();
                        System.out.print("Masukkan Alas Bawah Baru: ");
                        double newAlasBawah = inp.nextDouble();
                        System.out.print("Masukkan Sisi Miring Baru: ");
                        double newSisiMiring = inp.nextDouble();
                        System.out.print("Masukkan Tinggi Baru: ");
                        double newTinggi = inp.nextDouble();
                        System.out.print("Masukkan Tinggi Prisma Baru: ");
                        double newTinggiPrisma = inp.nextDouble();
                        inp.nextLine();

                        if (newAlasAtas <= 0 || newAlasBawah <= 0 || newSisiMiring <= 0 || newTinggi <= 0 || newTinggiPrisma <= 0) {
                            System.out.println("Nilai harus lebih dari nol.\n");
                            continue;
                        }

                        volume = hitungVolume(newAlasAtas, newAlasBawah, newSisiMiring, newTinggi, newTinggiPrisma);
                        luasPermukaan = hitungLuasPermukaan(newAlasAtas, newAlasBawah, newSisiMiring, newTinggi, newTinggiPrisma);
                        System.out.printf("\nVolume Prisma Baru: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Prisma Baru: %.2f\n", luasPermukaan);
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // Clear the invalid input
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
        hitungVolume();
        hitungLuasPermukaan();
    }
    
}
