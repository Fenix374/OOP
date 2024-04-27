package org.example; // Объявление пакета, где расположен класс

import java.util.Scanner; // Импорт класса Scanner для считывания ввода пользователя

public class Main { // Объявление главного класса программы
    public static void main(String[] args) { // Главный метод программы
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для считывания данных с консоли
        Inventory inventory = new Inventory(); // Создание объекта инвентаря
        ProductionLine productionLine = new ProductionLine(); // Создание объекта производственной линии
        MaintenanceTeam maintenanceTeam = new MaintenanceTeam(); // Создание объекта команды обслуживания

        Factory factory = new Factory(inventory, productionLine, maintenanceTeam); // Создание объекта фабрики, объединяющего инвентарь, производственную линию и команду обслуживания

        boolean exit = false; // Переменная для контроля выхода из цикла
        while (!exit) { // Начало цикла, выполняющегося до тех пор, пока пользователь не выберет выход
            System.out.println("\nSelect an action:"); // Вывод сообщения с запросом выбора действия
            System.out.println("1. Produce item"); // Пункт меню для производства товара
            System.out.println("2. Ship item"); // Пункт меню для отгрузки товара
            System.out.println("3. Optimize production schedule"); // Пункт меню для оптимизации производственного расписания
            System.out.println("4. Track inventory"); // Пункт меню для отслеживания инвентаря
            System.out.println("5. Analyze production data"); // Пункт меню для анализа данных производства
            System.out.println("6. Add maintenance task"); // Пункт меню для добавления задачи по техническому обслуживанию
            System.out.println("7. Notify maintenance team"); // Пункт меню для уведомления команды технического обслуживания
            System.out.println("8. Report production issue"); // Пункт меню для сообщения о проблеме на производстве
            System.out.println("9. View production issues"); // Пункт меню для просмотра проблем производства
            System.out.println("10. Escalate issue"); // Пункт меню для эскалации проблемы
            System.out.println("11. View escalated issues"); // Пункт меню для просмотра эскалированных проблем
            System.out.println("12. Exit"); // Пункт меню для выхода из программы

            try {
                int choice = Integer.parseInt(scanner.nextLine()); // Считывание выбора пользователя и преобразование в число

                switch (choice) { // Оператор выбора, обрабатывающий введённый выбор
                    case 1:
                        factory.produceItem(scanner); // Вызов метода производства товара
                        break;
                    case 2:
                        System.out.print("Enter the item name to ship: "); // Запрос имени товара для отгрузки
                        String itemToShip = scanner.nextLine(); // Считывание имени товара
                        System.out.print("Enter the destination: "); // Запрос пункта назначения для отгрузки
                        String destination = scanner.nextLine(); // Считывание пункта назначения
                        factory.shipItem(itemToShip, destination); // Вызов метода для отгрузки товара
                        break;
                    case 3:
                        factory.optimizeProductionSchedule(); // Вызов метода для оптимизации расписания производства
                        break;
                    case 4:
                        factory.trackInventory(scanner); // Вызов метода для отслеживания инвентаря
                        break;
                    case 5:
                        factory.analyzeProductionData(); // Вызов метода для анализа данных производства
                        break;
                    case 6:
                        System.out.print("Enter the maintenance task: "); // Запрос описания задачи по техническому обслуживанию
                        String maintenanceTask = scanner.nextLine(); // Считывание описания задачи
                        maintenanceTeam.addMaintenanceTask(maintenanceTask); // Добавление задачи в список команды обслуживания
                        break;
                    case 7:
                        maintenanceTeam.notifyTeam(); // Уведомление команды обслуживания
                        break;
                    case 8:
                        System.out.print("Enter the production issue: "); // Запрос описания проблемы производства
                        String productionIssue = scanner.nextLine(); // Считывание описания проблемы
                        productionLine.reportProductionIssue(productionIssue); // Сообщение о проблеме в производственную линию
                        break;
                    case 9:
                        factory.viewProductionIssues(); // Вызов метода для просмотра проблем производства
                        break;
                    case 10:
                        System.out.print("Enter the issue to escalate: "); // Запрос на эскалацию конкретной проблемы
                        String issueToEscalate = scanner.nextLine(); // Считывание проблемы для эскалации
                        maintenanceTeam.escalateIssue(issueToEscalate); // Эскалация проблемы
                        break;
                    case 11:
                        maintenanceTeam.viewEscalatedIssues(); // Вызов метода для просмотра эскалированных проблем
                        break;
                    case 12:
                        exit = true; // Установка флага выхода из цикла
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again."); // Сообщение о неверном выборе
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number."); // Обработка исключения, если ввод не является числом
            }
        }

        scanner.close(); // Закрытие сканера для освобождения ресурсов
    }
}
