package jp.techacademy.yusuke.sato.jumpactiongame

import com.badlogic.gdx.graphics.Texture

class Ufo(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : GameObject(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object {
        val UFO_WIDTH = 2.0f
        val UFO_HEIGHT = 1.3f
    }

    init {
        setSize(UFO_WIDTH, UFO_HEIGHT)
    }
}