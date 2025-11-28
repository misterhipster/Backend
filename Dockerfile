# Используем официальный образ OpenJDK
FROM eclipse-temurin:17-jdk-jammy

# Создаем директорию приложения
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/*.jar app.jar

# Копируем файл data.txt в контейнер
COPY data.txt data.txt

# Открываем порт 8080
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]