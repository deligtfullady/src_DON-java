package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        ArrayList<String> fileList = new ArrayList<>();
        String input;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while ((input = reader.readLine()) != null)
        {
            fileList.add(input);
        }
        reader.close();

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        String[] strngArray;
        for (String fl : fileList) {
            strngArray = fl.split("");
            names.add(strngArray[0]);
            values.add(Double.parseDouble(strngArray[1]));
        }

        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i<names.size();i++) {
            map.put(names.get(i), values.get(i));
        }

        ArrayList<String> ignoredNames = new ArrayList<>();
        for (int i=0; i<names.size();i++)
        {
            for (int j=0; j< names.size(); j++)
            {
                if (names.get(i).equals(names.get(j)) && !ignoredNames.contains(names.get(i)))
                {
                    double temp = values.get(i) + values.get(j);
                    map.put(names.get(i), temp);
                }
            }
        }

        double max = map.get(names.get(0));
        for (Map.Entry<String, Double> entry :
                map.entrySet())
        {
            if (entry.getValue() > max)
            {
                max = entry.getValue();
            }
        }

        ArrayList<String> riche = new ArrayList<>();
        for (Map.Entry<String, Double> entry :
                map.entrySet())
        {
            if (entry.getValue() == max)
            {
                riche.add(entry.getKey());
            }
        }

        for (String str :
                riche)
        {
            System.out.println(str);
        }
    }
}
