
package project1;
 
public abstract class Course {
    private String cName;
    private int crnNum;
    private String courseNum;
    private String secNum;
    private int hours;
    private String instructName;

 



        public Course(String cn, int crn, String cnum, String snum, int ch, String in){
            this.cName = cn;
            this.crnNum = crn;
            this.courseNum = cnum;
            this.secNum = snum;
            this.hours = ch;
            this.instructName = in;

        }

        public String getCourseName(){
            return cName;
        }
        public String setCourseName(String cn){
            return this.cName = cn;
        }
        public int getCRNnumber(){
            return crnNum;
        }
        public int setCRNnumber(int crn){
            return this.crnNum = crn;
        }
        public String getCourseNumber(){
            return courseNum;
        }
        public String setCourseNumber(String cnum){
            return this.courseNum = cnum;
        }
        public String getSectionNumber(){
            return secNum;
        }
        public String setSectionNumber(String snum){
            return this.secNum = snum;
        }
        public int getCreditHour(){
            return hours;
        }
        public int setCreditHour(int ch){
            return this.hours = ch;
        }
        public String getInstructorName(){
            return instructName;
        }
        public String setInstructorName(String in){
            return this.instructName = in;
        }

        public abstract boolean conflictsWith(Course c);
}
    
    
    
    
    
    
    

    
    
  