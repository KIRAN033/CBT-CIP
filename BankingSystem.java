import java.io.*;
import java.time.LocalDate;
class BankingSystem{
static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
static Customer custArr[]=new Customer[100];
static int pos=-1;

//MAIN METHOD
public static void main (String args[])throws IOException
{
while(true){
System.out.println(" Welcome To Banking System");
System.out.println("======================================================================");
String opt[]={"Create Account","Deposit Amount","Withdraw Amount","Change Pin","Reset Password","View Account Balance","Exit"};



System.out.println("Press Options");
System.out.println("======================================================================");

for(int i=0;i<opt.length;i++){
System.out.println((i+1)+" "+opt[i]);
}
System.out.println("======================================================================");
System.out.println("Enter your Option: ");

int option = Integer.parseInt(r.readLine());
if(option>0 && option<=7)
{
if(option==1){
createAccount();
System.out.println(" Press R (Return) for returning to main Menu and any other key for exiting.");
String choice=r.readLine();
if(choice.equalsIgnoreCase("R")|| choice.equalsIgnoreCase("Return"))
continue;
else
break;
}
else if(option==2)
{
int res = deposit();
if(res==1)
continue;
else
break;
}

else if(option==3){
int res = withdraw();
if(res==1)
continue;
else
break;
}

else if(option==4){

    int res = changePin();
    if(res==1)
    continue;
    else
    break;
    
    } else if(option==5){
    int res = changePassword();
    if(res==1)
    continue;
    else
    break;
    
    } else if(option==6){
    int res = viewBalance();
    if(res==1)
    continue;
    else
    break;
    }

    else
    break;

    }else{
        System.out.println("Entered Wrong choice.Do you want to continue with correct choice? Press Y for 1YES , Any other character for Exiting : ");
    String choice=r.readLine();
    if(choice.equalsIgnoreCase("Y")|| choice.equalsIgnoreCase("Yes"))
    continue;
    else
    break;
    }
    }
    }


//CREATE ACCOUNT

    private static void createAccount()throws IOException
    {
    System.out.println("Enter your name: ");
    String name=r.readLine();
    String accNo=(int)(Math.random()*100)+"7890"+(int)(Math.random()*100);
    System.out.println("Enter your Phone Number: ");
    Long phNo=Long.parseLong(r.readLine());
    double balance=0.0;
    System.out.println("Set your Pin: ");
    int pin = Integer.parseInt(r.readLine());
    System.out.println("Set your Password: ");
    String password=r.readLine();
    System.out.println("------------------------------------------------------------------");
    System.out.println("Your account has been created. Your account number is "+accNo+" . Please keep a note of your Account Number , Pin and Password which will be required for any transactions.");
    
    Customer c = new Customer(name,accNo,phNo,balance,pin,password);
    custArr[++pos]=c;
    }



