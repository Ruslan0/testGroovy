import java.util.regex.Matcher
import java.util.regex.Pattern

class TestTask1 {
	
	def Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile( /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$/, Pattern.DOTALL)
	
	
 	public boolean validate(String emailStr) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
			return matcher.find();
	}

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
	
	def doOutputReverse(String s) {
		def arr =	s.split()
		def res= arr.findAll{
			word->isReverse(word)
		}
	}

	static void main(args) {
	  def foo = new TestTask1()
	  if ( args.size()==0 ) return
	  
	  println(foo.doOutputReverse("1234321"))
	  
	  def str = args[0]
	  foo.doOutputOnlyLwerCase(str)
	  if (str.length()>16)
	  println(str.substring(11, 16));
	  foo.doOutputEnglish(str);
	  println(foo.replaceFirstSymboltoUp(str))
	  println(foo.doOutputReverse(str))
	}
  
}
