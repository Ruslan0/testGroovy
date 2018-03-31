
class TestTask4 {
	
	def task41() {
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
		

	static main(args) {
		def foo = new TestTask4()
		foo.task41()
	}

}
