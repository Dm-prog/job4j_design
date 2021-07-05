package ru.job4j.ood.ocp;

/*
Первый пример Open Closed Principle. Для сохранения заказа не изменяем
класс OrderProcessor, а расшитряем с помощью SaveProcessor.
 */
public class SaveProcessor extends OrderProcessor {
    private boolean save() {
        return true;
    }
}

