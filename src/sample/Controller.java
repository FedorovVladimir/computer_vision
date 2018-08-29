package sample;

import algorithms.AlgorithmBlackWhite;
import algorithms.AlgorithmContour;
import algorithms.AlgorithmLine;
import algorithms.AlgorithmNone;
import details.CompositeViews;
import javafx.scene.control.Slider;

public class Controller {
    public Slider counterSlider;

    public void noneButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmNone(), "AlgorithmNone");
    }

    public void lineButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmLine(), "AlgorithmLine");
    }

    public void blackWhiteButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmBlackWhite(), "Black While");
    }

    public void contourButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmContour(), "Black While -> Contour");
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
