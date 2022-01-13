public class CoursesList {
    private Courses[] list;



    private int listIndex=0;
    public CoursesList(){
        list=new Courses[1000];
    }

    public CoursesList(int listNum) {
        list=new Courses[listNum];
    }
    public void addCrs(Courses crs){
        list[listIndex]=crs;
        listIndex++;
    }
    public boolean isEmpty(Integer[] list){
        if (listIndex==0)
            return true;
        else
            return false;
    }

    public  void addAll(int index,Courses[] arr) {

        for (int i = 0; i < arr.length; i++) {
            addValue(index + i, arr[i]);
        }

    }

    public  void addValue(int indexOfValue, Courses value) {
        listIndex++;
        for (int i = listIndex; i > 0; i--) {
            if (i > indexOfValue) {
                list[i] = list[i-1];
            } else if (i == indexOfValue) {
                list[indexOfValue] = value;
            }
        }

    }

    public void showList(){
        for (int i = 0; i < listIndex; i++) {
            System.out.println("id:"+ list[i].getCourseId()+" name:"+list[i].getCourseName()+" unit:"+list[i].getCourseUnit()+" term:"+list[i].getTerm()+" profId:"+list[i].getProfId());
        }

    }

    public void remove(int index){

        for(int i=index;i<listIndex-1;i++){
            list[i]=list[i+1];
        }
        list[listIndex]=null;
        listIndex--;
    }

    public boolean contains(Courses intNum){
        for (int i=0;i<listIndex;i++) {
            if(list[i]==intNum)
                return true;
        }

        return false;
    }

    public void clear(){
        for (int i=0;i<listIndex;i++) {
            list[i]=null;
        }
        listIndex=0;
    }

    public Courses[] getList() {
        return list;
    }

    public void setList(Courses[] list) {
        this.list = list;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }
}


