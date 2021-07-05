package ru.job4j.ood.lsp;

/*
Третий пример нарушения Liskov’s Substitution Principle. Используется
определение класса во время выполнения и в зависимости от результата вызывается
нужная функция с явным приведением класса аргумента. И если добавится новый
наследник класса Shape, ее нужно будет изменить, так как иначе произойдет вызов
drawCircle, которая в лучшем случае выкинет ошибку, а в худшем — отработает некорректно.
 */
public class ActionShape {
    void drawShape(Shape shape) {
//        if (shape instanceof Square) {
//            drawSquare((Square) shape);
//        } else {
//            drawCircle((Circle) shape);
//        }
    }
}
