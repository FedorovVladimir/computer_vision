package details;

import algorithms.Algorithm;
import opencv.CvUtils;
import org.opencv.core.Mat;

import java.awt.image.BufferedImage;

public class View extends Thread {
    private Window window;
    private Camera camera;
    private Algorithm algoritm;

    public View(int width, int height, String title, Algorithm algorithm) {
        window = new Window(title, width + 20, height + 43);
        camera = new Camera(0, width, height);
        this.algoritm = algorithm;
    }

    public void run() {
        try {
            Mat frame = new Mat();
            while (camera.read(frame) && window.isVisible()) {
                algoritm.change(frame);
                BufferedImage buffer = CvUtils.convertMatToBufferedImage(frame);
                window.drawImage(buffer, 10, 33, null);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public boolean isVisible() {
        return window.isVisible();
    }

    public void close() {
        camera.release();
    }
}
