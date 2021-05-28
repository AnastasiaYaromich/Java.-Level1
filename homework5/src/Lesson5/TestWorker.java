package Lesson5;

public class TestWorker {
    public static void main(String[] args) {

        // Task 4. Создать массив из 5 сотрудников.
        Worker[] workers = new Worker[5];

        workers[0] = new Worker("Яромич Анастасия Викторовна",
                "Инженер по радиационной защите", "Anastasia281295@gmail.com",
                "375256822285", 45000, 25);
        workers[1] = new Worker("Яромич Евгений Вячеславович",
                "Ведущий инженер управления реактором", "Jane19937788@gmail.com",
                "375293469059", 70000, 28);
        workers[2] = new Worker("Бородын Елена Петровна", "Учитель иностранных языков",
                "HelenBorodyn@gmail.com", "375299062389", 28000, 49);

        workers[3] = new Worker("Лузин Михаил Юрьевич", "Начальник цеха АЭС",
                "LuzinMY@mail.ru", "375297896236", 110000, 56);

        workers[4] = new Worker("Свидерский Валерий Валентинович", "Судмедэксперт",
                "SviderskiyVV@gmail.com", "375445694752",78000, 37);

        // Выведем информация о всех 5 сотрудниках на консоль.
        for (int i = 0; i < workers.length; i++) {
            workers[i].InfoWorker();
        }
        System.out.println();

        // Task 5. С помощью цикла вывести информацию .
        // только о сотрудниках старше 40 лет.
        System.out.println("Информация о сотрудниках старше 40 лет:");
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getAge() > 40)
                workers[i].InfoWorker();

            }
        }

        }


