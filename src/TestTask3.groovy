import java.nio.file.Path
import groovy.xml.MarkupBuilder

class TestTask3 {

    static def getBaseFileName(String fileName) {
		if (fileName.indexOf(".") > 0) {
			return fileName.substring(0, fileName.lastIndexOf("."))
		 } else {
			return fileName
		 }
	}
	
	static def getDir(String fileName) {
		if (fileName.indexOf("\\") > 0) {
			return fileName.substring(0, fileName.lastIndexOf("\\"))
		 } else {
			return fileName
		 }
	}

    static def findFilesGroovy(dir) {
		def mask = /^0|[1-9]\d*\.txt$/
		
		def groovyFiles = new FileNameByRegexFinder().getFileNames(dir, mask)
        println groovyFiles
        groovyFiles.each {
            File f = new File(it);
            String newFileName = getBaseFileName(f.getName()).reverse()
            Integer suf = 0
            newFileName.each {suf += Integer.valueOf(it)}
            if (f.renameTo(getDir(f.getPath())+"/"+newFileName+"_"+suf+".dat"))
                println f.getName() + " has been renamed to " +  newFileName+"_"+suf+".dat"
            else
                println f.getName() + " hasn't been renamed to " +  +newFileName+"_"+suf+".dat"
		}

	}

	static main(args) {
		if (args.size()==0) {
			println ("the directory is not found")
			return
		}
		findFilesGroovy(args[0])
	}

}
