package vcgJsonAnalyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import vcgUtilities.JsonObjectCounter;

public class VcgJsonAnalyserMain {

	public static void main(String[] args) throws IOException {

		// Count JSONObjects {}
		JsonObjectCounter jsonObjectCounter = new JsonObjectCounter(new FileReader("/home/sea29/eclipse-workspace/VcgJsonAnalyser/myJSON.json"));

		int objectsCounts = jsonObjectCounter.jsonObjCount();

		// Putting read JSON-Objects into an Array
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("/home/sea29/eclipse-workspace/VcgJsonAnalyser/myJSON.json"));
			
			// The file content starts with { - on top level we have a JSONObjekt.
			JSONObject jsonObject = (JSONObject) obj;
			// On the following level it goes ahead with [ - this indicates an Array.
			JSONArray jsonArray = (JSONArray) jsonObject.get("ports");

			// Object counts include JSON on all level - contentlevel is -1
			VcgJsonClass[] listPorts = new VcgJsonClass[objectsCounts - 1];

			for (int i = 0; i < objectsCounts - 1; i++) {

				JSONObject jsonObject2 = (JSONObject) jsonArray.get(i);

				String status = (String) jsonObject2.get("status");
				String registered_identity = (String) jsonObject2.get("registered_identity");
				String name = (String) jsonObject2.get("name");
				String hostport = (String) jsonObject2.get("hostport");
				String type = (String) jsonObject2.get("type");
				long lines = (long) jsonObject2.get("lines");
				long concurrent_calls = (long) jsonObject2.get("concurrent_calls");
				String unexpected_calls = (String) jsonObject2.get("unexpected_calls");

				// Putting Details in a prepared class and loop through the content to be saved.
				VcgJsonClass vcgJsonClass = new VcgJsonClass(status, registered_identity, name, hostport, type, lines,
						concurrent_calls, unexpected_calls);

				listPorts[i] = vcgJsonClass;
			}

			for (int j = 0; j < objectsCounts - 1; j++) {
				System.out.println((j+1) + ".) The Port with the name " + listPorts[j].getName()
						+ " has the following amount of lines: " + listPorts[j].getLines() + ".");
			}

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
//		} catch (ParseException e) {
//			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
