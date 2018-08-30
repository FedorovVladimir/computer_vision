package algorithms;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.imgproc.Imgproc.arrowedLine;

public class AlgorithmMalen implements Algorithm {
    private static int size = 20;

    @Override
    public void change(Mat frame) {
        Mat dop = new Mat();
        frame.copyTo(dop);
        new AlgorithmCanny().change(dop);

        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(dop, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);

        if (contours.size() > 1)
            makeCube(frame, contours.get(contours.size() - 1), contours.get(0));
    }


    private void makeCube(Mat frame, MatOfPoint matOfPoint1, MatOfPoint matOfPoint2) {
        Rect rect1 = Imgproc.boundingRect(matOfPoint1);
        Rect rect2 = Imgproc.boundingRect(matOfPoint2);

        arrowedLine(frame, getCenter(rect1), getCenter(rect2), new Scalar(0, 0, 255), 4, Imgproc.LINE_AA, 0, 0.1);
    }

    private Point getCenter(Rect rect) {
        return new Point(rect.x + rect.width/2, rect.y + rect.height/2);
    }

    public static void setSize(int size) {
        AlgorithmMalen.size = size;
    }
}
