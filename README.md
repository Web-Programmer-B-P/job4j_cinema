# Сервис бронирования/покупки билетов
***
* Главная страница кинотеатра

![screenshot of sample](https://booking-cinema-ticket.herokuapp.com/image/main_page.png)
---
 
* Модальное окно ввода данных для бронирония/покупки

![screenshot of sample](https://booking-cinema-ticket.herokuapp.com/image/modal.png)
---
### Особенности работы сервиса

1. Главная страница сервиса по умолчанию обновляет данные каждые 1.5 минуты.
1. Сброс всех купленных мест происходит каждые 2 часа.

---
### Технологии которые использовались в разработке сервиса

* Сторона бэкенд: java 12, servlet 4.0.1.
* Сторона фронтенд: jquery + bootstrap3 + css 
* База данных: postgres 9.6, дамп для разворота находится в директории src/main/resources/hall_dump.sql
* Apache Tomcat 9.0.30
* Логирование log4j 2.12.1
* Сервес залит на тестовую площадку Heroku, посмотреть сервис в работе можно перейдя по 
[этой ссылке](https://booking-cinema-ticket.herokuapp.com/hall)  


 