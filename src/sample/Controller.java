package sample;

import algorithms.AlgorithmLine;
import algorithms.AlgorithmNone;
import details.CompositeViews;

public class Controller {

    public void noneButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmNone(), "AlgorithmNone");
    }

    public void lineButton() {
        CompositeViews.getInstance().setAlgorithm(new AlgorithmLine(), "AlgorithmLine");
    }

    public void photoButton() {
        CompositeViews.getInstance().photo();
    }

    public void exitButton() {
        System.exit(0);
    }
}
