package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Разрешаем запросы с любого origin
public class GetData {

    @PostMapping("api/send")
    public String sendData(@RequestBody String data) {
        try (FileWriter writer = new FileWriter("data.txt", true)) { // true = append mode
            writer.write(LocalDateTime.now() + ": " + data + "\n");
            return "Данные успешно добавлены в файл";
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при сохранении данных";
        }
    }

    @GetMapping("api/get")
    public String getData(){
        try {
            Path path = Paths.get("data.txt");

            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении файла: ";
        }
    }
}