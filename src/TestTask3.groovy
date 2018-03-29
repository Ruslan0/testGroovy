import java.nio.file.Path
import groovy.xml.MarkupBuilder

class TestTask3 {
	
	def private String getBaseFileName(String fileName) { 
		if (fileName.indexOf(".") > 0) {
			return fileName.substring(0, fileName.lastIndexOf("."))
		 } else {
			return fileName
		 }
	}
	
	def private String getDir(String fileName) { 
		if (fileName.indexOf("\\") > 0) {
			return fileName.substring(0, fileName.lastIndexOf("\\"))
		 } else {
			return fileName
		 }
	}

		def findFilesGroovy(dir) {
		def mask = /^0|[1-9]\d*\.txt$/
		
		def groovyFiles = new FileNameByRegexFinder().getFileNames(dir, mask)
			println (groovyFiles)
			groovyFiles.each{
			
			File f = new File(it);
			def String newFileName = getBaseFileName(f.getName()).reverse()
			def Integer suf=0;
			for (int i =0; i < newFileName.length(); i++ ) {
				suf+=Integer.valueOf(newFileName.getAt(i));
			}
			if (f.renameTo(getDir(f.getPath())+"/"+newFileName+"_"+suf+".dat"))
				println (f.getName() + " has been renamed to " +  newFileName+"_"+suf+".dat")
			else	
				println (f.getName() + " hasn't been renamed to " +  +newFileName+"_"+suf+".dat")
				
		}

	}

	static main(args) {
		if (args.size()==0) {
			println ("the directory is not found")
			return
		}
		def foo = new TestTask3()
		foo.findFilesGroovy(args[0])
	}

}
