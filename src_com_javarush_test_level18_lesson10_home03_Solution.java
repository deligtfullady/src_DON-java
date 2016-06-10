package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream out = new FileOutputStream(new File(reader.readLine()), true);
        FileInputStream in1 = new FileInputStream(new File(reader.readLine()));
        FileInputStream in2 = new FileInputStream(new File(reader.readLine()));

        while (in1.available() > 0)
        {
            byte[] result = new byte[in1.available()];
            int count = in1.read(result);

            out.write(result, 0, count);
        }
        while (in2.available() > 0)
        {
            byte[] result = new byte[in2.available()];
            int count = in2.read(result);

            out.write(result, 0, count);
        }

        reader.close();
        out.close();
        in1.close();
        in2.close();

    }
}
