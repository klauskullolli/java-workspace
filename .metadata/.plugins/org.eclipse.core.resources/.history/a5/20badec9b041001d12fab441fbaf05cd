package Questions;

public class Shipping {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        int min ;
        int largeP = items / 5 ; 
        
        if((availableLargePackages*5 + availableSmallPackages) < items)
            return -1 ; 
        else{
            if (largeP>0){
                if(availableLargePackages>largeP){
                    min= largeP + items%largeP ;
                    }
                else {
                    min= availableLargePackages + items%availableLargePackages ;
                }
            }
            
            else
                min=availableSmallPackages ;
        
            
            
        }
        
        
    }
    
    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}