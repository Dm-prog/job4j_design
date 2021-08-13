package ru.job4j.ood.dip;

/**
 * Первый пример нарушения Dependency Inversion Principle. У нас есть жесткая связка
 * между классами (класс MusicPlayer зависит от RockMusic) Для того, чтобы разорвать
 * эту связь нужно использовать абстракцию, например interface Music с методом play(),
 * имплементировать в классе RockMusic и в классе MusicPlayer использовать метод playSomeMusic
 * public void playSomeMusic(Music music). Тогда на входящем параметре music мы сможем вызвать
 * не только Рок музыку, но и любую другую музыку в классах, имплементирующих Music.
 */
public class MusicPlayer {
    private RockMusic rockMusic;
    public void playSomeMusic() {
        rockMusic = new RockMusic();
        // код для воспроизведения Рок музыки.
    }
}
