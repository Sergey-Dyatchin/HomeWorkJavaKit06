package org.example;

import java.util.HashMap;


/**
 * Решение для подсчета побед при смене выбора можно было сделать значительно проще
 * Не рассчитывая открытую дверь и смену выбора
 * Достаточно было инвертировать результат первого выбора игрока.
 * Так как если изначальна была выбрана пустая дверь, а вторая пустая открыта то смена выбора всегда победа.
 * А смена выбора при изначально правильном выборе всегда поражение.
 * В этом случае реализация была бы более простой в коде,
 * но не отражала бы полный алгоритм для демонстрации парадокса.
 */
public class Main {
    public static void main(String[] args) {

        MontyHall montyHall = new MontyHall();
        HashMap<Integer, Integer> statisticsNoChangeDoor = new HashMap<>(); // для статистики без изменения выбора
        HashMap<Integer, Integer> statisticsUseChangeDoor = new HashMap<>(); // для статистики с изменением выбором

        for (int i = 0; i < 1000; i++) {
            statisticsNoChangeDoor.put(i, montyHall.play(false));
            statisticsUseChangeDoor.put(i, montyHall.play(true));
        }

        int sumNoChangeDoor = statisticsNoChangeDoor.values().stream().mapToInt(Integer::intValue).sum();
        int sumUseChangeDoor = statisticsUseChangeDoor.values().stream().mapToInt(Integer::intValue).sum();

        System.out.println("Побед из 1000 без смены выбора: " + sumNoChangeDoor);
        System.out.println("Побед из 1000 со сменой выбора: " + sumUseChangeDoor);

    }
}