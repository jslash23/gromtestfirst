package Lesson15.Rooms;

public class Controller {

    Room[] rooms;
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public API[] getApis() {
        return apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        // Вычисляем длину будущего массива
        int count = 0;
        for (API apiks : apis) {//Пробегаемся по всем апи
            for (Room roomApi : rooms)//Пробегаемся по всем румз
                if (apiks.equals(roomApi))
                    count++;
        }
        Room[] requestRooms = new Room[count];//Создали новый объект Room со ссылкой requestRooms

        //Записываем в наш массив комнаты с заданными параметрами
        int index = 0;


        for (API apiks : apis) {
            for (Room roomApi : rooms)
                if (apiks.equals(roomApi)) {
                    requestRooms[index] = roomApi;

                    index++;
                }
        }
        return requestRooms;
    }

    //Найти общие комнаты у двух АПИ,(в результирующий массив добавляем комнаты с api1).
    //Комнаты считаем равными если у них одинаковые все поля

    public Room[] check(API api1, API api2) {
        int count = 0;
        for (Room apik1 : api1.getAll()) {
            for (Room apik2 : api2.getAll()) {
                if (apik1.equals(apik2)) {
                    count++;
                }
            }
        }

        int index = 0;// создаем индекс
        Room[] apiRooms = new Room[count];

        for (Room apik1 : api1.getAll()) {
            for (Room apik2 : api2.getAll()) {
                if (apik1.equals(apik2)) {
                    apiRooms[index] = apik1;//
                    index++;
                }
            }
        }
        return apiRooms;
    }
}





