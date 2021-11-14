package edu.xidian.ictt.gpf.reservation;

import java.util.Scanner;

public class ClientCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean tomorrow;
        boolean internal;
        String phoneNumber;
        loop: while (true) {
            System.out.println("0.quit\n1.reserve\n2.cancle");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    break loop;
                case 1:
                    System.out.println("0.tomorrow\n1.the day after tomorrow");
                    tomorrow = scanner.nextInt() == 0;
                    System.out.println("0.internal\n1.outernal");
                    internal = scanner.nextInt() == 0;
                    scanner.nextLine();
                    if (ClientInterface.checkAvailable(tomorrow, internal)) {
                        while (true) {
                            System.out.println("phone number:");
                            phoneNumber = scanner.nextLine();
                            if (ClientInterface.checkPhoneNumber(tomorrow, internal, phoneNumber)) {
                                System.out.println("Success reserving.");
                                break;
                            } else {
                                System.out.println("retry.");
                            }
                        }
                    } else {
                        System.out.println("not available.");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    innerloop: while (true) {
                        System.out.println("phone number:");
                        phoneNumber = scanner.nextLine();
                        switch (ClientInterface.cancel(phoneNumber)) {
                            case 0:
                                System.out.println("phone number length error.");
                                break;
                            case 1:
                                System.out.println("phone number has no reservation.");
                                break;
                            case 2:
                                System.out.println("Success canceling.");
                                break innerloop;
                            default:
                                System.out.println("wrong ret.");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("wrong option.");
                    break;
            }
        }
        scanner.close();
    }

}
