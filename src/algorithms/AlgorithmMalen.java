package algorithms;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.imgproc.Imgproc.arrowedLine;
import static org.opencv.imgproc.Imgproc.rectangle;

public class AlgorithmMalen implements Algorithm {
    private static int size = 20;

    @Override
    public void change(Mat frame) {
        Mat dop = new Mat();
        frame.copyTo(dop);
        new AlgorithmCanny().change(dop);

        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(dop, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
//
//        for (int i = 0; i < contours.size() - 2; i ++)
//            makeCube(frame, contours.get(i), contours.get(i + 1));
//
        if (inAreaVision(contours.get(0)) && inAreaVision(contours.get(contours.size() - 1))) {
            if (contours.size() > 1)
            makeCube(frame, contours.get(contours.size() - 1), contours.get(0));
        }
        showRectangleSearch(frame);
    }

    private void showRectangleSearch(Mat frame) {
        Point x0y0 = new Point(160, 90);
        Point x1y1 = new Point(1120, 630);
        Scalar color = new Scalar(0,0,0);
        rectangle(frame, x0y0, x1y1, color, 1);
    }

    private boolean inAreaVision(MatOfPoint matOfPoint) {
        Rect rect = Imgproc.boundingRect(matOfPoint);
        int x1 = rect.x;
        int y1 = rect.y;
        int x2 = rect.x + rect.width;
        int y2 = rect.y + rect.height;
        return x1 > 160 && x2 < 1120 && y1 > 90 && y2 < 630;
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
