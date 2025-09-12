package liangFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_10 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Exercise17_10 SourceFile numberOfPieces");
            System.exit(1);
        }

        String sourceFile = args[0];
        int numberOfPieces = Integer.parseInt(args[1]);

        try (FileInputStream fis = new FileInputStream(sourceFile)) {
            long fileSize = fis.getChannel().size();
            long pieceSize = fileSize / numberOfPieces;
            long remaining = fileSize % numberOfPieces;

            byte[] buffer = new byte[1024];
            for (int i = 0; i < numberOfPieces; i++) {
                String pieceFile = sourceFile + "." + (i + 1);
                try (FileOutputStream fos = new FileOutputStream(pieceFile)) {
                    long currentPieceSize = pieceSize + (i < remaining ? 1 : 0);
                    for (long j = 0; j < currentPieceSize; j += buffer.length) {
                        int bytesRead = fis.read(buffer, 0, (int) Math.min(buffer.length, currentPieceSize - j));
                        fos.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("Created " + pieceFile);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
