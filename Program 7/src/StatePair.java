
public class StatePair <Type1 extends Comparable<Type1>, Type2 extends Comparable<Type2>> {
   private Type1 value1;
   private Type2 value2;
   
   // TODO: Define a constructor, mutators, and accessors 
   //       for StatePair
   
   public StatePair (Type1 value1, Type2 value2){
      this.value1 = value1;
      this.value2 = value2;
   }
   
   public void setKey(Type1 value1){
      this.value1 = value1;
   }
   
   public Type1 getKey (){
      return this.value1;
   }
   
   public void setValue(Type2 value2){
      this.value2 = value2;
   }
   
   public Type2 getValue(){
      return this.value2;
   }
   
   
   public void printInfo() {
      System.out.println(this.value1 + ": " + this.value2);
   }
   
   
   // TODO: Define printInfo() method
}