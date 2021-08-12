package ru.job4j.ood.isp;

/**
 * Первый пример нарушения Interface Segregation Principle. Интерфейс генерирует файл и содержит
 * 2 метода: первый - генерирует в PDF- формат, второй - в Excel. У клиента может быть
 * необходимость использовать только один вид генерации и один из методов окажется бесполезным,
 * по-этому рационально разбить один интерфейс на 2: GenerateExcel и GeneratePDF.
 */
public interface GenerateFile {
    void generateExcel();
    void generatedPdf();
}

