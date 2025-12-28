package infinity.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data {
	
	
	/**
	 * 
	 * 
	 * */
	public List<HashMap<String, String>> getJsonDataToMap(String fileLocation) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(fileLocation), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> map = mapper.readValue(jsonContent, new TypeReference<>(){});
		System.out.println("MAP:" +  map);
		return map;
	}

}
