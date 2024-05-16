import java.util.Scanner;
class Trees {
 char Zone;
 int id;
 String Kind;
 float Weight;
 float Height;
 int Quantity;
 int price;
 // Display 
 void Display() {
 System.out.printf("%d\t%c\t%s\t%.2f\t%.2f\t%d\t\t%d%n", id, Zone, Kind, Weight, 
Height, Quantity, price);
 }
 // Search Particular Record 
 void P_Search(Trees[] obj) {
 Scanner input = new Scanner(System.in);
 char zone;
 System.out.println("Enter the Zone for Searching... ");
 zone = input.next().charAt(0);
 boolean found = false;
 for (int i = 0; i < obj.length; i++) {
 if (zone == obj[i].Zone) {
 System.out.println("Match found:");
 obj[i].Display();
 found = true;
 break;
 }
 }
 if (!found) {
 System.out.println("No match found for the given zone.");
 }
 }
 //Search By Kind 
 void Kind_Search(Trees[] obj) {
 Scanner input = new Scanner(System.in);
 String kind;
 System.out.println("Enter the Kind for Searching... ");
 kind = input.nextLine();
 boolean found = false;
 for (int i = 0; i < obj.length; i++) {
 if (kind.equals(obj[i].Kind)) {
 System.out.println("Match found:");
 obj[i].Display();
 found = true;
 break;
 }
 }
 if (!found) {
 System.out.println("No match found for the given Kind.");
 }
 }
 // Update Records
 void Update_Record(Trees[] obj) {
 Scanner input = new Scanner(System.in);
 int id;
 System.out.println("Enter the ID of your Product : ");
 id = input.nextInt();
 for (int i = 0; i < obj.length; i++) {
 if (id == obj[i].id) {
 System.out.println("Record Match \n \t Please wait....");
 System.out.println("Enter the New ID of Timber : ");
 obj[i].id = input.nextInt();
 System.out.println("Enter the New Zone of Timber : ");
 obj[i].Zone = input.next().charAt(0);
 System.out.println("Enter the New Kind of Timber : ");
 input.nextLine(); // consume newline left by previous nextInt()
 obj[i].Kind = input.nextLine();
 System.out.println("Enter the New Weight of Timber : ");
 obj[i].Weight = input.nextFloat();
 System.out.println("Enter the New Height of Timber : ");
 obj[i].Height = input.nextFloat();
 System.out.println("Enter the New Quantity of Timber : ");
 obj[i].Quantity = input.nextInt();
 System.out.print("Enter the New Price of Timber : ");
 obj[i].price = input.nextInt();
 break; // Exit loop after updating record
 }
 }
 }
 // Delete Records
 void Delete_Record(Trees[] obj) {
 Scanner input = new Scanner(System.in);
 int id;
 System.out.println("Enter the ID of your Product : ");
 id = input.nextInt();
 for (int i = 0; i < obj.length; i++) {
 if (id == obj[i].id) {
 obj[i].Zone = 0;
 obj[i].id = 0;
 obj[i].Kind = null;
 obj[i].Weight = 0;
 obj[i].Height = 0;
 obj[i].price = 0;
 obj[i].Quantity = 0;
 break; // Exit loop after updating record
 }
 }
 }
 // Analysis Reports
 void Analysis(Trees[] obj)
 {
 Scanner input = new Scanner(System.in);
 for(int i = 0; i < obj.length;i++)
 {
 if(obj[i].Quantity < 100)
 {
 obj[i].Display();
 }
 }
 }
 //Sales
 void Sales_update(Trees[] obj)
 {
 Scanner input = new Scanner(System.in);
 int id;
 System.out.println(" Enter the TimberID to be sold : ");
 id = input.nextInt();
 int quantity = 0;
 for(int i = 0; i < obj.length; i++)
 {
 if(id == obj[i].id)
 {
 System.out.println("ID Match....!");
 System.out.println("Enter the Quantity to be sold : ");
 quantity = input.nextInt();
 if(quantity > obj[i].Quantity)
 {
 System.out.println("You have Limited Quantity ");
 }
 else
 {
 quantity = obj[i].Quantity - quantity;
 obj[i].Quantity = quantity;
 }
 break;
 }
 }
 
 }
}
class Timber_Store {
 public static void main(String args[]) {
 Scanner input = new Scanner(System.in);
 int choice = 0;
 System.out.println("********<< Welcome to TImber Store >>**********");
 int items;
 System.out.println("Enter the number of Items you want to Store : ");
 items = input.nextInt();
 Trees[] obj = new Trees[items];
 while (choice != 8) {
 System.out.println("**********( Welcome to Timber Store )***********");
 System.out.println("[1] => Add new Timber Records ");
 System.out.println("[2] => Display all records");
 System.out.println("[3] => Display particular records by kind ");
 System.out.println("[4] => Analysis of records ");
 System.out.println("[5] => Sales Update Reports ");
 System.out.println("[6] => Delete particular Timber Records ");
 System.out.println("[7] => Update particular Timber Records ");
 System.out.println("[8] => Exit ");
 System.out.print("Choice: ");
 choice = input.nextInt();
 switch (choice) {
 case 1:
 for (int i = 0; i < obj.length; i++) {
 obj[i] = new Trees();
 System.out.println("Enter the ID of Timber : ");
 obj[i].id = input.nextInt();
 System.out.println("Enter the Zone of Timber : ");
 obj[i].Zone = input.next().charAt(0);
 System.out.println("Enter the Kind of Timber : ");
 input.nextLine(); // consume newline left by previous nextInt()
 obj[i].Kind = input.nextLine();
 System.out.println("Enter the Weight of Timber : ");
 obj[i].Weight = input.nextFloat();
 System.out.println("Enter the Height of Timber : ");
 obj[i].Height = input.nextFloat();
 System.out.println("Enter the Quantity of Timber : ");
 obj[i].Quantity = input.nextInt();
 System.out.print("Enter the Price of Timber : ");
 obj[i].price = input.nextInt();
 }
 break;
 case 2:
 System.out.println("Displaying records using Zone");
 System.out.println("ID\tZone\tKind\tWeight\tHeight\tQuantity\tPrice");
 
 obj[0].P_Search(obj);
 
 break;
 case 3:
 System.out.println("Display particular records Kind");
 System.out.println("ID\tZone\tKind\tWeight\tHeight\tQuantity\tPrice");
 
 obj[0].Kind_Search(obj);
 break;
 case 4:
 System.out.println("Analysis of records");
 System.out.println("ID\tZone\tKind\tWeight\tHeight\tQuantity\tPrice");
 obj[0].Analysis(obj);
 break;
 case 5:
 System.out.println("Sales Update Reports");
 obj[0].Sales_update(obj);
 break;
 case 6:
 System.out.println("Delete particular Timber Records");
 
 obj[0].Delete_Record(obj);
 
 break;
 case 7:
 System.out.println("Update particular Timber Records");
 
 obj[0].Update_Record(obj);
 break;
 case 8:
 System.out.println("Exiting...");
 break;
 default:
 System.out.println("Invalid choice");
 break;
       }
     }
   }
}