import java.util.regex.Matcher
import java.util.regex.Pattern

class TestTask1 {
	
	def Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile( /\A[^@]+@([^@\.]+\.)+[^@\.]+\z/, Pattern.DOTALL)
	
	
	def doOutputOnlyLwerCase(String s) {
		def arr =	s.split()
		def res= arr.findAll{
			word->word.equals(word.toLowerCase())
		}
		println (res)
	}
	
	def doOutputEnglish(String s) {
		def arr= s.toCharArray().findAll{ch->ch>='a'&&ch<='z'}
	}


	def replaceFirstSymboltoUp(String s) {
        def char[] arr = s.toCharArray()
        def boolean inWord = false
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] >= 97 && arr[i] <= 122) {
                if (inWord) {
                    continue
                }
                arr[i] -= 32
                inWord = true
            } else {
                inWord = false
            }
        }
        return new String(arr)
	}

	def  boolean isReverse(String s) {
		def char[] arrchar = s.toCharArray()
		def boolean flag = true
		if (arrchar.length/2>=5) return false
		for (int i=0; i<arrchar.length/2; i++ ) {
			if (arrchar[i]!=arrchar[arrchar.length-i-1]) {
				flag = false
				break
			}
		}
		return flag
	}
	
	public boolean isEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	def doOutputReverse(String s) {
		def arr =	s.split()
		def res= arr.findAll{
			word->isReverse(word)
		}
	}

	def isContainEmail(String s) {
		return s.split().any{isEmail(it)}
	}

	def task11(String str) {
	  doOutputOnlyLwerCase(str)             // à
	  if (str.length()>16)
	  println(str.substring(11, 16));		// á
	  println(doOutputEnglish(str));		// â
	  println(replaceFirstSymboltoUp(str))  // ã 
	  println(doOutputReverse(str))			// ä
	  println(isContainEmail(str))			// å
	}
	
	def task12(Integer[] intArray) {
		def Integer[] intArray2 = [220, 300, 110,-122, 110,2,3,332,2,6, -1]                     
		println("unique size = "+intArray.toUnique().size());									// à
		println("max = "+intArray.toUnique().max() + "; min = "+intArray.toUnique().min());		// á
		println(intArray.collect ({return it>0?it*2:it*3}))										// â
		println(intArray.collect().intersect(intArray2.collect()))								// ã
	}	
	
	static void main(args) {
	  def foo = new TestTask1()
	  def str="I want to walk my DOG, Cat, and asrtatrsa and qwertrewq Maybe even my tortoise@mail.ru ."
	  def Integer[] intArray = [200, 300, 100,-122, 100,2,1,331,2,5, -1]
	  println("*** Task 1.1 ***")			
	  foo.task11(str)
	  println("*** Task 1.2 ***")			
	  foo.task12(intArray)
	}
  
}
