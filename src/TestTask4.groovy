
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

	static main(args) {
		def foo = new TestTask4()
		foo.task41()
		foo.task42()
	}

}
