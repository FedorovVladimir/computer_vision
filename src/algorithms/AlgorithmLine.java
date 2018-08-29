package algorithms;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;

import static org.opencv.imgproc.Imgproc.line;

public class AlgorithmLine implements Algorithm {
    @Override
    public void change(Mat img) {
        line(img, new Point(0, 0), new Point(img.width(), img.height()), new Scalar(255, 0, 0));
        line(img, new Point(0, img.height()), new Point(img.width(), 0), new Scalar(255, 0, 0));
    }
}
