package wk.demo.block.node;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;

import java.util.Random;

import wk.demo.block.constant.SnikeConstant;

public class Node extends Group {
    private int posX = 0;
    private int posY = 0;
    public Node next;
    private String textureName;

    public Node(int posX, int posY) {
        this(posX,posY,null);
    }

    public Node(int posX, int posY,String textureName) {
        this.posX = posX;
        this.posY = posY;
        int random = (int) (Math.random() * 49 +1);
        if (textureName == null) {
            textureName = "21_" + random + ".png";
        }
        this.textureName = textureName;
        Image bg = new Image(Asset.getAsset().getTexture("food/bg_3.png"));
        addActor(bg);
        Image image = new Image(Asset.getAsset().getTexture("food/"+textureName));
        addActor(image);
        setSize(image.getWidth(),image.getHeight());
        bg.setX(getWidth()/2f, Align.center);
        bg.setY(getHeight()/2f, Align.center);
        setScale(SnikeConstant.tableSize/getWidth());
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

    public String getTexture() {
        return textureName;
    }
}