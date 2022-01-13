import java.util.Scanner;

public class Actions {
   private StaffsList staffsList;
   private StudentsList studentsList;
   private CourseTakenList courseTakenList;
   private CoursesList coursesList;
   private ProfessorsList professorsList;
   private boolean studentsLogedin = false;
   private boolean profLogedin = false;
   private boolean staffLogedin = false;
   private String user;
   private String currentTerm;

   public Actions() {
      staffsList=new StaffsList();
      studentsList=new StudentsList();
      professorsList=new ProfessorsList();
      coursesList= new CoursesList();
      courseTakenList = new CourseTakenList();
      staffsList.addStuff(new Staffs("Administrator","000000","1976-01-09","Tehran","001","admin","admin",5000000L));
   }

   public void startProgram() {
      StaffTasks staffTasks=new StaffTasks();
      System.out.println("Login options enter a number to continue as below:");
      System.out.println("1.Staff Login");
      System.out.println("2.Student Login");
      System.out.println("3.Professor Login");
      Scanner scanner=new Scanner(System.in);
      String input=scanner.nextLine();

      switch(input){
         case "1":
            System.out.println("enter username:");
            String user=scanner.nextLine();
            System.out.println("enter password:");
            String pass=scanner.nextLine();
            staffsLogin(user,pass);
            break;
         case "2":
            System.out.println("enter username:");
            user=scanner.nextLine();
            System.out.println("enter password:");
            pass=scanner.nextLine();
            studentLogin(user,pass);
            break;
         case "3":
            System.out.println("enter username:");
            user=scanner.nextLine();
            System.out.println("enter password:");
            pass=scanner.nextLine();
            profsLogin(user,pass);
            break;

         default:
            startProgram();

      }
   }

   public String staffsLogin(String user, String pass) {
      StaffTasks staffTasks=new StaffTasks();

      for (int i = 0; i < staffsList.getListIndex(); i++) {
         {
            if (staffsList.getList()[i].getStaffUser().equals(user) && staffsList.getList()[i].getStaffPass().equals(pass) ) {
               staffLogedin = true;
               this.user=user;
               staffTasks.printStaffMainMenu(this);

               return user;
            }
         }

      }
      System.out.println("wrong Login");
      staffLogedin = false;
      startProgram();

      return "";

   }

   public String profsLogin(String user, String pass) {
      ProfTasks profTasks=new ProfTasks();
      for (int i = 0; i < professorsList.getListIndex(); i++) {
         {
            if (professorsList.getList()[i].getProfUser().equals(user) && professorsList.getList()[i].getProfPass().equals(pass)) {
               profLogedin = true;
               this.user=user;
               profTasks.printProfMainMenu(this);
               return user;
            }
         }

      }
      System.out.println("wrong Login");
      profLogedin = false;
      startProgram();

      return "";

   }

   public String studentLogin(String user, String pass) {
      StudentTasks studentTasks=new StudentTasks();

      for (int i = 0; i < studentsList.getListIndex(); i++) {
         {
            if (studentsList.getList()[i].getStudentUser().equals(user) && studentsList.getList()[i].getStudentPass().equals(pass)) {
               studentsLogedin = true;
               this.user=user;
               studentTasks.printStudentMainMenu(this);

               return user;
            }
         }

      }
      System.out.println("wrong Login");

      studentsLogedin = false;
      startProgram();
      return "";

   }

   public void doLogout() {
      studentsLogedin = false;
      profLogedin = false;
      staffLogedin = false;
      startProgram();


   }



   public boolean isUserAvailabe(String user, String type) {
      if (type.equals("students")) {
         for (int i = 0; i < studentsList.getListIndex(); i++) {
            {
               if (studentsList.getList()[i].getStudentUser().equals(user)) {
                 return false;
               }
            }
         }

      } else if (type.equals("staffs")) {
         for (int i = 0; i < staffsList.getListIndex(); i++) {
            {
               if (staffsList.getList()[i].getStaffUser().equals(user) || user.equals("admin")) {
                  return false;
               }
            }
         }
      } else if (type.equals("professors")) {
         for (int i = 0; i < professorsList.getListIndex(); i++) {
            {
               if (professorsList.getList()[i].getProfUser().equals(user)) {
                  return false;
               }
            }
         }
      } else {
         System.out.println("wrong type");
      }
      return true;
   }

   public boolean isIdAvailabe(String id, String type) {
      if (type.equals("students")) {
         for (int i = 0; i < studentsList.getListIndex(); i++) {
            {
               if (studentsList.getList()[i].getStudentId().equals(id)) {
                  return false;
               }
            }
         }

      } else if (type.equals("staffs")) {
         for (int i = 0; i < staffsList.getListIndex(); i++) {
            {
               if (staffsList.getList()[i].getStaffId().equals(id)) {
                  return false;
               }
            }
         }
      } else if (type.equals("professors")) {
         for (int i = 0; i < professorsList.getListIndex(); i++) {
            {
               if (professorsList.getList()[i].getProfId().equals(id)) {
                  return false;
               }
            }
         }
      }
      else if (type.equals("courses")) {
         for (int i = 0; i < coursesList.getListIndex(); i++) {
            {
               if (coursesList.getList()[i].getCourseId().equals(id)) {
                  return false;
               }
            }
         }
      }
      else {
         System.out.println("wrong type");
      }
      return true;
   }
   public void addStd(Students std) {
         studentsList.addStd(std);
   }

   public void showStdList () {
      studentsList.showList();
   }

   public void showCrsList () {
      coursesList.showList();
   }

   public void addStaff(Staffs staff) {
      staffsList.addStuff(staff);
   }


