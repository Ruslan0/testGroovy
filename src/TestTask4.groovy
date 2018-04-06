import Person.Address

class TestTask4 {

    static def task41() {
        println("*** Task 4.1 ***")
        Integer.metaClass.toComment = { str -> str + delegate.toString() }
        Integer.metaClass.static.ValueOfByte = { Byte ch ->
            String str = ch.toString()
            return delegate.valueOf(str)
        }
        Integer i = 2
        Byte b = 10;
        Integer j = Integer.valueOf(i)
        println i.toComment("Inteher = ")
        println Integer.ValueOfByte(b)

        List.getMetaClass().info = { "Size: " + delegate.size() + "; Elements: " + delegate.toString() }
        List<String> arrList = new ArrayList()
        arrList.add("A")
        arrList.add("B")
        arrList.add("C")
        println arrList.info("Inteher = ")
    }

    static def task42() {
        println("*** Task 4.2 ***")
        def test1 = { Integer x, String s, Closure c -> return s + x + c }
        def test2 = { String... args -> return args.join('') }
        def p = test1.call(5, "Test1 ", { 2 })
        def q = test1(4, "Test2 ", { " Test" })
        def z = test2("Test", "2", "ok ")
        println "p: ${p}"
        println "q: ${q}"
        println "z: ${z}"

    }

    static def task43() {
        Person p1 = new Person(firstName: "Иван", surName: "Петров", age: 32,
            address: new Address(city: "Минск", street: "Железнодорожная", index: 210239))
        Person p2 = new Person(firstName: "Татьяна", surName: "Сухорукова", age: 29,
            address: new Address(city: "Москва", street: "Кирова", index: 220309))
        Person p3 = new Person(firstName: "Сергей", surName: "Котов", age: 39,
            address: new Address(city: "Гродно", street: "Чкалова", index: 220009))
        def arr= [] + p1 + p2 + p3
        println arr
        println arr - p2
        println arr.findAll { it.age < 30 }
        arr.each {
            println it.address
        }
    }


    static main(args) {
        task41()
        task42()
        task43()
    }

}
