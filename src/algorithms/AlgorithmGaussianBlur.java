package algorithms;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class AlgorithmGaussianBlur implements Algorithm {
    private static int size = 5;

    @Override
    public void change(Mat frame) {
        new AlgorithmBlackWhite().change(frame);
        Mat dop = new Mat();
        frame.copyTo(dop);
        Imgproc.GaussianBlur(dop, frame, new Size(size, size), 0);
    }

    public static void setSize(int size) {
        AlgorithmGaussianBlur.size = size * 2 + 1;
    }
}