   public void addProf(Professors prof) {
      professorsList.addProf(prof);
   }
   public void addCourse(Courses crs) {
      coursesList.addCrs(crs);
   }

   public void addCourseTaken(CourseTaken crs) {
      courseTakenList.addCrsTkn(crs);
   }

   public void removeStd(String  stdId) {
      boolean isRemoved=false;
      for (int i=0;i<studentsList.getListIndex();i++){
         if(studentsList.getList()[i].getStudentId().equals(stdId)){
            studentsList.remove(i);
            isRemoved=true;
            break;
         }
      }
      if(!isRemoved){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully deleted!");
      }

   }

   public void removeStaff(String  stfId) {
      boolean isRemoved=false;
      for (int i=0;i<staffsList.getListIndex();i++){
         if(staffsList.getList()[i].getStaffId().equals(stfId)){
            staffsList.remove(i);
            isRemoved=true;
            break;
         }
      }
      if(!isRemoved){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully deleted!");
      }

   }

   public void removeProf(String  profId) {
      boolean isRemoved=false;
      for (int i=0;i<professorsList.getListIndex();i++){
         if(professorsList.getList()[i].getProfId().equals(profId)){
            professorsList.remove(i);
            isRemoved=true;
            break;
         }
      }
      if(!isRemoved){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully deleted!");
      }

   }

   public void removeCourse(String  crsId) {
      boolean isRemoved=false;
      for (int i=0;i<coursesList.getListIndex();i++){
         if(coursesList.getList()[i].getCourseId().equals(crsId)){
            coursesList.remove(i);
            isRemoved=true;
            break;
         }
      }
      if(!isRemoved){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully deleted!");
      }

   }

   public void editStd(Students newStd,String stdId) {
      boolean isEdited=false;
      for (int i=0;i<studentsList.getListIndex();i++){
         if(studentsList.getList()[i].getStudentId().equals(stdId)){
            studentsList.getList()[i]=newStd;
            isEdited=true;
            break;
         }
      }
      if(!isEdited){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully edited!");
      }
   }

   public void editStaff(Staffs newStaff, String stfId) {
      boolean isEdited=false;
      for (int i=0;i<staffsList.getListIndex();i++){
         if(staffsList.getList()[i].getStaffId().equals(stfId)){
            staffsList.getList()[i]=newStaff;
            isEdited=true;
            break;
         }
      }
      if(!isEdited){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully edited!");
      }
   }

   public void editProf(Professors newprof, String profId) {
      boolean isEdited=false;
      for (int i=0;i<professorsList.getListIndex();i++){
         if(professorsList.getList()[i].getProfId().equals(profId)){
            professorsList.getList()[i]=newprof;
            isEdited=true;
            break;
         }
      }
      if(!isEdited){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully edited!");
      }
   }

   public void editCourse(Courses newCrs, String crsId) {
      boolean isEdited=false;
      for (int i=0;i<coursesList.getListIndex();i++){
         if(coursesList.getList()[i].getCourseId().equals(crsId)){
            coursesList.getList()[i]=newCrs;
            isEdited=true;
            break;
         }
      }
      if(!isEdited){
         System.out.println("this id not found");
      }else {
         System.out.println("successfully edited!");
      }
   }



   public StaffsList getStaffsList() {
      return staffsList;
   }

   public void setStaffsList(StaffsList staffsList) {
      this.staffsList = staffsList;
   }

   public StudentsList getStudentsList() {
      return studentsList;
   }

   public void setStudentsList(StudentsList studentsList) {
      this.studentsList = studentsList;
   }

   public CourseTakenList getCourseTakenList() {
      return courseTakenList;
   }

   public void setResultsList(CourseTakenList courseTakenList) {
      this.courseTakenList = courseTakenList;
   }

   public CoursesList getCoursesList() {
      return coursesList;
   }

   public void setCoursesList(CoursesList coursesList) {
      this.coursesList = coursesList;
   }

   public ProfessorsList getProfessorsList() {
      return professorsList;
   }

   public void setProfessorsList(ProfessorsList professorsList) {
      this.professorsList = professorsList;
   }

   public boolean isStudentsLogedin() {
      return studentsLogedin;
   }

   public void setStudentsLogedin(boolean studentsLogedin) {
      this.studentsLogedin = studentsLogedin;
   }

   public boolean isProfLogedin() {
      return profLogedin;
   }

   public void setProfLogedin(boolean profLogedin) {
      this.profLogedin = profLogedin;
   }

   public boolean isStaffLogedin() {
      return staffLogedin;
   }

   public void setStaffLogedin(boolean staffLogedin) {
      this.staffLogedin = staffLogedin;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getCurrentTerm() {
      return currentTerm;
   }

   public void setCurrentTerm(String currentTerm) {
      this.currentTerm = currentTerm;
   }

   public String getUserById(String id,String type) {
      switch(type) {

         case "students":
         for (int i = 0; i < getStudentsList().getListIndex(); i++) {
            if (getStudentsList().getList()[i].getStudentId().equals(id))
               return getStudentsList().getList()[i].getStudentUser();
         }
         break;
         case "professors":
            for (int i = 0; i < getProfessorsList().getListIndex(); i++) {
               if (getProfessorsList().getList()[i].getProfId().equals(id))
                  return getProfessorsList().getList()[i].getProfUser();
            }
            break;

         case "staffs":
            for (int i = 0; i < getStaffsList().getListIndex(); i++) {
               if (getStaffsList().getList()[i].getStaffId().equals(id))
                  return getStaffsList().getList()[i].getStaffUser();
            }
            break;
         default:
            System.out.println("wrong type");
      }
      return "";
   }
}
