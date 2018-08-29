package algorithms;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class AlgorithmBlackWhite implements Algorithm {
    @Override
    public void change(Mat frame) {
        Mat dop = new Mat();
        frame.copyTo(dop);
        Imgproc.cvtColor(dop, frame, Imgproc.COLOR_BGR2GRAY);
    }
}
