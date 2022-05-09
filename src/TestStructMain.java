import java.util.List;

public class TestStructMain {
    public static void main(String[] args) {
        TestStruct testStruct = new TestStruct(new int[]{1,2,3,4});
        List<Integer> list = testStruct.getList();
        System.out.println(list);
        list.add(1);
        //没有通过setter就往TestStruct里的list添加数据 {1,2,3,4,1}
        System.out.println(testStruct.getList());
    }
}
