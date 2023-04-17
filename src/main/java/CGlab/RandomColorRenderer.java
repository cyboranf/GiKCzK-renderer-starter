package CGlab;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomColorRenderer extends Renderer {
    public RandomColorRenderer(String filename, Integer width, Integer height, String method) {
        super(filename, width, height, method);
    }

    void render(Model model) {
        for (Vec3i face : model.getFaceList()) {

            Vec2i[] screen_coords = new Vec2i[3];
            for (int j = 0; j < 3; j++) {
                Vec3f world_coord = model.getVertex(face.get(j));
                screen_coords[j] = new Vec2i((int) ((world_coord.x() + 1.0) * this.getWidth() / 2.0), (int) ((world_coord.y() + 1.0) * this.getHeight() / 2.0) - this.getHeight() / 2);
            }

            drawTriangle(screen_coords[0], screen_coords[1], screen_coords[2], new Color());
        }
    }


}

