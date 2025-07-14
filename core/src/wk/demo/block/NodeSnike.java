package wk.demo.block;

import com.badlogic.gdx.graphics.Color;

import wk.demo.block.node.Node;
import wk.demo.block.view.GameView;

public class NodeSnike {
    private Node head;
    private Node end;
    private GameView gameView;

    public NodeSnike(int startX, int startY, GameView gameView){
        this.gameView = gameView;
        head = new Node(startX,startY,"chngcong.jpg");
        gameView.addActor(head);
        head.next = null;
        end = head;
    }

    public void addNode (Node nodeFood){
        Node node = new Node(end.getPosX(),end.getPosY(),nodeFood.getTexture());
        gameView.addActor(node);
        end.next = node;
        end = node;
    }

    public Node getHead() {
        return head;
    }

}