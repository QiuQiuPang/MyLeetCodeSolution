import java.util.ArrayList;
import java.util.List;

public class TestStruct {
    private List<Integer> list;

    public TestStruct(int[] array){
        this.list = new ArrayList<>();
        for(int cur: array) this.list.add(cur);
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
