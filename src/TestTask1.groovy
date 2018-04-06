import java.util.regex.Pattern

class TestTask1 {

    static Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(/\A[^@]+@([^@\.]+\.)+[^@\.]+\z/, Pattern.DOTALL)
    static def str = "I want to walk my DOG, Cat, and asrtatrsa and qwertrewq Maybe even my tortoise@mail.ru ."

    static def getWordsOnlyLwerCase() {
        return str.split().findAll { word -> word == word.toLowerCase() }
    }

    static def getStrFrom11To16(String str) {
        if (str.length() >= 16)
            return str[11..16]
        else
            return ""
    }

    static def getEnglishLetters(String s) {
        return s.toCharArray().findAll { ch -> ((ch >= 'a') && (ch <= 'z')) }
    }

    static def getreplaceFirstSymboltoUp(String s) {
        return s.split().collect { it.capitalize() }.join(" ")
    }

    static def getReverse(String target) {
        return target.tokenize().findAll { it.toSet().size() <= 5 && it == it.reverse() }
    }


    static def isContainEmail(String s) {
        return s.split().any { VALID_EMAIL_ADDRESS_REGEX.matcher(it).find() }
    }

    static def task11(String str) {
        println wordsOnlyLwerCase      // а
        println getStrFrom11To16(str)        // б
        println getEnglishLetters(str)        // в
        println getreplaceFirstSymboltoUp(str)  // г
        println getReverse(str)             // д
        println(isContainEmail(str))        // е
    }

    static def task12(Integer[] intArray) {
        Integer[] intArray2 = [220, 300, 110, -122, 110, 2, 3, 332, 2, 6, -1]
        println "unique size = " + intArray.toUnique().size()                                    // а
        println "max = " + intArray.toUnique().max() + "; min = " + intArray.toUnique().min()        // б
        println intArray.collect({ return it > 0 ? it * 2 : it * 3 })                                        // в
        println intArray.collect().intersect(intArray2.collect())                                // г
    }

    static void main(args) {
        Integer[] intArray = [200, 300, 100, -122, 100, 2, 1, 331, 2, 5, -1]
        println "*** Task 1.1 ***"
        task11(str)
        println "*** Task 1.2 ***"
        task12(intArray)
    }

}
