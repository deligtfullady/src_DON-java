package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        String str = " ";
        BufferedReader in = new BufferedReader(new FileReader(file));
        while (in.ready())
        {
            str += in.readLine() + " ";
        }
        in.close();

        str = str.toLowerCase().replaceAll("[^a-z]", " ");
        String word = "word";
        String[] words = str.split(" ");
        int count = 0;
        for (String tmp :
                words)
        {
            if (tmp.equals(word))
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
