package algorithms;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgproc.Imgproc.line;

public class AlgorithmLine implements Algorithm {
    @Override
    public void change(Mat img) {
        line(img, new Point(0, 0), new Point(img.width(), 0), new Scalar(0, 0, 255), 10, Imgproc.LINE_AA, 0);
        line(img, new Point(0, img.height()), new Point(0, 0), new Scalar(0, 0, 255), 10, Imgproc.LINE_AA, 0);
        line(img, new Point(img.width(), img.height()), new Point(0, img.height()), new Scalar(0, 0, 255), 10, Imgproc.LINE_AA, 0);
        line(img, new Point(img.width(), 0), new Point(img.width(), img.height()), new Scalar(0, 0, 255), 10, Imgproc.LINE_AA, 0);
    }
}
