/**
 * 
 */

/**
 * @author Ruslan Paluektau
 * Mar 31, 2018
 */
class Person {
	String firstName
	String surName
	Integer age
    public static class Address {
		String city
		String street 
		Integer index
		@Override
		public String toString() {
			return "Address [city=" + city + ", street=" + street + ", index=" + index + "]";
		}
	}
	Address address
	
	ArrayList<Person> plus(Person person) {
		[person]
	}

	ArrayList<Person>  minus(ArrayList<Person> arr, Person person) {
		[person]-person
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", surName=" + surName + ", age=" + age + ", address=" + address
				+ "]";
	}
}
