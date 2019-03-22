# Project1

Project 1 is a programming assignment given to create a class registration system at Jacksonville State University.


## Overview
This program utilizes abstract classes, classes, ArrayLists, as well as other basic programming practices. The program takes an excel spreadsheet, reads the data, and outputs results based on your choices. One of the most diffucult parts of this assignment was understanding how to use the built in LocalTime library in java.

## Usage
This program is very practical and could easily be adapted into an actual college or school's registrar system. It is very easy to read, understand, and follow the logic. Once the program is ran, it will prompt the user with four choices. Choice one will allow the user to search for courses. Choice two will allow the user to register for a course. Choice three allows the user to view their current schedule. Choice four will close the program. Overall the program was challenging to make, but is very user-friendly, logically designed, and fun.


### Specifics
This program takes full advantage of abstract classes, ArrayLists, inheritance, and encapsulation. The two child classes, OnlineCourse and TraditionalClass, inherit most of their functions from the parent class, Course. Once the excel sheet is read in, it is seperated using the tab delimitered sequence. For example:

                    while ( in.hasNextLine() ) {
                    String line = in.nextLine();
                    String [] currCourse = (line.split("\t"));


The data is then read into its respective class ArrayList, and stored correctly. 

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




When the user searches for a course, the data is pulled from the ArrayList and displayed to the screen. 

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



When the user registers for a class, they enter the CRN. That CRN is then added to the schedule. 

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


Finally, the user can display their current schedule by choosing choice three. 

      else if(choice == 3){
                for (Course l: actualSchedule){
                    System.out.println(l);
                }
                System.out.println();
            }
