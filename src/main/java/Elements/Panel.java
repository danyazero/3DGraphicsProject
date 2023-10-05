package Elements;

import com.example.zero.GroupExtended;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class Panel {
    private Box box;
    public Panel(int width, int height, int depth, Color color){
        box = new Box(width, height, depth);
        PhongMaterial material = new PhongMaterial(color);
        material.setSpecularColor(Color.BLACK);
        box.setMaterial(material);
    }

    public Box getPanel(){
        return box;
    }
    public Box setPosition(int x, int y, int z) {
        box.translateXProperty().set(x);
        box.translateYProperty().set(y);
        box.translateZProperty().set(z);

        return box;
    }

    public Box setRotate(int xAngle, int yAngle, int zAngle){
        box.getTransforms().add(new Rotate(xAngle, Rotate.X_AXIS));
        box.getTransforms().add(new Rotate(yAngle, Rotate.Y_AXIS));
        box.getTransforms().add(new Rotate(zAngle, Rotate.Z_AXIS));

        return box;
    }
}
