package org.example; // Объявление пакета, к которому принадлежит класс

import java.util.Scanner; // Импорт класса Scanner для ввода данных с консоли

public class Factory {
    private Inventory inventory; // Ссылка на объект инвентаря
    private ProductionLine productionLine; // Ссылка на объект производственной линии
    private MaintenanceTeam maintenanceTeam; // Ссылка на объект команды обслуживания

    public Factory(Inventory inventory, ProductionLine productionLine, MaintenanceTeam maintenanceTeam) {
        this.inventory = inventory; // Инициализация инвентаря
        this.productionLine = productionLine; // Инициализация производственной линии
        this.maintenanceTeam = maintenanceTeam; // Инициализация команды обслуживания
    }

    public void produceItem(Scanner scanner) {
        System.out.print("Enter the item name to produce: "); // Запрос названия изделия для производства
        String itemToProduce = scanner.nextLine(); // Считывание названия изделия

        System.out.println("\nAvailable materials:"); // Вывод сообщения о доступных материалах
        inventory.trackItems(scanner); // Отслеживание и вывод доступных материалов

        System.out.print("Enter the required material: "); // Запрос на ввод необходимого материала
        String requiredMaterial = scanner.nextLine(); // Считывание введённого материала

        productionLine.produceItem(itemToProduce, requiredMaterial); // Производство изделия с указанным материалом
    }

    public void shipItem(String itemName, String destination) {
        inventory.removeItem(itemName); // Удаление изделия из инвентаря
        System.out.println("Shipping " + itemName + " to " + destination); // Вывод сообщения об отправке изделия
    }

    public void optimizeProductionSchedule() {
        productionLine.optimizeSchedule(); // Оптимизация расписания производственной линии
    }

    public void trackInventory(Scanner scanner) {
        inventory.trackItems(scanner); // Отслеживание и вывод списка материалов в инвентаре
    }

    public void analyzeProductionData() {
        productionLine.analyzeData(); // Анализ данных производства
    }

    public void notifyMaintenanceTeam() {
        maintenanceTeam.notifyTeam(); // Уведомление команды технического обслуживания
    }

    public void escalateProductionIssue(String issue) {
        maintenanceTeam.escalateIssue(issue); // Эскалация производственной проблемы
    }

    public void viewProductionIssues() {
        productionLine.viewProductionIssues(); // Просмотр текущих проблем на производственной линии
    }

    // Геттеры
    public Inventory getInventory() {
        return inventory; // Возвращает объект инвентаря
    }

    public ProductionLine getProductionLine() {
        return productionLine; // Возвращает объект производственной линии
    }

    public MaintenanceTeam getMaintenanceTeam() {
        return maintenanceTeam; // Возвращает объект команды технического обслуживания
    }

    // Сеттеры
    public void setInventory(Inventory inventory) {
        this.inventory = inventory; // Установка нового объекта инвентаря
    }

    public void setProductionLine(ProductionLine productionLine) {
        this.productionLine = productionLine; // Установка нового объекта производственной линии
    }

    public void setMaintenanceTeam(MaintenanceTeam maintenanceTeam) {
        this.maintenanceTeam = maintenanceTeam; // Установка нового объекта команды технического обслуживания
    }
}
