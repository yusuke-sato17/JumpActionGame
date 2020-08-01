package jp.techacademy.yusuke.sato.jumpactiongame

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite

class Enemy(texture: Texture, srcX: Int, srcY: Int, srcWidth: Int, srcHeight: Int)
    : Sprite(texture, srcX, srcY, srcWidth, srcHeight) {

    companion object {
        val ENEMY_WIDTH = 0.8f
        val ENEMY_HEIGHT = 0.8f
    }
}