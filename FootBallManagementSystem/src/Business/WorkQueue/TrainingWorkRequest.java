/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class TrainingWorkRequest extends WorkRequest{
    
    private int trainingHours;
    
    public enum TrainingType{
        Dribbling("Dribbling"),
        Shooting("Shooting"),
        Passing("Passing"),
        Defensive("Defensive"),
        Fitness("Fitness");
        
        private String value;
        private TrainingType(String value){
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

    public TrainingWorkRequest() {
    
    }
    
}
