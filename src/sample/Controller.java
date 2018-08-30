package sample;

import algorithms.*;
import details.CompositeViews;
import javafx.scene.control.Slider;

public class Controller {
    public Slider counterSlider;
    public Slider gaussianBlurSlider;
    public Slider cannyMin;
    public Slider cannyMax;
    public Slider size;

    public void noneButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmNone(), "AlgorithmNone");
    }

    public void lineButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmLine(), "AlgorithmLine");
    }

    public void blackWhiteButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmBlackWhite(), "Black While");
    }

    public void gaussianBlurButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmGaussianBlur(), "Gaussian blur");
    }

    public void gaussianBlurChange() {
        AlgorithmGaussianBlur.setSize((int) gaussianBlurSlider.getValue());
    }

    public void contourButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmContour(), "Black While -> Gaussian blur -> Contour");
    }

    public void contourChange() {
        AlgorithmContour.setMaxValue((int) counterSlider.getValue());
    }

    public void cannyButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmCanny(), "Canny");
    }

    public void minCanny() {
        AlgorithmCanny.setMinValue((int) cannyMin.getValue());
    }

    public void maxCanny() {
        AlgorithmCanny.setMaxValue((int) cannyMax.getValue());
    }

    public void curFrameButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmCurFrame(), "Contour -> Canny -> Cur Frame");
    }

    public void sizeCurFrame() {
        AlgorithmCurFrame.setSize((int) size.getValue());
        AlgorithmMalen.setSize((int) size.getValue());
    }

    public void malenButtom() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmMalen(), "Malen");
    }



    public void photoButton() {
        CompositeViews.getInstance().photo();
    }

    public void videoStart() {
        CompositeViews.getInstance().videoStart();
    }

    public void videoStop() {
        CompositeViews.getInstance().videoStop();
    }

    public void videoSave() {
        videoStop();
        CompositeViews.getInstance().videoSave();
        System.out.println("video save");
    }

    public void exitButton() {
        System.exit(0);
    }
}
