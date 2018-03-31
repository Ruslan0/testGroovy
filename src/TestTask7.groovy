import Person.Address

/**
 * @author Ruslan Paluektau
 * Mar 31, 2018
 */
class TestTask7 {

	static main(args) {
			println (4**5) // 7.1
			def printValue =  {(it!=null)?it:"no value"}
			println printValue("Test")
			println printValue()
			Person p0 = new Person(firstName: "Test") 
			Person p1 = new Person(firstName: "Михаил", surName: "Тропин", age: 32, 
				address : new Address(city: "Москва", street: "Смоленкая", index: 210239))
			Person p2 = new Person(firstName: "Анна", surName: "Столина", age: 29, 
				address : new Address(city: "Витебск", street: "Кирова", index: 220309))
			Person p3 = new Person(firstName: "Иван", surName: "Сидоров", age: 39, 
				address : new Address(city: "Минск", street: "Независмости", index: 220009))
			List<Person> arr=p0+p1+p2+p3
			arr.findAll{it.address!=null}.each{
				println it.address.index
			}
	}

}
