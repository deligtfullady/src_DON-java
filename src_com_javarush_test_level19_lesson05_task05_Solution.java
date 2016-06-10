package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader fin = new BufferedReader(new FileReader(f1));
        BufferedWriter fout = new BufferedWriter(new FileWriter(f2));


        while(fin.ready())
        {
            String str = fin.readLine();
            str = str.replaceAll("[^a-zA-Z]", "");
            fout.write(str);
            fout.newLine();
        }

        fin.close();
        fout.close();


    }
}

