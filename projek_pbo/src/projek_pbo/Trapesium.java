package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Trapesium extends BangunDatar {
    private double alasAtas;
    private double alasBawah;
    private double sisiMiring;
    private double tinggi;

    public Trapesium(double alasAtas, double alasBawah, double sisiMiring, double tinggi) {   
        this.alasAtas = alasAtas;
        this.alasBawah = alasBawah;
        this.sisiMiring = sisiMiring;
        this.tinggi = tinggi;
        this.hitungKeliling();
        this.hitungLuas();
    }

    @Override
    public double hitungLuas() {
        this.luas = 0.5 * (alasAtas + alasBawah) * tinggi; 
        return luas;
    }

    @Override
    public double hitungKeliling() {
        this.keliling =  alasAtas + alasBawah + 2 * sisiMiring;   
        return keliling;
    }

    public double hitungLuas(double alasAtasBaru, double alasBawahBaru, double sisiMiringBaru, double tinggiBaru) {
        luas = 0.5 * (alasAtasBaru + alasBawahBaru) * tinggiBaru;
        return luas;
    }

    public double hitungKeliling(double alasAtasBaru, double alasBawahBaru, double sisiMiringBaru, double tinggiBaru) {
        keliling = alasAtasBaru + alasBawahBaru + 2 * sisiMiringBaru;
        return keliling;
    }

    public void prosesInputDanValidasi() {
        java.util.Scanner inp = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas atas, alas bawah, sisi miring, dan tinggi trapesium? (Y/N): ");
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
                        inp.nextLine();
                        if (newAlasAtas <= 0 || newAlasBawah <= 0 || newSisiMiring <= 0 || newTinggi <= 0) {
                            System.out.println("Nilai harus lebih dari nol.\n");
                            continue;
                        }
                        alasAtas = newAlasAtas;
                        alasBawah = newAlasBawah;
                        sisiMiring = newSisiMiring;
                        tinggi = newTinggi;
                        luas = hitungLuas(newAlasAtas, newAlasBawah, newSisiMiring, newTinggi);
                        keliling = hitungKeliling(newAlasAtas, newAlasBawah, newSisiMiring, newTinggi);
                        System.out.printf("\nLuas Trapesium: %.2f\n", luas);
                        System.out.printf("Keliling Trapesium: %.2f\n", keliling);
                        break; // keluar dari loop input
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
                        inp.nextLine(); // bersihkan input yang salah
                    }
                }
                break;
            } else if (jawab.equalsIgnoreCase("N")) {
                break; // keluar dari loop jika tidak ingin mengubah nilai
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan Y atau N.");
            }
        }
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    public double getAlasAtas() {
        return alasAtas;
    }

    public double getAlasBawah() {
        return alasBawah;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }

    public void setAlasAtas(double alasAtas) {
        this.alasAtas = alasAtas;
    }
    public void setAlasBawah(double alasBawah) {
        this.alasBawah = alasBawah;
    }

    public void setSisiMiring(double sisiMiring) {
        this.sisiMiring = sisiMiring;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }
}

