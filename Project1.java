
package project1;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;



public class Project1 {
    
    public static final int TRADITIONAL = 11;
    public static final int ONLINE = 7;
    
        public static void main(String[] args) throws IOException {
            
            Scanner in = new Scanner(Paths.get("project1input (4).csv"), "UTF-8");
            ArrayList<Course> allClasses = new ArrayList<>();


                while ( in.hasNextLine() ) {
                    String line = in.nextLine();
                    String [] currCourse = (line.split("\t"));
                    
                        if(currCourse.length == TRADITIONAL){
                            
                            String [] start = currCourse[5].split(":");
                            String [] end = currCourse[6].split(":");
                            
                            int startHour = Integer.parseInt(start[0]);
                            int startMinute = Integer.parseInt(start[1]);
                            
                            int endHour = Integer.parseInt(end[0]);
                            int endMinute = Integer.parseInt(end[1]);
                            
                            LocalTime newStrt = LocalTime.of(startHour, startMinute);
                            LocalTime newEnd = LocalTime.of(endHour, endMinute);
                            
                            TraditionalClass t = new TraditionalClass
                           (currCourse[0], 
                            Integer.parseInt(currCourse[1]),
                            currCourse[2],
                            currCourse[3],
                            Integer.parseInt(currCourse[4]),
                            newStrt,
                            newEnd,
                            currCourse[7],
                            currCourse[8],
                            currCourse[9],
                            currCourse[10]);
                            
                            allClasses.add(t);
                            
                            
                            
                  
                }
                        else if (currCourse.length == ONLINE){
                            
                            OnlineCourse o = new OnlineCourse(
                            currCourse[0],
                            Integer.parseInt(currCourse[1]),
                            currCourse[2],
                            currCourse[3],
                            Integer.parseInt(currCourse[4]),
                            currCourse[5],
                            currCourse[6]);
                            
                            
                            allClasses.add(o);
                        }
                        
                        
                        
                        
                       
                }
                
                boolean schedule = false;
                ArrayList<Course> actualSchedule = new ArrayList<>();
                
                while (!schedule){
            System.out.println("1) Search Courses");
            System.out.println("2) Register for Course");
            System.out.println("3) View Trial Schedule");
            System.out.println("4) Quit");
            
            Scanner c = new Scanner(System.in);

            int choice = c.nextInt();
            
            if (choice == 1){
                System.out.println("Please search for the class you want. Ex: CS 231: ");
            
            Scanner search = new Scanner(System.in);
            String classChoice = search.nextLine();
            
            ArrayList<Course> options = new ArrayList<>();
            
            for (Course l : allClasses){
                if (l.getCourseNumber().equals(classChoice)){
                    options.add(l);
                }
                
            }
            
            for (Course l : options){
                System.out.println(l);  
            }
        }
            
            else if (choice == 2){
                System.out.println("Please enter the CRN number for the class you wish to add: ");
                
                Scanner crnChoice = new Scanner(System.in);
                int crn = crnChoice.nextInt();
                
                
                for (Course l : allClasses){
                    
                    if (l.getCRNnumber() == crn){
                        Course cCourse = l;
                        
                        if(actualSchedule.isEmpty()){
                            actualSchedule.add(cCourse);
                            System.out.println("Class has been added!");
                            System.out.println();
                            
                        }
                        else{
                            
                            int conflictCounter = 0;
                            for (Course cCoursese : actualSchedule){
                                
                                if(cCourse.conflictsWith(cCoursese) == false){
                                    ++conflictCounter;
                                }
                                
                                else{
                                    System.out.println("Detected a conflict!");
                                    System.out.println();
                                }
                                
                            }
                            if(conflictCounter == actualSchedule.size()){
                                actualSchedule.add(cCourse);
                                System.out.println("Class has been added!");
                                System.out.println();
                            }
                        }
                    }
                }
                
            }
            
            else if(choice == 3){
                for (Course l: actualSchedule){
                    System.out.println(l);
                }
                System.out.println();
            }
            else if(choice == 4){
                System.out.println("The program has now ended. \nThank You!");
                        
                        schedule = true;
            }
            else System.out.println("Please enter a correct choice.");
            
            
            
            
            
            
            
                }
        }
}