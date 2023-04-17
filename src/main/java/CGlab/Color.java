package CGlab;

import java.util.Random;

public class Color extends Vec3i{
    private int validateValue(int color){
        if (color < 0) {
            return 0;
        }

        if (color > 255) {
            return 255;
        } else {
            return color;
        }
    }

    public Color(){
        super(0,0,0);
        Random random = new Random();
        x = random.nextInt(255 - 0);
        y = random.nextInt(255 - 0);
        z = random.nextInt(255 - 0);
    }

    public Color(int x, int y, int z) {
        super(x,y,z);
        x = validateValue(x);
        y = validateValue(y);
        z = validateValue(z);
    }
}
