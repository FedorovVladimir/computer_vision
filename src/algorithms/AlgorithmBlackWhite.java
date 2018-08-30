package algorithms;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class AlgorithmBlackWhite implements Algorithm {
    @Override
    public void change(Mat frame) {
        Mat dop = new Mat();
        frame.copyTo(dop);
        Imgproc.cvtColor(dop, frame, Imgproc.COLOR_BGR2GRAY);

        frame.copyTo(dop);
        Imgproc.threshold(dop, frame, 100, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);
    }
}
