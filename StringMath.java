import java.util.ArrayList;

/**
 * @author Mathew Fan
 * @version 1.0
 */
public class StringMath
{
   /**
    * @param number
    * @return boolen if String is equal to zero
    */
   static boolean isZero(String number)
   {
      for(int i = 0; i < number.length(); i ++)
      {  
         if(!(number.substring(i , i + 1).equals("0")))
         {
            return false;
         }
      }
      return true;
   }

   /**
    * @param number
    * @param numLeadZero
    * @return String number with leading zero
    */
   static String addLeadingZero(String number , int numLeadZero)
   {   
      for(int i = 0; i < numLeadZero; i ++)
      {
         number = "0" + number;
      }
      
      return number;
   }

   /**
    * @param number
    * @param numTrailZero
    * @return String number with Trailing Zero
    */
   static String addTrailingZero(String number , int numTrailZero)
   {
      for(int i = 0; i < numTrailZero; i ++)
      {
         number += "0";
      }
      
      return number;
   }

   /**
    * @param number
    * @return number with removed leading zero
    */
   static String removeLeadingZero(String number)
   {
      String temp;
      
      if(isZero(number))
      {
         return "0";
      }
      
      for(int i = number.length();;i --)
      {  
         if(number.substring(0 , 1).equals("0"))
         {
            number = number.substring(1 , i);
         }
         else
         {
            return number;
         }
      }
   }

   /**
    * @param number
    * @return number with removed trailing zero or "Like no U" if no trailing zeros
    */
   static String removeTrailingZero(String number)
   {
      return "Like no U";
   }

   /**
    * @param num1
    * @param num2
    * @return number with longer length or "Like no U" if numbers are equal
    */
   static String findLong(String num1 , String num2)
   {
      if(num1.length() > num2.length())
      {
         return num1;
      }
      else if(num2.length() > num1.length())
      {
         return num2;
      }
   // else
   // {
         return "Like no U";
   // }
   }

   /**
    * @param num1
    * @param num2
    * @return number with shorter length or "Like no U" if numbers are equal
    */
   static String findShort(String num1 , String num2)
   {
      if(num1.length() < num2.length())
      {
         return num1;
      }
      else if(num2.length() < num1.length())
      {
         return num2;
      }   
   // else
   // {
         return "Like no U";
   // }
   }

   /**
    * @param n1
    * @param n2
    * @return number with larger value or "Like no U" if numbers are equal
    */
   static String findLarge(String n1 , String n2)
   {
      int d1;
      int d2;
      
      String num1 = n1;
      String num2 = n2;

      if(!isZero(num1))
      {
         num1 = removeLeadingZero(num1);
      }
      
      if(!isZero(num2))
      {
         num2 = removeLeadingZero(num2);
      }
      
      int length = findLong(num1 , num2).length();
      
      if(findLong(num1 , num2).equals(num1))
      {
         num2 = addLeadingZero(num2 , num1.length() - num2.length());
      }
      else
      {
         num1 = addLeadingZero(num1 , num2.length() - num1.length());
      }
      
      
      for(int i = 0; i < num1.length(); i ++)
      {
         d1 = Integer.parseInt(num1.substring(i , i + 1));
         d2 = Integer.parseInt(num2.substring(i , i + 1));
         
         if(d1 > d2)
         {
            return n1;
         }
         else if(d2 > d1)
         {
            return n2;
         }
      }
      return "Like no U";
   }

   /**
    * @param num1
    * @param num2
    * @return number with smaller value or "Like no U" if numbers are equal
    */
   static String findSmall(String num1 , String num2)
   {
      return "";
   }

   /**
    * @param number
    * @return number of digits in String number
    */
   static String digitSum(String number)
   {
      String result = "";
      String tempSub;
      
      for(int i = 0; i < number.length(); i ++)
      {
         tempSub = number.substring(i , i + 1);
         result = add(result , tempSub);
      }
      
      return result;
   }

   /**
    * @param num1
    * @param num2
    * @return sum of num1 and num2
    */
   static String add(String  num1 , String num2)
   {
      String result = "";
      
      boolean carry = false;
      
      int numLength;
      int d1;
      int d2;
      int dr;
      
      String digit1;
      String digit2;
   
   
      if(findLong(num1 , num2) == num1)
      {
         num2 = addLeadingZero(num2 , num1.length() - num2.length());
      }
      else if(findLong(num1 , num2) == num2)
      {
         num1 = addLeadingZero(num1 , num2.length() - num1.length());
      }
      
      numLength = num1.length();
      
      for(int i = numLength - 1; i >= 0; i --)
      {
         digit1 = num1.substring(i , i + 1);
         digit2 = num2.substring(i , i + 1);
         
         d1 = Integer.parseInt(digit1);
         d2 = Integer.parseInt(digit2);
         
         dr = d1 + d2;
         
         if(carry == true)
         {
            dr ++;
         }
         
         if(dr > 9)
         {
            dr -= 10;
            carry = true;
         }
         else
         {
            carry = false;
         }
         
         result = String.valueOf(dr) + result;
      }
      
      if(carry == true)
      {
         result = "1" + result;
      }
      
      return result;
   }

