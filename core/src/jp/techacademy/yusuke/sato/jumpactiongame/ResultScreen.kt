package jp.techacademy.yusuke.sato.jumpactiongame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport

class ResultScreen(private val mGame: JumpActionGame, private val mScore: Int): ScreenAdapter() {
    companion object  {
        internal val GUI_WIDTH = 320f
        internal val GUI_HEIGHT = 480f
    }

    private var mBg: Sprite
    private var mGuiCamera: OrthographicCamera
    private var mGuiViewPort: FitViewport
    private var mFont: BitmapFont

    init {

        if (mGame.mRequestHandler != null) {
            mGame.mRequestHandler.showAds(true)
        }

        val bgTexture = Texture("resultback.png")
        mBg = Sprite(TextureRegion(bgTexture, 0, 0, 540, 810))
        mBg.setSize(GUI_WIDTH, GUI_HEIGHT)
        mBg.setPosition(0f, 0f)

        mGuiCamera = OrthographicCamera()
        mGuiCamera.setToOrtho(false, GUI_WIDTH, GUI_HEIGHT)
        mGuiViewPort = FitViewport(GUI_WIDTH, GUI_HEIGHT, mGuiCamera)

        mFont = BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false)

    }

    override fun render(delta: Float) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mGuiCamera.update()
        mGame.batch.projectionMatrix = mGuiCamera.combined

        mGame.batch.begin()
        mBg.draw(mGame.batch)
        mFont.draw(mGame.batch, "Score: $mScore", 0f, GUI_HEIGHT / 2 + 40, GUI_WIDTH, Align.center, false)
        mFont.draw(mGame.batch, "Retry?", 0f, GUI_HEIGHT / 2 -40, GUI_WIDTH, Align.center, false)
        mGame.batch.end()

        if (Gdx.input.justTouched()) {
            if (mGame.mRequestHandler != null) {
                mGame.mRequestHandler.showAds(false)
            }
            mGame.screen = GameScreen(mGame)
        }
    }
}