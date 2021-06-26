package ru.job4j.ood.ocp;

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

