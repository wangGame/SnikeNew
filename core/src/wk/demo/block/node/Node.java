package wk.demo.block.node;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import wk.demo.block.constant.SnikeConstant;

public class Node extends Group {
    private int posX = 0;
    private int posY = 0;
    public Node next;
    public Node(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        Image image = new Image(new Texture("snike.png"));
        addActor(image);
        image.setSize(20,20);
        setSize(image.getWidth(),image.getHeight());
        setDebug(true);
        setPosition(posX * SnikeConstant.tableSize,posY* SnikeConstant.tableSize);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        setX(posX * SnikeConstant.tableSize);
    }

    public void setPosY(int posY) {
        this.posY = posY;
        setY(posY * SnikeConstant.tableSize);
    }
}