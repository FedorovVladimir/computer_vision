package algorithms;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class AlgorithmCanny implements Algorithm {
    private static int minValue = 20;
    private static int maxValue = 20;

    @Override
    public void change(Mat frame) {
        Mat dop = new Mat();
        frame.copyTo(dop);
        Imgproc.Canny(dop, frame, minValue, maxValue, 3, true);
    }

    public static void setMinValue(int minValue) {
        AlgorithmCanny.minValue = minValue;
    }

    public static void setMaxValue(int maxValue) {
        AlgorithmCanny.maxValue = maxValue;
    }
}
