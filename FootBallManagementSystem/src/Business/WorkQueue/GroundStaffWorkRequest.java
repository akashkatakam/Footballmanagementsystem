/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class GroundStaffWorkRequest extends WorkRequest{
    
    private String status;
    private RequestType requestType;
    
    public enum RequestType{
        GrassMaintenance("Grass Maintenance"),
        Painting("Painting"),
        Security("Security"),
        Lighting("Lighting"),
        CateringServices("CateringServices");
        
        private String value;
        private RequestType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }
    
    
    
    
}
