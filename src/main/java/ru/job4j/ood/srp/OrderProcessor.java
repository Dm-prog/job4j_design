package ru.job4j.ood.srp;

/*
Первый пример нарушения Single Responsibility Principle
 */
public class OrderProcessor {

    public void process() {
    }

    private boolean save() {
        //MySqlConnection connection = new MySqlConnection("database.url");
        // сохраняем заказ в базу данных
        return true;
    }

    private void sendConfirmationEmail() {
        //String name = order.getCustomerName();
        //String email = order.getCustomerEmail();

        // Шлем письмо клиенту
    }
}

