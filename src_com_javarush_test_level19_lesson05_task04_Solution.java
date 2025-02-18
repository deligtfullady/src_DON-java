package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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
            str = str.replaceAll("[.]", "!");
            fout.write(str);
            fout.newLine();
        }

        fin.close();
        fout.close();


    }
}
