
package project1;


public class OnlineCourse extends Course{ 
    
 private String class_type;

    public OnlineCourse(String cn, int crn, String cnum, String snum, int ch, String ct, String in){

        super(cn, crn, cnum, snum, ch, in);

        this.class_type = ct;
    }

    public String getClassType(){
        return class_type;
    }
    public String setClassType(String ct){
        return this.class_type = ct;
    }

    @Override
    public String toString(){
            return ("#" + getCRNnumber() + ": " + getCourseNumber() + " (" + getCourseName() + "), " + getInstructorName() + ", " +
                    getClassType());
        }

    @Override
    public boolean conflictsWith(Course c) {
        boolean conflicts = false;

        if(this.getCRNnumber() == c.getCRNnumber()){
            conflicts = true;
        }
        return conflicts;
    }



}

   


        
