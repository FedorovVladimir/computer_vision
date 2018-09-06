package details;

import algorithms.AlgorithmNone;

public class CompositeViews {
    private static View view;

    public static View getInstance() {
        if (view == null) {
            view = new View(1280, 720, "AlgorithmNone", new AlgorithmNone(), 0);
            view.start();
        }
        return view;
    }
}
