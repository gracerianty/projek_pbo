package threadingTrapesium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import projek_pbo.*;

public class MainThreading {

    public static void main(String[] args) {

        List<BendaGeometri> shapes = Arrays.asList(

                new Trapesium(10, 14, 8, 6),

                new LimasTrapesium(10, 14, 8, 6, 12),

                new PrismaTrapesium(10, 14, 8, 6, 15)

        );

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (BendaGeometri shape : shapes) {

            executor.submit(() -> processShape(shape));

        }

        executor.shutdown();
    }

    private static void processShape(BendaGeometri shape) {

        String threadName = Thread.currentThread().getName();

        try {

            if (shape instanceof Trapesium) {

                Trapesium t = (Trapesium) shape;

                System.out.println(threadName
                        + " -> Trapesium");

                System.out.println("Luas = "
                        + t.hitungLuas());

                System.out.println("Keliling = "
                        + t.hitungKeliling());
            }

            if (shape instanceof LimasTrapesium) {

                LimasTrapesium lt =
                        (LimasTrapesium) shape;

                System.out.println(threadName
                        + " -> Limas Trapesium");

                System.out.println("Volume = "
                        + lt.hitungVolume());

                System.out.println("Luas Permukaan = "
                        + lt.hitungLuasPermukaan());
            }

            if (shape instanceof PrismaTrapesium) {

                PrismaTrapesium pt =
                        (PrismaTrapesium) shape;

                System.out.println(threadName
                        + " -> Prisma Trapesium");

                System.out.println("Volume = "
                        + pt.hitungVolume());

                System.out.println("Luas Permukaan = "
                        + pt.hitungLuasPermukaan());
            }

        } catch (Exception e) {

            System.out.println("Error : "
                    + e.getMessage());
        }
    }
}