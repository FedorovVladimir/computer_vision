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
        new AlgorithmContour().change(dop);
        new AlgorithmCanny().change(dop);

        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(dop, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(frame, contours, 1, new Scalar(0,0,255), 2);


        for (MatOfPoint matOfPoint: contours) {
            if (Imgproc.contourArea(matOfPoint) > 50) {
                Rect rect = Imgproc.boundingRect(matOfPoint);
                if (rect.height > size && rect.width > size ){
                    Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width,rect.y + rect.height), new Scalar(0,0,255),3);
                }
            }
        }
    }

    public static void setSize(int size) {
        AlgorithmCurFrame.size = size;
    }
}
