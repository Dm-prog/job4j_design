package ru.job4j.ood.lsp;

/*
Второй пример нарушения Liskov’s Substitution Principle. Изменилось ожидаемое поведение
переопределенных методов. Выбрасывается исключение, тогда как ожидается вывод сообщения.
 */
public class Penguin extends Bird {

    @Override
    public void canFly() {
        throw new UnsupportedOperationException("Help! I cannot fly!");
    }
}
