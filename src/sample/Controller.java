package sample;

import algorithms.*;
import details.CompositeViews;
import javafx.scene.control.Slider;

public class Controller {
    public Slider counterSlider;
    public Slider gaussianBlurSlider;

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
        CompositeViews.getInstance().setAlgorithm(new AlgorithmContour(), "Gaussian blur -> Contour");
    }

    public void counterChange() {
        AlgorithmContour.setMaxValue((int) counterSlider.getValue());
    }

    public void photoButton() {
        CompositeViews.getInstance().photo();
    }

    public void exitButton() {
        System.exit(0);
    }
}
