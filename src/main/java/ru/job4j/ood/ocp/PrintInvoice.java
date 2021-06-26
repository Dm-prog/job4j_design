package ru.job4j.ood.ocp;

/*
Третий пример Open Closed Principle. Для печати счета-фактуры  не изменяем
класс Invoice, а расшитряем с помощью PrintInvoice.
 */
public class PrintInvoice extends Invoice {
    public void printInvoice() {
    }
}
