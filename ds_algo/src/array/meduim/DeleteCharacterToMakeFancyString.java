package array.meduim;

public class DeleteCharacterToMakeFancyString {

    public static void main(String[] args) {

        DeleteCharacterToMakeFancyString  deleteCharacterToMakeFancyString = new DeleteCharacterToMakeFancyString();
        String s = "a";
        String result = deleteCharacterToMakeFancyString.makeFancyString(s);

        System.out.println(result);

    }

    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0;i<=1 && i< arr.length;i++){
            result.append(arr[i]);
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]==arr[i-1] && arr[i]==arr[i-2]){
                //result.append(arr[i]);
            }
            else{
                result.append(arr[i]);
            }
        }

        return result.toString();

    }
}
