package com.company.java_core.homework18.task1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1
        ArrayList<String> strings = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        arrayList = strings; // (1) Ok
        arrayList.add(1); // (2) unchecked call

        /*Java дозволяє виконати присвоєння в рядку (1).
        Це необхідно для забезпечення зворотної сумісності. Але якщо ми
        спробуємо виконати метод add у рядку (2), то отримаємо попередження
        Unchecked call — компілятор попереджає нас про можливу помилку.
        Насправді, ми намагаємося в список рядків добавити ціле число.
         */
    }

    // 2
    static List<String> t() {
        List l = new ArrayList<Number>();
        l.add(1);
        List<String> ls = l; // (1)
        ls.add("");
        return ls;
    }
    /*присвоєння посилань на Raw тип змінної параметризованого
    типу, призводить до попередження «Неперевірене призначення».
    Якщо ми його ігноруємо, то можлива ситуація під назвою
        "Забруднення купи" */


    // 3
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // (1)
        String s = stringLists[0].get(0); // (2)
    }
    /*потрібно навести і інший приклад «забруднення купи» — коли у нас
    використовуються параметризовані об’єкти. недопустимо використовувати
    параметризовані типи в якості аргументів методу з використанням Varargs.
    У цьому випадку параметр методу m – це List<String>…, тобто фактично,
    масив елементів типу List<String>. Учитывающее правило відображення типів
    при затиранні, тип stringLists перетворюється в масив необроблених списків
            (List[]), т.е. можна виконати присваивание Object[] array = stringLists;
            і після запису в масив об’єкта, відмінного від списку рядків (1),
            викликає ClassCastException у рядку (2).
     */
}
