import java.util.*;

public class TreeTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int round = scanner.nextInt();
        for(int i=0; i< round;i++){
            int numOfNode = scanner.nextInt();
            int[] rankTable = new int[numOfNode+1] , teamTable = new int[numOfNode+1];
            for(int j=1; j<numOfNode+1; j++){
                int curTeam = scanner.nextInt();
                teamTable[j] = curTeam;
                rankTable[curTeam] = j;
            }
            int numOfEvent = scanner.nextInt();
            for(int k=0; k<numOfEvent;k++){
                int curType = scanner.nextInt();
                int fromTeam = scanner.nextInt();
                int toRank = scanner.nextInt();
                switch(curType){
                    case 1:
                        int temp = teamTable[fromTeam];
                        for(int t=teamTable[fromTeam]; t>toRank; t--){
                            rankTable[t] = rankTable[t-1];
                            teamTable[rankTable[t]]++;
                        }
                        rankTable[toRank] = fromTeam;
                        teamTable[fromTeam]= toRank;
                        //System.out.println(Arrays.toString(teamTable));
                        //System.out.println(Arrays.toString(rankTable));
                        break;
                    case 2:
                        int count = 0;
                        for(int c=fromTeam; c<=toRank; c++){
                            if(teamTable[c] > numOfNode*0.6) count++;
                        }
                        System.out.println(count);
                        break;
                }
            }

        }
    }



}
