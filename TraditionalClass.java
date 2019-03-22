
package project1;

import java.time.LocalTime;


public class TraditionalClass extends Course{
    
private LocalTime sTime;
    private LocalTime eTime;
    private String mDays;
    private String mLocation;
    private String cType;


    public TraditionalClass(String cn, int crn, String cnum, String snum, int ch, LocalTime st, LocalTime et, String md, String ml, String ct, String in){

            super (cn, crn, cnum, snum, ch, in);

            this.sTime = st;
            this.eTime = et;
            this.mDays = md;
            this.mLocation = ml;
            this.cType = ct;

    }

        public LocalTime getStartTime(){
            return sTime;
        }
        public LocalTime setStartTime(LocalTime st){
            return this.sTime = st;
        }
        public LocalTime getEndTime(){
            return eTime;
        }
        public LocalTime setEndTime(LocalTime et){
            return this.eTime = et;
        }
        public String getMeetingDays(){
            return mDays;
        }
    
public String setMeetingDays(String md){
            return this.mDays = md;
        }
        public String getMeetingLocation(){
            return mLocation;
        }
        public String setMeetingLocation(String ml){
            return this.mLocation = ml;
        }
        public String getCourseType(){
            return cType;
        }
        public String setCourseType(String ct){
            return this.cType = ct;
        } 


    @Override
        public String toString(){
            return ("#" + getCRNnumber() + ": " + getCourseNumber() + " (" + getCourseName() + "), " + getInstructorName() + ", " +
                    getCourseType() + ", " + getStartTime() + " - " + getEndTime() + ", " + getMeetingDays() + ", " + getMeetingLocation());
        }




    @Override
    public boolean conflictsWith(Course c){
        boolean conflicts = false;

        if(c instanceof TraditionalClass){
            TraditionalClass trad = (TraditionalClass)c;

            if (this.getMeetingDays().equals(trad.getMeetingDays())){



                if(this.getEndTime().isAfter(trad.getStartTime()) && this.getStartTime().isBefore(trad.getStartTime())){
                    conflicts = true;
                }

                else if (this.getStartTime().isBefore(trad.getEndTime()) && this.getEndTime().isAfter(trad.getEndTime())){
                    conflicts = true;
                }
                else if (this.getStartTime().isAfter(trad.getStartTime()) && this.getEndTime().isBefore(trad.getEndTime())){
                    conflicts = true;
                }
                else if(this.getStartTime() == trad.getStartTime()){
                    conflicts = true;
                }
            }
            else{
                conflicts = false;
            }
        }
        return conflicts;
    }
}
    
    