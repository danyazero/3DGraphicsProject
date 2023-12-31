package Components;

import Elements.Panel;
import com.example.zero.GroupExtended;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Radiator {
    int x, y, z, xAngle, yAngle, zAngle, width;
    GroupExtended group;
    boolean on;

    public Radiator(int x, int y, int z, int width, int xAngle, int yAngle, int zAngle, GroupExtended group, boolean on) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.zAngle = zAngle;
        this.group = group;
        this.on = on;
    }

    public void init(){
        GroupExtended radiator = new GroupExtended();

        Panel platform = new Panel(width-4, width-4, 15, Color.rgb(228, 228, 228), on);
        platform.setSpecular(Color.WHITE);
        radiator.getChildren().add(platform.getPanel());

        int n = (width-4) / 6;
        int position = -((width-4) / 2);
        for (int i = 1; i <= n+1; i++) {
            Panel p1 = new Panel(3, width, 60-15, Color.rgb(228, 228, 228), on);
            p1.setSpecular(Color.WHITE);
            p1.setPosition(0, position, 15);
            p1.setRotate(0, 0,90);
            radiator.getChildren().add(p1.getPanel());
            position += 6;
        }
        radiator.translateXProperty().set(x);
        radiator.translateYProperty().set(y);
        radiator.translateZProperty().set(z);

        radiator.getTransforms().add(new Rotate(xAngle, Rotate.X_AXIS));
        radiator.getTransforms().add(new Rotate(yAngle, Rotate.Y_AXIS));
        radiator.getTransforms().add(new Rotate(zAngle, Rotate.Z_AXIS));

        group.getChildren().add(radiator);
    }
}
