package ru.kpfu.itis.gallows.ui.interfaces;

public interface IClientView {
    void repaintView(boolean isRight, char[] secretWord, int mistake, char[] usedWords);
    void gameOver();
}
