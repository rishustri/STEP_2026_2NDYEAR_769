class GymMember {

    private static int memberCounter = 2000;

    private final String membershipNumber;

    protected int monthlyFee;
    protected int feesPaid;

    public GymMember(int monthlyFee) {

        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;

        memberCounter++;

        membershipNumber = "GYM-" + memberCounter;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {

        System.out.println("Payment Mode: " + mode);

        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'G') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {
        return memberCounter - 2000;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }
}


class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(
            int monthlyFee,
            String className) {

        super(monthlyFee);
        this.className = className;
    }
}


class WeeklyProcessor {

    static String processWeeklyCheckIn(GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
             + nullSkipped + " null skipped | "
             + group + " group | "
             + individual + " individual";
    }
}