/**
 *
 */

/**
 * @author Ruslan Paluektau
 * Mar 31, 2018
 */
class TestTask6 {

    static def task6(path) {
        for (File myFile : new File(path).listFiles()) {
            if (myFile.isFile()) myFile.delete()
            else if (myFile.isDirectory()) task6(myFile.getPath())
        }
    }

    static main(args) {
        if (args.size() == 0) {
            println("the directory is not found")
            return
        }
        task6(args[0])
    }

}
