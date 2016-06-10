package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        FileReader in = new FileReader(f1);
        FileWriter out = new FileWriter(f2);

        int i =1;
        while (in.ready())
        {
            int data = in.read();
            if (i % 2 == 0)
            {
                out.write(data);
            }
            i++;
        }
        in.close();
        out.close();
    }

}
