import groovy.xml.MarkupBuilder

class TestTask2 {
	
	static def findFilesGroovy(dir) {
		def mask = /.groovy\.*/
		
		def groovyFiles = new FileNameByRegexFinder().getFileNames(dir, mask)
		def writer = new StringWriter()
		def xml = new MarkupBuilder(writer)

		groovyFiles.each{
			File f = new File( it )
			println f.name + " | "+ f.size()+" | "+f.absolutePath
			
			xml.records() {
				file(name: f.name) {
					attributes(size: f.size(), f.absolutePath)
				}
			}
			println writer.toString()
	
		}
	}

	static main(args) {
		if (args.size() == 0) {
			println "the directory is not found"
			return
		}
		findFilesGroovy(args[0])
	}

}
