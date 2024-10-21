package array.meduim;

import java.util.PriorityQueue;

class SolutionTwo {

    public static void main(String[] args) {
        SolutionTwo solutionTwo = new SolutionTwo();

    }
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((A, B)-> -1 * Integer.compare(A.count,B.count));

        init(a,b,c,pq);
        String result = "";

        while(!pq.isEmpty()){

            Pair pop = pq.poll();

            int n = result.length();
            if(result.length()>=2 && pop.c == result.charAt(n-1) && pop.c==result.charAt(n-2)){

                if(pq.isEmpty()){
                    break;

                }
                Pair pop2 = pq.poll();

                result+=String.valueOf(pop2.c);
                pop2.count--;
                if(pop2.count>0){
                    pq.add(new Pair(pop2.c,pop2.count));
                }




            }
            else{
                pop.count--;
                result+=String.valueOf(pop.c);

            }

            if(pop.count>0){
                pq.add(new Pair(pop.c,pop.count));
            }




        }

        return result;

    }

    private void init(int a,int b,int c,PriorityQueue<Pair> pq ){

        if(a>0){
            pq.add(new Pair('a',a));
        }
        if(b>0){
            pq.add(new Pair('b',b));

        }
        if(c>0){
            pq.add(new Pair('c',c));

        }


    }


    class Pair{
        char c;
        int count = 0;
        public Pair(char c ,int count){
            this.c = c;
            this.count = count;
        }
    }
}
