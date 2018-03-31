import Person.Address

class TestTask4 {
	

	def task41() {
	  println("*** Task 4.1 ***")			
		Integer.metaClass.toComment= { str -> str + delegate.toString() }
		Integer.metaClass.static.ValueOfByte= {Byte ch -> 
			String str = ch.toString()
			return delegate.valueOf(str)
		}
		Integer i = 2
		Byte b = 10;
		Integer j=Integer.valueOf(i)
		println i.toComment("Inteher = ")
		println Integer.ValueOfByte(b)
		
		List.getMetaClass().info= {"Size: " +delegate.size()+ "; Elements: " + delegate.toString()}
		List<String> arrList = new ArrayList()
		arrList.add("A")
		arrList.add("B")
		arrList.add("C")
		println arrList.info("Inteher = ")
	}

	def task42() {
		println("*** Task 4.2 ***")			
		def test1 = {Integer x, String s, Closure c -> return s + x + c } // замыкание
		def test2 = {String...args-> return args.join('') } 
		def p = test1.call(5, "Test1 ",  {2})                 // прямоый вызов
		def q = test1(4, "Test2 ", {" Test"})                  // косвенный вызов
		def z = test2("Test", "2","ok ")                 
		println "p: ${p}"                       
		println "q: ${q}"                       
		println "z: ${z}"
		
	}

	def task43() {
		Person p0 = new Person(firstName: "Test") 
		Person p1 = new Person(firstName: "Михаил", surName: "Тропин", age: 32, 
			address : new Address(city: "Москва", street: "Смоленкая", index: 210239))
		Person p2 = new Person(firstName: "Анна", surName: "Столина", age: 29, 
			address : new Address(city: "Витебск", street: "Кирова", index: 220309))
		Person p3 = new Person(firstName: "Иван", surName: "Сидоров", age: 39, 
			address : new Address(city: "Минск", street: "Независмости", index: 220009))
		List<Person> arr=p0+p1+p2+p3
		println arr
		println arr-p2
		println  arr.findAll{it.age<30}
		arr.each{
			println it.address
		}
	}
	
	
	static main(args) {
		def foo = new TestTask4()
		foo.task41()
		foo.task42()
		foo.task43()
	}

}
