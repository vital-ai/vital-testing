package ai.vital.vitalsigns.test

import ai.vital.domain.Thing
import ai.vital.vitalsigns.VitalSigns
import ai.vital.vitalsigns.model.VITAL_Node
import ai.vital.vitalsigns.model.VitalApp

class TestVitalSigns {

    static void main( args) {

        TestVitalSigns test = new TestVitalSigns()

        test.runTest(args)
    }

    public runTest(args) {

        println "Hello World!"

        VitalSigns vs = VitalSigns.get()

        VitalApp app = VitalApp.withId("vitalapp")

        Thing thing = new Thing().generateURI(app)

        thing.name = "The Thing"

        println "Thing: " + thing.toJSON()

    }

}
