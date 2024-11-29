package org.example;

import java.util.Random;

/**
 * Описывает игру парадокс Монти Холла.
 */
public class MontyHall {
    int[] listDoor;  //массив из 3 дверей, где 0 ничего, а 1 приз
    private int selectDoor;   // номер двери в масcиве, которую выбрал игрок
    private int openDoor;   // номер пустой двери которую открыл ведущий.
    private Random random;

    public MontyHall() {
        random = new Random();
        listDoor = new int[3];
    }

    /**
     * Принимает boolean true если менять выбор двери, false если не менять
     * возвращает int 1 в случаее победы или 0 в случае проигрыша
     *
     * @param changeDoor
     * @return
     */
    public int play(boolean changeDoor) {
        initDoor();
        selectingDoor();
        if (!changeDoor) {
            return listDoor[selectDoor];
        }
        openEmptyDoor();
        changeSelectDoor();
        return listDoor[selectDoor];
    }

    /**
     * Помещает в массив listDoor из трех элементов два 0 и одну 1 в случайное поле
     * для новой игры
     */
    private void initDoor() {
        int numberPrize = random.nextInt(3);
        for (int i = 0; i < listDoor.length; i++) {
            if (i == numberPrize) {
                listDoor[i] = 1;
            } else {
                listDoor[i] = 0;
            }
        }
    }

    /**
     * Помещает в поле selectDoor случайное номер двери от 0 до 2
     */
    private void selectingDoor() {
        selectDoor = random.nextInt(3);
    }

    /**
     * итерирует listDoor, проверяет все двери по очереди
     * помещает в поле openDoor номер двери не выбранный игроком и со значением 0 (без приза)
     */
    private void openEmptyDoor() {
        for (int i = 0; i < listDoor.length; i++) {
            if (i != selectDoor && listDoor[i] == 0) {
                openDoor = i;
                return;
            }
        }
    }

    /**
     * итерирует listDoor, проверяет все двери по очереди
     * помещает в поле selectDoor номер двери оставшеся закрытой (не выбранной ранее и не открытой)
     */
    private void changeSelectDoor() {
        for (int i = 0; i < listDoor.length; i++) {
            if (i != selectDoor && i != openDoor) {
                selectDoor = i;
                return;
            }
        }
    }
}