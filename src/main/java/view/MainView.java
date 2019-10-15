package view;

import exceptions.AgeException;
import exceptions.WrongChoiceException;
import model.Address;
import model.Operator;
import model.User;
import ansi.ColorServiceImpl;
import patterns.NamePattern;
import operators.OperatorServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.Scanner;

public class MainView {

    private static final OperatorServiceImpl OPERATOR_SERVICE = new OperatorServiceImpl();
    private static final ColorServiceImpl COLOR_SERVICE = new ColorServiceImpl();
    private static final NamePattern NAME_PATTERN = new NamePattern();

    public void view(EntityManager entityManager, User user, Address address) {
        EntityTransaction et = entityManager.getTransaction();
        et.begin();
        try (Scanner scanner = new Scanner(System.in)) {
            mainInfoAboutServices();
            System.out.println("Where are you from?\n1 - POLAND \n2 - GERMANY " +
                    "\n3 - ENGLAND \n4 - FRANCE \n5 - OTHER COUNTRY");
            address.setCountry(countrySet(""));
            System.out.print("City : ");
            address.setCity(scanner.nextLine());
            System.out.print("Post-code : ");
            address.setPostCode(scanner.nextLine());
            System.out.print("Street (only name of street) : ");
            address.setStreetName(scanner.nextLine());
            System.out.print("Home number : ");
            address.setHomeNumber(scanner.next());
            System.out.print("First name : ");
            user.setFirstName(NAME_PATTERN.firstName());
            System.out.print("Last name : ");
            user.setLastName(NAME_PATTERN.lastName());
            ageValidation(user);
            user.setAddress(address);
            setOperatorService();
            chooseOperator(user);
            entityManager.persist(address);
            entityManager.persist(user);
            et.commit();
            entityManager.close();
            COLOR_SERVICE.result();
            COLOR_SERVICE.leaveMessage(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void chooseOperator(User user) {
        Operator[] operators = Operator.values();
        boolean finish = false;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!finish) {
                switch (scanner.nextInt()) {
                    case 1: {
                        user.setOperator(Operator.ORANGE);
                        System.out.println("Your choice is : ");
                        COLOR_SERVICE.setAnsiOrange();
                        user.setPhoneNumber(OPERATOR_SERVICE.orange());
                        COLOR_SERVICE.getNumber(user);
                        System.out.println("[PRESS 0 TO EXIT]");
                        break;
                    }
                    case 2: {
                        user.setOperator(Operator.PLAY);
                        System.out.println("Your choice is : ");
                        COLOR_SERVICE.setAnsiPlay();
                        user.setPhoneNumber(OPERATOR_SERVICE.play());
                        COLOR_SERVICE.getNumber(user);
                        System.out.println("[PRESS 0 TO EXIT]");
                        break;
                    }
                    case 3: {
                        user.setOperator(Operator.PLUS);
                        System.out.println("Your choice is : ");
                        COLOR_SERVICE.setAnsiPlus();
                        user.setPhoneNumber(OPERATOR_SERVICE.plus());
                        COLOR_SERVICE.getNumber(user);
                        System.out.println("[PRESS 0 TO EXIT]");
                        break;
                    }
                    case 4: {
                        user.setOperator(Operator.T_MOBILE);
                        System.out.println("Your choice is : ");
                        COLOR_SERVICE.setAnsiTmobile();
                        user.setPhoneNumber(OPERATOR_SERVICE.tMobile());
                        COLOR_SERVICE.getNumber(user);
                        System.out.println("[PRESS 0 TO EXIT]");
                        break;
                    }
                    case 0: {
                        finish = true;
                        break;
                    }
                    default:
                        throw new WrongChoiceException("Not found operator id : " + "'" + scanner.next() + "'" +
                                "\navailable operators " + Arrays.toString(operators));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     String countrySet(String country) {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                country = "Poland";
                break;
            case 2:
                country = "Germany";
                break;
            case 3:
                country = "England";
                break;
            case 4:
                country = "France";
                break;
            case 5:
                System.out.println("Please enter your country (in english please) : ");
                country = scanner.next();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
        }
        return country;
    }

     void ageValidation(User user) {
        int age = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age : ");
        age = scanner.nextInt();
        if (age > 18) {
            user.setAge(age);
        } else {
            throw new AgeException("Only adults can use from our service");
        }
    }

     void mainInfoAboutServices() {
        System.out.println("Welcome to the call center");
        System.out.println("***************************");
        System.out.println("*INFORMATIONS*");
        System.out.println("1. Only adults can use our services" +
                "\n2. Our services offer setting up a phone number in a selected mobile operator" +
                "\n3. Available operators : [ORANGE/PLAY/PLUS/T-MOBILE]" +
                "\n4 - Telephone numbers will have a unique starting digit depending " +
                "on the operator\nORANGE - 5********\nPLAY - 6********\nT-MOBILE - 7********\nPLUS - 8********" +
                "\n5 - By using our services you agree to the processing of personal data in the database");
        System.out.println("***************************");
        System.out.println("Fill in the form");
    }
    void setOperatorService(){
        System.out.println("Please choose your mobile operator in which we will register your number");
        System.out.print("[PRESS 1 TO CHOOSE : ");
        COLOR_SERVICE.setAnsiOrange();
        System.out.println("]");
        System.out.print("[PRESS 2 TO CHOOSE : ");
        COLOR_SERVICE.setAnsiPlay();
        System.out.println("]");
        System.out.print("[PRESS 3 TO CHOOSE : ");
        COLOR_SERVICE.setAnsiPlus();
        System.out.println("]");
        System.out.print("[PRESS 4 TO CHOOSE : ");
        COLOR_SERVICE.setAnsiTmobile();
        System.out.println("]");
        System.out.println("********************");
    }
}