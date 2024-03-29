
public class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findKth(a,0,n-1,K);
    }
    public int partation(int[] a,int low,int high){
        int key=a[low];
        while(low<high){
            while(low<high&&a[high]<=key)
                high--;
            a[low]=a[high];
            while(low<high&&a[low]>=key)
                low++;
            a[high]=a[low];
        }
        a[low]=key;
        return low;
    }
    public int findKth(int[] a,int low,int high,int k){
        int part=partation(a,low,high);
        
        if(k==part-low+1)
            return a[part];
        else if(k>part-low+1)
            return findKth(a,part+1,high,k-part+low-1);
        else return findKth(a,low,part-1,k);
    }
}