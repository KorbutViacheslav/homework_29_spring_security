# homework_29_spring_security

1. Реализовать класс Product. Данный класс будет хранить значения: id, name, cost
2. Заказы будут храниться в специализированном классе-репозиторие ProductRepository.
   2.1 Реализовать метод получения по id
   2.2 Реализовать метод получения все
   2.3 Реализовать метод добавлени
   2.4 Реализовать метод удаления
3. Реализовать класс User. Данный класс будет хранить значения: id, name, password, role
4. Реализовать класс SecurityConfiguration.
   4.1 Данный класс должен запрещать получать доступ к приложению для неавторизованных пользователей
   4.2 Данный класс должен открыть возможность аутентификации при помощи Basic Authentication. Входящие данные
   сравниваются с данными в БД
   4.3 Операции добавления, удаления заказа должны быть доступны только для пользователя с ролью Admin
5. Сконфигурировать Spring-приложение через application.yml
   6.1 Приложение должно быть доступно по URL: http://localhost:8080
   6.2 Настроить подключение в БД
   6.3 Настроить логирование на уровне INFO для пакетов приложения и для пакета org.springframework.web
   Процесс логирования включает вывод в консоль и запись в файл
7. Реализовать контроллер Ping для проверки того, что приложение работает. Данный контроллер имеет лишь один метод и
   возвращает сообщение “ОК”.
   7.1 Контроллер доступен по URL: http://localhost:8080/ping
   7.2 Данный контроллер доступен всем пользователям
8. Реализовать контроллер для взаимодействия с ресурсом Product.
   8.1 Контроллер доступен по URL: http://localhost:8080/products
   8.2 Получение конкретного продукта
   8.3 Получение всех продуктов
   8.4 Удаление продукта
   8.5 Добавление продукта
   ВАЖНО: ProductRepository возвращает данные из БД, для этого необходимо создать БД и соответствующие таблицы