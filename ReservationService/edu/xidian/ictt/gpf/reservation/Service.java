package edu.xidian.ictt.gpf.reservation;

import java.util.HashMap;
import java.util.Map;

public class Service {

    private Map<Integer, Integer> remainAmount;
    private Map<String, Integer> reservedPhoneNumber;

    public Service() {
        remainAmount = new HashMap<Integer, Integer>();
        remainAmount.put(0, 2);
        remainAmount.put(1, 2);
        remainAmount.put(2, 2);
        remainAmount.put(3, 2);
        reservedPhoneNumber = new HashMap<String, Integer>();
    }

    // check the remain amount
    public boolean checkAvailable(boolean tomorrow, boolean internal) {
        int key = ((tomorrow ? 0 : 1) << 1) + (internal ? 0 : 1);
        return remainAmount.get(key) > 0;
    }

    // check the phone number
    public boolean checkPhoneNumber(boolean tomorrow, boolean internal, String phoneNumber) {
        int key = ((tomorrow ? 0 : 1) << 1) + (internal ? 0 : 1);
        if (phoneNumber.length() == 11 && !reservedPhoneNumber.containsKey(phoneNumber)) {
            remainAmount.replace(key, remainAmount.get(key) - 1);
            reservedPhoneNumber.put(phoneNumber, key);
            return true;
        } else {
            return false;
        }
    }

    // cancel the reservation
    public int cancel(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return 0;
        } else if (!reservedPhoneNumber.containsKey(phoneNumber)) {
            return 1;
        } else {
            int key = reservedPhoneNumber.get(phoneNumber);
            remainAmount.replace(key, remainAmount.get(key) + 1);
            reservedPhoneNumber.remove(phoneNumber);
            return 2;
        }
    }
    
}