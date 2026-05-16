package threadingTrapesium;

import java.util.List;

import projek_pbo.*;

public class ThreadExecutorSingle {

    public static void processShapes(List<BendaGeometri> shapes) {
        for (BendaGeometri shape : shapes) {
            processShape(shape);
        }
    }

    private static void processShape(BendaGeometri shape) {
        String threadName = Thread.currentThread().getName(); // biasanya "main"

        try {
            if (shape.getClass().getSuperclass().equals(BangunDatar.class)) {
                // direct subclass of bangun datar
                BangunDatar bd = (BangunDatar) shape;
                double keliling = bd.hitungKeliling();
                double luas = bd.hitungLuas();
                System.out.printf("%s - [%s] 2D -> Keliling: %.2f, Luas: %.2f%n",
                        threadName, shape.getClass().getSimpleName(), keliling, luas);
            }

            try {
                var volumeMethod = shape.getClass().getMethod("hitungVolume");
                var luasPermukaanMethod = shape.getClass().getMethod("hitungLuasPermukaan");

                double volume = (double) volumeMethod.invoke(shape);
                double luasPermukaan = (double) luasPermukaanMethod.invoke(shape);

                System.out.printf("%s - [%s] Volume: %.2f, Luas Permukaan: %.2f%n",
                        threadName, shape.getClass().getSimpleName(), volume, luasPermukaan);
            } catch (NoSuchMethodException ignored) {
                // abaikan jika bukan bangun ruang
            }

        } catch (Exception e) {
            System.err.println("Error processing shape " + shape.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
