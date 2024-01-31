class Solution{
public:
    // Function to find majority element in the array
    // a: input array
    // size: size of input array
    int majorityElement(int a[], int size)
    {
        int candidate = 0, count = 0;
        for(int i = 0 ; i < size ; i++){
            if(count == 0){
                candidate = a[i];
            }
            count += (candidate == a[i]) ? 1 : -1;
        }
        count = 0;
        for(int i =  0 ; i<size ; i++){
            if(candidate == a[i]) count ++;
        }
        return (count > size/2) ? candidate : -1;
    }
};