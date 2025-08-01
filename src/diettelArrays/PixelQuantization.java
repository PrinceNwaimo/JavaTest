package diettelArrays;

public class PixelQuantization {
    public static void quantizePixels(int[] pixels) {
        for (int i = 0; i < pixels.length; i++) {
            if (pixels[i] <= 20) {
                pixels[i] = 10;
            } else if (pixels[i] <= 40) {
                pixels[i] = 30;
            } else if (pixels[i] <= 60) {
                pixels[i] = 50;
            } else if (pixels[i] <= 80) {
                pixels[i] = 70;
            } else if (pixels[i] <= 100) {
                pixels[i] = 90;
            } else if (pixels[i] <= 120) {
                pixels[i] = 110;
            } else if (pixels[i] <= 140) {
                pixels[i] = 130;
            } else if (pixels[i] <= 160) {
                pixels[i] = 150;
            } else if (pixels[i] <= 180) {
                pixels[i] = 170;
            } else {
                pixels[i] = 190;
            }
        }
    }

    public static void printArray(int[] pixels) {
        for (int pixel : pixels) {
            System.out.print(pixel + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] pixels = {15, 35, 55, 75, 95, 115, 135, 155, 175, 195};
        System.out.print("Original pixel values: ");
        printArray(pixels);
        quantizePixels(pixels);
        System.out.print("Quantized pixel values: ");
        printArray(pixels);
    }

}
