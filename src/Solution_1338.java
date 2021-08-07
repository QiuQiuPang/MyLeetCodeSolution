import java.util.*;

class Solution_1338 {

    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{2,28,92,30,100,52,28,48,91,27,66,19,11,53,91,95,74,51,65,65,96,81,21,55,98,3,2,89,99,57,78,34,50,2,57,76,23,90,89,36,53,22,73,59,95,45}));
    }
    public static int minSetSize(int[] arr) {
        //chooes the numbers of max occurrences
        HashMap<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y)->y[1]-x[1]);
        for(int i=0; i<arr.length; i++){
            //what if sort the list by the frequency
            if(frequency.containsKey(arr[i])){
                frequency.put(arr[i],frequency.get(arr[i])+1);
            }
            else frequency.put(arr[i],1);
        }
        for(Map.Entry<Integer,Integer> i: frequency.entrySet()){
            heap.add(new int[]{i.getKey(),i.getValue()});
        }
        int count = 0;
        int size = arr.length/2;
        while (size > 0){
            int[] currentElement = heap.poll();
            size-=currentElement[1];
            count ++;
        }
        return count;
    }

    public static int minSetSize2(int[] arr) {

        // assumption:
        // #1 size of arr is even
        // #2 arr does not gurantee all the same integer will appear continuously
        // #3 not sorted

        // brute force way
        // firstly count occurrences of all integers inside of array
        // store the occurance count with integer in heap
        // starting remove the element of largest occurance untill size is smaller than arr.length/2
        //time complexity: O(nlogn)

        // Is there better solution
        // is it possible to do O(n)?
        // greedy? not gurantee
        // bucket sort? no because 1 <= arr[i] <= 10^5
        // unless assumption #2 is wrong, otherwise no better solution

        // firstly count occurrences of all integers inside of array
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            }
            else{
                countMap.put(arr[i], 1);
            }
        }

        // store the occurance count with integer in heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((x,y)-> y[1] - x[1]);
        for(Integer key:countMap.keySet()){
            heap.offer(new int[]{key, countMap.get(key)});
        }

        int count = arr.length;
        List<Integer> result = new ArrayList<>();

        // starting remove the element of largest occurance untill size is smaller than arr.length/2
        while (count > arr.length/2){
            int[] currentElement = heap.poll();

            result.add(currentElement[0]);
            count = count - currentElement[1];
        }

        return result.size();
    }
}

