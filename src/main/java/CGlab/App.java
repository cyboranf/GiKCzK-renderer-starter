package CGlab;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    String version = "0.02";

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.out.println("Niepoprawne argumenty! Użyj: java App [ścieżka] [szerokość] [wysokość]");
            return;
        }

        String filePath = args[0];
        Integer width = Integer.parseInt(args[1]);
        Integer height = Integer.parseInt(args[2]);

        System.out.println(filePath);
        System.out.println(width);
        System.out.println(height);

//        Renderer mainRenderer = new Renderer(filePath);
//        mainRenderer.clear();
//        mainRenderer.drawPoint(100, 100, Color.cyan);
//
//        mainRenderer.drawTriangle(new Vec2f(10,10),new Vec2f(10,30), new Vec2f(40,10), new Color());
//
//        try {
//            mainRenderer.save();
//        } catch (IOException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }

        RandomColorRenderer mainRenderer = new RandomColorRenderer("img/jelen.png", 1000, 1000, "NAIVE");
        Model jelen = new Model();
        jelen.readOBJ("deer.obj");
        mainRenderer.clear();
        mainRenderer.render(jelen);
        jelen.translate(new Vec3f(0.3f, 0.3f, 0.3f));

        FlatShadingRenderer mainRenderer2 = new FlatShadingRenderer("img/flatJelen.png", 1000, 1000, "NAIVE");
        Model jelen2 = new Model();
        jelen2.readOBJ("deer.obj");
        mainRenderer2.clear();
        mainRenderer2.render(jelen2);
        jelen2.translate(new Vec3f(0.3f, 0.3f, 0.3f));

        try {
            mainRenderer.save();
            mainRenderer2.save();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public String getVersion() {
        return this.version;
    }
}
