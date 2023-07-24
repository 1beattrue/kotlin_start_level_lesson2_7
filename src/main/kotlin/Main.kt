import kotlin.collections.ArrayList

fun main() {
    // коллекции

    // массив - неизменяемый тип данных, коллекция фиксированной длины
    val array: Array<Int> = arrayOf(1, 2, 3)
    println(array[2])
    array[2] = 10
    println(array[2])

    // создание массива, заполненного нулями
    val array2: Array<Int?> = arrayOfNulls(10)
    val array3 = arrayOfNulls<Int?>(10) // альтернативный способ создания массива

    // ArrayList
    val listOfNumbers = ArrayList<Int>()
    listOfNumbers.add(5) // добавление элемента в конец списка
    println(listOfNumbers[0])

    /* небольшое, но важное отвлечение: если мы используем принцип программирования clean architecture,
    нам необходимо приводить все типы данных к родительским
    так, например, ArrayList стоило бы привести к его родителю List, чтобы, например, в методе, в который мы
    планируем передавать массив мы могли в качестве аргумента указать переменную типа List и передавать туда
    ArrayList, LinkedList и т д
    но родительские классы коллекций являются неизменяемыми, поэтому вместо класса List мы используем
    MutableList - изменяемый List */
    val listOfNums: MutableList<Int> = ArrayList<Int>()
    // таким образом мы все еще можем добавлять в него элементы
    listOfNums.add(3)
    method(listOfNums) // но также мы можем передать его в качестве аргумента с типом List

    // но можно создавать и простые изменяемые коллекции
    val set = mutableSetOf<Int>(1, 2, 3)
    val list = mutableListOf<Int>(1, 2, 3)
    val map = mutableMapOf<Int, String>()

    // но забавный факт, метод mutableListOf возвращает ArrayList, то есть
    val list1: MutableList<Int> = mutableListOf()
    val list2: MutableList<Int> = ArrayList() // одно и то же

    /*
    итоги:
    1) использовать абстракции вместо реализаций (ArrayList -> MutableList)
    2) по умолчанию все интерфейсы коллекций неизменяемые, чтобы сделать изменяемыми -
    используем интерфейсы с приставкой Mutable
    3) к элементам коллекции можно обращаться как и к элементам массива []
    4) быстрая инициализация коллекции - ...of(), изменяемой - mutable...Of()
     */
}

fun method(a: List<Int>) {
    println(a)
}