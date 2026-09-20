class GymMember {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {

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
        System.out.print(
            "Standard | Sessions: " + sessionsAttended
        );
    }
}


class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.print(
            "Premium | Trainer: " + trainerName +
            " | Sessions: " + sessionsAttended
        );
    }
}


class AttendanceAnnouncer {

    static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {

            // Polymorphic call
            member.displayInfo();

            // Build the actual announcement
            if (result.length() > 0) {
                result.append(" | ");
            }

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                    (PremiumMember) member;

                result.append(
                    "Premium | Trainer: "
                    + premium.getTrainerName()
                    + " | Sessions: "
                    + premium.getSessionsAttended()
                    + " [Trainer via downcast: "
                    + premium.getTrainerName()
                    + "]"
                );

            } else {

                result.append(
                    "Standard | Sessions: "
                    + member.getSessionsAttended()
                );
            }
        }

        return result.toString();
    }
}