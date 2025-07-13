package wk.demo.block.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kw.gdx.constant.Constant;

import wk.demo.block.constant.SnikeConstant;
import wk.demo.block.node.Node;
import wk.demo.block.NodeSnike;
import wk.demo.block.dir.Direction;


public class GameView extends Group {
    private Node head;
    private NodeSnike snike;
    private Action tempAction;
    private Direction currentDir;
    private Vector2 current = new Vector2(0,0);
    private Vector2 prePos = new Vector2(Integer.MAX_VALUE,Integer.MAX_VALUE);
    private float time;
    private Node foodNode;

    public GameView(){
        setDebug(true);
        setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
        snike = new NodeSnike((int) (getWidth()/2f/ SnikeConstant.tableSize), (int) (getHeight()/2f/SnikeConstant.tableSize),this);
        head = snike.getHead();
//        tempAction =Actions.forever(Actions.delay(0.4F,Actions.run(
//                ()->{
//                    snike.addNode();
//
//            }
//        )));

        currentDir = Direction.LEFT;

        InputAdapter adapter = new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                System.out.println(keycode);
                return super.keyDown(keycode);
            }
        };
        Gdx.input.setInputProcessor(adapter);


    }

    public void genFood(){
        if (foodNode!=null)foodNode.remove();
        int x = (int) (Math.random() * (getWidth() - SnikeConstant.tableSize));
        int y = (int) (Math.random() * (getHeight() - SnikeConstant.tableSize));
        foodNode = new Node((int) (x/SnikeConstant.tableSize), (int) (y/SnikeConstant.tableSize));
        addActor(foodNode);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        if (time>0.1f) {
            move();
        }
        handler();
    }


    public void move(){
        time = 0;
        int distance  = 1;
        head = snike.getHead();
        if (foodNode!=null){
            if (head.getPosX() == foodNode.getPosX() && head.getPosY() == foodNode.getPosY()){
                snike.addNode(foodNode);
                genFood();
            }
        }else {
            genFood();
        }

        while (head !=null){
            if (prePos.x == Integer.MAX_VALUE) {
                prePos.set(head.getPosX(),head.getPosY());
                if (currentDir == Direction.UP){
                    int distanceEnd = head.getPosY() + distance;
                    if (distanceEnd * SnikeConstant.tableSize >= Constant.GAMEHIGHT){
                        distanceEnd = 0;
                    }
                    current.set(head.getPosX(),distanceEnd);
                }else if (currentDir == Direction.DOWN){
                    int distanceEnd = head.getPosY() - distance;
                    if (distanceEnd * SnikeConstant.tableSize <0){
                        distanceEnd = (int) ((Constant.GAMEHIGHT)/SnikeConstant.tableSize);
                    }
                    current.set(head.getPosX(),distanceEnd);
                }else if (currentDir == Direction.LEFT){
                    int distanceEnd = head.getPosX() - distance;
                    if (distanceEnd * SnikeConstant.tableSize < 0){
                        distanceEnd = (int) ((Constant.GAMEWIDTH - SnikeConstant.tableSize)/SnikeConstant.tableSize);
                    }
                    current.set(distanceEnd,head.getPosY());
                }else if (currentDir == Direction.RIGHT){
                    int distanceEnd = head.getPosX() + distance;
                    if (distanceEnd * SnikeConstant.tableSize >= Constant.GAMEWIDTH){
                        distanceEnd = 0;
                    }
                    current.set(distanceEnd,head.getPosY());
                }
                head.setPosX((int) current.x);
                head.setPosY((int) current.y);
            }else {
                float tempx = prePos.x;
                float tempy = prePos.y;
                prePos.set(head.getPosX(),head.getPosY());
                head.setPosX((int)tempx);
                head.setPosY((int)tempy);
            }
            head = head.next;
        }
        prePos.set(Integer.MAX_VALUE,Integer.MAX_VALUE);
    }


    public void handler(){
        Direction oldDir = currentDir;
        //上  下   左  右
        if (Gdx.input.isKeyPressed(19)) {
            if (oldDir != Direction.DOWN){
                currentDir = Direction.UP;
            }
        }else if (Gdx.input.isKeyPressed(20)){
            if (oldDir != Direction.UP){
                currentDir = Direction.DOWN;
            }
        }else if (Gdx.input.isKeyPressed(21)){
            if (oldDir != Direction.RIGHT) {
                currentDir = Direction.LEFT;
            }
        }else if (Gdx.input.isKeyPressed(22)){
            if (oldDir != Direction.LEFT){
                currentDir = Direction.RIGHT;
            }
        }
        if (oldDir!=currentDir){
//            move();
        }
    }
}