    //DIPOSITE
    private static int deposit()throws IOException
{
System.out.println("Enter your account Number : ");
String accNo=r.readLine();
System.out.println("Enter Pin :");
int pin = Integer.parseInt(r.readLine());
boolean flg=false;
for(Customer c : custArr){
if(c!=null && c.accNo.equals(accNo)){
if(c.pin==pin){

System.out.println("Enter the amount to be deposited: ");
double depo=Double.parseDouble(r.readLine());
c.balance+=depo;
flg=true;
break;
}
}
} if(!flg)
{
System.out.println("Your credentials are wrong.\n-----------------------------------");
}
else{
System.out.println("You have successfully deposited.\n------------------------------------- ");
}
System.out.println(" Press R (Return) for returning to main Menu and any other key for exiting.");
String choice=r.readLine();
if(choice.equalsIgnoreCase("R")|| choice.equalsIgnoreCase("Return"))
return 1;
else
return 0;
}

//WITHDRAW

private static int withdraw()throws IOException
{
System.out.println("Enter your account Number : ");
String accNo=r.readLine();
System.out.println("Enter Pin :");
int pin = Integer.parseInt(r.readLine());
boolean flg=false;
for(Customer c : custArr){
if(c.accNo.equals(accNo)){
if(c!=null && c.pin==pin){

System.out.println("Enter the amount to be withdrawn: ");
double wd=Double.parseDouble(r.readLine());

if(c.balance>wd)
{
c.balance-=wd;
System.out.println("You have successfully withdrawn.\n------------------------------------- ");
}
else
System.out.println("Insufficient Balance\n----------------");
flg=true;
break;

}

}
}
if(!flg)
{
System.out.println("Your credentials are wrong.\n-----------------------------------");
}
System.out.println(" Press R (Return) for returning to main Menu and any other key for exiting.");
String choice=r.readLine();
if(choice.equalsIgnoreCase("R")|| choice.equalsIgnoreCase("Return"))
return 1;
else
return 0;
}

// CHANGE PIN 

private static int changePin()throws IOException
{
System.out.println("Enter your account Number : ");
String accNo=r.readLine();
System.out.println("Enter password :");
String pass = r.readLine();
boolean flg=false;
for(Customer c : custArr){
if(c!=null && c.accNo.equals(accNo)){
if(c.password.equalsIgnoreCase(pass)){
System.out.println("Enter the new pin:");
int pin = Integer.parseInt(r.readLine());
c.pin=pin;
flg=true;
break;
}
}
}
if(!flg)
{
System.out.println("Your credentials are wrong.\n-----------------------------------");
}
else{
System.out.println("You have successfully changed pin.\n------------------------------------- ");
}
System.out.println(" Press R (Return) for returning to main Menu and any other key for exiting.");
String choice=r.readLine();
if(choice.equalsIgnoreCase("R")|| choice.equalsIgnoreCase("Return"))
return 1;
else
return 0;
}


//CHANGE PASSWORD
private static int changePassword()throws IOException{

System.out.println("Enter your account Number : ");
String accNo=r.readLine();
System.out.println("Enter Pin :");
int pin = Integer.parseInt(r.readLine());
boolean flg=false;
for(Customer c : custArr){
if(c!=null && c.accNo.equals(accNo)){
if(c.pin==pin){

System.out.println("Enter the new password: ");
String pass=r.readLine();
c.password=pass;
System.out.println("You have successfully changed password.");
System.out.println("---------------------------------------------");

flg=true;
break;
}
}
}
if(!flg)
{
System.out.println("Your credentials are wrong.");
System.out.println("---------------------------------------------");

}
System.out.println(" Press R (Return) for returning to main Menu and any other key for exiting.");
String choice=r.readLine();
if(choice.equalsIgnoreCase("R")|| choice.equalsIgnoreCase("Return"))
return 1;
else
return 0;
}

//VIEW BALANCE
private static int viewBalance()throws IOException
{
System.out.println("Enter your account Number : ");
String accNo=r.readLine();
System.out.println("Enter Pin :");
int pin = Integer.parseInt(r.readLine());
boolean flg=false;
for(Customer c : custArr){
if(c!=null && c.accNo.equals(accNo)){
if(c.pin==pin){
c.printBalance();
flg=true;
break;
}
}
}
if(!flg)
{
System.out.println("Your credentials are wrong.");
System.out.println("---------------------------------------------");

}
System.out.println(" Press R (Return) for returning to main Menu and any other key for exiting.");
String choice=r.readLine();
if(choice.equalsIgnoreCase("R")|| choice.equalsIgnoreCase("Return"))
return 1;
else
return 0;
}
}

//CUSTOMER 

class Customer{
public String name;
String accNo;
Long phNo;
double balance;
int pin;
String password;
public Customer(String name,String accNo,Long phNo,double balance,int pin,String password){
this.name=name;
this.accNo=accNo;
this.phNo=phNo;
this.balance=balance;
this.pin=pin;
this.password=password;
}
public void printBalance(){
System.out.println("Your acoount with account number : *****"+accNo.substring(accNo.length()-3)
+" has Rs"+balance);
}
}