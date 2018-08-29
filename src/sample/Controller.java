package sample;

import algorithms.AlgorithmLine;
import algorithms.AlgorithmNone;
import details.View;

public class Controller {
    public void noneButton() {
        System.out.println("none");

        String title = "Реальное изображение";
        int width = 320;
        int height = 240;
        View view = new View(width, height, title, new AlgorithmNone());
        view.start();
    }

    public void lineButton() {
        System.out.println("line");
        String title = "Изображение с линиями";
        int width = 320;
        int height = 240;
        View viewLine = new View(width, height, title, new AlgorithmLine());
        viewLine.start();
    }

    public void exitButton() {
        System.exit(0);
    }
}
