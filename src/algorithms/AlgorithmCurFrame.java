package algorithms;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.imgproc.Imgproc.rectangle;

public class AlgorithmCurFrame implements Algorithm {
    private static int size = 20;

    @Override
    public void change(Mat frame) {
        Mat dop = new Mat();
        frame.copyTo(dop);
        new AlgorithmCanny().change(dop);

        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(dop, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(frame, contours, 1, new Scalar(0,80,255), 2);

        for(int i = 0; i < contours.size(); i++) {
            if (inAreaVision(contours.get(i))) {
                Rect rect = Imgproc.boundingRect(contours.get(i));
                if (rect.height > size && rect.width > size) {
                    Imgproc.drawContours(frame, contours, i, new Scalar(0, 127, 255), 2);
                    Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
                }
            }
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

    public static void setSize(int size) {
        AlgorithmCurFrame.size = size;
    }
}
