
package CGlab;

import static java.lang.Math.sqrt;

public class FlatShadingRenderer extends RandomColorRenderer{
    public FlatShadingRenderer(String filename, Integer width, Integer height, String method) {
        super(filename,width,height,method);
    }

    public float cosBetweenVectors(Vec3f A, Vec3f B){
        float dotproduct = (A.x * B.x) + (A.y * B.y) + (A.z * B.z);
        float v1Length = (float) sqrt(A.x * A.x + A.y * A.y + A.z * A.z);
        float v2Length = (float) sqrt(B.x * B.x + B.y * B.y + B.z * B.z);
        return  dotproduct / (v1Length * v2Length);
    }

    public Vec3f Normal(Vec3f A, Vec3f B, Vec3f C) {
        Vec3f v1 = new Vec3f((B.x - A.x), (B.y - A.y),(B.z - A.z));
        Vec3f v2 = new Vec3f((C.x - A.x), (C.y - A.y),(C.z - A.z));
        Vec3f cross = crossProduct(v1, v2);
        return cross;
    }

    void render(Model model) {

        for (Vec3i face : model.getFaceList()) {
            Vec3f[] screen_coords3 = new Vec3f[3];
            Vec3i[] screen_coords = new Vec3i[3];
            for (int j=0; j<3; j++) {
                Vec3f world_coord = model.getVertex(face.get(j));
                screen_coords3[j] = world_coord;
                screen_coords[j] = new Vec3i((int)((world_coord.x() + 1.0) * this.getWidth() / 2.0), (int)((world_coord.y() + 1.0) * this.getHeight() / 2.0) - this.getHeight() / 2, (int)((world_coord.z() + 1.0) * this.getHeight() / 2.0) - this.getHeight() / 2 );
            }

            Float cosBetweenVectors = cosBetweenVectors( new Vec3f( 50,50,50), Normal( screen_coords3[0],screen_coords3[1],screen_coords3[2])) *128 + 128;
            Integer cosBetweenVectorsInt = Math.round(cosBetweenVectors);
            drawTriangle(screen_coords[0], screen_coords[1], screen_coords[2],new Color(cosBetweenVectorsInt,cosBetweenVectorsInt,cosBetweenVectorsInt));
        }
    }

}
