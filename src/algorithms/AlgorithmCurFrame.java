package algorithms;

import org.opencv.core.Mat;

public class AlgorithmCurFrame implements Algorithm {
    @Override
    public void change(Mat frame) {
        new AlgorithmContour().change(frame);
//        Imgproc.Canny(frame, imageA, Window.getInstance().slider1.getValue(), Window.getInstance().slider2.getValue(), 3, true);
//        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
//        Imgproc.findContours(imageA, contours, new Mat(), Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
//        Imgproc.drawContours(imageBlurr, contours, 1, new Scalar(0,0,255));
//        for(int i=0; i< contours.size();i++){
//            if (Imgproc.contourArea(contours.get(i)) > 50 ){
//                Rect rect = Imgproc.boundingRect(contours.get(i));
//                int sl = Window.getInstance().slider3.getValue();
//                if (rect.height > sl && rect.width > sl ){
//                    Imgproc.rectangle(frame, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255),3);
//                }
//            }
//        }
    }
}
