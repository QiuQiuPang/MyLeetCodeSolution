import java.util.*;

class Solution_692 {
    public static void main(String[] args) {
        String[] input = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(input,2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        for(String word :words){
            int freq = 1;
            if(wordMap.containsKey(word)) freq += wordMap.get(word);
            wordMap.put(word,freq);
        }
        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>(
                (x,y)->y.getValue().equals(x.getValue())?x.getKey().compareTo(y.getKey()):y.getValue()-x.getValue()
        );
        for(Map.Entry<String, Integer> entry: wordMap.entrySet()){
            heap.add(entry);
        }
        List<String> result = new ArrayList<>();
        while(!heap.isEmpty()){
            result.add(heap.poll().getKey());
            if(result.size()==k) break;
        }
        return result;

    }
}