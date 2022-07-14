# myProject
# Авиакасса (Максим Язвинский)
# Поиск доступных рейсов 
# Фильтры по:
# •	Авиакомпаниям
# •	Пересадкам
# •	длительности
# Просмотр информации о рейсе
# Логин и регистрация пользователей
# Восстановление пароля
# Бронирование и отмена билетов
# Просмотр доступных мест на рейсе
# Кабинет пользователя
# •	Просмотр данных о пользователе
# •	Редактирование
# •	Список пассажиров для подстановки
# Админка
# •	Блокировка и разблокировка пользователей
# •	Добавление рейсов
# •	Добавление авиакомпаний


# Общие требования:
# •	Юнит тесты для всех сущностей сервисов.
# •	Тесты DAO для всех НЕ CRUD запросов в базу, через базу в памяти.
# •	Интеграционные тесты для всех методов контроллеров только для RestController(1 хэппи пасс). Крады тестить не нужно.
# •	Интеграционные тесты для каждого бизнес требования в задании. Крад контроллеры тестить не нужно
# •	Валидация входных данных.
# •	Изолированные транзакции.
# •	К приложению в репозитории, должна быть создана Postman коллекция для всех доступных контроллеров.
# •	Обработка ошибок, в виде специальной сущности с полями:
# о Код ошибки(статус ответа протоколом HttpStatusCode)
# о Тип исключения
# о Разъяснения для пользователя/клиента
# •	Сервисы и модели данных должны предусматривать высокую гибкость, для будущих изменений. OOP SOLID and etc
# Выполнение вышеперечисленных требований на “удовлетворительно" и за установленный срок, претендует на оценку в 7 баллов.
# Дополнительно (10 max). (Эти баллы прибавляются только если за основной блок было получено 7 баллов)
# •	1 Развертывание вашего приложение должно происходить в Docker. Независимо от типа ОС целевой машины.
# •	1 балл. Подключение Swagger к вашему приложению с последующей демонстрацией. Только для приложения с RestController
# •	1 балл. Создание SPA приложения, которое будет использоваться для просмотра существующих таблиц. (Без SpringBoot, на базе Tomcat контейнера.)
# •	1 балл. Подключение GitHub CI, на своем репозитории, с шагами:
# о Сборка
# о Тестирование(юниты и интеграционные)
# о Проверка качества кода (SolarLint и подобные)
# о Форматирование кода (форматтер от Google)

# Обратите внимание:
# Все задания будут проходить защиту, в время которой вы будет демонстрировать работу вашего приложение на другой машине, отвечать на
# вопросы по проектированию и реализации. А также по теории используемых фреймворков, библиотек и т.д.
