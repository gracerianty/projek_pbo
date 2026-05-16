package projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasTrapesium extends Trapesium {
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasTrapesium(double alasAtas,double alasBawah,double sisiMiring, double tinggi, double tinggiLimas) {
        super(alasAtas, alasBawah, sisiMiring, tinggi);
        this.tinggiLimas = tinggiLimas;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.luas * tinggiLimas;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasAlas = super.luas;

        double tinggiSisiTegak = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((super.getAlasBawah() - super.getAlasAtas()) / 2.0, 2));

        double luasSegitigaAtas = 0.5 * super.getAlasAtas() * tinggiSisiTegak;
        double luasSegitigaBawah = 0.5 * super.getAlasBawah() * tinggiSisiTegak;
        double luasSegitigaMiring = 2 * (0.5 * super.getSisiMiring() * tinggiSisiTegak); 

        luasPermukaan = luasAlas + luasSegitigaAtas + luasSegitigaBawah + luasSegitigaMiring;
        return luasPermukaan;
    }

    public double hitungVolume(double alasAtasBaru, double alasBawahBaru, double sisiMiringBaru, double tinggiBaru, double tinggiLimasBaru) {
        volume = (1.0 / 3.0) * super.hitungLuas(alasAtasBaru, alasBawahBaru, sisiMiringBaru, tinggiBaru) * tinggiLimasBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double alasAtasBaru, double alasBawahBaru, double sisiMiringBaru, double tinggiBaru, double tinggiLimasBaru) {
        double luasAlas = super.hitungLuas(alasAtasBaru, alasBawahBaru, sisiMiringBaru, tinggiBaru);

        double tinggiSisiTegak = Math.sqrt(Math.pow(tinggiLimasBaru, 2) + Math.pow((alasBawahBaru - alasAtasBaru) / 2.0, 2));

        double luasSegitigaAtas = 0.5 * alasAtasBaru * tinggiSisiTegak;
        double luasSegitigaBawah = 0.5 * alasBawahBaru * tinggiSisiTegak;
        double luasSegitigaMiring = 2 * (0.5 * sisiMiringBaru * tinggiSisiTegak); 

        luasPermukaan = luasAlas + luasSegitigaAtas + luasSegitigaBawah + luasSegitigaMiring;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("\nApakah ingin mengubah nilai alas atas, alas bawah, sisi miring, tinggi, dan tinggi limas? (Y/N): ");
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
                        System.out.print("Masukkan Tinggi Limas Baru: ");
                        double newTinggiLimas = inp.nextDouble();
                        inp.nextLine();

                        this.hitungLuasPermukaan(newAlasAtas, newAlasBawah, newSisiMiring, newTinggi, newTinggiLimas);
                        this.hitungVolume(newAlasAtas, newAlasBawah, newSisiMiring, newTinggi, newTinggiLimas);
                        this.setTinggiLimas(newTinggiLimas);
                        System.out.println("Luas Permukaan Limas Trapesium: " + this.getLuasPermukaan());
                        System.out.println("Volume Limas Trapesium: " + this.getVolume());
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid. Silakan coba lagi.");
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

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double getLuas() {
        return luasPermukaan;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
        this.hitungVolume();
        this.hitungLuasPermukaan();
    }

}
