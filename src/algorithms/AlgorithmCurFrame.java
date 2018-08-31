package algorithms;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmCurFrame implements Algorithm {
    private static int size = 20;

    @Override
    public void change(Mat frame) {
        Mat dop = new Mat();
        frame.copyTo(dop);
        new AlgorithmCanny().change(dop);

        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(dop, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);

        for(int i = 0; i < contours.size(); i++) {
            Rect rect = Imgproc.boundingRect(contours.get(i));
            if (rect.height > size && rect.width > size) {
                Imgproc.drawContours(frame, contours, i, new Scalar(0, 127, 255), 2);
                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
            }
        }

    }



    public static void setSize(int size) {
        AlgorithmCurFrame.size = size;
    }
}
