package hr.josip.mydata.processing;

import java.util.ArrayList;

public interface Id {
    /**
     * this function asks parameters how much data you want to input
     * returns arrays to function that will really write to the file
     * @param number
     * @return personal id array
     */
    PersonalId[] enterValues(int number);
    boolean findItem(String numberId,File file);
    PersonalId findObject(String numberId,File file);
    boolean findItemByPIN(String PIN,File file);

}
