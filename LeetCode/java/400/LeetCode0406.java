public class LeetCode0406{
    public int[][] reconstructQueue(int[][] people) {
        for (int i = 1;i < people.length;i++){
            int h = people[i][0];
            int r = people[i][1];
            int j = i - 1;
            while (j > 0 && people[j][0] > h){
                people[j+1][0] = people[j][0];
                people[j+1][1] = people[j][1];
                j--;
            }
            people[j+1][0] = h;
            people[j+1][1] = r;
        }
        for (int i = 0;i < people.length;i++){
            if (people[i][1] > i && people[people[i][1]][1] < people[i][1]){
                swap(people, people[i][1], i);
            } else if (people[i][1] < i && people[i][0] < people[people[i][1]][0]){
                swap(people, i, people[i][1]);
            }
        }
        return people;
    }

    public void swap(int[][] arr,int x,int y){
        int height = arr[x][0];
        int rank = arr[x][1];
        arr[x][0] = arr[y][0];
        arr[x][1] = arr[y][1];
        arr[y][0] = height;
        arr[y][1] = rank;
    }
}