   /**
    * @param num1
    * @param num2
    * @return product of num1 and num2
    */
   static String mult(String num1 , String num2)
   {
      String digit1;
      String digit2;
      
      String temp;
      String tempResult = "";
      String carry = "";
      String result;
      
      int d1;
      int d2;
      
      int numTrail = 0;
      
      ArrayList<String> toAdd = new ArrayList<String>();
        
      for(int i = num2.length() - 1; i >= 0; i --)
      {
         digit1 = num2.substring(i , i + 1);
         
         d1 = Integer.parseInt(digit1);
         
         for(int k = num1.length() - 1; k >= 0; k --)
         {
            digit2 = num1.substring(k , k + 1);
            
            d2 = Integer.parseInt(digit2);
            
            temp = String.valueOf(d1 * d2);
            
            temp = add(temp , carry);
            
            if(temp.length() == 2)
            {
               carry = temp.substring(0 , 1);
               temp = temp.substring(1 , 2);
            }
            else
            {
               carry = "";
            }
            
            tempResult = temp + tempResult;
         }
         
         tempResult = carry + tempResult;
         
         tempResult = addTrailingZero(tempResult , numTrail);         
         
         toAdd.add(tempResult);
         
         numTrail ++;
          
         carry = "";
         tempResult = "";
      }
      
      result = "0";
      
      for(int i = 0; i < toAdd.size(); i ++)
      {
         result = add(result , toAdd.get(i));
      }
      
      return result;
   }

   /**
    * @param num1
    * @param num2
    * @return difference of num1 and num2
    */
   static String sub(String num1 , String num2)
   {
      String result = "";
      
      boolean borrow = false;
      
      int numLength;
      int d1;
      int d2;
      int dt;
      int dr;
      
      String digit1;
      String digit2;
   
   
      if(findLong(num1 , num2) == num1)
      {
         num2 = addLeadingZero(num2 , num1.length() - num2.length());
      }
      else if(findLong(num1 , num2) == num2)
      {
         num1 = addLeadingZero(num1 , num2.length() - num1.length());
      }
      
      numLength = num1.length();
      
      for(int i = numLength - 1; i >= 0; i --)
      {
         digit1 = num1.substring(i , i + 1);
         digit2 = num2.substring(i , i + 1);
         
         d1 = Integer.parseInt(digit1);
         d2 = Integer.parseInt(digit2);
         
         if(borrow == true)
         {
            if(d1 == 0)
            {
               d1 = 9;
               borrow = true;
            }
            else
            {
               d1 --;
               borrow = false;
            }  
         }
         
         if(d1 < d2)
         {
            borrow = true;
            d1 += 10;
         }
         
         dr = d1 - d2;
         
              
         result = String.valueOf(dr) + result;
      }
      return result;
   }

   /**
    * @param num1
    * @param num2
    * @return quotant of num1 and num2
    */
   static String div(String num1 , String num2)
   {
      String substring = "";
      String toSub = "";
      
      String result = "";
      
      boolean addZero = false;
      boolean firstTime = true;
      
      for(int i = 0; i < num1.length(); i ++)
      {  
         addZero = false;
                  
         for(int k = i + 1; k <= num1.length(); k ++)
         {
            substring += num1.substring(k - 1 , k);
            if(substring.equals("0"))
            {
               break;
            }
            else if(findLarge(substring , num2).equals(substring) || findLarge(substring , num2).equals(""))
            {
               if(addZero == true && firstTime == false)
               {
                  result += "0";
               }
               firstTime = false;
               break;
            }
            
            if(addZero == true && firstTime == false)
            {
               result += "0";
            }
            
            addZero = true;
            
            i ++;
         }
         
         for(int n = 0; n <= 10; n ++)
         {
            toSub = mult(String.valueOf(n) , num2);
            
            if(findLarge(toSub , substring).equals(toSub))
            {
               result += String.valueOf(n - 1);
               substring = sub(substring , mult(String.valueOf(n - 1) , num2));
               break;
            }
         }
      }
      return result;
   }

   /**
    * @param num1
    * @param num2
    * @return mod of num1 and num2
    */
   static String mod(String num1 , String num2)
   {
      String result;
   
      String div = div(num1 , num2);
      
      div = mult(div , num2);
      
      result = sub(num1 , div);
      
      result = removeLeadingZero(result);
      
      return result;
   }

   /**
    * @param number
    * @return facorial of number
    */
   static String factorial(String number)
   {
      String result = "1";
      
      for(int i = 1; i <= Integer.parseInt(number); i ++)
      {
         result = mult(result , String.valueOf(i));
      }
      
      return result;
   }

   /**
    * @param number
    * @param power
    * @return power of number to its power
    */
   static String pow(String number , String power)
   {
      String result = "1";
      
      for(int i = 0; i < Integer.parseInt(power); i ++)
      {
         result = mult(result , number);
      }
      return result;
   }  
}