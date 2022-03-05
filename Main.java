package ru.netology.lesson1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    // Создали лог для записи об успешноном или неуспешном создании файлов и директорий.
    public static String log = "";

    public static void main(String[] args) {

        /**
         * 1. В папке Games создаём несколько директорий: src, res, savegames, temp.
         */
        // Указываем путь, где находится папка
        String parentFolderOne = "D://Games";
        // Создаем список, указывая какие директории должны быть созданы
        List<String> directoriesOne = Arrays.asList("src", "res", "savegames", "temp");
        // Создаем дирректории согласно списка
        for (String dir : directoriesOne) {
            createDir(parentFolderOne, dir);
        }

        /**
         * 2. В каталоге src создаём две директории: main, test.
         */
        // Указываем путь, где находится каталог
        String parentFolderTwo = "D://Games//src";
        // Создаем список, указывая какие директории должны быть созданы
        List<String> directoriesTwo = Arrays.asList("main", "test");
        // Создаем дирректории согласно списка
        for (String dir : directoriesTwo) {
            createDir(parentFolderTwo, dir);
        }

        /**
         * 3. В подкаталоге main создаём два файла: Main.java, Utils.java.
         */
        // Указываем путь, где находится каталог
        String parentFolderThree = "D://Games//src//main";
        // Создаем список, указывая какие файлы должны быть созданы
        List<String> filesOne = Arrays.asList("Main.java", "Utils.java");
        // Создаем файлы согласно списка
        for (String file : filesOne) {
            createFile(parentFolderThree, file);
        }

        /**
         * 4. В каталоге res создаём три директории: drawables, vectors, icons.
         */
        // Указываем путь, где находится каталог
        String parentFolderFour = "D://Games//res";
        // Создаем список, указывая какие директории должны быть созданы
        List<String> directoriesThree = Arrays.asList("drawables", "vectors", "icons");
        // Создаем дирректории согласно списка
        for (String dir : directoriesThree) {
            createDir(parentFolderFour, dir);
        }

        /**
         * 5. В директории temp создаём файл temp.txt.
         */
        // Указываем путь, где находится каталог
        String parentFolderFive = "D://Games//temp";
        // Создаем список, указывая какие файлы должны быть созданы
        List<String> filesTwo = Arrays.asList("temp.txt");
        // Создаем файлы согласно списка
        for (String file : filesTwo) {
            createFile(parentFolderFive, file);
        }

        /**
         * В файл temp.txt записываем информацию из лога об успешноном или неуспешном создании файлов и директорий.
         */
        recorderLog("D://Games//temp//temp.txt");

    }

    // Метод для создания директорий
    public static void createDir(String parentFolder, String dir) {
        String newLog = null;
        StringBuilder value = new StringBuilder();
        value.append(parentFolder);
        value.append("//");
        value.append(dir);
        String preNewDir = value.toString();
        File newDir = new File(preNewDir);
        if (newDir.mkdir()) {
            newLog = "Создана директория: '" + preNewDir + "'";
        } else {
            newLog = "Ошибка создания директории: '" + preNewDir + "'";
        }
        System.out.println(newLog);
        addLog(newLog);
    }

    // Метод для создания файлов
    public static void createFile(String dir, String file){
        String newLog = null;
        StringBuilder value = new StringBuilder();
        value.append(dir);
        value.append("//");
        value.append(file);
        String preNewFile = value.toString();
        File newFile = new File(preNewFile);
        try {
            if (newFile.createNewFile())
                newLog = "Создан файл: '" + preNewFile + "'";
        } catch (IOException ex){
            newLog = ex.getMessage();
        }
        System.out.println(newLog);
        addLog(newLog);
    }

    // Метод для добавления записей в лог
    public static void addLog(String newLog) {
        StringBuilder value = new StringBuilder();
        value.append(log);
        value.append(newLog);
        value.append("\n");
        log = value.toString();
    }

    // Метод для записи лога в файл temp.txt
    public static void recorderLog(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(log);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
