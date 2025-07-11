package wk.demo.block;

import com.kw.gdx.BaseGame;

import wk.demo.block.screen.GameScreen;

public class SnakeMain extends BaseGame {
    @Override
    protected void loadingView() {
        super.loadingView();
        setScreen(new GameScreen(this));
    }
}
