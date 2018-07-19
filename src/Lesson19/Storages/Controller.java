package Lesson19.Storages;

//      Написать часть условной системы для отправки файлов из одного хранилища в другое

//Файл описывается классом File
//Хранилище описывается классом Storage
//Должен быть создан класс контроллер Controller с методами:
//  put (Storage storage File file) добавляет файл в хранилище, гарантируется
//      что файл уже есть в условной БД
//  delete(Storage storage File file) удаляем конкретный файл из определенного хранилища
//  transferAll(Storage storageFrom, Storage storageTo) трансфер всех файлов
//  transferFile(Storage storageFrom, Storage storageTo, long id) трансфер файла с хранилища storageFrom
//      по его айди

//Если операцию выполнить невозможно пишите ошибку в консоль и выбрасывайте нужное исключение
//В тексте пишем причину ошибки, айди файла который не удалось доставить и ай ди хранилища
//куда не удалось доставить
//Файлы считаем одинаковыми если у них равные айди и имя.

//                      Ограничения
//Storage может хранить файлы только поддерживаемого формата.
//Нужно учитывать максимальный размер файла
//В одном хранилище не могут храниться файлы с одинаковыми айди но могут с одинаковыми именами
//Имя файла не может быть больше 10 символов, файл с таким именем не может быть создан

//В демоклассе протестировать код на как минимум 3 тестовых данных

//ПЛАН РЕШЕНИЯ
//1.Создадим класс File с нужными полями

//2.Создадим класс Storage с нужными полями это клас по которому мы будем создавать Хранилища
//Хранилищ может быть много, т.е. больще двух
//Каждая пара хранилищ должна поддерживать одинаковые форматы файлов
//Изначально в хранилища файлы добавляются из условной БД

//У хранилищ есть ограничения по добавлению файлов:
//Файлы добавляемые в хранилища проверяются по формату, по длине имени ,  айди
//Так же файлы могут удалятся

//3.Создадим класс Controller который производит операции с самими файлами и изменяет Хранилища
//4.Создадим тестовый класс Demo для проверки роботоспособности нашей программы


public class Controller {
    //int n = storages.length;
    private File[] files = new File[10];

    private Storage[] storages;

    //Нужно загрузить конкретный файл в конкретное хранилище
    public Storage put(Storage storage, File file) throws Exception {
        Validate test = new Validate();
        //Проверка наличия  значений  в  storage и file
        if (!test.checkInputValue(storage, file)) {
            throw new Exception("storage is null or file in DB is null!");
        }
        //Проверка отсутствия загружаемого файла в хранилище
        if (test.findById(storage, file.getId())) {
            throw new Exception("File " + file.getId() + " already exist in storage " + storage.getId());
        }
        //Валидация формата файла и хранилища
        if (!test.checkFormat(storage, file)) {
            throw new Exception(file.getFormat() + " isn't supported in storage " + storage.getId());
        }
        //checkForFreePlace(storage)  проверка свободных ячеек в хранилище
        if (!test.checkForFreePlace(storage, storage.getFiles().length)) {
            throw new Exception("No free space in storage " + storage.getId());
        }
        //Проверка свободного места в хранилище
        if (!test.checkForSize(storage, file.getSize())) {
            throw new Exception("No free space in storage " + storage.getId());
        }
        //Проверка длины имени файла
        if (!test.checkForLengthName(storage, file.getName())) {
            throw new Exception("Name of file " + file.getName() + " can not be more than 10 simvols");
        }
        //запись файла в хранилище
        setFile(storage, file);
        return storage;
    }

    //Метод удаления нужного файла из заданого хранилища
    public void delete(Storage storage, File file) throws Exception {
        Validate test = new Validate();
        //checkInputValue(storage, file);
        int index = 0;
        if (storage == null)
            throw new Exception("storage is null");
        if (file == null)
            throw new Exception("file in DB is null");

        if (!test.findById(storage, file.getId())) {
            throw new Exception(storage.getId() + " is not found");
        }
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == file.getId()) {//если файл с таким ай ди мы нашли

                storage.getFiles()[index] = null;
            }
            index++;
        }
    }

    //Найти файл по ай ди  в хранилище storageFrom  и загрузить его в хранилище storageTo
    public Storage transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        Validate test = new Validate();
        //ищем файл по айди в хранилище storageFrom
        for (File fileFrom : storageFrom.getFiles()) {
            if (!test.findById(storageFrom, fileFrom.getId())) {
                throw new Exception("There exist file " + id + "in " + storageFrom.getId());
            }

            //проверяем нету ли уже такого файла в хранилище  storageTo
            for (File fileTo : storageTo.getFiles()) {
                if (test.findById(storageTo, fileFrom.getId())) {
                    throw new Exception("file exist" + id + "in " + storageTo.getId());
                }

                //проверка совместимости форматов файла и хранилища  storageTo
                if (!test.checkFormat(storageTo, fileFrom)) {
                    throw new Exception(fileFrom + " isn't supported in storage " + storageTo.getId());
                }

                //Проверка свободного места в хранилище storageTo
                if (!test.checkForFreePlace(storageTo, storageTo.getFiles().length)) {
                    throw new Exception("No free space in storage " + storageTo.getId());
                }

                //Запись файла из fileFrom в пустое место в хранилище storageTo
                setFile(storageTo, fileFrom);
                return storageTo;
            }
        }
        return storageTo;
    }

    //Загружаем наш файл в перую свободную ячейку
    private static Storage setFile(Storage storage, File file) throws Exception {

        int countPlaced = 0;
        for (File f : storage.getFiles()) {
            if (f != null)//если ячейка не пустая
                countPlaced++;//считаем сколько занятых ячеек
        }
        if (countPlaced > storage.getFiles().length)//если количество занятых ячеек больше длины
            // стораджа то ретёрн налл
            throw new Exception("there is no empty place in storage " + storage.getId());

        int index = 0;
        for (File f : storage.getFiles()) {
            //если ячейка пустая то индекс файла в который мы будем  записывать файл  будет = 0
            if (f == null) {
                storage.getFiles()[index] = file;
                return storage;
            }
            index++;
        }
        return storage;
    }

    public Storage transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        Validate test = new Validate();

        if (test.validateParams(storageFrom, storageTo)) {
            int count = 0;
            for (File fileFrom : storageFrom.getFiles()) {
                if (fileFrom != null) {
                    for (File fileTo : storageTo.getFiles()) {
                        if (fileTo == null) {//Если мы нашли пустую ячейку
                            // Проверка свободного места в хранилище
                            storageTo.getFiles()[count] = fileFrom;//ТО загружаем в эту ячейку наш файл
                            break;
                        }
                        count++;
                    }
                }
                count = 0;
            }
        }
        return storageTo;
    }
}