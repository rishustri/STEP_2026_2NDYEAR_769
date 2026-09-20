class GymMember2 {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMember2(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println(
            "Standard Member | Sessions: " + sessionsAttended
        );
    }
}


class PremiumMember extends GymMember2 {
    protected String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Premium Member | Trainer: " + trainerName +
            " | Sessions: " + sessionsAttended
        );
    }
}


class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(
            String memberId,
            int monthlyFee,
            String trainerName,
            String lockerNumber) {

        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Elite Member | Trainer: " + trainerName +
            " | Locker: " + lockerNumber +
            " | Sessions: " + sessionsAttended
        );
    }
}


class GroupClassMember extends GymMember2 {
    private String className;

    public GroupClassMember(
            String memberId,
            int monthlyFee,
            String className) {

        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Group Class Member | Class: " + className +
            " | Sessions: " + sessionsAttended
        );
    }
}


class MembershipChecker {

    static String classifyGeneration(GymMember2 member) {

        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof PremiumMember) {
            return "Multilevel descendant (2 generations deep)";
        }

        return "Base Member";
    }

    static int getTotalSessionsAttended(GymMember2[] members) {

        int total = 0;

        for (GymMember2 member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }
}