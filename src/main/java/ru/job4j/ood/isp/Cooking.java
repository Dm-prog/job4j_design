package ru.job4j.ood.isp;

/**
 * Второй пример нарушения Interface Segregation Principle. Интерфейс приготовление блюд
 * содержит 3 метода с разными блюдами. Для какого-то кулинарного заведения не требуется
 * все эти блюда и рационально вынести в отдельный интерфейс только те методы, которые точно
 * будут использоваться.
 */
public interface Cooking {
    void makingCake();
    void cookingSoup();
    void saladPreparation();
}
