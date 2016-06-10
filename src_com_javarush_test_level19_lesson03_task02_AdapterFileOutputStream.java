package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать
FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream a;

    public AdapterFileOutputStream(FileOutputStream a)
    {
        this.a = a;
    }

    @Override
    public void flush() throws IOException
    {
this.a.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
this.a.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
this.a.close();
    }
}

