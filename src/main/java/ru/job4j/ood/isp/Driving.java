package ru.job4j.ood.isp;

/**
 * Третий пример нарушения Interface Segregation Principle. Интерфейс вождение предусматриавает
 * методы для вождения разных видов транспорта, если требуется использовать только метод для
 * вождения трамвая - рационально создать интерфейс DrivingTram и использовать подходящий метод,
 * исключив остальные, не нужные для реализации методы.
 */
public interface Driving {
    void drivingCar();
    void drivingTram();
    void drivingBus();
}
