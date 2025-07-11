package wk.demo.block.screen;


import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;

import wk.demo.block.view.GameView;

public class GameScreen extends BaseScreen {

    public GameScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        GameView view = new GameView();
        stage.addActor(view);
    }

}
