package algorithm.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Comparator를 구현하여 자연정렬처리
 * 주어진 데이터가 내림차순으로 정렬이 되어 있어야 함. (이전 탐색이므로 )
 */
public class PhysExamSearch2 {
    static class PhyscData{
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString(){
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private  static class VisionOrderComparator implements Comparator<PhyscData>{
            public int compare(PhyscData d1, PhyscData d2){
                return (d1.vision > d2.vision) ? -1 :
                        (d1.vision < d2.vision) ? 1 : 0;
            }
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

//        PhyscData[] x = {
//                new PhyscData("이수민", 175,2.0),
//                new PhyscData("홍준기", 171,1.5),
//                new PhyscData("이호연", 174,1.2),
//                new PhyscData("김한결", 169,0.8),
//                new PhyscData("전서현", 173,0.7),
//                new PhyscData("이나령", 162,0.3),
//                new PhyscData("유지훈", 168,0.4),
//        };

        PhyscData[] x = {
                new PhyscData("이나령", 162,0.3),
                new PhyscData("유지훈", 168,0.4),
                new PhyscData("김한결", 169,0.8),
                new PhyscData("홍준기", 171,1.5),
                new PhyscData("전서현", 173,0.7),
                new PhyscData("이호연", 174,1.2),
                new PhyscData("이수민", 175,2.0),
        };

        // 데이터를 정렬한 후에
        Arrays.sort(x, PhyscData.VISION_ORDER);

        System.out.print("시력인 몇 인 사람을 찾고 있나요? : ");
        double vision  = stdIn.nextDouble();

        // 이진 탐색으로 검색
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("",0,vision),
                PhyscData.VISION_ORDER
        );

        if(idx < 0)
            System.out.println("그 값의 요소가 없습니다.");
        else{
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : "+ x[idx]);

        }

    }
}
