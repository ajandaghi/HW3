public class ProfessorsList {
    private Professors[] list;
    private int listIndex=0;

    public ProfessorsList(){
        list=new Professors[1000];
    }

    public ProfessorsList(int listNum) {
        list=new Professors[listNum];
    }
    public void addProf(Professors prof){
        list[listIndex]=prof;
        listIndex++;
    }
    public boolean isEmpty(Professors[] list){
        if (listIndex==0)
            return true;
        else
            return false;
    }

    public  void addAll(int index,Professors[] arr) {

        for (int i = 0; i < arr.length; i++) {
            addValue(index + i, arr[i]);
        }

    }

    public  void addValue(int indexOfValue, Professors value) {
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
            System.out.println(" fullName:"+list[i].getFullName()+" id:"+list[i].getProfId()+" nationalCod:"+list[i].getNationalCode()+" user:"+list[i].getProfUser());
        }
    }

    public void remove(int index){

        for(int i=index;i<listIndex-1;i++){
            list[i]=list[i+1];
        }
        list[listIndex]=null;
        listIndex--;
    }

    public boolean contains(Professors intNum){
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

    public Professors[] getList() {
        return list;
    }

    public void setList(Professors[] list) {
        this.list = list;
    }

    public int getListIndex() {
        return listIndex;
    }
}
