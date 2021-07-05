package ru.job4j.ood.lsp;

/*
Первый пример нарушения Liskov’s Substitution Principle. Изменилось ожидаемое поведение
переопределенных методов. Метод при не соблюдении условий может выбросить
исключение, тогда как родительский метод ожидает либо true либо false.
 */
public class OrderStockAndPackValidator extends OrderStockValidator {

    @Override
    public boolean isValid(Order order) {
//        for (Item item : order.getItems()) {
//            if ( !item.isInStock() || !item.isPacked() ){
//                throw new IllegalStateException(
//                        String.format("Order %d is not valid!", order.getId())
//                );
//            }
//        }
        return true;
    }
}
