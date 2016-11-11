package com.sussex.ase1.gpstry3;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;



/**
 * Created by User on 09/11/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void validPostcode() throws Exception {
        String[] goodPostcodes = {"BN7 2AZ", "TN22 1QW", "BN3 3WD"};
        String[] badPostcodes = {"QN1 3AZ", "BN275 1A", "ZZ12 3AX"};

        for (int i = 0; i < goodPostcodes.length; i++) {

            String[] pArray = goodPostcodes[i].toUpperCase().trim().split(" ");
            String areaDistrict = pArray[0];

            String sectorUnit = "";
            if (pArray.length == 2)
                sectorUnit = pArray[1];

            String aMatch = "";
            String sMatch = "";

            switch (areaDistrict.length()) {
                case 1:
                    aMatch = "[A-Z&&[^QVX]]";
                    break;
                case 2:
                    aMatch = "([A-Z&&[^QVX]][0-9])|([A-Z&&[^QVX]][A-Z&&[^IJZ]])";
                    break;
                case 3:
                    aMatch = "(([A-Z&&[^QVX]][0-9][0-9])|([A-Z&&[^QVX]][A-Z&&[^IJZ]][0-9])|([A-Z&&[^QVX]][0-9][A-HJKPSTUW]))";
                    break;
                case 4:
                    aMatch = "(([A-Z&&[^QVX]][A-Z&&[^IJZ]][0-9][0-9])|([A-Z&&[^QVX]][A-Z&&[^IJZ]][0-9][ABEHMNPRVWXY]))";
                    break;
                default:
                    ;
            }

            switch (sectorUnit.length()) {
                case 1:
                    sMatch = "[0-9]";
                    break;
                case 2:
                    sMatch = "([0-9][A-Z&&[^CIKMOV]])";
                    break;
                case 3:
                    sMatch = "([0-9][A-Z&&[^CIKMOV]]{2})";
                    break;
                default:
                    ;
            }

            MainActivity aaa = mActivityRule.getActivity();

            String logString = "";

            if (aaa.validPostcode(goodPostcodes[i]) == (areaDistrict.matches(aMatch) == sectorUnit.matches(sMatch))) {
                logString = goodPostcodes[i] + " true";
            }else {
                logString = goodPostcodes[i] + " false";
            }
            Log.e("TASE1_VALID_POSTCODE", logString);
        assertTrue(aaa.validPostcode(goodPostcodes[i]) == (areaDistrict.matches(aMatch) == sectorUnit.matches(sMatch)));

        }


    }

}