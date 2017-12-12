package buffbeds;

public class Request {
	private String Type;
	private int ReqID;
	private int RequestedID;
	private int responderID;
	
	public Request()
	{
		
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getReqID() {
		return ReqID;
	}

	public void setReqID(int reqID) {
		ReqID = reqID;
	}

	public int getRequestedID() {
		return RequestedID;
	}

	public void setRequestedID(int requestedID) {
		RequestedID = requestedID;
	}

	public int getResponderID() {
		return responderID;
	}

	public void setResponderID(int responderID) {
		this.responderID = responderID;
	}
	
	
	

}
