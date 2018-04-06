import Person.Address

/**
 * @author Ruslan Paluektau
 * Mar 31, 2018
 */
class TestTask7 {

    static main(args) {
        println(4**5)
        def printValue = { it ?: "no value" }
        println printValue("Test")
        println printValue()
        Person p0 = new Person(firstName: "Николай", surName: "Семенов", age: 42)
        Person p1 = new Person(firstName: "Иван", surName: "Петров", age: 32,
            address: new Address(city: "Минск", street: "Железнодорожная", index: 210239))
        Person p2 = new Person(firstName: "Татьяна", surName: "Сухорукова", age: 29,
            address: new Address(city: "Москва", street: "Кирова", index: 220309))
        Person p3 = new Person(firstName: "Сергей", surName: "Котов", age: 39,
            address: new Address(city: "Гродно", street: "Чкалова", index: 220009))
        Person p4 = new Person(firstName: "Ольга", surName: "Митова", age: 38)
        List<Person> arr = [] + p0 + p1 + p2 + p3
        arr.findAll { it.address }.each {
            println it.address.index
        }
    }

}
