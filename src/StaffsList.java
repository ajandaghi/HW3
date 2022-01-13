public class StaffsList {
    private Staffs[] list;
    private int listIndex=0;

    public StaffsList(){
        list=new Staffs[1000];
    }

    public StaffsList(int listNum) {
        list=new Staffs[listNum];
    }
    public void addStuff(Staffs staff){
        list[listIndex]=staff;
        listIndex++;
    }
    public boolean isEmpty(Staffs[] list){
        if (listIndex==0)
            return true;
        else
            return false;
    }

    public  void addAll(int index,Staffs[] arr) {

        for (int i = 0; i < arr.length; i++) {
            addValue(index + i, arr[i]);
        }

    }

    public  void addValue(int indexOfValue, Staffs value) {
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
            System.out.println("full name:"+list[i].getFullName()+" id:"+list[i].getStaffId()+" nationalCode:"+list[i].getNationalCode()+" user:"+list[i].getStaffUser());
        }
    }

    public void remove(int index){

        for(int i=index;i<listIndex-1;i++){
            list[i]=list[i+1];
        }
        list[listIndex]=null;
        listIndex--;
    }

    public boolean contains(Staffs intNum){
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

    public Staffs[] getList() {
        return list;
    }

    public void setList(Staffs[] list) {
        this.list = list;
    }

    public int getListIndex() {
        return listIndex;
    }
}
