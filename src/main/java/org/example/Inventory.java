package org.example; // Определение пакета, к которому принадлежит класс
import java.util.ArrayList; // Импорт класса ArrayList для работы с динамическими массивами
import java.util.List; // Импорт интерфейса List для работы со списками
import java.util.Scanner; // Импорт класса Scanner для ввода данных с консоли

public class Inventory {
    private List<String> items; // Приватный список для хранения названий предметов на складе

    public Inventory() {
        items = new ArrayList<>(); // Инициализация списка предметов
    }

    // Геттер для списка items
    public List<String> getItems() {
        return new ArrayList<>(items); // Возвращаем копию списка для защиты данных
    }

    // Сеттер для списка items
    public void setItems(List<String> items) {
        this.items = new ArrayList<>(items); // Создаем новый список на основе предоставленного
    }

    public void addItem(String item) {
        items.add(item); // Добавление нового предмета в список
        System.out.println("Added " + item + " to inventory"); // Вывод сообщения об добавлении предмета
    }

    public void removeItem(String item) {
        if (items.contains(item)) { // Проверка наличия предмета в списке
            items.remove(item); // Удаление предмета из списка
            System.out.println("Removed " + item + " from inventory"); // Вывод сообщения об удалении предмета
        } else {
            System.out.println("Item not found in inventory: " + item); // Вывод сообщения, если предмет не найден
        }
    }

    public void trackItems(Scanner scanner) {
        boolean exit = false; // Переменная для контроля выхода из цикла
        while (!exit) {
            System.out.println("\nTracking inventory:"); // Вывод заголовка для отслеживания инвентаря
            for (String item : items) {
                System.out.println("- " + item); // Вывод всех предметов в инвентаре
            }
            System.out.println("\nChoose an action:"); // Предложение выбрать действие
            System.out.println("1. Add item"); // Опция добавления предмета
            System.out.println("2. Remove item"); // Опция удаления предмета
            System.out.println("3. Back to main menu"); // Опция возврата в главное меню

            int choice = scanner.nextInt(); // Считывание выбора пользователя
            scanner.nextLine(); // Очистка буфера после ввода числа

            switch (choice) { // Обработка выбора пользователя
                case 1:
                    System.out.print("Enter the item name to add: "); // Запрос названия предмета для добавления
                    String itemToAdd = scanner.nextLine(); // Считывание названия предмета
                    addItem(itemToAdd); // Вызов метода добавления предмета
                    break;
                case 2:
                    System.out.print("Enter the item name to remove: "); // Запрос названия предмета для удаления
                    String itemToRemove = scanner.nextLine(); // Считывание названия предмета
                    removeItem(itemToRemove); // Вызов метода удаления предмета
                    break;
                case 3:
                    exit = true; // Выход из цикла
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Вывод сообщения о неверном выборе
            }
        }
    }
}
