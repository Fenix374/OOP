package org.example; // Объявление пакета, к которому принадлежит класс
import java.util.ArrayList; // Импорт класса ArrayList для использования динамических массивов
import java.util.Collections; // Импорт класса Collections для работы с коллекциями
import java.util.List; // Импорт интерфейса List для работы со списками

public class ProductionLine {
    private List<String> producedItems; // Список произведенных изделий
    private List<String> productionIssues; // Список проблем производства

    public ProductionLine() {
        producedItems = new ArrayList<>(); // Инициализация списка произведенных изделий
        productionIssues = new ArrayList<>(); // Инициализация списка проблем производства
    }

    public List<String> getProducedItems() {
        return new ArrayList<>(producedItems); // Возвращаем копию списка для безопасности
    }

    public List<String> getProductionIssues() {
        return new ArrayList<>(productionIssues); // Возвращаем копию списка проблем для безопасности
    }

    public void setProducedItems(List<String> producedItems) {
        this.producedItems = new ArrayList<>(producedItems); // Создаем новый список произведенных изделий из предоставленного
    }

    public void setProductionIssues(List<String> productionIssues) {
        this.productionIssues = new ArrayList<>(productionIssues); // Создаем новый список проблем из предоставленного
    }

    public void produceItem(String itemName, String requiredMaterial) {
        if (materialAvailable(requiredMaterial)) { // Проверка наличия материала
            System.out.println("Producing " + itemName + " using " + requiredMaterial); // Вывод сообщения о производстве изделия
            producedItems.add(itemName); // Добавление изделия в список произведенных
        } else {
            System.out.println("Cannot produce " + itemName + ". Insufficient " + requiredMaterial); // Сообщение о недостатке материала
        }
    }

    private boolean materialAvailable(String material) {
        return true; // Простая заглушка, всегда возвращает истину
    }

    public void optimizeSchedule() {
        System.out.println("Optimizing production schedule"); // Вывод сообщения об оптимизации расписания
        Collections.sort(producedItems); // Сортировка списка произведенных изделий
        System.out.println("Production schedule optimized. Current production order: " + producedItems); // Вывод оптимизированного расписания
    }

    public void analyzeData() {
        System.out.println("Analyzing production data:"); // Вывод сообщения об анализе данных
        for (String item : producedItems) {
            System.out.println("- " + item); // Вывод каждого произведенного изделия
        }
    }

    public void reportProductionIssue(String issue) {
        productionIssues.add(issue); // Добавление проблемы в список
        System.out.println("Reported production issue: " + issue); // Сообщение о зарегистрированной проблеме
    }

    public void resolveProductionIssue(String issue) {
        productionIssues.remove(issue); // Удаление проблемы из списка
        System.out.println("Resolved production issue: " + issue); // Сообщение о решенной проблеме
    }

    public void viewProductionIssues() {
        System.out.println("Production issues:"); // Вывод заголовка списка проблем
        for (String issue : productionIssues) {
            System.out.println("- " + issue); // Вывод каждой проблемы
        }
    }
}
