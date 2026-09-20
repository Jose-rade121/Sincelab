package sincelab.storage;


/**
 *
 * @author josee
 */
public class Users {
       
    // Principio de encapsulamiento(POO)
    private String name = null;
    private String career = null;
    private int points; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
 
    
}
