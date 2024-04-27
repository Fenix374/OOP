package org.example; // Объявление пакета, к которому принадлежит класс
import java.util.ArrayList; // Импорт класса ArrayList для использования списков
import java.util.List; // Импорт интерфейса List для работы со списками
import java.util.logging.Logger; // Импорт класса Logger для логирования

public class MaintenanceTeam {
    private List<String> maintenanceTasks; // Список задач по техническому обслуживанию
    private List<String> escalatedIssues; // Список эскалированных проблем

    public MaintenanceTeam() {
        maintenanceTasks = new ArrayList<>(); // Инициализация списка задач
        escalatedIssues = new ArrayList<>(); // Инициализация списка проблем
    }

    public void notifyTeam() {
        System.out.println("Notifying maintenance team"); // Вывод сообщения о уведомлении команды
        for (String task : maintenanceTasks) {
            System.out.println("- " + task); // Вывод списка задач
        }
    }

    public void escalateIssue(String issue) {
        System.out.println("Escalating production issue: " + issue); // Вывод сообщения об эскалации проблемы
        escalatedIssues.add(issue); // Добавление проблемы в список эскалированных
    }

    public void addMaintenanceTask(String task) {
        maintenanceTasks.add(task); // Добавление новой задачи в список задач
    }

    public void completeMaintenanceTask(String task) {
        maintenanceTasks.remove(task); // Удаление задачи из списка
    }

    public void viewEscalatedIssues() {
        Logger logger = Logger.getLogger(this.getClass().getName()); // Получение логгера для текущего класса
        if (escalatedIssues.isEmpty()) {
            System.out.println("No escalated issues at the moment."); // Вывод сообщения, если нет эскалированных проблем
            logger.info("Checked escalated issues: none found."); // Запись в лог
        } else {
            System.out.println("Escalated issues:"); // Вывод заголовка списка проблем
            logger.info("Viewing escalated issues."); // Запись в лог о просмотре проблем
            for (String issue : escalatedIssues) {
                System.out.println("- " + issue); // Вывод каждой проблемы в списке
            }
        }
    }

    public List<String> getMaintenanceTasks() {
        return new ArrayList<>(maintenanceTasks); // Возврат копии списка задач
    }

    public List<String> getEscalatedIssues() {
        return new ArrayList<>(escalatedIssues); // Возврат копии списка эскалированных проблем
    }

    // Сеттеры
    public void setMaintenanceTasks(List<String> maintenanceTasks) {
        this.maintenanceTasks = new ArrayList<>(maintenanceTasks); // Установка нового списка задач
    }

    public void setEscalatedIssues(List<String> escalatedIssues) {
        this.escalatedIssues = new ArrayList<>(escalatedIssues); // Установка нового списка эскалированных проблем
    }
}
