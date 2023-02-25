package resource;

import PojoPayloads.CreateRepoPojo;

public class TestDataBuilder {
	
	CreateRepoPojo req_payload = new CreateRepoPojo();
	public CreateRepoPojo createRepoPayload(String name, String desc) {		
		req_payload.setName(name);
		req_payload.setDescription(desc);
		return req_payload;	
	}
	
	public String getName() {
		return req_payload.getName();
	}

}
