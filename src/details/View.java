package details;

import algorithms.Algorithm;
import date.FormatDate;
import opencv.CvUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.videoio.VideoWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View extends Thread {
    private Window window;
    private Camera camera;
    private Algorithm algorithm;

    private VideoWriter writer;
    private boolean videoStart = false;
    private boolean videoSave = true;

    private int width;
    private int height;


    View(int width, int height, String title, Algorithm algorithm, int index) {
        this.width = width;
        this.height = height;
        window = new Window(title, width + 20, height + 43);
        camera = new Camera(index, width, height);
        this.algorithm = algorithm;
    }

    public void run() {
        try {
            Mat frame = new Mat();
            while (camera.read(frame) && window.isVisible()) {
                //frame = flip(frame);
                algorithm.change(frame);
                BufferedImage buffer = CvUtils.convertMatToBufferedImage(frame);
                window.drawImage(buffer, 10, 33, null);
                if (videoStart)
                    writer.write(frame);
                frame.release();
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    private Mat flip(Mat frame) {
        Mat dop = new Mat();
        Core.flip(frame, dop, 1);
        return dop;
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
        frame.release();
    }

    public void setAlgorithm(Algorithm algorithm, String title) {
        this.algorithm = algorithm;
        window.setTitle(title);
    }

    public void videoStart() {
        if (videoSave) {
            writer = new VideoWriter("videos\\" + FormatDate.get("dd.MM.yyyy HH.mm.SS") + ".avi",
                    VideoWriter.fourcc('M','J','P','G'), 20, new Size(width, height), true);
            videoSave = false;
        }
        videoStart = true;
    }

    public void videoStop() {
        videoStart = false;
    }

    public void videoSave() {
        videoSave = true;
        writer.release();
    }
}
