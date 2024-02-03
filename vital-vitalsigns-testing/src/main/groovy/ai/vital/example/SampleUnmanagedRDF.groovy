package ai.vital.example

import ai.vital.vitalsigns.model.VitalApp;
import ai.vital.vitalsigns.VitalSigns
import ai.vital.vitalsigns.model.VITAL_Node
import ai.vital.vitalsigns.model.*
import ai.vital.vitalsigns.rdf.RDFFormat
import ai.vital.vitalsigns.model.XSD



class SampleUnmanagedRDF {

	
	
	static main(args) {
	
		
		VitalSigns vs = VitalSigns.get()
		
		VitalApp app = new VitalApp(name: 'app', appID: 'app')
		
		
		vs.setCurrentApp(app)
		
		vs.addExternalNamespace("myapp", "http://example.org/myapp/myapp")
		
		println "Hello World!"
		
		VITAL_Node node = new VITAL_Node().generateURI()
		
		node."myapp:name" = "John"^XSD.xstring
		node."myapp:birthday" = "January 1, 1970 EST"^XSD.xdatetime("MMMM d, yyyy z")
		
		node."myapp:age" = "1"^XSD.xint
		
		node."myapp:price" = "1.99"^"xsd:double"
		
		node."myapp:happy" = "true"^XSD.xboolean
		
		node."myapp:colors" = ["red"^XSD.xstring, "blue"^XSD.xstring, "white"^XSD.xstring]
		
		node."myapp:friends" = ["fred", "mary", "bob"]
		
		// fix in 0.2.303
		//node."myapp:hashvalue" = "1010101"^"myapp:hash"
		
		println "URI: " + node.URI
		println "Name: " + node."myapp:name"
		println "Birthday: " + node."myapp:birthday"
		println "Age: " + node."myapp:age"
		println "Price: " + node."myapp:price"
		println "Happy: " + node."myapp:happy"
		println "Colors: " + node."myapp:colors"
		println "Friends: " + node."myapp:friends"
		println "Hashvalue: " + node."myapp:hashvalue"
		
		
		println node.toRDF()
		println node.toRDF(RDFFormat.RDF_XML)
		
		println node.toJSON()
		println node.toCompactString()
		
		String myrdf = node.toRDF()
		
		def objs = vs.fromRDFGraph(myrdf)
		
		objs.each {
			
			println it.toCompactString()
			println it."myapp:birthday"
			
			
		}
		
		
	}

}
