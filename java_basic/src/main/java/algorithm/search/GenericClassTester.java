package algorithm.search;

public class GenericClassTester {
    static class GeneriaClass<T>{
        private T xyz;
        GeneriaClass(T t){
            this.xyz = t;
        }

        T getXyz(){
            return xyz;
        }
    }

    public static void main(String[] args){
        GeneriaClass<String> s = new GeneriaClass<>("ABC");
        GeneriaClass<Integer> n = new GeneriaClass<>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
