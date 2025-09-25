package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

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
}