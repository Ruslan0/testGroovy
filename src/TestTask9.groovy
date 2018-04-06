/**
 * Created by paluektau on 4/6/2018.
 */
class TestTask9 {
    static def filterXmlByValue(String filename, def value) {
        return new XmlSlurper().parse(new File(filename)).fields.field.find{it.text().trim() == value}
    }

    static main(args) {
        if (args.size() == 0) {
            println "the file is not defined"
            return
        }
        println filterXmlByValue(args[0],"Value 5")

    }
}
