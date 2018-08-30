package sample;

import algorithms.*;
import details.CompositeViews;
import javafx.scene.control.Slider;

public class Controller {
    public Slider counterSlider;
    public Slider gaussianBlurSlider;
    public Slider cannyMin;
    public Slider cannyMax;

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

    public void photoButton() {
        CompositeViews.getInstance().photo();
    }

    public void exitButton() {
        System.exit(0);
    }
}
