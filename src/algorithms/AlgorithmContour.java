package algorithms;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class AlgorithmContour implements Algorithm {
    private static int maxValue = 40;

    @Override
    public void change(Mat frame) {
        new AlgorithmGaussianBlur().change(frame);
        Mat dop = new Mat();
        frame.copyTo(dop);
        Imgproc.adaptiveThreshold(dop, frame, maxValue, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY,7, 5);
    }

    public static void setMaxValue(int maxValue) {
        AlgorithmContour.maxValue = maxValue;
    }
}
