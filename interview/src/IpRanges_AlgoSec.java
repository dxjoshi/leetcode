/*
########## IP and IP Ranges Definitions
192.168.0.0 - 192.168.0.255 (192.168.0.44 is in this range)
192.168.0.0 - 192.168.0.0
Invalid range: 192.168.0.255 - 192.168.0.0
lowAddr <= highAddr

########## IP represnentation as integers (unsigned 32bits)
//IP to Decimal examples
192.168.1.0 - 192.168.1.255
192.168.1.0 = 3232235776
192.168.1.1 = 3232235777
192.168.1.2 = 3232235778
######### Range calculation example
192.168.1.255 = 3232236031
192.168.1.0 = 3232235776
192.168.1.255 - 192.168.1.0
3232236031 - 3232235776 + 1 = 256
3232236031 - 3232235776 = 255
192.168.1.255 - (minus) 192.168.1.0 = 255
3232236031 - 3232235776 = 255
Wifi: 192.168.1.0 - 192.168.1.255
Lan (Cable): 192.168.44.0 - 192.168.44.255


Reminder - ** lowAddr <= highAddr (Promised)

################ The Task ######################

// Task
// Implement a function named
// boolean contains(ipRanges ipRanges1, ipRanges ipRanges2)
// Function should return true if ipRanges1 contains all ranges in ipRanges2
// False otherwise.

contains ( {10-30}, {15-17}) = True
contains ( {10-20,30-40}, {15-17}) = True
contains ( {10-20,30-40}, {35-37}) = True
contains ( {10-20,30-40}, {15-17,35-37}) = True
contains ( {10-20,30-40}, {20-25}) = False
contains ( {10-20,30-40}, {20-25}) = False
*/

// Task Implement a function named boolean contains(ipRanges ipRanges1, ipRanges ipRanges2) Function should return true if ipRanges1 contains all ranges in ipRanges2 False otherwise.


import java.util.Arrays;

public class IpRanges_AlgoSec {

    public class ipRange {
        public int lowAddr; // 32 bits
        public int highAddr;
    }

    public class ipRanges {
        public String name;
        public ipRange[] ipRangeArr;
    }


    boolean contains(ipRanges ipRanges1, ipRanges ipRanges2) {
        ipRange[] range1 = ipRanges1.ipRangeArr;
        ipRange[] range2 = ipRanges2.ipRangeArr;
        Arrays.sort(range1, (a, b) -> a.lowAddr - b.lowAddr);
        Arrays.sort(range2, (a, b) -> a.lowAddr - b.lowAddr);
        int n = range1.length;
        int m = range2.length;

        int j = 0;    // 0 to m-1

        int low = range2[j].lowAddr;
        int high = range2[j].highAddr;

        for (int i = 0; i < n && j < m; i++) {
            // ipRange in 2 is contained in the ipRange in 1
            if (range1[i].lowAddr <= low && range1[i].highAddr >= high) {
                ++j;
                low = range2[j].lowAddr;
                high = range2[j].highAddr;

            } else if (!(range1[i].lowAddr <= low && range1[i].highAddr >= high)) {
                return false;
            } else {
                // ipRange in 2 is outside the ipRange in 1
                if (range1[i].lowAddr <= low && range1[i].highAddr >= low) {
                    low = Math.max(low, range1[i].highAddr) + 1;
                } else if (range1[i].lowAddr <= high && range1[i].highAddr >= high) {
                    high = Math.min(high, range1[i].lowAddr) + 1;
                    ;
                }
            }
        }
        return j == m ? true : false;
    }
}