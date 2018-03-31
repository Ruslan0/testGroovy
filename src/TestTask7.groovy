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
			Person p1 = new Person(firstName: "������", surName: "������", age: 32, 
				address : new Address(city: "������", street: "���������", index: 210239))
			Person p2 = new Person(firstName: "����", surName: "�������", age: 29, 
				address : new Address(city: "�������", street: "������", index: 220309))
			Person p3 = new Person(firstName: "����", surName: "�������", age: 39, 
				address : new Address(city: "�����", street: "������������", index: 220009))
			List<Person> arr=p0+p1+p2+p3
			arr.findAll{it.address!=null}.each{
				println it.address.index
			}
	}

}
