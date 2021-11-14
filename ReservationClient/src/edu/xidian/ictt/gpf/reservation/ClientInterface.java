package edu.xidian.ictt.gpf.reservation;

import edu.xidian.ictt.gpf.reservation.ReservationServiceStub.CheckAvailable;
import edu.xidian.ictt.gpf.reservation.ReservationServiceStub.CheckAvailableResponse;
import edu.xidian.ictt.gpf.reservation.ReservationServiceStub.CheckPhoneNumber;
import edu.xidian.ictt.gpf.reservation.ReservationServiceStub.CheckPhoneNumberResponse;
import edu.xidian.ictt.gpf.reservation.ReservationServiceStub.Cancel;
import edu.xidian.ictt.gpf.reservation.ReservationServiceStub.CancelResponse;

public class ClientInterface {

    private ClientInterface() {}

    static private ReservationServiceStub stub;

    static {
        try {
            stub = new ReservationServiceStub("http://10.170.63.21:8080/axis2/services/ReservationService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkAvailable(boolean param0, boolean param1) {
        try {
            CheckAvailable req = new CheckAvailable();
            req.setArgs0(param0);
            req.setArgs1(param1);
            CheckAvailableResponse res = stub.checkAvailable(req);
            return res.get_return();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n\n");
            return false;
        }
    }

    public static boolean checkPhoneNumber(boolean param0, boolean param1, String param2) {
        try {
            CheckPhoneNumber req = new CheckPhoneNumber();
            req.setArgs0(param0);
            req.setArgs1(param1);
            req.setArgs2(param2);
            CheckPhoneNumberResponse res = stub.checkPhoneNumber(req);
            return res.get_return();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n\n");
            return false;
        }
    }

    public static int cancel(String param0) {
        try {
            Cancel req = new Cancel();
            req.setArgs0(param0);
            CancelResponse res = stub.cancel(req);
            return res.get_return();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n\n");
            return -1;
        }
    }

}
