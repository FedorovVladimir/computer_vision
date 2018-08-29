package details;

import algorithms.Algorithm;
import date.FormatDate;
import opencv.CvUtils;
import org.opencv.core.Mat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View extends Thread {
    private Window window;
    private Camera camera;
    private Algorithm algorithm;

    View(int width, int height, String title, Algorithm algorithm, int index) {
        window = new Window(title, width + 20, height + 43);
        camera = new Camera(0, width, height);
        this.algorithm = algorithm;
    }

    public void run() {
        try {
            Mat frame = new Mat();
            while (camera.read(frame) && window.isVisible()) {
                algorithm.change(frame);
                BufferedImage buffer = CvUtils.convertMatToBufferedImage(frame);
                window.drawImage(buffer, 10, 33, null);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public void photo() {
        Mat frame = new Mat();
        camera.read(frame);
        algorithm.change(frame);
        BufferedImage buffer = CvUtils.convertMatToBufferedImage(frame);

        File outputfile = new File("photos\\" + FormatDate.get("dd.MM.yyyy HH.mm.SS") + ".jpg");
        try {
            ImageIO.write(buffer, "jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAlgorithm(Algorithm algorithm, String title) {
        this.algorithm = algorithm;
        window.setTitle(title);
    }

    public void setVisible(boolean b) {
        window.setVisible(b);
    }
}
