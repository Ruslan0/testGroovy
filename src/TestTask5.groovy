/**
 * 
 */

/**
 * @author Ruslan Paluektau
 * Mar 31, 2018
 */
class TestTask5 {
	
	static main(args) {
		Integer number = 0
		(1..10).each {
		  println "Number ${it}"
			def thread = Thread.start {
			  sleep(100)
			  synchronized(number) {
				  number++
			  }
			  println "res ${number}"
			}			
		}
	}

}
